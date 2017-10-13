package org.eop.groovy.cchelper.test.sql.migu.music

import java.util.List
import java.util.Map

import org.eop.groovy.cchelper.test.sql.AbstractSqlTest
import org.junit.Test

/**
 * @author lixinjie
 */
class _302MthHisOpeRecQry extends AbstractSqlTest {

	@Override
	Map getSqlFile() {
		[dir:'E:\\yaxin\\需求\\咪咕公司接口\\数据库\\测试环境\\', name:'302咪咕音乐-包月历史操作记录查询']
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
		[route:'', name:'咪咕公司_查询_咪咕音乐-包月历史操作记录查询', clsnm:'miguIntfService', type:'1', path:'business/migu/music/mthHisOpeRecQry', bizcode:'', method:'GET', fmttype:'json', entid:'', desc:'咪咕公司_查询_咪咕音乐-包月历史操作记录查询(20170606_in)', biztype:'001']
	}
	
	@Override
	Map getOutInterface() {
		[route:'', name:'网状网_查询_咪咕音乐-包月历史操作记录查询', clsnm:'miguQueryTransactService', type:'1', path:'/Trans/Receiver', bizcode:'', method:'POST', fmttype:'xml', entid:'10', desc:'网状网_查询_咪咕音乐-包月历史操作记录查询(20170606_out)', biztype:'001']
	}
	
	@Override
	List getInInterfaceParams() {
		def list = []
		list << [type:'1', name:'indictSeq', nflag:'0', seqno:'1']
		list << [type:'1', name:'callerNo', nflag:'1', seqno:'2']
		list << [type:'1', name:'calledNo', nflag:'1', seqno:'3']
		list << [type:'1', name:'subsName', nflag:'1', seqno:'4']
		list << [type:'1', name:'subsLevel', nflag:'1', seqno:'5']
		list << [type:'1', name:'subsBrand', nflag:'1', seqno:'6']
		list << [type:'1', name:'svcTypeId', nflag:'0', seqno:'7']
		list << [type:'1', name:'homeProv', nflag:'0', seqno:'8']
		list << [type:'1', name:'svcCity', nflag:'0', seqno:'9']
		list << [type:'1', name:'originTime', nflag:'0', seqno:'10']
		list << [type:'1', name:'acceptTime', nflag:'0', seqno:'11']
		list << [type:'1', name:'acceptStaff', nflag:'1', seqno:'12']
		list << [type:'1', name:'contactChannel', nflag:'0', seqno:'13']
		list << [type:'1', name:'serviceTypeId', nflag:'1', seqno:'14']
		list << [type:'1', name:'operateTypeId', nflag:'1', seqno:'15']
		list << [type:'1', name:'operateConditions', nflag:'1', seqno:'16']
		list << [type:'1', name:'queryPageNum', nflag:'1', seqno:'17']
		
		list << [type:'1', name:'userMobile', nflag:'0', seqno:'20']
		list << [type:'1', name:'beginTime', nflag:'0', seqno:'20']
		list << [type:'1', name:'endTime', nflag:'0', seqno:'20']
		
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
		list << [type:'1', name:'CallerNo', nflag:'1', seqno:'2']
		list << [type:'1', name:'CalledNo', nflag:'1', seqno:'3']
		list << [type:'1', name:'SubsName', nflag:'1', seqno:'4']
		list << [type:'1', name:'SubsLevel', nflag:'1', seqno:'5']
		list << [type:'1', name:'SubsBrand', nflag:'1', seqno:'6']
		list << [type:'1', name:'SvcTypeId', nflag:'1', seqno:'7']
		list << [type:'1', name:'HomeProv', nflag:'1', seqno:'8']
		list << [type:'1', name:'SvcCity', nflag:'1', seqno:'9']
		list << [type:'1', name:'OriginTime', nflag:'1', seqno:'10']
		list << [type:'1', name:'AcceptTime', nflag:'1', seqno:'11']
		list << [type:'1', name:'AcceptStaff', nflag:'1', seqno:'12']
		list << [type:'1', name:'ContactChannel', nflag:'1', seqno:'13']
		list << [type:'1', name:'ServiceTypeId', nflag:'1', seqno:'14']
		list << [type:'1', name:'OperateTypeId', nflag:'1', seqno:'15']
		list << [type:'1', name:'OperateConditions', nflag:'1', seqno:'16']
		
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
		list << [name1:'callerNo', name2:'CallerNo', type:'1']
		list << [name1:'calledNo', name2:'CalledNo', type:'1']
		list << [name1:'subsName', name2:'SubsName', type:'1']
		list << [name1:'subsLevel', name2:'SubsLevel', type:'1']
		list << [name1:'subsBrand', name2:'SubsBrand', type:'1']
		list << [name1:'svcTypeId', name2:'SvcTypeId', type:'1']
		list << [name1:'homeProv', name2:'HomeProv', type:'1']
		list << [name1:'svcCity', name2:'SvcCity', type:'1']
		list << [name1:'originTime', name2:'OriginTime', type:'1']
		list << [name1:'acceptTime', name2:'AcceptTime', type:'1']
		list << [name1:'acceptStaff', name2:'AcceptStaff', type:'1']
		list << [name1:'contactChannel', name2:'ContactChannel', type:'1']
		list << [name1:'serviceTypeId', name2:'ServiceTypeId', type:'1']
		list << [name1:'operateTypeId', name2:'OperateTypeId', type:'1']
		list << [name1:'operateConditions', name2:'OperateConditions', type:'1']
		
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
		list << [name:'BIPCode', value:'BIP2C092', seqno:'01']
		list << [name:'ActivityCode', value:'T2002092', seqno:'02']
		list << [name:'reqRootElement', value:'SvcRoot', seqno:'03']
		list << [name:'provCodeSuccess', value:'0000', seqno:'04']
		list << [name:'resultCodeSuccess', value:'00000', seqno:'05']
		list << [name:'resultDescSuccess', value:'成功', seqno:'06']
		list << [name:'rpsTypeElement', value:'RspType', seqno:'07']
		list << [name:'rpsCodeElement', value:'RspCode', seqno:'08']
		list << [name:'rpsDescElement', value:'RspDesc', seqno:'09']
		
		list << [name:'param_in_mapping', value:'1|userMobile,2|beginTime,3|endTime', seqno:'20']
		list << [name:'param_out_mapping', value:'1|recordNo,2|businessName,3|businessType,4|operateType,5|operateWay,6|operateChannel,7|operateTime,8|operateResult', seqno:'21']
		
		list << [name:'serviceTypeId', value:'72', seqno:'30']
		list << [name:'operateTypeId', value:'3104', seqno:'31']
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
