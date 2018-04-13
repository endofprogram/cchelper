package org.eop.groovy.cchelper.test.sql.gs931.intnet15

class GsUserOrderSPQueryService extends Intnet15ByNengkaiCommonOneSqlTest{
	@Override
	public String getSqlFilePrefix() {
		'int15';
	}

	@Override
	public String getDistinctName() {
		'查询用户订购的SP业务';
	}
	
	@Override
	public String getDepKey() {
		'UserOrderSP';
	}

	@Override
	public Map getInIntfMap() {
		['cls':'gsUserOrderSPQueryInService','path': 'business/gs/UserOrderSP', 'method': 'GET']
	}
	@Override
	public List getInParams() {
		['userMobile'];
	}

	@Override
	public Map getOutIntfMap() {
		[ 'cls':'gsUserOrderSPQueryOutService', 'path': '/openapi/V1/BizInteraction/Order/queryVAS4Online', 'method': 'POST']
	}

}
