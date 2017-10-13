package org.eop.groovy.cchelper.test.sql.hn371

import java.util.List
import java.util.Map

import org.eop.groovy.cchelper.test.sql.AbstractSqlTest
import org.junit.Test

/**
 * @author lixinjie
 */
class _02DYLLMXTest extends AbstractSqlTest {

	@Override
	Map getSqlFile() {
		[dir:'E:\\yaxin\\需求\\河南接口\\数据库\\测试环境\\', name:'02当月流量明细']
	}
	
	@Override
	Map getDb() {
		[name:'interfacepf']
	}
	
	@Override
	Map getBusiSystem() {
		[name:'', desc:'', prov:'371', code:'HENAN_CRM']
	}

	@Override
	Map getChannel() {
		[name:'', addr:'http://218.206.190.10:8703']
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
		[route:'1', name:'直连_查询_当月流量明细', clsnm:'userMobileCommonIntfService', type:'1', path:'business/gs/monthFlowDetail', bizcode:'', method:'GET', fmttype:'json', entid:'', desc:'直连_查询_当月流量明细(20170411_in)', biztype:'001']
	}
	
	@Override
	Map getOutInterface() {
		[route:'1', name:'河南_查询_当月流量明细', clsnm:'hnResultIsArrayQueryService', type:'1', path:'/oppf?postSysParam=true&busiKey=jsonParams', bizcode:'ESB_NEW_WAP_200867', method:'POST', fmttype:'json', entid:'10', desc:'河南_查询_当月流量明细(20170411_out)', biztype:'001']
	}
	
	@Override
	List getInInterfaceParams() {
		def list = []
		list << [type:'1', name:'userMobile', nflag:'0', seqno:'1']
		list << [type:'1', name:'itemId', nflag:'0', seqno:'2']
		list << [type:'2', name:'itemId', nflag:'1', seqno:'11']
		list << [type:'2', name:'itemName', nflag:'1', seqno:'12']
		list << [type:'2', name:'unitDes', nflag:'1', seqno:'13']
		list << [type:'2', name:'freeRes', nflag:'1', seqno:'14']
		list << [type:'2', name:'freeResUsed', nflag:'1', seqno:'15']
		list << [type:'2', name:'freeResLeft', nflag:'1', seqno:'16']
		list
	}
	
	@Override
	List getOutInterfaceParams() {
		def list = []
		list << [type:'1', name:'SvcNum', nflag:'1', seqno:'1']
		list << [type:'1', name:'ItemId', nflag:'1', seqno:'2']
		list << [type:'2', name:'ITEM_ID', nflag:'1', seqno:'11']
		list << [type:'2', name:'ITEM_NAME', nflag:'1', seqno:'12']
		list << [type:'2', name:'UNIT_DES', nflag:'1', seqno:'13']
		list << [type:'2', name:'FREE_RES', nflag:'1', seqno:'14']
		list << [type:'2', name:'FREE_RES_USED', nflag:'1', seqno:'15']
		list << [type:'2', name:'FREE_RES_LEFT', nflag:'1', seqno:'16']
		list
	}
	
	@Override
	List getInterfaceParamsMapping() {
		def list = []
		list << [name1:'userMobile', name2:'SvcNum', type:'1']
		list << [name1:'itemId', name2:'ItemId', type:'1']
		list << [name1:'itemId', name2:'ITEM_ID', type:'2']
		list << [name1:'itemName', name2:'ITEM_NAME', type:'2']
		list << [name1:'unitDes', name2:'UNIT_DES', type:'2']
		list << [name1:'freeRes', name2:'FREE_RES', type:'2']
		list << [name1:'freeResUsed', name2:'FREE_RES_USED', type:'2']
		list << [name1:'freeResLeft', name2:'FREE_RES_LEFT', type:'2']
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
		file << channelAuthSql
		file << secretKeySql
		file << encryptRelSql
	}
}
