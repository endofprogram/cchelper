package org.eop.groovy.cchelper.test.sql.gs931

import org.eop.groovy.cchelper.test.sql.AbstractSqlTest
import org.junit.Test

class ivr_09NumAttributionQry  extends _00Int15CommonOneSqlTest {

    @Override
    String getSqlFilePrefix() {
        'ivr_09'
    }

    @Override
    String getDistinctName() {
        '号码归属地查询'
    }
    @Override
    String getDepKey() {
        ''
    }
    @Override
    Map getInIntfMap() {
        ['path': 'business/gs/check_userPromo', 'method': 'POST' ]
    }

    @Override
    List getInParams() {
        []
    }

    @Override
    Map getOutIntfMap() {
        [ 'cls':'', 'path': '/openapi/V1/partner/ability/sandbox/get_phoneArea', 'method': 'POST' ]
    }
}

