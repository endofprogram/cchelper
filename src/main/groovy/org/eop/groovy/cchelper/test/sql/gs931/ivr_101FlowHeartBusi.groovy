package org.eop.groovy.cchelper.test.sql.gs931;

import java.util.List;
import java.util.Map;

public class ivr_101FlowHeartBusi extends _00Int15CommonOneSqlTest{

    @Override
    String getSqlFilePrefix() {
        'ivr_101'
    }

    @Override
    String getDistinctName() {
        '流量安心包'
    }

    @Override
    String getDepKey() {
        ''
    }
    @Override
    Map getInIntfMap() {
        ['path': 'business/gs/flowHeartBusiTrans', 'method': 'POST' ]
    }

    @Override
    List getInParams() {
        ['userMobile', 'actionType','veType']
    }

    @Override
    Map getOutIntfMap() {
        [ 'cls':'gsIvrZnyydhFlowHeartTransactService', 'path': '/openapi/V1/partner/ability/production/productChangePlanProd4cmcc', 'method': 'POST' ]
    }
}

