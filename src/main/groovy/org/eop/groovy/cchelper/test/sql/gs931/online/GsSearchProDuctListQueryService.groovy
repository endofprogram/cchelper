package org.eop.groovy.cchelper.test.sql.gs931.online

import java.util.List
import java.util.Map

class GsSearchProDuctListQueryService extends OnlineByNengkaiCommonOneSqlTest{
	@Override
	public String getSqlFilePrefix() {
		'online';
	}

	@Override
	public String getDistinctName() {
		'可选套餐-活动列表查询接口';
	}
	
	@Override
	public String getDepKey() {
		'SearchProDuctList';
	}

	@Override
	public Map getInIntfMap() {
		['cls':'gsSearchProDuctListQueryInService','path': 'business/gs/SearchProDuctList', 'method': 'GET']
	}
	@Override
	public List getInParams() {
		['cityCode','svcNum','queryWords','productCode'];
	}

	@Override
	public Map getOutIntfMap() {
		[ 'cls':'gsSearchProDuctListQueryOutService', 'path': '/openapi/V1/Product/Product/queryUserAvailableProducts4Online', 'method': 'POST']
	}
}
