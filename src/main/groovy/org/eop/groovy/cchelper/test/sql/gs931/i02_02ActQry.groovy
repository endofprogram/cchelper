package org.eop.groovy.cchelper.test.sql.gs931

class i02_02ActQry extends _00Int15CommonOneSqlTest {

    @Override
    String getSqlFilePrefix() {
        'i02_02'
    }

    @Override
    String getDistinctName() {
        '办理活动查询'
    }

    @Override
    String getDepKey() {
        'useractivity'
    }

    @Override
    Map getInIntfMap() {
        ['path': 'business/gs/actQry', 'method': 'GET', 'depkey': '']
    }

    @Override
    List getInParams() {
        ['userMobile']
    }

    @Override
    Map getOutIntfMap() {
        ['cls': 'gsUserActivityQueryService', 'path': '/openapi/V1/partner/ability/production/userPromo4cmcc', 'method': 'POST', 'depkey': '']
    }
}


