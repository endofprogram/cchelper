package org.eop.groovy.cchelper.test.sql.ah551

import java.util.List
import java.util.Map

import org.eop.groovy.cchelper.test.sql.AbstractSqlTest
import org.junit.Test

/**
 * @author lixinjie
 */
class _03Test extends AbstractSqlTest {

	@Override
	Map getSqlFile() {
		[dir:'E:\\yaxin\\需求\\安徽众包接口\\数据库\\生产环境\\', name:'03流量升档']
	}
	
	@Override
	Map getDb() {
		[name:'interfacepf']
	}
	
	@Override
	Map getBusiSystem() {
		[name:'安徽能力开发平台', desc:'安徽能力开发平台', prov:'551', code:'AH_NL_PLTFM']
	}

	@Override
	Map getChannel() {
		[name:'安徽能力开发平台', addr:'http://120.209.204.229:81']
	}
	
	@Override
	List getStaticConfig() {
		def list = []
		list << [type:'AH_NL_PLTFM', fst:'fstConfigItem201705', sec:'appKey', val:'', rmk:'']
		list << [type:'AH_NL_PLTFM', fst:'fstConfigItem201705', sec:'userName', val:'', rmk:'']
		list << [type:'AH_NL_PLTFM', fst:'fstConfigItem201705', sec:'privateKey', val:'', rmk:'']
		list << [type:'AH_NL_PLTFM', fst:'fstConfigItem201705', sec:'status', val:'', rmk:'']
		list
	}

	@Override
	Map getInInterface() {
		[route:'1', name:'直连_业务_流量升档', clsnm:'userMobileCommonIntfService', type:'1', path:'business/gs/flowUpgrade', bizcode:'', method:'PUT', fmttype:'json', entid:'', desc:'直连_业务_流量升档(20170515_in)', biztype:'002']
	}
	
	@Override
	Map getOutInterface() {
		[route:'1', name:'安徽众包_业务_流量升档', clsnm:'ahFlowUpgradeService', type:'1', path:'/rest/2.0/s4000Cfm', bizcode:'', method:'GET', fmttype:'json', entid:'1', desc:'安徽众包_业务_流量升档(20170515_out)', biztype:'002']
	}
	
	@Override
	List getInInterfaceParams() {
		def list = []
		list << [type:'1', name:'userMobile', nflag:'0', seqno:'01']
		list << [type:'1', name:'currProductId', nflag:'0', seqno:'02']
		list << [type:'1', name:'newProductId', nflag:'0', seqno:'03']
		list
	}
	
	@Override
	List getOutInterfaceParams() {
		def list = []
		list << [type:'1', name:'svcNum', nflag:'1', seqno:'01']
		list << [type:'2', name:'BYYYZLL', nflag:'1', seqno:'11']
		list
	}
	
	@Override
	List getInterfaceParamsMapping() {
		def list = []
		list << [name1:'userMobile', name2:'svcNum', type:'1']
		list << [name1:'monthUsed', name2:'BYYYZLL', type:'2']
		list
	}
	
	@Override
	List getOutInterfaceParamsStatic() {
		def list = []
		list << [name:'configTypeCd', value:'AH_NL_PLTFM', seqno:'01']
		list << [name:'fstConfigItemNm', value:'fstConfigItem201705', seqno:'02']
		list << [name:'originalSuccessReturnCode', value:'0', seqno:'03']
		list << [name:'successResultCode', value:'00000', seqno:'04']
		list << [name:'successResultDesc', value:'成功', seqno:'05']
		list << [name:'ipt_LOGIN_NO', value:'Y18611445', seqno:'08']
		list << [name:'ipt_MASTER_SERV_ID', value:'1001', seqno:'09']
		list << [name:'ipt_OPERATE_TYPE', value:'U', seqno:'10']
		list << [name:'ipt_SERVICE_NO', value:'${userMobile}', seqno:'11']
		list << [name:'ipt_FORMER_PRCID', value:'${currProductId}', seqno:'06']
		list << [name:'ipt_PROD_PRCID', value:'${newProductId}', seqno:'07']
		list << [name:'ipt_appKey', value:'${appKey}', seqno:'12']
		list << [name:'ipt_status', value:'${status}', seqno:'13']
		list << [name:'ipt_timeStamp', value:'${timeStamp}', seqno:'14']
		list << [name:'ipt_userName', value:'${userName}', seqno:'15']
		list
	}
	
	@Override
	Map getEncryptRel() {
		[stgid:'3']
	}
	
	@Override
	Map getSecretKey() {
		[stgid:'3', key1:'a67aae2843b7e6dc83298b9532082522,504089', key2:'a67aae2843b7e6dc83298b9532082522']
	}
	
	@Override
	Map getCallbackMapping() {
		[addr:'/dualmicro/releaseNotice', clsnm:'dualmicroCallBackService']
	}
	
	@Override
	Map getCallback() {
		[code:'1', method:'POST', addr:'/business/flows/mobiles/gs/resultNotice']
	}
	
	@Test
	void testExecute() {
		def file = new File(sqlFile.dir + sqlFile.name + '.sql')
		file.write('')
		file << inInterfaceSql
		file << outInterfaceSql
		file << interfaceMappingSql
		inInterfaceParamsSql.each{
			file << it
		}
		outInterfaceParamsStaticSql.each{
			file << it
		}
		file << channelAuthSql
	}
}
