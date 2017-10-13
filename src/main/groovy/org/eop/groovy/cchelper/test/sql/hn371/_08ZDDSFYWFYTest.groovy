package org.eop.groovy.cchelper.test.sql.hn371

import java.util.List
import java.util.Map

import org.eop.groovy.cchelper.test.sql.AbstractSqlTest
import org.junit.Test

/**
 * @author lixinjie
 */
class _08ZDDSFYWFYTest extends AbstractSqlTest {

	@Override
	Map getSqlFile() {
		[dir:'E:\\yaxin\\需求\\河南接口\\数据库\\测试环境\\', name:'08账单代收费业务费用']
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
		[route:'1', name:'直连_查询_账单代收费业务费用', clsnm:'userMobileCommonIntfService', type:'1', path:'business/gs/billAgencyFeeBusi', bizcode:'', method:'GET', fmttype:'json', entid:'', desc:'直连_查询_账单代收费业务费用(20170411_in)', biztype:'001']
	}
	
	@Override
	Map getOutInterface() {
		[route:'1', name:'河南_查询_账单代收费业务费用', clsnm:'hnResultIsArrayQueryService', type:'1', path:'/oppf?postSysParam=true&busiKey=jsonParams', bizcode:'ESB_CLOUD_BUSINESS_920138', method:'POST', fmttype:'json', entid:'10', desc:'河南_查询_账单代收费业务费用(20170411_out)', biztype:'001']
	}
	
	@Override
	List getInInterfaceParams() {
		def list = []
		list << [type:'1', name:'userMobile', nflag:'0', seqno:'1']
		list << [type:'1', name:'billingCycle', nflag:'0', seqno:'2']
		list << [type:'1', name:'beginDate', nflag:'0', seqno:'3']
		list << [type:'1', name:'endDate', nflag:'0', seqno:'4']
		list << [type:'1', name:'optrId', nflag:'0', seqno:'5']
		
		list << [type:'2', name:'busiPort', nflag:'1', seqno:'11']
		list << [type:'2', name:'busiName', nflag:'1', seqno:'12']
		list << [type:'2', name:'spName', nflag:'1', seqno:'13']
		list << [type:'2', name:'useType', nflag:'1', seqno:'14']
		list << [type:'2', name:'feeType', nflag:'1', seqno:'15']
		list << [type:'2', name:'chargeFee', nflag:'1', seqno:'16']
		list << [type:'2', name:'totalFee', nflag:'1', seqno:'17']
		list
	}
	
	@Override
	List getOutInterfaceParams() {
		def list = []
		list << [type:'1', name:'SvcNum', nflag:'1', seqno:'1']
		list << [type:'1', name:'BILLING_CYCLE', nflag:'1', seqno:'2']
		list << [type:'1', name:'CYCLE_BEGIN_DATE', nflag:'1', seqno:'3']
		list << [type:'1', name:'CYCLE_END_DATE', nflag:'1', seqno:'4']
		list << [type:'1', name:'optrid', nflag:'1', seqno:'5']
		
		list << [type:'2', name:'BUSI_PORT', nflag:'1', seqno:'11']
		list << [type:'2', name:'BUSI_NAME', nflag:'1', seqno:'12']
		list << [type:'2', name:'SP_NAME', nflag:'1', seqno:'13']
		list << [type:'2', name:'USE_TYPE', nflag:'1', seqno:'14']
		list << [type:'2', name:'FEE_TYPE', nflag:'1', seqno:'15']
		list << [type:'2', name:'CHARGE_FEE', nflag:'1', seqno:'16']
		list << [type:'2', name:'TOTAL_FEE', nflag:'1', seqno:'17']
		list
	}
	
	@Override
	List getInterfaceParamsMapping() {
		def list = []
		list << [name1:'userMobile', name2:'SvcNum', type:'1']
		list << [name1:'billingCycle', name2:'BILLING_CYCLE', type:'1']
		list << [name1:'beginDate', name2:'CYCLE_BEGIN_DATE', type:'1']
		list << [name1:'endDate', name2:'CYCLE_END_DATE', type:'1']
		list << [name1:'optrId', name2:'optrid', type:'1']
		
		list << [name1:'busiPort', name2:'BUSI_PORT', type:'2']
		list << [name1:'busiName', name2:'BUSI_NAME', type:'2']
		list << [name1:'spName', name2:'SP_NAME', type:'2']
		list << [name1:'useType', name2:'USE_TYPE', type:'2']
		list << [name1:'feeType', name2:'FEE_TYPE', type:'2']
		list << [name1:'chargeFee', name2:'CHARGE_FEE', type:'2']
		list << [name1:'totalFee', name2:'TOTAL_FEE', type:'2']
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
