package org.eop.groovy.cchelper.test.sql.gs931.intnet15

import java.util.List
import java.util.Map

class GsAllBusiQueryService extends Intnet15ByNengkaiCommonUnionSqlTest{

	@Override
	public String getSqlFilePrefix() {
		'int15'
	}

	@Override
	public String getDistinctName() {
		'已订购业务查询'
	}
	@Override
	public List getDeps() {
		['用户已订购商品查询', '查询用户订购的SP业务']
	}

	@Override
	public Map getInIntfMap() {
		['cls':'gsAllBusiQueryInService','path': 'business/gs/AllBusi', 'method': 'GET']
	}
	@Override
	public List getInParams() {
		['userMobile']
	}

	@Override
	public Map getOutIntfMap() {
		['cls': 'gsAllBusiQueryOutService']
	}

	

	

}
