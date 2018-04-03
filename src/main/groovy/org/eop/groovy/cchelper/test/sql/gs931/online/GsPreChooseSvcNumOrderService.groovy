package org.eop.groovy.cchelper.test.sql.gs931.online

import java.util.List
import java.util.Map

import org.eop.groovy.cchelper.test.sql.gs931.online.OnlineByNengkaiCommonOneSqlTest

class GsPreChooseSvcNumOrderService extends OnlineByNengkaiCommonOneSqlTest{
	
		@Override
		public String getSqlFilePrefix() {
			'online';
		}
	
		@Override
		public String getDistinctName() {
			'订单预校验';
		}
		
		@Override
		public String getDepKey() {
			'PreChooseSvcNumOrder';
		}
	
		@Override
		public Map getInIntfMap() {
			['cls':'gsPreChooseSvcNumOrderQueryInService','path': 'business/gs/PreChooseSvcNumOrder', 'method': 'POST']
		}
		@Override
		public List getInParams() {
			['transactionID','reqInfo'];
		}
	
		@Override
		public Map getOutIntfMap() {
			[ 'cls':'gsPreChooseSvcNumOrderQueryOutService', 'path': '/openapi/V1/BizInteraction/Order/precheckOrderInformation4Online', 'method': 'POST']
		}
	
		
		
	}
	