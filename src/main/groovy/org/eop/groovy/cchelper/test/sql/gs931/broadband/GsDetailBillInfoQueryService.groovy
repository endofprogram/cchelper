package org.eop.groovy.cchelper.test.sql.gs931.broadband

import java.util.List
import java.util.Map

import org.eop.groovy.cchelper.test.sql.gs931.broadband.BroadbandByNengkaiCommonOneSqlTest

class GsDetailBillInfoQueryService  extends BroadbandByNengkaiCommonOneSqlTest {
	
		@Override
		String getSqlFilePrefix() {
			'broadband'
		}
	
		@Override
		String getDistinctName() {
			'明细账单信息接口'
		}
	
		@Override
		String getDepKey() {
			'DetailBillInfo'
		}
		@Override
		Map getInIntfMap() {
			['cls':'gsDetailBillInfoQueryInService','path': 'business/gs/DetailBillInfo', 'method': 'GET']
		}
	
		@Override
		List getInParams() {
			['busiCode','acount']
		}
	
		@Override
		Map getOutIntfMap() {
			[ 'cls':'gsDetailBillInfoQueryOutService', 'path': '/openapi/V1/Charge/Bill/queryBroadbandDetailBill4Online', 'method': 'POST']
		}
	}
	