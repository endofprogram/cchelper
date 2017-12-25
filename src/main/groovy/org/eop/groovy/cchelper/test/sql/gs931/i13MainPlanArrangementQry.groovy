package org.eop.groovy.cchelper.test.sql.gs931

class i13MainPlanArrangementQry extends _00Int15CommonOneSqlTest{
    @Override
    String getSqlFilePrefix() {
        'i13'
    }

    @Override
    String getDistinctName() {
        '主套餐变更'
    }

    @Override
    String getDepKey() {
        'mainPlanArrangement'
    }

    @Override
    Map getInIntfMap() {
        ['path': 'business/gs/mainPlanArrangementBusi', 'method': 'POST']
    }

    @Override
    List getInParams() {
        ['userMobile','newPlanId','newBrandId']
    }

    @Override
    Map getOutIntfMap() {
        [ 'cls':'gsMainPlanArrangementService', 'path': '/openapi/V1/partner/ability/sandbox/userChangePlanProd', 'method': 'POST']
    }
}