package org.eop.groovy.cchelper.test.sql.gs931

import org.eop.groovy.cchelper.test.sql.AbstractSqlTest
import org.junit.Test

class i01RtimeFeeQry  extends _00Int15CommonOneSqlTest {

    @Override
    String getSqlFilePrefix() {
        '01'
    }

    @Override
    String getDistinctName() {
        '实时话费查询'
    }

    @Override
    Map getInIntfMap() {
        ['path': 'business/gs/rtimeFeeQry', 'method': 'GET', 'depkey':'']
    }

    @Override
    List getInParams() {
        ['userMobile']
    }

    @Override
    Map getOutIntfMap() {
        [ 'cls':'gsSsPhoneMoneyQueryService', 'path': '/openapi/V1/partner/ability/production/oweFeeSimple', 'method': 'POST', 'depkey':'']
    }
}

