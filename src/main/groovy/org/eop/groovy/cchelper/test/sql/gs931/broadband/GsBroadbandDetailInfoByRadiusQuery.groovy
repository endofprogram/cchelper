package org.eop.groovy.cchelper.test.sql.gs931.broadband

import java.util.List
import java.util.Map

class GsBroadbandDetailInfoByRadiusQuery extends BroadbandByNengkaiCommonOneSqlTest{

	@Override
	String getSqlFilePrefix() {
		'broadband'
	}

	@Override
	String getDistinctName() {
		'查询宽带用户的详细信息_Radius'
	}

	@Override
	String getDepKey() {
		'BroadbandDetailInfoCompletedByRadius'
	}
	@Override
	Map getInIntfMap() {
		['cls':'gsBroadbandDetailInfoQueryInService','path': 'business/gs/BroadbandDetailInfoCompletedByRadius', 'method': 'GET']
	}

	@Override
	List getInParams() {
		['account']
	}

	@Override
	Map getOutIntfMap() {
		[ 'cls':'gsBroadbandDetailInfoByRadiusQueryOutService', 'path': '/openapi/V1/Service/Notification/redius', 'method': 'POST']
	}
}
