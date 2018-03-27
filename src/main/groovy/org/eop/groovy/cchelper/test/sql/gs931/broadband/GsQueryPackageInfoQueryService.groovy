package org.eop.groovy.cchelper.test.sql.gs931.broadband

import java.util.List
import java.util.Map

import org.eop.groovy.cchelper.test.sql.gs931.broadband.BroadbandByNengkaiCommonOneSqlTest

class GsQueryPackageInfoQueryService  extends BroadbandByNengkaiCommonOneSqlTest {
	
		@Override
		String getSqlFilePrefix() {
			'broadband'
		}
	
		@Override
		String getDistinctName() {
			'查询套餐信息接口'
		}
	
		@Override
		String getDepKey() {
			'QueryPackageInfo'
		}
		@Override
		Map getInIntfMap() {
			['cls':'gsQueryPackageInfoQueryInService','path': 'business/gs/QueryPackageInfo', 'method': 'GET']
		}
	
		@Override
		List getInParams() {
			['busiCode']
		}
	
		@Override
		Map getOutIntfMap() {
			[ 'cls':'gsQueryPackageInfoQueryOutService', 'path': '/openapi/V1/Party/User/queryBroadbandProductInformation4Online', 'method': 'POST']
		}
	}