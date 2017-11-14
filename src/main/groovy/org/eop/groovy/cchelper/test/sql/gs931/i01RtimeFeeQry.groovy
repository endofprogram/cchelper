package org.eop.groovy.cchelper.test.sql.gs931

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
    String getDepKey() {
        ''
    }

    @Override
    Map getInIntfMap() {
        ['path': 'business/gs/rtimeFeeQry', 'method': 'GET']
    }

    @Override
    List getInParams() {
        ['userMobile']
    }

    @Override
    Map getOutIntfMap() {
        [ 'cls':'gsSsPhoneMoneyQueryService', 'path': '/openapi/V1/partner/ability/production/oweFeeSimple', 'method': 'POST']
    }
}

