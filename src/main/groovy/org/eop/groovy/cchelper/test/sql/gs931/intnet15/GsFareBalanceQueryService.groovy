package org.eop.groovy.cchelper.test.sql.gs931.intnet15

import java.util.List
import java.util.Map

class GsFareBalanceQueryService extends Intnet15ByNengkaiCommonOneSqlTest {

	@Override
	String getSqlFilePrefix() {
		'int15'
	}

	@Override
	String getDistinctName() {
		'实时话费查询'
	}

	@Override
	String getDepKey() {
		'FareBalance'
	}
	@Override
	Map getInIntfMap() {
		['cls':'gsFareBalanceQueryInService','path': 'business/gs/FareBalance', 'method': 'GET']
	}

	@Override
	List getInParams() {
		['userMobile']
	}

	@Override
	Map getOutIntfMap() {
		[ 'cls':'gsFareBalanceQueryOutService', 'path': '/openapi/V1/Charge/Allowance/queryOweFee4Online', 'method': 'POST']
	}

}
