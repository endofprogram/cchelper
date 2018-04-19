package org.eop.groovy.cchelper.test.sql.gs931.broadband

import java.util.List
import java.util.Map
 
class GsTransactBusinessRecordsQueryService extends BroadbandByNengkaiCommonOneSqlTest{
	@Override
	String getSqlFilePrefix() {
		'broadband'
	}

	@Override
	String getDistinctName() {
		'业务办理记录'
	}

	@Override
	String getDepKey() {
		'TransactBusinessRecords'
	}
	@Override
	Map getInIntfMap() {
		['cls':'gsTransactBusinessRecordsQueryInService','path': 'business/gs/TransactBusinessRecords', 'method': 'GET']
	}

	@Override
	List getInParams() {
		['account','type','startTime','endTime','regionId','srvCode']
	}

	@Override
	Map getOutIntfMap() {
		[ 'cls':'gsTransactBusinessRecordsQueryOutService', 'path': '/openapi/V1/BizInteraction/Order/queryBroadbandBizInteractionRecords4Online', 'method': 'POST']
	}
}
