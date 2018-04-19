package org.eop.groovy.cchelper.test.sql.gs931.broadband

class GsQueryPayRecordsQueryService extends BroadbandByNengkaiCommonOneSqlTest {

    @Override
    String getSqlFilePrefix() {
        'payRecords'
    }

    @Override
    String getDistinctName() {
        '缴费记录查询'
    }

    @Override
    String getDepKey() {
        'QueryPayRecords'
    }
    @Override
    Map getInIntfMap() {
        ['cls':'gsQueryPayRecordsQueryInService','path': 'business/gs/QueryPayRecords', 'method': 'GET']
    }

    @Override
    List getInParams() {
        ['srvCode','startTime','endTime']
    }

    @Override
    Map getOutIntfMap() {
        [ 'cls':'gsQueryPayRecordsQueryOutService', 'path': '/openapi/V1/Charge/Book/queryBroadbandPaymentRecords4Online', 'method': 'POST']
    }
}

