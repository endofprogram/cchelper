package org.eop.groovy.cchelper.test.sql

import org.eop.groovy.cchelper.test.AbstractCommonTest

/**
 * @author lixinjie
 */
abstract class AbstractSqlTest extends AbstractCommonTest {

	abstract Map getSqlFile()
	
	abstract Map getDb()
	
	abstract Map getBusiSystem()
	
	abstract Map getChannel()
	
	abstract List getStaticConfig()
	
	abstract Map getInInterface();
	
	abstract Map getOutInterface();
	
	abstract List getInInterfaceParams()
	
	abstract List getOutInterfaceParams()
	
	abstract List getInterfaceParamsMapping()
	
	abstract List getOutInterfaceParamsStatic()
	
	abstract Map getEncryptRel()
	
	abstract Map getSecretKey()
	
	abstract Map getCallbackMapping()
	
	abstract Map getCallback()
	
	List getStaticConfigTokenInterfaceIds() {
		[]
	}
	
	List getDependentInterfaces() {
		[]
	}
	
	String getBusiSystemSql() {
		"""\
/* 业务系统 */
INSERT INTO `bs_busi_system` (`BIZ_SYS_ID`, `BIZ_SYS_NM`, `BIZ_SYS_DESC`, `CRT_TIME`, `OP_TIME`, `PROV_ID`, `BIZ_SYS_CODE`)
select (select max(cast(t.biz_sys_id as signed)) + 1 from bs_busi_system t), '$busiSystem.name', '$busiSystem.desc', now(), now(), '$busiSystem.prov', '$busiSystem.code';

"""
	}
	
	String getChannelSql() {
		"""\
/* 渠道 */
INSERT INTO `bs_interface_channel` (`CHNL_ID`, `SYS_ID`, `CHNL_JNUP_MODE_NM`, `CHNL_ADDR`, `CRT_TIME`, `OP_TIME`, `SYS_STS_CD`, `CHNL_NM`)
select (select max(cast(c.chnl_id as signed)) + 1 from bs_interface_channel c), $busiSystemId, '2', '$channel.addr', now(), now(), '1', '$channel.name';

"""
	}
	
	List getStaticConfigSql() {
		def list = []
		list << '''/* 静态配置参数 */
'''
		staticConfig.each({
			list <<	"""\
INSERT INTO `bs_static_config` (`CONFIG_ID`, `CONFIG_TYPE_CD`, `FST_CONFIG_ITEM_NM`, `SECD_CONFIG_ITEM_NM`, `CONFIG_ITEM_CHAR_ATTR_VAL`, `RMK`, `STS_CD`, `CRT_TIME`, `MODF_TIME`)
select (select max(cast(c.config_id as signed)) + 1 from bs_static_config c), '$it.type', '$it.fst', '$it.sec', '$it.val', '$it.rmk', '1', now(), now();

"""
		})
		list
	}
	
	List getStaticConfigTokenInterfaceIdsSql() {
		def ids = ["$inInterfaceId", "$outInterfaceId"]
		def list = []
		list << '''/* 静态配置参数TokenInterfaceIds */
'''
		staticConfigTokenInterfaceIds.eachWithIndex{it, index ->
			list <<	"""\
update `bs_static_config` c set c.`CONFIG_ITEM_CHAR_ATTR_VAL` = ${ids[index]}
where c.`CONFIG_TYPE_CD` = '$it.type' and c.`FST_CONFIG_ITEM_NM` = '$it.fst' and c.`SECD_CONFIG_ITEM_NM` = '$it.sec';

"""
		}
		list
	}
	
	String getInInterfaceSql() {
		"""\
/* 接入接口 */
INSERT INTO `bs_interface` (`INTF_ID`, `ROUTE_RULE_ID`, `BIZ_SYS_ID`, `INTF_NM`, `INTF_CLA_NM`, `OUT_SYSTEM_TYPE`, `INTF_TYPE_CD`, `BACK_CHNL_ID`, `INTF_PATH`, `INTF_BIZ_CODE`, `RSTFL_REQST_MTHD_NM`, `MSG_FMT_TYPE_CD`, `AGRMT_ENT_ID`, `INTF_DESC`, `INTF_BIZ_TYPE_ID`, `EFF_TIME`, `INVLD_TIME`, `SYS_STS_CD`, `CRT_TIME`, `OP_TIME`)
select (select max(cast(i.intf_id as signed)) + 1 from bs_interface i), '$inInterface.route', $crmpfBusiSystemId, '$inInterface.name', '$inInterface.clsnm', '1', '$inInterface.type', $channelId, '$inInterface.path', '$inInterface.bizcode', '$inInterface.method', '$inInterface.fmttype', '$inInterface.entid', '$inInterface.desc', '$inInterface.biztype', now(), date_add(now(), interval 10 year), '1', now(), now();

"""
	}
	
