package org.eop.groovy.cchelper.test.sql.gs931

class i17PaymentRecordQry extends _00Int15CommonOneSqlTest {

    @Override
    String getSqlFilePrefix() {
        "i17"
    }

        @Override
        String getDistinctName() {
            "缴费历史查询"
        }

        @Override
        Map getInIntfMap() {
        ['path': 'business/gs/paymentHistoryQry', 'method': 'GET']
    }

    @Override
    Map getOutIntfMap() {
        [ 'cls':'gsPaymentRecordQueryService', 'path': '/openapi/V1/partner/ability/sandbox/busiRec4cmcc', 'method': 'POST']
    }

    @Override
    List getInParams() {
        ['userMobile','startTime','endTime']
    }

    @Override
    String getDepKey() {
       ''
    }
}
