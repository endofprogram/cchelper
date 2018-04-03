package org.eop.groovy.cchelper.test.sql.gs931.online

import java.util.List
import java.util.Map

import org.eop.groovy.cchelper.test.sql.gs931.online.OnlineByNengkaiCommonOneSqlTest

class GsChooseSvcNumService extends OnlineByNengkaiCommonOneSqlTest{
	
		@Override
		public String getSqlFilePrefix() {
			'online';
		}
	
		@Override
		public String getDistinctName() {
			'选号接口';
		}
		
		@Override
		public String getDepKey() {
			'ChooseSvcNum';
		}
	
		@Override
		public Map getInIntfMap() {
			['cls':'gsChooseSvcNumQueryInService','path': 'business/gs/ChooseSvcNum', 'method': 'POST']
		}
		@Override
		public List getInParams() {
			['transactionID','reqInfo'];
		}
	
		@Override
		public Map getOutIntfMap() {
			[ 'cls':'gsChooseSvcNumQueryOutService', 'path': '/openapi/V1/Resource/Msisdn/queryAvailablePHONE_NUMBER4Online', 'method': 'POST']
		}
	
		
		
	}
	