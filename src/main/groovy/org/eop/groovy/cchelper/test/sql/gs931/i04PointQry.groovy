package org.eop.groovy.cchelper.test.sql.gs931

class i04PointQry extends _00Int15CommonOneSqlTest {

    @Override
    String getSqlFilePrefix() {
        'i04'
    }

    @Override
    String getDistinctName() {
        '积分查询'
    }

    @Override
    String getDepKey() {
        ''
    }

    @Override
    Map getInIntfMap() {
        ['path': 'business/gs/pointQry', 'method': 'GET', 'depkey': '']
    }

    @Override
    List getInParams() {
        ['userMobile']
    }

    @Override
    Map getOutIntfMap() {
        ['cls': 'gsUniCoinQueryService', 'path': '/openapi/V1/partner/ability/production/userCoinEx', 'method': 'POST', 'depkey': '']
    }
}

