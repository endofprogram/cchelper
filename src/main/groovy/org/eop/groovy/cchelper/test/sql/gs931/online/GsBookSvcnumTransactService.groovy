package org.eop.groovy.cchelper.test.sql.gs931.online

import java.util.List
import java.util.Map

class GsBookSvcnumTransactService extends OnlineByNengkaiCommonOneSqlTest{
	@Override
	public String getSqlFilePrefix() {
		'online';
	}

	@Override
	public String getDistinctName() {
		'号码预占接口';
	}
	
	@Override
	public String getDepKey() {
		'BookSvcnum';
	}

	@Override
	public Map getInIntfMap() {
		['cls':'gsBookSvcnumTransactInService','path': 'business/gs/BookSvcnum', 'method': 'POST']
	}
	@Override
	public List getInParams() {
		['transactionID','reqInfo'];
	}

	@Override
	public Map getOutIntfMap() {
		[ 'cls':'gsBookSvcnumTransactOutService', 'path': '/openapi/V1/Resource/Msisdn/submitPreOccupyingMsisdn4Online', 'method': 'POST']
	}
}
