package org.eop.groovy.cchelper.test.sql.gs931

class i15curtInfoQry extends _00Int15CommonOneSqlTest{
    @Override
    String getSqlFilePrefix() {
        'i15'
    }

    @Override
    String getDistinctName() {
        '查询客户资料信息'
    }

    @Override
    String getDepKey() {
        'curtInfo'
    }

    @Override
    Map getInIntfMap() {
        ['path': 'business/gs/curtInfoQry', 'method': 'GET']
    }

    @Override
    List getInParams() {
        ['userMobile']
    }

    @Override
    Map getOutIntfMap() {
        [ 'cls':'gsCustInfoQueryService', 'path': '/openapi/V1/partner/ability/sandbox/query_custInfo', 'method': 'POST']
    }

}

