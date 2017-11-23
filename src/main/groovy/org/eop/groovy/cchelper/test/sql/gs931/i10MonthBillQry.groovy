package org.eop.groovy.cchelper.test.sql.gs931

class i10MonthBillQry extends _00Int15CommonOneSqlTest {

    @Override
    String getSqlFilePrefix() {
        '10'
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
        ['path': 'business/gs/monBillQry', 'method': 'GET']
    }

    @Override
    List getInParams() {
        ['userMobile','beginMonth','endMonth']
    }

    @Override
    Map getOutIntfMap() {
        [ 'cls':'gsMonthsBillQueryService', 'path': '/openapi/V1/partner/ability/production/queryMonthBillNewForJituan', 'method': 'POST']
    }
}