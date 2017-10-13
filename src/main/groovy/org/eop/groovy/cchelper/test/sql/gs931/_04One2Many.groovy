package org.eop.groovy.cchelper.test.sql.gs931

import java.util.List
import java.util.Map

import org.eop.groovy.cchelper.test.sql.AbstractSqlTest
import org.junit.Test

/**
 * @author lixinjie
 */
class _04One2Many extends AbstractSqlTest {

	@Override
	Map getSqlFile() {
		[dir:'E:\\luying\\甘肃在线公司\\需求\\众包接口\\数据库\\测试环境\\', name:'04一对多接口调用']
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
		list << [type:'GS_NL_PLTFM', fst:'nengkai20170922', sec:'tokenInInterfaceId', val:'828', rmk:'']
		list << [type:'GS_NL_PLTFM', fst:'nengkai20170922', sec:'tokenOutInterfaceId', val:'829', rmk:'']
		list
	}

	@Override
	public List getStaticConfigTokenInterfaceIds() {
		[]
	}
	@Override
	Map getInInterface() {
		[route:'', name:'甘肃能开_接入_一对多接口调用', clsnm:'userMobileCommonIntfService', type:'1', path:'business/gs/one2Many', bizcode:'', method:'GET', fmttype:'json', entid:'', desc:'甘肃能开_接入_一对多接口调用(20170922_in)', biztype:'001']
	}
	
	@Override
	Map getOutInterface() {
		[route:'', name:'甘肃能开_转接_一对多接口调用', clsnm:'gsZbOne2ManyService', type:'1', path:'', bizcode:'', method:'POST', fmttype:'json', entid:'10', desc:'甘肃能开_转接_一对多接口调用(20170922_out)', biztype:'001']
	}
	
	@Override
	List getInInterfaceParams() {
		def list = []
		list << [type:'1', name:'userMobile', nflag:'0', seqno:'01']
		list << [type:'1', name:'attributeName', nflag:'1', seqno:'02']
		list << [type:'1', name:'value', nflag:'1', seqno:'03']
		list << [type:'1', name:'promoId', nflag:'0', seqno:'04']
		list << [type:'1', name:'condId', nflag:'0', seqno:'05']
		list << [type:'1', name:'actType', nflag:'0', seqno:'06']
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
		dependentInterfacesSql.each{
			file << it
		}
	}
}
