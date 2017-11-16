package org.eop.groovy.cchelper.test.sql.gs931

class i03DinnerRmQry extends _00Int15CommonUnionSqlTest {

    @Override
    String getSqlFilePrefix() {
        'i03'
    }

    @Override
    String getDistinctName() {
        '套餐余量查询'
    }

    @Override
    List getDeps() {
        ['当前下周期计划查询', '流量使用带产品']
    }

    @Override
    Map getInIntfMap() {
        ['path': 'business/gs/dinnerRmnQry', 'method': 'GET']
    }

    @Override
    List getInParams() {
        ['userMobile']
    }

    @Override
    Map getOutIntfMap() {
        ['cls': 'gsDinnerRemainQueryService']
    }
}