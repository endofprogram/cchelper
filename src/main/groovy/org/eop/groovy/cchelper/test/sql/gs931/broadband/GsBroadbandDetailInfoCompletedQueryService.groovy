package org.eop.groovy.cchelper.test.sql.gs931.broadband

import java.util.List
import java.util.Map

import org.eop.groovy.cchelper.test.sql.gs931.broadband.BroadbandByNengkaiCommonOneSqlTest

class GsBroadbandDetailInfoCompletedQueryService  extends BroadbandByNengkaiCommonOneSqlTest {
	
		@Override
		String getSqlFilePrefix() {
			'broadband'
		}
	
		@Override
		String getDistinctName() {
			'查询宽带用户的详细信息_竣工'
		}
	
		@Override
		String getDepKey() {
			'BroadbandDetailInfoCompleted'
		}
		@Override
		Map getInIntfMap() {
			['cls':'gsBroadbandDetailInfoQueryInService','path': 'business/gs/BroadbandDetailInfoCompleted', 'method': 'GET']
		}
	
		@Override
		List getInParams() {
			['busiCode']
		}
	
		@Override
		Map getOutIntfMap() {
			[ 'cls':'gsBroadbandDetailInfoCompletedQueryOutService', 'path': '/openapi/V1/Party/User/queryBroadbandDetailInfo4Online', 'method': 'POST']
		}
	}
	