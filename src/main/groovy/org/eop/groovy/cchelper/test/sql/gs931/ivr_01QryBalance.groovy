package org.eop.groovy.cchelper.test.sql.gs931

import org.eop.groovy.cchelper.test.sql.AbstractSqlTest
import org.junit.Test

class ivr_01QryBalance  extends _00Int15CommonOneSqlTest {

    @Override
    String getSqlFilePrefix() {
        'ivr_01'
    }

    @Override
    String getDistinctName() {
        '余额查询'
    }

    @Override
    Map getInIntfMap() {
        ['path': 'business/gs/query_balance', 'method': 'GET', 'depkey':'']
    }

    @Override
    List getInParams() {
        ['queryType']
    }

    @Override
    Map getOutIntfMap() {
        [ 'cls':'gsIvrZnyydhRemainFeeQueryService', 'path': '/openapi/V1/partner/ability/sandbox/oweFeeSimple', 'method': 'POST', 'depkey':'']
    }
}

