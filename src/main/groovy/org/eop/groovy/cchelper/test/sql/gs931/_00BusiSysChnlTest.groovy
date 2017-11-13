package org.eop.groovy.cchelper.test.sql.gs931

import java.util.List
import java.util.Map

import org.eop.groovy.cchelper.test.sql.AbstractSqlTest
import org.junit.Test

/**
 * @author lixinjie
 */
class _00BusiSysChnlTest extends AbstractSqlTest {

	@Override
	Map getSqlFile() {
		[dir:'E:\\luying\\甘肃在线公司\\需求\\众包接口\\数据库\\测试环境\\', name:'00系统渠道']
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
		list << [type:'GS_NL_PLTFM', fst:'intnet1520171011', sec:'appId', val:'A2017081710261500016', rmk:'']
		list << [type:'GS_NL_PLTFM', fst:'intnet1520171011', sec:'accessToken', val:'84e3b4f3b25bac4442e497706338d3b8230f8a97', rmk:'']
		list << [type:'GS_NL_PLTFM', fst:'ivrznyydh20171012', sec:'appId', val:'A2017110316010500006', rmk:'']
		list << [type:'GS_NL_PLTFM', fst:'ivrznyydh20171012', sec:'accessToken', val:'8f0f2042aad43c84459f7d5c90bedb2110c7fff8', rmk:'']
		list << [type:'GS_NL_PLTFM', fst:'nengkai20170922', sec:'tokenInInterfaceId', val:'', rmk:'']
		list << [type:'GS_NL_PLTFM', fst:'nengkai20170922', sec:'tokenOutInterfaceId', val:'', rmk:'']
		list
	}

	@Override
	Map getInInterface() {
		[:]
	}
	
	@Override
	Map getOutInterface() {
		[:]
	}
	
	@Override
	List getInInterfaceParams() {
		[]
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
		file << busiSystemSql
		file << channelSql
		staticConfigSql.each{
			file << it
		}
	}
}
