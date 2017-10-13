package org.eop.groovy.cchelper.test.sql.hn371

import java.util.List
import java.util.Map

import org.eop.groovy.cchelper.test.sql.AbstractSqlTest
import org.junit.Test

/**
 * @author lixinjie
 */
class _09YJZDBGTest extends AbstractSqlTest {

	@Override
	Map getSqlFile() {
		[dir:'E:\\yaxin\\需求\\河南接口\\数据库\\测试环境\\', name:'09一级账单项表格']
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
		[route:'1', name:'直连_查询_一级账单项表格', clsnm:'userMobileCommonIntfService', type:'1', path:'business/gs/levelOneBillTable', bizcode:'', method:'GET', fmttype:'json', entid:'', desc:'直连_查询_一级账单项表格(20170411_in)', biztype:'001']
	}
	
	@Override
	Map getOutInterface() {
		[route:'1', name:'河南_查询_一级账单项表格', clsnm:'hnResultIsArrayQueryService', type:'1', path:'/oppf?postSysParam=true&busiKey=jsonParams', bizcode:'SO_QUERY_LEVEL_ONE_BILL', method:'POST', fmttype:'json', entid:'10', desc:'河南_查询_一级账单项表格(20170411_out)', biztype:'001']
	}
	
	@Override
	List getInInterfaceParams() {
		def list = []
		list << [type:'1', name:'userMobile', nflag:'0', seqno:'1']
		list << [type:'1', name:'billingCycle', nflag:'0', seqno:'2']
		list << [type:'1', name:'endDay', nflag:'0', seqno:'3']
		list << [type:'1', name:'beginDate', nflag:'0', seqno:'4']
		list << [type:'1', name:'endDate', nflag:'0', seqno:'5']
		
		list << [type:'2', name:'billItemId', nflag:'1', seqno:'11']
		list << [type:'2', name:'billItemName', nflag:'1', seqno:'12']
		list << [type:'2', name:'billItemAmount', nflag:'1', seqno:'13']
		list << [type:'2', name:'sum', nflag:'1', seqno:'14']
		list << [type:'2', name:'otherPay1', nflag:'1', seqno:'15']
		list << [type:'2', name:'otherPay2', nflag:'1', seqno:'16']
		list << [type:'2', name:'otherPay3', nflag:'1', seqno:'17']
		list << [type:'2', name:'otherPay4', nflag:'1', seqno:'18']
		list << [type:'2', name:'svcNum', nflag:'1', seqno:'19']
		list << [type:'2', name:'custName', nflag:'1', seqno:'20']
		list << [type:'2', name:'brandName', nflag:'1', seqno:'21']
		list << [type:'2', name:'brandId', nflag:'1', seqno:'22']
		list << [type:'2', name:'billingCycleStart', nflag:'1', seqno:'23']
		list << [type:'2', name:'billingCycleEnd', nflag:'1', seqno:'24']
		list
	}
	
	@Override
	List getOutInterfaceParams() {
		def list = []
		list << [type:'1', name:'SVC_NUM', nflag:'1', seqno:'1']
		list << [type:'1', name:'BILLING_CYCLE', nflag:'1', seqno:'2']
		list << [type:'1', name:'CYCLE_END_DAY', nflag:'1', seqno:'3']
		list << [type:'1', name:'CYCLE_BEGIN_DATE', nflag:'1', seqno:'4']
		list << [type:'1', name:'CYCLE_END_DATE', nflag:'1', seqno:'5']
		
		list << [type:'2', name:'BILL_ITEM_ID', nflag:'1', seqno:'11']
		list << [type:'2', name:'BILL_ITEM_NAME', nflag:'1', seqno:'12']
		list << [type:'2', name:'BILL_ITEM_AMOUNT', nflag:'1', seqno:'13']
		list << [type:'2', name:'SUM', nflag:'1', seqno:'14']
		list << [type:'2', name:'OTHER_PAY1', nflag:'1', seqno:'15']
		list << [type:'2', name:'OTHER_PAY2', nflag:'1', seqno:'16']
		list << [type:'2', name:'OTHER_PAY3', nflag:'1', seqno:'17']
		list << [type:'2', name:'OTHER_PAY4', nflag:'1', seqno:'18']
		list << [type:'2', name:'SVCNUM', nflag:'1', seqno:'19']
		list << [type:'2', name:'CUST_NAME', nflag:'1', seqno:'20']
		list << [type:'2', name:'BRAND_NAME', nflag:'1', seqno:'21']
		list << [type:'2', name:'BRAND_ID', nflag:'1', seqno:'22']
		list << [type:'2', name:'BILLING_CYCLE_START', nflag:'1', seqno:'23']
		list << [type:'2', name:'BILLING_CYCLE_END', nflag:'1', seqno:'24']
		list
	}
	
	@Override
	List getInterfaceParamsMapping() {
		def list = []
		list << [name1:'userMobile', name2:'SVC_NUM', type:'1']
		list << [name1:'billingCycle', name2:'BILLING_CYCLE', type:'1']
		list << [name1:'endDay', name2:'CYCLE_END_DAY', type:'1']
		list << [name1:'beginDate', name2:'CYCLE_BEGIN_DATE', type:'1']
		list << [name1:'endDate', name2:'CYCLE_END_DATE', type:'1']
		
		list << [name1:'billItemId', name2:'BILL_ITEM_ID', type:'2']
		list << [name1:'billItemName', name2:'BILL_ITEM_NAME', type:'2']
		list << [name1:'billItemAmount', name2:'BILL_ITEM_AMOUNT', type:'2']
		list << [name1:'sum', name2:'SUM', type:'2']
		list << [name1:'otherPay1', name2:'OTHER_PAY1', type:'2']
		list << [name1:'otherPay2', name2:'OTHER_PAY2', type:'2']
		list << [name1:'otherPay3', name2:'OTHER_PAY3', type:'2']
		list << [name1:'otherPay4', name2:'OTHER_PAY4', type:'2']
		list << [name1:'svcNum', name2:'SVCNUM', type:'2']
		list << [name1:'custName', name2:'CUST_NAME', type:'2']
		list << [name1:'brandName', name2:'BRAND_NAME', type:'2']
		list << [name1:'brandId', name2:'BRAND_ID', type:'2']
		list << [name1:'billingCycleStart', name2:'BILLING_CYCLE_START', type:'2']
		list << [name1:'billingCycleEnd', name2:'BILLING_CYCLE_END', type:'2']
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
