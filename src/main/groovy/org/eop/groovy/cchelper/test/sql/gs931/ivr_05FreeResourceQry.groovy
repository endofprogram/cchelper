package org.eop.groovy.cchelper.test.sql.gs931

import org.eop.groovy.cchelper.test.sql.AbstractSqlTest
import org.junit.Test

class ivr_05FreeResourceQry  extends _00Int15CommonOneSqlTest {

    @Override
    String getSqlFilePrefix() {
        'ivr_05'
    }

    @Override
    String getDistinctName() {
        '套餐及流量使用情况查询'
    }

    @Override
    String getDepKey() {
        ''
    }
    @Override
    Map getInIntfMap() {
        ['path': 'business/gs/query_freeResource', 'method': 'POST']
    }

    @Override
    List getInParams() {
        ['month']
    }

    @Override
    Map getOutIntfMap() {
        [ 'cls':'gsIvrZnyydhMealFlowUsedQueryService', 'path': '/openapi/V1/partner/ability/sandbox/feeResource', 'method': 'POST']
    }
}

