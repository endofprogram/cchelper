package org.eop.groovy.cchelper.test.sql.gs931.intnet15

import java.util.List
import java.util.Map

class GsMonthBillQueryOutService extends Intnet15ByNengkaiCommonOneSqlTest {

	@Override
	String getSqlFilePrefix() {
		'int15'
	}

	@Override
	String getDistinctName() {
		'月账单查询'
	}

	@Override
	String getDepKey() {
		'MonthBillQuery'
	}
	@Override
	Map getInIntfMap() {
		['cls':'gsMonthBillQueryInService','path': 'business/gs/MonthBillQuery', 'method': 'GET']
	}

	@Override
	List getInParams() {
		['userMobile']
	}

	@Override
	Map getOutIntfMap() {
		[ 'cls':'gsMonthBillQueryOutService', 'path': '/openapi/V1/Charge/Allowance/queryMonthlyBill4Online', 'method': 'POST']
	}

}
