package org.eop.groovy.cchelper.test.sql.gs931.broadband

import java.util.List
import java.util.Map

class GsBroadbandArrearageInfoQueryService extends BroadbandByNengkaiCommonOneSqlTest{

	@Override
	String getSqlFilePrefix() {
		'broadband'
	}

	@Override
	String getDistinctName() {
		'查询宽带帐号状态-是否欠费接口'
	}
  
	
	@Override
	String getDepKey() {
		'BroadbandArrearageInfo'
	}
	@Override
	Map getInIntfMap() {
		['cls':'gsBroadbandArrearageInfoQueryInService','path': 'business/gs/BroadbandArrearageInfo', 'method': 'GET']
	}

	@Override
	List getInParams() {
		['busiCode']
	}

	@Override
	Map getOutIntfMap() {
		[ 'cls':'gsBroadbandArrearageInfoQueryOutService', 'path': '/openapi/V1/Charge/Allowance/queryBroadbandOweFee4Online', 'method': 'POST']
	}
}
