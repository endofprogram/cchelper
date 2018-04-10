package org.eop.groovy.cchelper.test.sql.gs931.online

import java.util.List
import java.util.Map

class GsSimCheckOrderTransactService extends OnlineByNengkaiCommonOneSqlTest{
	@Override
	public String getSqlFilePrefix() {
		'online';
	}

	@Override
	public String getDistinctName() {
		'手机号和SIM卡号校验';
	}
	
	@Override
	public String getDepKey() {
		'SimCheckOrder';
	}

	@Override
	public Map getInIntfMap() {
		['cls':'gsSimCheckOrderTransactInService','path': 'business/gs/SimCheckOrder', 'method': 'POST']
	}
	@Override
	public List getInParams() {
		['transactionID','simCardNo','billId'];
	}

	@Override
	public Map getOutIntfMap() {
		[ 'cls':'gsSimCheckOrderTransactOutService', 'path': '/openapi/V1/BizInteraction/Order/checkPhoneNumberAndSim4Online', 'method': 'POST']
	}
}
