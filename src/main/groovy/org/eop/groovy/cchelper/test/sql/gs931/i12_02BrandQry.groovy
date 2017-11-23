package org.eop.groovy.cchelper.test.sql.gs931

class i12_02BrandQry extends _00Int15CommonOneSqlTest {

    @Override
    String getSqlFilePrefix() {
        '12_02'
    }

    @Override
    String getDistinctName() {
        '用户品牌查询'
    }

    @Override
    String getDepKey() {
        'userbrand'
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
        [ 'cls':'gsUserBrandQueryService', 'path': '/openapi/V1/partner/ability/production/userPromoCommon', 'method': 'POST']
    }
}
