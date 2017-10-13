package org.eop.groovy.cchelper.test.sql.pointplatform

import java.util.List
import java.util.Map

import org.eop.groovy.cchelper.test.sql.AbstractSqlTest
import org.junit.Test

/**
 * @author lixinjie
 */
class _000BusiSysChnlTest extends AbstractSqlTest {

	@Override
	Map getSqlFile() {
		[dir:'E:\\yaxin\\需求\\积分接口\\数据库\\测试环境\\', name:'000业务系统渠道']
	}
	
	@Override
	Map getDb() {
		[name:'interfacepf']
	}
	
	@Override
	Map getBusiSystem() {
		[name:'积分管理平台', desc:'积分管理平台', prov:'pointplatform', code:'POINT_PLATFORM']
	}

	@Override
	Map getChannel() {
		[name:'积分管理平台', addr:'http://218.206.190.26:6627']
	}
	
	@Override
	List getStaticConfig() {
		def list = []
		list << [type:'DualMicro', fst:'Secret', sec:'secretType', val:'off', rmk:'双微加密类型']
		list << [type:'DualMicro', fst:'Secret', sec:'secretKey', val:'eddd62cbbe9a3424857a968cd8c356fe', rmk:'双微加密密钥']
		list << [type:'DualMicro', fst:'Secret', sec:'secretAddr', val:'', rmk:'双微加密机地址']
		list << [type:'DualMicro', fst:'Secret', sec:'secretPort', val:'', rmk:'双微加密机端口']
		list
	}

	@Override
	Map getInInterface() {
		[route:'1', name:'接口名称', clsnm:'接口处理类', type:'接口类型', path:'', bizcode:'', method:'', fmttype:'', entid:'', desc:'绑定关系解除(20170303_in)', biztype:'']
	}
	
	@Override
	Map getOutInterface() {
		[desc:'绑定关系解除(20170303_out)']
	}
	
	@Override
	List getInInterfaceParams() {
		def list = []
		list << [type:'', name:'', nflag:'', seqno:'']
		list
	}
	
	@Override
	List getOutInterfaceParams() {
		def list = []
		list << [type:'', name:'', nflag:'', seqno:'']
		list
	}
	
	@Override
	List getInterfaceParamsMapping() {
		def list = []
		list << [name1:'', name2:'', type:'']
		list
	}
	
	@Override
	List getOutInterfaceParamsStatic() {
		def list = []
		list << [name:'', value:'', seqno:'']
		list
	}
	
	@Override
	Map getEncryptRel() {
		[stgid:'3']
	}
	
	@Override
	Map getSecretKey() {
		[stgid:'', key1:'a67aae2843b7e6dc83298b9532082522,504089', key2:'a67aae2843b7e6dc83298b9532082522']
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
		file << busiSystemSql
		file << channelSql
	}
}
