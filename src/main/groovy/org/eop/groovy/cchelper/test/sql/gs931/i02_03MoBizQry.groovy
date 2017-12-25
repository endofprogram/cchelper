package org.eop.groovy.cchelper.test.sql.gs931

class i02_03MoBizQry extends _00Int15CommonOneSqlTest {

    @Override
    String getSqlFilePrefix() {
        'i03_03'
    }

    @Override
    String getDistinctName() {
        '查询在用梦网业务'
    }

    @Override
    String getDepKey() {
        'usermobiz'
    }

    @Override
    Map getInIntfMap() {
        ['path': 'business/gs/userMoBizQry', 'method': 'GET']
    }

    @Override
    List getInParams() {
        ['userMobile']
    }

    @Override
    Map getOutIntfMap() {
        ['cls': 'gsUserCurMoBizQueryService', 'path': '/openapi/V1/partner/ability/production/query_allRadiusInfo', 'method': 'POST']
    }
}
