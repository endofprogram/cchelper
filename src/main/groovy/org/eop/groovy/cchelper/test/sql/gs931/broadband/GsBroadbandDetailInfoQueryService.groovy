package org.eop.groovy.cchelper.test.sql.gs931.broadband

class GsBroadbandDetailInfoQueryService extends BroadbandByNengkaiCommonOneSqlTest {

    @Override
    String getSqlFilePrefix() {
        'detailInfo'
    }

    @Override
    String getDistinctName() {
        '查询宽带用户的详细信息'
    }

    @Override
    String getDepKey() {
        'BroadbandDetailInfo'
    }
    @Override
    Map getInIntfMap() {
        ['cls':'gsBroadbandDetailInfoQueryInService','path': 'business/gs/BroadbandDetailInfo', 'method': 'GET']
    }

    @Override
    List getInParams() {
        ['account']
    }

    @Override
    Map getOutIntfMap() {
        [ 'cls':'gsBroadbandDetailInfoQueryOutService', 'path': '/openapi/V1/Party/User/queryBroadbandUserDetail4Online', 'method': 'POST']
    }
}


