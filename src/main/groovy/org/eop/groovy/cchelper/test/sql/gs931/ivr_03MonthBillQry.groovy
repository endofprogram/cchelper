package org.eop.groovy.cchelper.test.sql.gs931

import org.eop.groovy.cchelper.test.sql.AbstractSqlTest
import org.junit.Test

class ivr_03MonthBillQry  extends _00Int15CommonOneSqlTest {

    @Override
    String getSqlFilePrefix() {
        'ivr_03'
    }

    @Override
    String getDistinctName() {
        '月账单查询'
    }
    @Override
    String getDepKey() {
        ''
    }
    @Override
    Map getInIntfMap() {
        ['path': 'business/gs/monthBillQry', 'method': 'GET']
    }

    @Override
    List getInParams() {
        ['userMobile','billMonth']
    }

    @Override
    Map getOutIntfMap() {
        [ 'cls':'gsIvrZnyydhMonthBillQueryService', 'path': '/openapi/V1/partner/ability/production/monthBillNewGs', 'method': 'POST']
    }
}

