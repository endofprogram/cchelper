package org.eop.groovy.cchelper.test.sql.hn371

import java.util.List
import java.util.Map

import org.eop.groovy.cchelper.test.sql.AbstractSqlTest
import org.junit.Test

/**
 * @author lixinjie
 */
class _03LLRBTest extends AbstractSqlTest {

	@Override
	Map getSqlFile() {
		[dir:'E:\\yaxin\\需求\\河南接口\\数据库\\测试环境\\', name:'03流量日报']
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
		[route:'1', name:'直连_查询_流量日报', clsnm:'userMobileCommonIntfService', type:'1', path:'business/gs/flowDailyReport', bizcode:'', method:'GET', fmttype:'json', entid:'', desc:'直连_查询_流量日报(20170411_in)', biztype:'001']
	}
	
	@Override
	Map getOutInterface() {
		[route:'1', name:'河南_查询_流量日报', clsnm:'hnResultIsArrayQueryService', type:'1', path:'/oppf?postSysParam=true&busiKey=jsonParams', bizcode:'ESB_NEW_WAP_200828', method:'POST', fmttype:'json', entid:'10', desc:'河南_查询_流量日报(20170411_out)', biztype:'001']
	}
	
	@Override
	List getInInterfaceParams() {
		def list = []
		list << [type:'1', name:'userMobile', nflag:'0', seqno:'1']
		list << [type:'1', name:'startDay', nflag:'0', seqno:'2']
		list << [type:'1', name:'endDay', nflag:'0', seqno:'3']
		
		list << [type:'2', name:'billDay', nflag:'1', seqno:'11']
		list << [type:'2', name:'dayAllRes', nflag:'1', seqno:'12']
		list << [type:'2', name:'idleRes', nflag:'1', seqno:'13']
		list << [type:'2', name:'busyRes', nflag:'1', seqno:'14']
		list << [type:'2', name:'freeRes', nflag:'1', seqno:'15']
		list << [type:'2', name:'billRes', nflag:'1', seqno:'16']
		list << [type:'2', name:'gjRes', nflag:'1', seqno:'17']
		list << [type:'2', name:'sjRes', nflag:'1', seqno:'18']
		list << [type:'2', name:'snRes', nflag:'1', seqno:'19']
		list << [type:'2', name:'g2Res', nflag:'1', seqno:'20']
		list << [type:'2', name:'g3Res', nflag:'1', seqno:'21']
		list << [type:'2', name:'g4Res', nflag:'1', seqno:'22']
		list
	}
	
	@Override
	List getOutInterfaceParams() {
		def list = []
		list << [type:'1', name:'SvcNum', nflag:'1', seqno:'1']
		list << [type:'1', name:'StartDay', nflag:'1', seqno:'2']
		list << [type:'1', name:'EndDay', nflag:'1', seqno:'3']
		
		list << [type:'2', name:'BILL_DAY', nflag:'1', seqno:'11']
		list << [type:'2', name:'DAY_ALL_RES', nflag:'1', seqno:'12']
		list << [type:'2', name:'IDLE_RES', nflag:'1', seqno:'13']
		list << [type:'2', name:'BUSY_RES', nflag:'1', seqno:'14']
		list << [type:'2', name:'FREE_RES', nflag:'1', seqno:'15']
		list << [type:'2', name:'BILL_RES', nflag:'1', seqno:'16']
		list << [type:'2', name:'GJ_RES', nflag:'1', seqno:'17']
		list << [type:'2', name:'SJ_RES', nflag:'1', seqno:'18']
		list << [type:'2', name:'SN_RES', nflag:'1', seqno:'19']
		list << [type:'2', name:'G2_RES', nflag:'1', seqno:'20']
		list << [type:'2', name:'G3_RES', nflag:'1', seqno:'21']
		list << [type:'2', name:'G4_RES', nflag:'1', seqno:'22']
		list
	}
	
	@Override
	List getInterfaceParamsMapping() {
		def list = []
		list << [name1:'userMobile', name2:'SvcNum', type:'1']
		list << [name1:'startDay', name2:'StartDay', type:'1']
		list << [name1:'endDay', name2:'EndDay', type:'1']
		
		list << [name1:'billDay', name2:'BILL_DAY', type:'2']
		list << [name1:'dayAllRes', name2:'DAY_ALL_RES', type:'2']
		list << [name1:'idleRes', name2:'IDLE_RES', type:'2']
		list << [name1:'busyRes', name2:'BUSY_RES', type:'2']
		list << [name1:'freeRes', name2:'FREE_RES', type:'2']
		list << [name1:'billRes', name2:'BILL_RES', type:'2']
		list << [name1:'gjRes', name2:'GJ_RES', type:'2']
		list << [name1:'sjRes', name2:'SJ_RES', type:'2']
		list << [name1:'snRes', name2:'SN_RES', type:'2']
		list << [name1:'g2Res', name2:'G2_RES', type:'2']
		list << [name1:'g3Res', name2:'G3_RES', type:'2']
		list << [name1:'g4Res', name2:'G4_RES', type:'2']
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
