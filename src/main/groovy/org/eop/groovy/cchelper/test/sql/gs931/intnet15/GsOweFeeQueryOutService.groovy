package org.eop.groovy.cchelper.test.sql.gs931.intnet15

import java.util.List
import java.util.Map

class GsOweFeeQueryOutService extends Intnet15ByNengkaiCommonOneSqlTest {

	@Override
	String getSqlFilePrefix() {
		'int15'
	}

	@Override
	String getDistinctName() {
		'欠费查询'
	}

	@Override
	String getDepKey() {
		'OweFeeQuery'
	}
	@Override
	Map getInIntfMap() {
		['cls':'gsOweFeeQueryInService','path': 'business/gs/OweFeeQuery', 'method': 'GET']
	}

	@Override
	List getInParams() {
		['userMobile']
	}

	@Override
	Map getOutIntfMap() {
		[ 'cls':'gsOweFeeQueryOutService', 'path': '/openapi/V1/Charge/Allowance/queryOweFee4Online', 'method': 'POST']
	}

}
