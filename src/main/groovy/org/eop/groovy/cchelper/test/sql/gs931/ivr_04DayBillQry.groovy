package org.eop.groovy.cchelper.test.sql.gs931

import org.eop.groovy.cchelper.test.sql.AbstractSqlTest
import org.junit.Test

class ivr_04DayBillQry  extends _00Int15CommonOneSqlTest {

    @Override
    String getSqlFilePrefix() {
        'ivr_04'
    }

    @Override
    String getDistinctName() {
        '日账单查询'
    }

    @Override
    String getDepKey() {
        ''
    }
    @Override
    Map getInIntfMap() {
        ['path': 'business/gs/dayBillQry', 'method': 'GET']
    }

    @Override
    List getInParams() {
        ['userMobile','beginDate','endDate']
    }

    @Override
    Map getOutIntfMap() {
        [ 'cls':'gsIvrZnyydhDailyBillQueryService', 'path': '/openapi/V1/partner/ability/production/accBillDaily', 'method': 'POST']
    }
}

