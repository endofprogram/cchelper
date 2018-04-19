package org.eop.groovy.cchelper.test.sql.gs931.online

import java.util.List
import java.util.Map

class GsQueryMoreNumQueryService extends OnlineByNengkaiCommonOneSqlTest{

	@Override
	public String getSqlFilePrefix() {
		'online';
	}

	@Override
	public String getDistinctName() {
		'一证多号查询';
	}
	
	@Override
	public String getDepKey() {
		'QueryMoreNum';
	}

	@Override
	public Map getInIntfMap() {
		['cls':'gsQueryMoreNumQueryInService','path': 'business/gs/QueryMoreNum', 'method': 'GET']
	}                                                
	@Override
	public List getInParams() {
		['reqInfo'];
	}

	@Override
	public Map getOutIntfMap() {
		[ 'cls':'gsQueryMoreNumQueryOutService', 'path': '/openapi/V1/Party/Customer/queryMsisdnByCredentials4Online', 'method': 'POST']
	}

	
	
}
