package org.eop.groovy.cchelper.test.sql.gs931.broadband

class GsQueryAccessModeQueryService extends BroadbandByNengkaiCommonOneSqlTest {

    @Override
    String getSqlFilePrefix() {
        'AccessMode'
    }

    @Override
    String getDistinctName() {
        '查询宽带接入方式'
    }

    @Override
    String getDepKey() {
        'QueryAccessMode'
    }
    @Override
    Map getInIntfMap() {
        ['cls':'gsQueryAccessModeQueryInService','path': 'business/gs/QueryAccessMode', 'method': 'GET']
    }

    @Override
    List getInParams() {
        ['account']
    }

    @Override
    Map getOutIntfMap() {
        [ 'cls':'gsQueryAccessModeQueryOutService', 'path': '/openapi/V1/Resource/Broadband/queryBroadbandAccessMode4Online', 'method': 'POST']
    }
}
