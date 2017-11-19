package org.eop.groovy.cchelper.test.sql.gs931

import org.eop.groovy.cchelper.test.sql.AbstractSqlTest
import org.junit.Test

class ivr_02CurTelBillQry  extends _00Int15CommonOneSqlTest {

    @Override
    String getSqlFilePrefix() {
        'ivr_02'
    }

    @Override
    String getDistinctName() {
        '查询实时话费及余额'
    }
    @Override
    String getDepKey() {
        ''
    }
    @Override
    Map getInIntfMap() {
        ['path': 'business/gs/realFeeQry', 'method': 'GET']
    }

    @Override
    List getInParams() {
        ['userMobile']
    }

    @Override
    Map getOutIntfMap() {
        [ 'cls':'gsIvrZnyydhRealFeeQueryService', 'path': '/openapi/V1/partner/ability/production/query_feeAndBook', 'method': 'POST']
    }
}