	String getOutInterfaceSql() {
		"""\
/* 转接接口 */
INSERT INTO `bs_interface` (`INTF_ID`, `ROUTE_RULE_ID`, `BIZ_SYS_ID`, `INTF_NM`, `INTF_CLA_NM`, `OUT_SYSTEM_TYPE`, `INTF_TYPE_CD`, `BACK_CHNL_ID`, `INTF_PATH`, `INTF_BIZ_CODE`, `RSTFL_REQST_MTHD_NM`, `MSG_FMT_TYPE_CD`, `AGRMT_ENT_ID`, `INTF_DESC`, `INTF_BIZ_TYPE_ID`, `EFF_TIME`, `INVLD_TIME`, `SYS_STS_CD`, `CRT_TIME`, `OP_TIME`)
select (select max(cast(i.intf_id as signed)) + 1 from bs_interface i), '$outInterface.route', $busiSystemId, '$outInterface.name', '$outInterface.clsnm', '1', '$outInterface.type', $channelId, '$outInterface.path', '$outInterface.bizcode', '$outInterface.method', '$outInterface.fmttype', '$outInterface.entid', '$outInterface.desc', '$outInterface.biztype', now(), date_add(now(), interval 10 year), '1', now(), now();

"""
	}
	
	String getInterfaceMappingSql() {
		"""\
/* 接口映射 */
INSERT INTO `bs_interface_mapping` (`INTF_ID`, `MAPNG_INTF_ID`, `PRI_LVL_SEQNO`, `CRT_TIME`, `CHNL_ID`, `DEPEND_INTF_ID`)
select $inInterfaceId, $outInterfaceId, '1', now(), $channelId, '';

"""
	}
	
	List getInInterfaceParamsSql() {
		def list = []
		list << '''/* 接入接口参数 */
'''
		inInterfaceParams.each({
			list << """\
INSERT INTO `bs_interface_param` (`PARA_ID`, `ENCR_STG_ID`, `INTF_ID`, `SRV_PARA_TYPE_CD`, `PARA_NM`, `DATA_TYPE_NM`, `DATA_LEN_VAL`, `NULL_FLAG`, `ARGE_SEQNO`, `CRT_TIME`, `OP_TIME`)
select (select max(cast(p.para_id as signed)) + 1 from bs_interface_param p), NULL, $inInterfaceId, '$it.type', '$it.name', NULL, NULL, '$it.nflag', '$it.seqno', now(), now();

"""
		})
		list
	}
	
	List getOutInterfaceParamsSql() {
		def list = []
		list << '''/* 转接接口参数 */
'''
		outInterfaceParams.each({
			list << """\
INSERT INTO `bs_interface_param` (`PARA_ID`, `ENCR_STG_ID`, `INTF_ID`, `SRV_PARA_TYPE_CD`, `PARA_NM`, `DATA_TYPE_NM`, `DATA_LEN_VAL`, `NULL_FLAG`, `ARGE_SEQNO`, `CRT_TIME`, `OP_TIME`)
select (select max(cast(p.para_id as signed)) + 1 from bs_interface_param p), NULL, $outInterfaceId, '$it.type', '$it.name', NULL, NULL, '$it.nflag', '$it.seqno', now(), now();

"""
		})
		list
	}
	
	List getInterfaceParamsMappingSql() {
		def list = []
		list << '''/* 接口参数映射 */
'''
		interfaceParamsMapping.each({
			list << """\
INSERT INTO `bs_interface_param_mapping` (`SRC_PARA_ID`, `MAPNG_PARA_ID`, `PARA_TRSFM_SCPT_CNTT`, `PARA_TRSFM_ACHV_CLA_NM`, `CRT_TIME`, `OP_TIME`)
select (select p.para_id from bs_interface_param p where p.intf_id = $inInterfaceId and p.para_nm = '$it.name1' and p.srv_para_type_cd = '$it.type'), (select p.para_id from bs_interface_param p where p.intf_id = $outInterfaceId and p.para_nm = '$it.name2' and p.srv_para_type_cd = '$it.type'), '$it.scpt', '', now(), now();

"""
		})
		list
	}
	
	List getOutInterfaceParamsStaticSql() {
		def list = []
		list << '''/* 转接接口静态参数 */
'''
		outInterfaceParamsStatic.each({
			list << """\
INSERT INTO `bs_interface_param_static` (`PARA_ID`, `MAPNG_INTF_ID`, `PARA_KEY`, `PARA_VALUE`, `ARGE_SEQNO`, `SYS_STS_CD`, `CRT_TIME`, `OP_TIME`)
select (select max(cast(i.para_id as signed)) + 1 from bs_interface_param_static i), $outInterfaceId, '$it.name', '$it.value', '$it.seqno', '1', now(), now();

"""
		})
		list
	}
	
