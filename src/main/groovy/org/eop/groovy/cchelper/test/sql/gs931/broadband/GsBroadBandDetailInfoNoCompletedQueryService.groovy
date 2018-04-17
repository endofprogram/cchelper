package org.eop.groovy.cchelper.test.sql.gs931.broadband

import java.util.List
import java.util.Map

import org.eop.groovy.cchelper.test.sql.gs931.broadband.BroadbandByNengkaiCommonOneSqlTest

class GsBroadBandDetailInfoNoCompletedQueryService  extends BroadbandByNengkaiCommonOneSqlTest {
	
		@Override
		String getSqlFilePrefix() {
			'broadband'
		}
	
		@Override
		String getDistinctName() {
			'查询宽带用户的详细信息_未竣工'
		}
	
		@Override
		String getDepKey() {
			'BroadbandDetailInfoNoCompleted'
		}
		@Override
		Map getInIntfMap() {
			['cls':'gsBroadbandDetailInfoQueryInService','path': 'business/gs/BroadbandDetailInfoNoCompleted', 'method': 'GET']
		}
	
		@Override
		List getInParams() {
			['busiCode']
		}
	
		@Override
		Map getOutIntfMap() {
			[ 'cls':'gsBroadbandDetailInfoNoCompletedQueryOutService', 'path': '/openapi/V1/BizInteraction/Order/queryBroadbandProductsSubscribedByID4Online', 'method': 'POST']
		}
	}
	