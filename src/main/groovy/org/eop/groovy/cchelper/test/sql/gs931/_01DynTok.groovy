package org.eop.groovy.cchelper.test.sql.gs931

import java.util.List
import java.util.Map

import org.eop.groovy.cchelper.test.sql.AbstractSqlTest
import org.junit.Test

/**
 * @author lixinjie
 */
class _01DynTok extends AbstractSqlTest {

	@Override
	Map getSqlFile() {
		[dir:'E:\\luying\\甘肃在线公司\\需求\\众包接口\\数据库\\测试环境\\', name:'01动态授权码']
	}
	
	@Override
	Map getDb() {
		[name:'interfacepf']
	}
	
	@Override
	Map getBusiSystem() {
		[name:'甘肃能力开发平台', desc:'甘肃能力开发平台', prov:'931', code:'GS_NL_PLTFM']
	}

	@Override
	Map getChannel() {
		[name:'甘肃能力开发平台', addr:'https://partner.cmccgs.cn']
	}
	
	@Override
	List getStaticConfig() {
		def list = []
		list << [type:'GS_NL_PLTFM', fst:'zhongbao20170922', sec:'appId', val:'A2017083117061000024', rmk:'']
		list << [type:'GS_NL_PLTFM', fst:'zhongbao20170922', sec:'accessToken', val:'4920cb16c8bdf0442c3aca5b5a7123b37fb10b5a', rmk:'']
		list << [type:'GS_NL_PLTFM', fst:'nengkai20170922', sec:'tokenInInterfaceId', val:'', rmk:'']
		list << [type:'GS_NL_PLTFM', fst:'nengkai20170922', sec:'tokenOutInterfaceId', val:'', rmk:'']
		list
	}

	@Override
	public List getStaticConfigTokenInterfaceIds() {
		def list = []
		list << [type:'GS_NL_PLTFM', fst:'nengkai20170922', sec:'tokenInInterfaceId']
		list << [type:'GS_NL_PLTFM', fst:'nengkai20170922', sec:'tokenOutInterfaceId']
		list
	}
	@Override
	Map getInInterface() {
		[route:'', name:'甘肃能开_接入_动态授权码', clsnm:'userMobileCommonIntfService', type:'1', path:'business/gs/dynamicToken', bizcode:'', method:'GET', fmttype:'json', entid:'', desc:'甘肃能开_接入_动态授权码(20170922_in)', biztype:'003']
	}
	
	@Override
	Map getOutInterface() {
		[route:'', name:'甘肃能开_转接_动态授权码', clsnm:'gsTokenOperService', type:'1', path:'/openapi/V1/partner/ability/dynamicToken', bizcode:'', method:'POST', fmttype:'json', entid:'10', desc:'甘肃能开_转接_动态授权码(20170922_out)', biztype:'003']
	}
	
	@Override
	List getInInterfaceParams() {
		def list = []
		list << [type:'1', name:'appId', nflag:'0', seqno:'01']
		list << [type:'1', name:'accessToken', nflag:'0', seqno:'02']
		list
	}
	
	@Override
	List getOutInterfaceParams() {
		[]
	}
	
	@Override
	List getInterfaceParamsMapping() {
		[]
	}
	
	@Override
	List getOutInterfaceParamsStatic() {
		[]
	}
	
	@Override
	List getDependentInterfaces() {
		def list = []
		list << [desc:'甘肃能开_接入_子活动查询(20170922_in)']
		list << [desc:'甘肃能开_转接_子活动查询(20170922_out)']
		list << [desc:'甘肃能开_接入_活动办理(20170922_in)']
		list << [desc:'甘肃能开_转接_活动办理(20170922_out)']
		list
	}
	
	@Override
	Map getEncryptRel() {
		[:]
	}
	
	@Override
	Map getSecretKey() {
		[:]
	}
	
	@Override
	Map getCallbackMapping() {
		[:]
	}
	
	@Override
	Map getCallback() {
		[:]
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
		file << channelAuthSql
		staticConfigTokenInterfaceIdsSql.each{
			file << it
		}
	}
}
