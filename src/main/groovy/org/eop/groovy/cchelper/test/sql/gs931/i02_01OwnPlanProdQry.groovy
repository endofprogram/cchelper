package org.eop.groovy.cchelper.test.sql.gs931

class i02_01OwnPlanProdQry extends _00Int15CommonOneSqlTest {

    @Override
    String getSqlFilePrefix() {
        'i02_01'
    }

    @Override
    String getDistinctName() {
        '已有计划和产品'
    }

    @Override
    Map getInIntfMap() {
        ['path': 'business/gs/ownPlanProdQry', 'method': 'GET', 'depkey': '']
    }

    @Override
    List getInParams() {
        ['userMobile']
    }

    @Override
    Map getOutIntfMap() {
        ['cls': 'gsUserCurPlanAndProdQueryService', 'path': '/openapi/V1/partner/ability/production/userPlanProd', 'method': 'POST', 'depkey': '']
    }
}
