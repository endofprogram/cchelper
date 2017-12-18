package org.eop.groovy.cchelper.test.sql.gs931

class i03_01PlanQry extends _00Int15CommonOneSqlTest {

    @Override
    String getSqlFilePrefix() {
        'i03_01'
    }

    @Override
    String getDistinctName() {
        '当前下周期计划查询'
    }

    @Override
    String getDepKey() {
        'userplan'
    }

    @Override
    Map getInIntfMap() {
        ['path': 'business/gs/planQry', 'method': 'GET']
    }

    @Override
    List getInParams() {
        ['userMobile']
    }

    @Override
    Map getOutIntfMap() {
        ['cls': 'gsUserPlanQueryService', 'path': '/openapi/V1/partner/ability/production/userCurAndNextPlan', 'method': 'POST']
    }
}

