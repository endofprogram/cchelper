package org.eop.groovy.cchelper.test.sql.migu

import java.util.List
import java.util.Map

import org.eop.groovy.cchelper.test.sql.AbstractSqlTest
import org.junit.Test

/**
 * @author lixinjie
 */
class _02ReqArchive extends AbstractSqlTest {

	@Override
	Map getSqlFile() {
		[dir:'E:\\yaxin\\需求\\咪咕公司接口\\数据库\\测试环境\\', name:'02咪咕-服务请求归档']
	}
	
	@Override
	Map getDb() {
		[name:'interfacepf']
	}
	
	@Override
	Map getBusiSystem() {
		[name:'咪咕公司', desc:'咪咕公司', prov:'migu', code:'MIGU']
	}

	@Override
	Map getChannel() {
		[name:'咪咕公司', addr:'http://218.206.190.10:7701']
	}
	
	@Override
	List getStaticConfig() {
		def list = []
		list << [type:'Migu', fst:'Paging', sec:'InInterfaceId', val:'', rmk:'分页查询接入接口Id']
		list << [type:'Migu', fst:'Paging', sec:'OutInterfaceId', val:'', rmk:'分页查询转接接口Id']
		list
	}

	@Override
	Map getInInterface() {
		[route:'', name:'咪咕公司_咪咕-服务请求归档', clsnm:'miguIntfService', type:'1', path:'business/migu/reqArchive', bizcode:'', method:'PUT', fmttype:'json', entid:'', desc:'咪咕公司_咪咕-服务请求归档(20170606_in)', biztype:'002']
	}
	
	@Override
	Map getOutInterface() {
		[route:'', name:'网状网_咪咕-服务请求归档', clsnm:'miguCommonService', type:'1', path:'/Trans/Receiver', bizcode:'', method:'POST', fmttype:'xml', entid:'10', desc:'网状网_咪咕-服务请求归档(20170606_out)', biztype:'002']
	}
	
	@Override
	List getInInterfaceParams() {
		def list = []
		list << [type:'1', name:'indictSeq', nflag:'0', seqno:'1']
		list << [type:'1', name:'handlingDept', nflag:'0', seqno:'2']
		list << [type:'1', name:'handlingStaff', nflag:'0', seqno:'3']
		list << [type:'1', name:'handlingComment', nflag:'0', seqno:'4']
		list << [type:'1', name:'time', nflag:'1', seqno:'5']
		
		list << [type:'2', name:'operRtnStaId', nflag:'1', seqno:'101']
		list << [type:'2', name:'rsltTotalCnt', nflag:'1', seqno:'102']
		list << [type:'2', name:'rsltPageMaxCnt', nflag:'1', seqno:'103']
		list << [type:'2', name:'rsltPageCurrCnt', nflag:'1', seqno:'104']
		list << [type:'2', name:'rsltPageNum', nflag:'1', seqno:'105']
		list << [type:'2', name:'rsltTotalPages', nflag:'1', seqno:'106']
		list << [type:'2', name:'qryRsltList', nflag:'1', seqno:'107']
		list
	}
	
	@Override
	List getOutInterfaceParams() {
		def list = []
		list << [type:'1', name:'IndictSeq', nflag:'1', seqno:'1']
		list << [type:'1', name:'HandlingDept', nflag:'1', seqno:'2']
		list << [type:'1', name:'HandlingStaff', nflag:'1', seqno:'3']
		list << [type:'1', name:'HandlingComment', nflag:'1', seqno:'4']
		list << [type:'1', name:'Time', nflag:'1', seqno:'5']
		
		list << [type:'2', name:'OperRtnStaId', nflag:'1', seqno:'101']
		list << [type:'2', name:'RsltTotalCnt', nflag:'1', seqno:'102']
		list << [type:'2', name:'RsltPageMaxCnt', nflag:'1', seqno:'103']
		list << [type:'2', name:'RsltPageCurrCnt', nflag:'1', seqno:'104']
		list << [type:'2', name:'RsltPageNum', nflag:'1', seqno:'105']
		list << [type:'2', name:'RsltTotalPages', nflag:'1', seqno:'106']
		list << [type:'2', name:'QryRsltList', nflag:'1', seqno:'107']
		list
	}
	
	@Override
	List getInterfaceParamsMapping() {
		def list = []
		list << [name1:'indictSeq', name2:'IndictSeq', type:'1']
		list << [name1:'handlingDept', name2:'HandlingDept', type:'1']
		list << [name1:'handlingStaff', name2:'HandlingStaff', type:'1']
		list << [name1:'handlingComment', name2:'HandlingComment', type:'1']
		list << [name1:'time', name2:'Time', type:'1']
		
		list << [name1:'operRtnStaId', name2:'OperRtnStaId', type:'2']
		list << [name1:'rsltTotalCnt', name2:'RsltTotalCnt', type:'2']
		list << [name1:'rsltPageMaxCnt', name2:'RsltPageMaxCnt', type:'2']
		list << [name1:'rsltPageCurrCnt', name2:'RsltPageCurrCnt', type:'2']
		list << [name1:'rsltPageNum', name2:'RsltPageNum', type:'2']
		list << [name1:'rsltTotalPages', name2:'RsltTotalPages', type:'2']
		list << [name1:'qryRsltList', name2:'QryRsltList', type:'2']
		list
	}
	
	@Override
	List getOutInterfaceParamsStatic() {
		def list = []
		list << [name:'BIPCode', value:'BIP2B322', seqno:'01']
		list << [name:'ActivityCode', value:'T2001322', seqno:'02']
		list << [name:'reqRootElement', value:'SvcRoot', seqno:'03']
		list << [name:'provCodeSuccess', value:'0000', seqno:'04']
		list << [name:'resultCodeSuccess', value:'00000', seqno:'05']
		list << [name:'resultDescSuccess', value:'成功', seqno:'06']
		list << [name:'rpsTypeElement', value:'RspType', seqno:'07']
		list << [name:'rpsCodeElement', value:'RspCode', seqno:'08']
		list << [name:'rpsDescElement', value:'RspDesc', seqno:'09']
		list
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
		outInterfaceParamsStaticSql.each{
			file << it
		}
		file << channelAuthSql
	}
}
