package org.eop.groovy.cchelper.test.sql.gs931.online

class GssyncActivateInforQueryService extends OnlineByNengkaiCommonOneSqlTest {
    @Override
    public String getSqlFilePrefix() {
        'online_01'
    }

    @Override
    public String getDistinctName() {
        '认证成功手机卡激活'
    }

    @Override
    public String getDepKey() {
        'ObtainOfferFee'
    }

    @Override
    public Map getInIntfMap() {
        ['cls':'gssyncActivateInforQueryInService','path': 'business/gs/ObtainOfferFee', 'method': 'POST']
    }
    @Override
    public List getInParams() {
        ['reqInfo']
    }

    @Override
    public Map getOutIntfMap() {
        [ 'cls':'gssyncActivateInforQueryOutService', 'path': '/openapi/V1/Party/User/syncActivateInformation4Online', 'method': 'POST']
    }
}
