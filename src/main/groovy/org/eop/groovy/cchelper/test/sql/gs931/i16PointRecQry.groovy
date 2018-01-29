package org.eop.groovy.cchelper.test.sql.gs931

import java.util.List
import java.util.Map

class i16PointRecQry extends _00Int15CommonOneSqlTest {

	@Override
	String getSqlFilePrefix() {
		'i16'
	}

	@Override
	String getDistinctName() {
		'积分兑换历史查询'
	}

	@Override
	String getDepKey() {
		'pointRec'
	}

	@Override
	Map getInIntfMap() {
		['path': 'business/gs/pointRecQry', 'method': 'GET']
	}

	@Override
	List getInParams() {
		['userMobile','startTime','endTime']
	}

	@Override
	Map getOutIntfMap() {
		[ 'cls':'gsPointRecQueryService', 'path': '/openapi/V1/partner/ability/sandbox/coinBusiRec4cmcc', 'method': 'POST']
	}
}