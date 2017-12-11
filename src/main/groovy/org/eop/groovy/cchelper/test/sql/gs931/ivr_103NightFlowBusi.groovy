package org.eop.groovy.cchelper.test.sql.gs931;

import java.util.List;
import java.util.Map;

public class ivr_103NightFlowBusi extends _00Int15CommonOneSqlTest{

    @Override
    String getSqlFilePrefix() {
        'ivr_103'
    }

    @Override
    String getDistinctName() {
        '夜间流量包'
    }

    @Override
    String getDepKey() {
        ''
    }
    @Override
    Map getInIntfMap() {
        ['path': 'business/gs/nightFlowBusiTrans', 'method': 'POST' ]
    }

    @Override
    List getInParams() {
        ['userMobile', 'actionType','veType']
    }

    @Override
    Map getOutIntfMap() {
        [ 'cls':'gsIvrZnyydhNightFlowTransactService', 'path': '/openapi/V1/partner/ability/production/productChangePlanProd4cmcc', 'method': 'POST' ]
    }
}

