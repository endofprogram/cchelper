package org.eop.groovy.cchelper.test.sql.gs931

import org.eop.groovy.cchelper.test.sql.AbstractSqlTest
import org.junit.Test

class ivr_08RechargeQry  extends _00Int15CommonOneSqlTest {

    @Override
    String getSqlFilePrefix() {
        'ivr_08'
    }

    @Override
    String getDistinctName() {
        '充值查询'
    }

    @Override
    String getDepKey() {
        ''
    }

    @Override
    Map getInIntfMap() {
        ['path': 'business/gs/chargeRecQry', 'method': 'GET' ]
    }

    @Override
    List getInParams() {
        ["userMobile",'beginDate','endDate','queryType']
    }

    @Override
    Map getOutIntfMap() {
        [ 'cls':'gsIvrZnyydhRechargeQueryService', 'path': '/openapi/V1/partner/ability/production/busiRec4cmcc', 'method': 'POST' ]
    }
}