	List getDependentInterfacesSql() {
		def list = []
		list << '''/* 接口映射,依赖接口ID设置 */
'''
		dependentInterfaces.each{
			list << """\
update `bs_interface_mapping` m set m.`DEPEND_INTF_ID` = case when length(trim(m.`DEPEND_INTF_ID`)) < 1 then ${getDependentInterfaceId(it.desc)} else concat(m.`DEPEND_INTF_ID`,',',${getDependentInterfaceId(it.desc)}) end
where m.`INTF_ID` = $inInterfaceId and m.`MAPNG_INTF_ID` = $outInterfaceId and m.`CHNL_ID` = $channelId;

"""
		}
		list
	}
	
	String getChannelAuthSql() {
		"""\
/* 渠道权限 */
INSERT INTO `bs_in_chnannel_auth` (`JNUP_CHNL_PRIV_ID`, `JNUP_CHNL_ID`, `JNUP_INTF_ID`, `SYS_STS_CD`, `CRT_TIME`)
select (select max(cast(a.jnup_chnl_priv_id as signed)) + 1 from bs_in_chnannel_auth a), (select c.chnl_id from bs_interface_channel c where c.sys_id = (select b.biz_sys_id from bs_busi_system b where b.biz_sys_code = 'NGCRMPF')), $inInterfaceId, '1', now();

"""
	}
	
	String getEncryptRelSql() {
		"""\
/* 接口加密引用 */
INSERT INTO `bs_interfac_encrypt_tactic_rel` (`INTF_ENCR_ID`, `INTF_ID`, `ENCR_STG_ID`, `ENCR_TYPE_CD`, `CRT_TIME`, `OP_TIME`)
select (select max(cast(r.intf_encr_id as signed)) + 1 from bs_interfac_encrypt_tactic_rel r), $outInterfaceId, '$encryptRel.stgid', '2', now(), now();

"""
	}
	
	String getSecretKeySql() {
		"""\
/* 密钥 */
INSERT INTO `bs_secret_key` (`ENCR_CRKEY_ID`, `ENCR_STG_ID`, `ENCR_CRKEY`, `DECR_CRKEY`, `CRKEY_VERNO`, `EFF_TIME`, `INVLD_TIME`, `CRT_DATE`, `SYS_STS_CD`, `OP_TIME`, `INTF_ID`)
select (select max(cast(k.encr_crkey_id as signed)) + 1 from bs_secret_key k), '$secretKey.stgid', '$secretKey.key1', '$secretKey.key2', '', now(), now(), now(), '1', now(), $outInterfaceId;

"""
	}
	
	String getCallbackMappingSql() {
		"""\
/* 回调映射 */
INSERT INTO `bs_callback_uniform_mapping` (`ID`, `BIZ_SYS_ID`, `TRSTCH_INTF_ID`, `INTF_CALLBCK_ADDR`, `CALLBCK_MSG_PRS_CLA_NM`, `SYS_STS_CD`, `EFF_TIME`, `CRT_TIME`)
select (select max(cast(m.id as signed)) + 1 from bs_callback_uniform_mapping m), $busiSystemId, $outInterfaceId, '$callbackMapping.addr', '$callbackMapping.clsnm', '1', now(), now();

"""
	}
	
	String getCallbackSql() {
		"""\
/* 回调 */
INSERT INTO `bs_callback_uniform` (`ID`, `JNUP_CHNL_ID`, `JNUP_INTF_ID`, `INTF_SRV_CODE`, `REST_METHOD_TYPE`, `URL_ADDR`, `SYS_STS_CD`, `EFF_TIME`, `CRT_TIME`)
select (select max(cast(c.id as signed)) + 1 from bs_callback_uniform c), $channelId, $inInterfaceId, '$callback.code', '$callback.method', '$callback.addr', '1', now(), now();
		
"""
	}
	
	String getCrmpfBusiSystemId() {
		"""(select b.biz_sys_id from bs_busi_system b where b.biz_sys_code = 'NGCRMPF')"""
	}
	
	String getBusiSystemId() {
		"""(select b.biz_sys_id from bs_busi_system b where b.biz_sys_code = '$busiSystem.code')"""
	}
	
	String getInInterfaceId() {
		"""(select i.intf_id from bs_interface i where i.intf_desc = '$inInterface.desc')"""
	}
	
	String getOutInterfaceId() {
		"""(select i.intf_id from bs_interface i where i.intf_desc = '$outInterface.desc')"""
	}
	
	String getChannelId() {
		"""(select c.chnl_id from bs_interface_channel c where c.sys_id = $busiSystemId)"""
	}
	
	String getDependentInterfaceId(desc) {
		"""(select i.intf_id from bs_interface i where i.intf_desc = '${desc}')"""
	}
}
