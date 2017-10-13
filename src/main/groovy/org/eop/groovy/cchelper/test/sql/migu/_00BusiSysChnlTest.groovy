package org.eop.groovy.cchelper.test.sql.migu

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
		[dir:'E:\\yaxin\\需求\\咪咕公司接口\\数据库\\测试环境\\', name:'00业务系统渠道']
	}
	
	@Override
	Map getDb() {
		[name:'interfacepf']
	}
	
	@Override
	Map getBusiSystem() {
		[name:'咪咕公司', desc:'咪咕公司', prov:'migu', code:'MIGU']
	}

	@Override
	Map getChannel() {
		[name:'咪咕公司', addr:'http://218.206.190.10:7701']
	}
	
	@Override
	List getStaticConfig() {
		def list = []
		list << [type:'Migu', fst:'Paging', sec:'InInterfaceId', val:'', rmk:'分页查询接入接口Id']
		list << [type:'Migu', fst:'Paging', sec:'OutInterfaceId', val:'', rmk:'分页查询转接接口Id']
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
		def list = []
		list
	}
	
	@Override
	List getOutInterfaceParams() {
		def list = []
		list
	}
	
	@Override
	List getInterfaceParamsMapping() {
		def list = []
		list
	}
	
	@Override
	List getOutInterfaceParamsStatic() {
		def list = []
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
		file << busiSystemSql
		file << channelSql
		staticConfigSql.each {
			file << it
		}
	}
}
