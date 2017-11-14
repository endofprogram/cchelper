package org.eop.groovy.cchelper.test.sql.gs931

class i03_01BrandQry extends _00Int15CommonOneSqlTest {

    @Override
    String getSqlFilePrefix() {
        'i03_01'
    }

    @Override
    String getDistinctName() {
        '品牌查询'
    }

    @Override
    String getDepKey() {
        'userplan'
    }

    @Override
    Map getInIntfMap() {
        ['path': 'business/gs/brandQry', 'method': 'GET']
    }

    @Override
    List getInParams() {
        ['userMobile']
    }

    @Override
    Map getOutIntfMap() {
        ['cls': 'gsUserBrandQueryService', 'path': '/openapi/V1/partner/ability/production/userPromoCommon', 'method': 'POST']
    }
}

