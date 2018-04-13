package org.eop.groovy.cchelper.test.sql.gs931.intnet15

import java.util.List
import java.util.Map

class GsUserOrderProductQueryService extends Intnet15ByNengkaiCommonOneSqlTest{
	@Override
	public String getSqlFilePrefix() {
		'int15';
	}

	@Override
	public String getDistinctName() {
		'用户已订购商品查询';
	}
	
	@Override
	public String getDepKey() {
		'UserOrderProduct';
	}

	@Override
	public Map getInIntfMap() {
		['cls':'gsUserOrderProductsQueryInService','path': 'business/gs/UserOrderProduct', 'method': 'GET']
	}
	@Override
	public List getInParams() {
		['userMobile'];
	}

	@Override
	public Map getOutIntfMap() {
		[ 'cls':'gsUserOrderProductsQueryOutService', 'path': '/openapi/V1/BizInteraction/Order/querySubscribedProducts4Online', 'method': 'POST']
	}

}
