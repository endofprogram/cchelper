package org.eop.groovy.cchelper.test.sql.gs931.broadband

import java.util.List
import java.util.Map

class GsBroadbandListInfoQueryService extends BroadbandByNengkaiCommonOneSqlTest{

@Override
		String getSqlFilePrefix() {
			'broadband'
		}
	
		@Override
		String getDistinctName() {
			'查询用户列表接口'
		}
	
		@Override
		String getDepKey() {
			'BroadbandListInfo'
		}
		@Override
		Map getInIntfMap() {
			['cls':'gsBroadbandListInfoQueryInService','path': 'business/gs/BroadbandListInfo', 'method': 'GET']
		}
	
		@Override
		List getInParams() {
			['idCard']
		}
	
		@Override
		Map getOutIntfMap() {
			[ 'cls':'gsBroadbandListInfoQueryOutService', 'path': '/openapi/V1/Party/User/queryBroadbandUserList4Online', 'method': 'POST']
		}
	}