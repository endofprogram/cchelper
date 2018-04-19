package org.eop.groovy.cchelper.test.sql.gs931.online

class GssyncActivateInforQueryService extends OnlineByNengkaiCommonOneSqlTest {
    @Override
     String getSqlFilePrefix() {
        'online_01'
    }

    @Override
     String getDistinctName() {
        '认证成功手机卡激活'
    }

    @Override
     String getDepKey() {
        'ObtainOfferFee'
    }

    @Override
     Map getInIntfMap() {
        ['cls':'gssyncActivateInforQueryInService','path': 'business/gs/ObtainOfferFee', 'method': 'POST']
    }
    @Override
    List getInParams() {
        ['reqInfo']
    }

    @Override
    Map getOutIntfMap() {
        [ 'cls':'gssyncActivateInforQueryOutService', 'path': '/openapi/V1/Party/User/syncActivateInformation4Online', 'method': 'POST']
    }
}
