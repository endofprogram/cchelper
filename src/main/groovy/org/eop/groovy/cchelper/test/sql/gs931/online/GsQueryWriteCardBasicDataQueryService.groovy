package org.eop.groovy.cchelper.test.sql.gs931.online

import java.util.List
import java.util.Map

class GsQueryWriteCardBasicDataQueryService extends OnlineByNengkaiCommonOneSqlTest{

	@Override
	public String getSqlFilePrefix() {
		'online';
	}

	@Override
	public String getDistinctName() {
		'获取写卡基础数据';
	}
	
	@Override
	public String getDepKey() {
		'QueryWriteCardBasicData';
	}

	@Override
	public Map getInIntfMap() {
		['cls':'gsQueryWriteCardBasicDataQueryInService','path': 'business/gs/QueryWriteCardBasicData', 'method': 'GET']
	}                                                
	@Override
	public List getInParams() {
		['transactionID','reqInfo'];
	}

	@Override
	public Map getOutIntfMap() {
		[ 'cls':'gsQueryWriteCardBasicDataQueryOutService', 'path': '/openapi/V1/Resource/Sim/queryWriteCardData4Online', 'method': 'POST']
	}

	
	
}
