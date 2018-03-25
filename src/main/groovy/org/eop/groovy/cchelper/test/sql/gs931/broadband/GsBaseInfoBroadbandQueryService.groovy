package org.eop.groovy.cchelper.test.sql.gs931.broadband

import java.util.List
import java.util.Map

import org.eop.groovy.cchelper.test.sql.gs931.broadband.BroadbandByNengkaiCommonOneSqlTest

class GsBaseInfoBroadbandQueryService  extends BroadbandByNengkaiCommonOneSqlTest {
	
		@Override
		String getSqlFilePrefix() {
			'broadband'
		}
	
		@Override
		String getDistinctName() {
			'查询宽带用户的基本信息接口'
		}
	
		@Override
		String getDepKey() {
			'BaseInfoBroadband'
		}
		@Override
		Map getInIntfMap() {
			['cls':'gsBaseInfoBroadbandQueryInService','path': 'business/gs/BaseInfoBroadband', 'method': 'GET']
		}
	
		@Override
		List getInParams() {
			['busiCode']
		}
	
		@Override
		Map getOutIntfMap() {
			[ 'cls':'gsBaseInfoBroadbandQueryOutService', 'path': '/openapi/V1/Party/User/queryBroadbandUserInformation4Online', 'method': 'POST']
		}
	}