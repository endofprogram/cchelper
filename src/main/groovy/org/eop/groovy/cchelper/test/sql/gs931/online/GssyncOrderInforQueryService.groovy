package org.eop.groovy.cchelper.test.sql.gs931.online

class GssyncOrderInforQueryService  extends OnlineByNengkaiCommonOneSqlTest {
    @Override
  String getSqlFilePrefix() {
        'online_05'
    }

    @Override


    String getDistinctName() {
        '预售卡'
    }

    @Override
    String getDepKey() {
        'PresaleCardOrder'
    }

    @Override
    Map getInIntfMap() {
        ['cls':'gssyncOrderInforQueryInService','path': 'business/gs/PresaleCardOrder', 'method': 'POST']
    }
    @Override
   List getInParams() {
        ['reqInfo']
    }

    @Override
    Map getOutIntfMap() {
        [ 'cls':'gssyncOrderInforQueryOutService', 'path': '/openapi/V1/BizInteraction/Order/syncOrderInformation4Online', 'method': 'POST']
    }
}

