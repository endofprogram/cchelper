package org.eop.groovy.cchelper.test.sql.gs931.intnet15

import java.util.List
import java.util.Map

class GsPlanRemianQueryService extends Intnet15ByNengkaiCommonUnionSqlTest{

	@Override
	public String getSqlFilePrefix() {
		'int15'
	}

	@Override
	public String getDistinctName() {
		'套餐余量查询'
	}
	@Override
	public List getDeps() {
		['用户已订购商品查询','套餐余量查询(子)']
	}

	@Override
	public Map getInIntfMap() {
		['cls':'gsPlanRemianQueryInService','path': 'business/gs/PlanRemian', 'method': 'GET']
	}
	@Override
	public List getInParams() {
		['userMobile']
	}

	@Override
	public Map getOutIntfMap() {
		['cls': 'gsPlanRemianQueryOutService']
	}

	

	

}
