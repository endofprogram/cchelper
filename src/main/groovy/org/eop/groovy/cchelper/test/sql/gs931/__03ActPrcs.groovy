package org.eop.groovy.cchelper.test.sql.gs931

import java.util.List
import java.util.Map

import org.eop.groovy.cchelper.test.sql.AbstractSqlTest
import org.junit.Test

/**
 * @author lixinjie
 */
class __03ActPrcs extends AbstractSqlTest {

	@Override
	Map getSqlFile() {
		[dir:'E:\\luying\\甘肃在线公司\\需求\\众包接口\\数据库\\测试环境\\', name:'03活动办理SCP']
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
		list
	}

	@Override
	Map getInInterface() {
		[route:'', name:'甘肃能开_接入_活动办理SCP', clsnm:'userMobileCommonIntfService', type:'1', path:'business/gs/actPrcsScp', bizcode:'', method:'POST', fmttype:'json', entid:'', desc:'甘肃能开_接入_活动办理SCP(20170922_in)', biztype:'002']
	}
	
	@Override
	Map getOutInterface() {
		[route:'', name:'甘肃能开_转接_活动办理SCP', clsnm:'gsZhongbaoOutIntfScpService', type:'1', path:'/openapi/V1/partner/ability/sandbox/soUserPromoCommon4cmcc', bizcode:'', method:'POST', fmttype:'json', entid:'10', desc:'甘肃能开_转接_活动办理SCP(20170922_out)', biztype:'002']
	}
	
	@Override
	List getInInterfaceParams() {
		def list = []
		list << [type:'1', name:'userMobile', nflag:'0', seqno:'01']
		list << [type:'1', name:'promoId', nflag:'0', seqno:'04']
		list << [type:'1', name:'condId', nflag:'0', seqno:'05']
		list << [type:'1', name:'actType', nflag:'0', seqno:'06']
		list << [type:'1', name:'__In_ServiceContent_MessageScript__', nflag:'1', seqno:'11']
		list << [type:'2', name:'__In_SuccessResult_MessageScript__', nflag:'1', seqno:'12']
		list
	}
	
	@Override
	List getOutInterfaceParams() {
		def list = []
		list << [type:'1', name:'__Out_ServiceContent_MessageScript__', nflag:'1', seqno:'01']
		list << [type:'2', name:'__Out_SuccessResult_MessageScript__', nflag:'1', seqno:'02']
		list
	}
	
	@Override
	List getInterfaceParamsMapping() {
		def list = []
		list << [name1:'__In_ServiceContent_MessageScript__', name2:'__Out_ServiceContent_MessageScript__', type:'1', scpt:'#ko(serviceContent,input{})#kv(promoId,promoId<>)#kv(condId,condId<>)#kv(actType,actType<>)#ok']
		list << [name1:'__In_SuccessResult_MessageScript__', name2:'__Out_SuccessResult_MessageScript__', type:'2', scpt:'#ko(successResult,eshub{})#kv(orderId,eshubTransactionId<>)#kv(oprTime,processTime<>)#ok']
		list
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
		file << channelAuthSql
	}
}
