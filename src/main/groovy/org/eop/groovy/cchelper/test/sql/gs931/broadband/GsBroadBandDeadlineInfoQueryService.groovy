package org.eop.groovy.cchelper.test.sql.gs931.broadband

import java.util.List
import java.util.Map

import org.eop.groovy.cchelper.test.sql.gs931.broadband.BroadbandByNengkaiCommonOneSqlTest

class GsBroadBandDeadlineInfoQueryService  extends BroadbandByNengkaiCommonOneSqlTest {
	
		@Override
		String getSqlFilePrefix() {
			'broadband'
		}
	
		@Override
		String getDistinctName() {
			'宽带业务到期查询接口'
		}
	
		@Override
		String getDepKey() {
			'BroadBandDeadlineInfo'
		}
		@Override
		Map getInIntfMap() {
			['cls':'gsBroadBandDeadlineInfoQueryInService','path': 'business/gs/BroadBandDeadlineInfo', 'method': 'GET']
		}
	
		@Override
		List getInParams() {
			['srvCode']
		}
	
		@Override
		Map getOutIntfMap() { 
			[ 'cls':'gsBroadBandDeadlineInfoQueryOutService', 'path': '/openapi/V1/Party/User/queryBroadbandExpirationInformation4Online', 'method': 'POST']
		}
	}
	