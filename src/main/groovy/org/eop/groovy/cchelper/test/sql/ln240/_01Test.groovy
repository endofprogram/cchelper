package org.eop.groovy.cchelper.test.sql.ln240

import java.util.List
import java.util.Map

import org.eop.groovy.cchelper.test.sql.AbstractSqlTest
import org.junit.Test

/**
 * @author lixinjie
 */
class _01Test extends AbstractSqlTest {

	@Override
	Map getSqlFile() {
		[dir:'E:\\yaxin\\需求\\辽宁流量统付\\数据库\\测试环境\\', name:'01产品查询']
	}
	
	@Override
	Map getDb() {
		[name:'interfacepf']
	}
	
	@Override
	Map getBusiSystem() {
		[name:'辽宁CRM', desc:'辽宁CRM', prov:'240', code:'LN_CRM']
	}

	@Override
	Map getChannel() {
		[name:'辽宁CRM', addr:'http://221.180.247.69:5301']
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
		[route:'', name:'在线统一接口_业务_流量产品查询接口', clsnm:'', type:'', path:'', bizcode:'', method:'GET', fmttype:'json', entid:'', desc:'在线统一接口_业务_流量产品查询接口', biztype:'001']
	}
	
	@Override
	Map getOutInterface() {
		[route:'', name:'辽宁流量统付_产品查询', clsnm:'lnFlowProdQueryService', type:'', path:'/oppf', bizcode:'', method:'POST', fmttype:'json', entid:'10', desc:'辽宁流量统付_产品查询(20170619_out)', biztype:'001']
	}
	
	@Override
	List getInInterfaceParams() {
		def list = []
		list << [type:'1', name:'indictSeq', nflag:'0', seqno:'1']
		
		list << [type:'2', name:'operRtnStaId', nflag:'1', seqno:'101']
		list
	}
	
	@Override
	List getOutInterfaceParams() {
		def list = []
		list << [type:'1', name:'IndictSeq', nflag:'1', seqno:'1']
		
		list << [type:'2', name:'OperRtnStaId', nflag:'1', seqno:'101']
		list
	}
	
	@Override
	List getInterfaceParamsMapping() {
		def list = []
		list << [name1:'indictSeq', name2:'IndictSeq', type:'1']
		
		list << [name1:'operRtnStaId', name2:'OperRtnStaId', type:'2']
		list
	}
	
	@Override
	List getOutInterfaceParamsStatic() {
		def list = []
		list << [name:'appKey', value:'4034b5f449656aa20c1d773260e3ba7b', seqno:'01']
		
		list << [name:'method', value:'OI_QueryProd', seqno:'01']
		list << [name:'appId', value:'502007', seqno:'02']
		list << [name:'version', value:'1.1.3', seqno:'03']
		list << [name:'operId', value:'100004638522', seqno:'04']
		
		list << [name:'BusiCode', value:'OI_QueryProd', seqno:'05']
		list << [name:'InterfaceId', value:'100000000100', seqno:'06']
		list << [name:'InterfaceType', value:'81', seqno:'04']
		list << [name:'OpId', value:'40121860', seqno:'05']
		list << [name:'CountyCode', value:'4000', seqno:'06']
		list << [name:'OrgId', value:'40001000', seqno:'06']
		list << [name:'RegionCode', value:'400', seqno:'06']
		
		list << [name:'OfferId', value:'112001010634', seqno:'06']
		list << [name:'CustId', value:'2502594784', seqno:'06']
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
		file << outInterfaceSql
		file << interfaceMappingSql
		outInterfaceParamsStaticSql.each{
			file << it
		}
		file << channelAuthSql
	}
}
