package org.eop.groovy.cchelper.test.sql.gs931

class ivr_03MonthBillQry extends _00Int15CommonUnionSqlTest {

    @Override
    String getSqlFilePrefix() {
        'ivr_03'
    }

    @Override
    String getDistinctName() {
        '月账单查询'
    }

    @Override
    List getDeps() {
        ['月账单明细查询', '月账单查询集团']
    }

    @Override
    Map getInIntfMap() {
        ['path': 'business/gs/query_monthBillFee', 'method': 'POST']
    }

    @Override
    List getInParams() {
        ['ServiceNumber','BgnMonth','EndMonth','billMonth','onlyMsisdn']
    }

    @Override
    Map getOutIntfMap() {
        ['cls': 'gsIvrZnyydhMonthBillQueryService']
    }
}
