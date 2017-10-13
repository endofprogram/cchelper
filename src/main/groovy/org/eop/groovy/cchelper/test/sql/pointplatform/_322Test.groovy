package org.eop.groovy.cchelper.test.sql.pointplatform

import java.util.List
import java.util.Map

import org.eop.groovy.cchelper.test.sql.AbstractSqlTest
import org.junit.Test

/**
 * @author lixinjie
 */
class _322Test extends AbstractSqlTest {

	@Override
	Map getSqlFile() {
		[dir:'E:\\yaxin\\需求\\积分接口\\数据库\\测试环境\\', name:'322正常子订单概要查询']
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
		[route:'', name:'积分平台_查询_正常子订单概要查询', clsnm:'pointPlatformIntfService', type:'1', path:'business/pointplatform/subOdrSmryQry', bizcode:'', method:'GET', fmttype:'json', entid:'', desc:'积分平台_查询_正常子订单概要查询(20170427_in)', biztype:'001']
	}
	
	@Override
	Map getOutInterface() {
		[route:'', name:'网状网_查询_正常子订单概要查询', clsnm:'pointPlatformCommonService', type:'1', path:'/Trans/Receiver', bizcode:'', method:'POST', fmttype:'xml', entid:'10', desc:'网状网_查询_正常子订单概要查询(20170427_out)', biztype:'001']
	}
	
	@Override
	List getInInterfaceParams() {
		def list = []
		list << [type:'1', name:'userMobile', nflag:'0', seqno:'1']
		list << [type:'1', name:'orderId', nflag:'0', seqno:'2']
		list << [type:'1', name:'subOrderId', nflag:'0', seqno:'3']
		list << [type:'1', name:'itemPayType', nflag:'0', seqno:'4']
		list << [type:'1', name:'itemPayStatus', nflag:'0', seqno:'5']
		list << [type:'1', name:'orderStatus', nflag:'0', seqno:'6']
		list << [type:'1', name:'orderStartTime', nflag:'0', seqno:'7']
		list << [type:'1', name:'orderEndTime', nflag:'0', seqno:'8']
		list << [type:'1', name:'startRowNum', nflag:'0', seqno:'9']
		list << [type:'1', name:'endRowNum', nflag:'0', seqno:'10']
		list
	}
	
	@Override
	List getOutInterfaceParams() {
		def list = []
		list << [type:'1', name:'Mobile', nflag:'1', seqno:'1']
		list << [type:'1', name:'OrderID', nflag:'1', seqno:'2']
		list << [type:'1', name:'SubOrderID', nflag:'1', seqno:'3']
		list << [type:'1', name:'ItemPayType', nflag:'1', seqno:'4']
		list << [type:'1', name:'ItemPayStatus', nflag:'1', seqno:'5']
		list << [type:'1', name:'OrdStatus', nflag:'1', seqno:'6']
		list << [type:'1', name:'OrderStartTime', nflag:'1', seqno:'7']
		list << [type:'1', name:'OrderEndTime', nflag:'1', seqno:'8']
		list << [type:'1', name:'SRowNum', nflag:'1', seqno:'9']
		list << [type:'1', name:'ERowNum', nflag:'1', seqno:'10']
		list
	}
	
	@Override
	List getInterfaceParamsMapping() {
		def list = []
		list << [name1:'userMobile', name2:'Mobile', type:'1']
		list << [name1:'orderId', name2:'OrderID', type:'1']
		list << [name1:'subOrderId', name2:'SubOrderID', type:'1']
		list << [name1:'itemPayType', name2:'ItemPayType', type:'1']
		list << [name1:'itemPayStatus', name2:'ItemPayStatus', type:'1']
		list << [name1:'orderStatus', name2:'OrdStatus', type:'1']
		list << [name1:'orderStartTime', name2:'OrderStartTime', type:'1']
		list << [name1:'orderEndTime', name2:'OrderEndTime', type:'1']
		list << [name1:'startRowNum', name2:'SRowNum', type:'1']
		list << [name1:'endRowNum', name2:'ERowNum', type:'1']
		list
	}
	
	@Override
	List getOutInterfaceParamsStatic() {
		def list = []
		list << [name:'BIPCode', value:'BIP2B422', seqno:'01']
		list << [name:'ActivityCode', value:'T2040092', seqno:'02']
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
