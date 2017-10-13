package org.eop.groovy.cchelper.test.sql.hn371

import java.util.List
import java.util.Map

import org.eop.groovy.cchelper.test.sql.AbstractSqlTest
import org.junit.Test

/**
 * @author lixinjie
 */
class _01LLCXTest extends AbstractSqlTest {

	@Override
	Map getSqlFile() {
		[dir:'E:\\yaxin\\需求\\河南接口\\数据库\\测试环境\\', name:'01流量查询']
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
		[route:'1', name:'直连_查询_流量查询', clsnm:'userMobileCommonIntfService', type:'1', path:'business/gs/flowQuery', bizcode:'', method:'GET', fmttype:'json', entid:'', desc:'直连_查询_流量查询(20170411_in)', biztype:'001']
	}
	
	@Override
	Map getOutInterface() {
		[route:'1', name:'河南_查询_流量查询', clsnm:'hnResultIsArrayQueryService', type:'1', path:'/oppf?postSysParam=true&busiKey=jsonParams', bizcode:'ESB_NEW_WAP_161108', method:'POST', fmttype:'json', entid:'10', desc:'河南_查询_流量查询(20170411_out)', biztype:'001']
	}
	
	@Override
	List getInInterfaceParams() {
		def list = []
		list << [type:'1', name:'userMobile', nflag:'0', seqno:'01']
		list << [type:'2', name:'monthUsed', nflag:'1', seqno:'11']
		list << [type:'2', name:'gnLeft', nflag:'1', seqno:'12']
		list << [type:'2', name:'gnUsed', nflag:'1', seqno:'13']
		list << [type:'2', name:'jryy', nflag:'1', seqno:'14']
		list << [type:'2', name:'totalLeft', nflag:'1', seqno:'15']
		list << [type:'2', name:'snLeft', nflag:'1', seqno:'16']
		list << [type:'2', name:'snUsed', nflag:'1', seqno:'17']
		list << [type:'2', name:'tnUsed', nflag:'1', seqno:'18']
		list << [type:'2', name:'twUsed', nflag:'1', seqno:'19']
		list << [type:'2', name:'xsLeft', nflag:'1', seqno:'20']
		list << [type:'2', name:'xsUsed', nflag:'1', seqno:'21']
		list << [type:'2', name:'totalUsed', nflag:'1', seqno:'22']
		list << [type:'2', name:'total', nflag:'1', seqno:'23']
		list << [type:'2', name:'zyLeft', nflag:'1', seqno:'24']
		list << [type:'2', name:'zyUsed', nflag:'1', seqno:'25']
		list
	}
	
	@Override
	List getOutInterfaceParams() {
		def list = []
		list << [type:'1', name:'svcNum', nflag:'1', seqno:'01']
		list << [type:'2', name:'BYYYZLL', nflag:'1', seqno:'11']
		list << [type:'2', name:'GN_LEFT', nflag:'1', seqno:'12']
		list << [type:'2', name:'GN_USED', nflag:'1', seqno:'13']
		list << [type:'2', name:'JRYY', nflag:'1', seqno:'14']
		list << [type:'2', name:'LEFTZL', nflag:'1', seqno:'15']
		list << [type:'2', name:'SN_LEFT', nflag:'1', seqno:'16']
		list << [type:'2', name:'SN_USED', nflag:'1', seqno:'17']
		list << [type:'2', name:'TN', nflag:'1', seqno:'18']
		list << [type:'2', name:'TW', nflag:'1', seqno:'19']
		list << [type:'2', name:'XS_LEFT', nflag:'1', seqno:'20']
		list << [type:'2', name:'XS_USED', nflag:'1', seqno:'21']
		list << [type:'2', name:'YSYZL', nflag:'1', seqno:'22']
		list << [type:'2', name:'ZLL', nflag:'1', seqno:'23']
		list << [type:'2', name:'ZY_LEFT', nflag:'1', seqno:'24']
		list << [type:'2', name:'ZY_USED', nflag:'1', seqno:'25']
		list
	}
	
	@Override
	List getInterfaceParamsMapping() {
		def list = []
		list << [name1:'userMobile', name2:'svcNum', type:'1']
		list << [name1:'monthUsed', name2:'BYYYZLL', type:'2']
		list << [name1:'gnLeft', name2:'GN_LEFT', type:'2']
		list << [name1:'gnUsed', name2:'GN_USED', type:'2']
		list << [name1:'jryy', name2:'JRYY', type:'2']
		list << [name1:'totalLeft', name2:'LEFTZL', type:'2']
		list << [name1:'snLeft', name2:'SN_LEFT', type:'2']
		list << [name1:'snUsed', name2:'SN_USED', type:'2']
		list << [name1:'tnUsed', name2:'TN', type:'2']
		list << [name1:'twUsed', name2:'TW', type:'2']
		list << [name1:'xsLeft', name2:'XS_LEFT', type:'2']
		list << [name1:'xsUsed', name2:'XS_USED', type:'2']
		list << [name1:'totalUsed', name2:'YSYZL', type:'2']
		list << [name1:'total', name2:'ZLL', type:'2']
		list << [name1:'zyLeft', name2:'ZY_LEFT', type:'2']
		list << [name1:'zyUsed', name2:'ZY_USED', type:'2']
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
