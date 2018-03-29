package org.eop.groovy.cchelper.test.sql.gs931.zhongbao

import java.util.List
import java.util.Map

import org.eop.groovy.cchelper.test.sql.gs931.broadband.BroadbandByNengkaiCommonOneSqlTest

class GsBusiDealOperTransactService  extends ZbByNengkaiCommonOneSqlTest {
	
		@Override
		String getSqlFilePrefix() {
			'zb'
		}
	
		@Override
		String getDistinctName() {
			'众包活动办理'
		}
	
		@Override
		String getDepKey() {
			'BusiDealOper'
		}
		@Override
		Map getInIntfMap() {
			['cls':'gsBusiDealOperTransactInService','path': 'business/gs/BusiDealOper', 'method': 'POST']
		}
	
		@Override
		List getInParams() {
			['userMobile']
		}
	
		@Override
		Map getOutIntfMap() {
			[ 'cls':'gsBusiDealOperTransactOutService', 'path': '/openapi/V1/BizInteraction/Order/submitBizSubscribing4Online', 'method': 'POST']
		}
	}