package org.eop.groovy.cchelper.test.sql.pointplatform

import java.util.List
import java.util.Map

import org.eop.groovy.cchelper.test.sql.AbstractSqlTest
import org.junit.Test

/**
 * @author lixinjie
 */
class _323Test extends AbstractSqlTest {

	@Override
	Map getSqlFile() {
		[dir:'E:\\yaxin\\需求\\积分接口\\数据库\\测试环境\\', name:'323正常子订单详细信息查询']
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
		[route:'', name:'积分平台_查询_正常子订单详细信息查询', clsnm:'pointPlatformIntfService', type:'1', path:'business/pointplatform/subOdrDtalQry', bizcode:'', method:'GET', fmttype:'json', entid:'', desc:'积分平台_查询_正常子订单详细信息查询(20170427_in)', biztype:'001']
	}
	
	@Override
	Map getOutInterface() {
		[route:'', name:'网状网_查询_正常子订单详细信息查询', clsnm:'pointPlatformCommonService', type:'1', path:'/Trans/Receiver', bizcode:'', method:'POST', fmttype:'xml', entid:'10', desc:'网状网_查询_正常子订单详细信息查询(20170427_out)', biztype:'001']
	}
	
	@Override
	List getInInterfaceParams() {
		def list = []
		list << [type:'1', name:'subOrderId', nflag:'0', seqno:'1']
		list
	}
	
	@Override
	List getOutInterfaceParams() {
		def list = []
		list << [type:'1', name:'SubOrderID', nflag:'1', seqno:'1']
		list
	}
	
	@Override
	List getInterfaceParamsMapping() {
		def list = []
		list << [name1:'subOrderId', name2:'SubOrderID', type:'1']
		list
	}
	
	@Override
	List getOutInterfaceParamsStatic() {
		def list = []
		list << [name:'BIPCode', value:'BIP2B423', seqno:'01']
		list << [name:'ActivityCode', value:'T2040093', seqno:'02']
		list << [name:'reqRootElement', value:'OrderReq', seqno:'03']
		list << [name:'rpsRootElement', value:'OrderRes', seqno:'04']
		list << [name:'rpsCodeElement', value:'TradeResCode', seqno:'05']
		list << [name:'rpsDescElement', value:'TradeResDesc', seqno:'06']
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
		outInterfaceParamsSql.each{
			file << it
		}
		interfaceParamsMappingSql.each{
			file << it
		}
		outInterfaceParamsStaticSql.each{
			file << it
		}
		file << channelAuthSql
	}
}
