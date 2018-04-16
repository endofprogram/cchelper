package org.eop.groovy.cchelper.test.sql.gs931.online

class GssyncOrderInforQueryService  extends OnlineByNengkaiCommonOneSqlTest {
    @Override
    public String getSqlFilePrefix() {
        'online_05'
    }

    @Override
    public String getDistinctName() {
        '预售卡'
    }

    @Override
    public String getDepKey() {
        'PresaleCardOrder'
    }

    @Override
    public Map getInIntfMap() {
        ['cls':'gssyncOrderInforQueryInService','path': 'business/gs/PresaleCardOrder', 'method': 'POST']
    }
    @Override
    public List getInParams() {
        ['reqInfo']
    }

    @Override
    public Map getOutIntfMap() {
        [ 'cls':'gssyncOrderInforQueryOutService', 'path': '/openapi/V1/BizInteraction/Order/syncOrderInformation4Online', 'method': 'POST']
    }
}

