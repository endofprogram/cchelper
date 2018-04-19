package org.eop.groovy.cchelper.test.sql.gs931.intnet15

import java.util.List
import java.util.Map

class GsPlanRemian1QueryService extends Intnet15ByNengkaiCommonOneSqlTest{

	@Override
	public String getSqlFilePrefix() {
		'int15';
	}

	@Override
	public String getDistinctName() {
		'套餐余量查询(子)';
	}
	
	@Override
	public String getDepKey() {
		'PlanRemian1';
	}

	@Override
	public Map getInIntfMap() {
		['cls':'gsPlanRemian1QueryInService','path': 'business/gs/PlanRemian1', 'method': 'GET']
	}                                                
	@Override
	public List getInParams() {
		['userMobile'];
	}

	@Override
	public Map getOutIntfMap() {
		[ 'cls':'gsPlanRemian1QueryOutService', 'path': '/openapi/V1/Charge/Allowance/queryPackageAllowance4Online', 'method': 'POST']
	}

	
	
}
