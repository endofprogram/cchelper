package org.eop.groovy.cchelper.test.sql.gs931.broadband

import java.util.List
import java.util.Map

import org.eop.groovy.cchelper.test.sql.gs931.broadband.BroadbandByNengkaiCommonOneSqlTest

class GsMarketingCampaignRecordQueryService  extends BroadbandByNengkaiCommonOneSqlTest {
	
		@Override
		String getSqlFilePrefix() {
			'broadband'
		}
	
		@Override
		String getDistinctName() {
			'家宽营销活动记录接口'
		}
	
		@Override
		String getDepKey() {
			'MarketingCampaignRecord'
		}
		@Override
		Map getInIntfMap() {
			['cls':'gsMarketingCampaignRecordQueryInService','path': 'business/gs/MarketingCampaignRecord', 'method': 'GET']
		}
	
		@Override
		List getInParams() {
			['busiCode']
		}
	
		@Override
		Map getOutIntfMap() {
			[ 'cls':'gsMarketingCampaignRecordQueryOutService', 'path': '/openapi/V1/Party/User/queryBroadbandActivityInformation4Online', 'method': 'POST']
		}
	}
	