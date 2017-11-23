package org.eop.groovy.cchelper.test.sql.gs931

class i12MainPlanQry extends _00Int15CommonUnionSqlTest {

    @Override
    String getSqlFilePrefix() {
        'i12'
    }

    @Override
    String getDistinctName() {
        '主套餐查询'
    }

    @Override
    List getDeps() {
        ['当前下周期计划查询', '用户品牌查询']
    }

    @Override
    Map getInIntfMap() {
        ['path': 'business/gs/mainPlanQry', 'method': 'GET']
    }

    @Override
    List getInParams() {
        ['userMobile']
    }

    @Override
    Map getOutIntfMap() {
        ['cls': 'gsMainPlanQueryService']
    }
}