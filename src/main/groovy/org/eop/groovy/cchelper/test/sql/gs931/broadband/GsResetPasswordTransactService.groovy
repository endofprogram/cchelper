package org.eop.groovy.cchelper.test.sql.gs931.broadband

import java.util.List
import java.util.Map
/**
 * 密码重置
 * 
 * @author CUIBEIBEI
 * @date 2018年4月8日 上午11:04:37
 *
 */
class GsResetPasswordTransactService extends BroadbandByNengkaiCommonOneSqlTest{

	
	@Override
	String getSqlFilePrefix() {
		'broadband'
	}

	@Override
	String getDistinctName() {
		'密码重置'
	}

	@Override
	String getDepKey() {
		'ResetPassword'
	}
	@Override
	Map getInIntfMap() {
		['cls':'gsResetPasswordTransactInService','path': 'business/gs/ResetPassword', 'method': 'POST']
	}

	@Override
	List getInParams() {
		['account','newPassword']
	}

	@Override
	Map getOutIntfMap() {
		[ 'cls':'gsResetPasswordTransactOutService', 'path': '/openapi/V1/Party/User/submitBroadbandPasswordResetting4Online', 'method': 'POST']
	}
}

