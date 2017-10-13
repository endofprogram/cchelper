package org.eop.groovy.cchelper.test.sql.hn371

import java.util.List
import java.util.Map

import org.eop.groovy.cchelper.test.sql.AbstractSqlTest
import org.junit.Test

/**
 * @author lixinjie
 */
class _10YHHFTest extends AbstractSqlTest {

	@Override
	Map getSqlFile() {
		[dir:'E:\\yaxin\\需求\\河南接口\\数据库\\测试环境\\', name:'10用户话费']
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
		[route:'1', name:'直连_查询_用户话费', clsnm:'userMobileCommonIntfService', type:'1', path:'business/gs/userPhoneFee', bizcode:'', method:'GET', fmttype:'json', entid:'', desc:'直连_查询_用户话费(20170411_in)', biztype:'001']
	}
	
	@Override
	Map getOutInterface() {
		[route:'1', name:'河南_查询_用户话费', clsnm:'hnResultIsArrayQueryService', type:'1', path:'/oppf?postSysParam=true&busiKey=jsonParams', bizcode:'SO_QUERY_FEE_161201', method:'POST', fmttype:'json', entid:'10', desc:'河南_查询_用户话费(20170411_out)', biztype:'001']
	}
	
	@Override
	List getInInterfaceParams() {
		def list = []
		list << [type:'1', name:'userMobile', nflag:'0', seqno:'1']
		
		list << [type:'2', name:'instantFee', nflag:'1', seqno:'11']
		list << [type:'2', name:'monthFee', nflag:'1', seqno:'12']
		list << [type:'2', name:'feeLeft', nflag:'1', seqno:'13']
		list << [type:'2', name:'instantFeeFlag', nflag:'1', seqno:'14']
		list << [type:'2', name:'effectiveDate', nflag:'1', seqno:'15']
		list << [type:'2', name:'feeEndDate', nflag:'1', seqno:'16']
		list << [type:'2', name:'prevMonthFee', nflag:'1', seqno:'17']
		list << [type:'2', name:'cycleEndDay', nflag:'1', seqno:'18']
		list << [type:'2', name:'userBrand', nflag:'1', seqno:'19']
		list
	}
	
	@Override
	List getOutInterfaceParams() {
		def list = []
		list << [type:'1', name:'SvcNum', nflag:'1', seqno:'1']
		
		list << [type:'2', name:'INSTANTFEE', nflag:'1', seqno:'11']
		list << [type:'2', name:'当月费用合计', nflag:'1', seqno:'12']
		list << [type:'2', name:'余额', nflag:'1', seqno:'13']
		list << [type:'2', name:'立即话费标志', nflag:'1', seqno:'14']
		list << [type:'2', name:'有效期时间', nflag:'1', seqno:'15']
		list << [type:'2', name:'话费截止日期', nflag:'1', seqno:'16']
		list << [type:'2', name:'上月话费', nflag:'1', seqno:'17']
		list << [type:'2', name:'结账日', nflag:'1', seqno:'18']
		list << [type:'2', name:'用户品牌', nflag:'1', seqno:'19']
		list
	}
	
	@Override
	List getInterfaceParamsMapping() {
		def list = []
		list << [name1:'userMobile', name2:'SvcNum', type:'1']
		
		list << [name1:'instantFee', name2:'INSTANTFEE', type:'2']
		list << [name1:'monthFee', name2:'当月费用合计', type:'2']
		list << [name1:'feeLeft', name2:'余额', type:'2']
		list << [name1:'instantFeeFlag', name2:'立即话费标志', type:'2']
		list << [name1:'effectiveDate', name2:'有效期时间', type:'2']
		list << [name1:'feeEndDate', name2:'话费截止日期', type:'2']
		list << [name1:'prevMonthFee', name2:'上月话费', type:'2']
		list << [name1:'cycleEndDay', name2:'结账日', type:'2']
		list << [name1:'userBrand', name2:'用户品牌', type:'2']
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
