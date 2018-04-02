package org.eop.groovy.cchelper.test.sql.gs931.online

import java.util.List
import java.util.Map

class GsQuerySvmStatusQueryService extends OnlineByNengkaiCommonOneSqlTest{

	@Override
	public String getSqlFilePrefix() {
		'online';
	}

	@Override
	public String getDistinctName() {
		'用户状态查询';
	}
	
	@Override
	public String getDepKey() {
		'QuerySvmStatus';
	}

	@Override
	public Map getInIntfMap() {
		['cls':'gsQuerySvmStatusQueryInService','path': 'business/gs/QuerySvmStatus', 'method': 'GET']
	}                                                
	@Override
	public List getInParams() {
		['reqInfo'];
	}

	@Override
	public Map getOutIntfMap() {
		[ 'cls':'gsQuerySvmStatusQueryOutService', 'path': '/openapi/V1/Party/User/queryUserStatus4Online', 'method': 'POST']
	}

	
	
}
