package org.eop.groovy.cchelper.test.sql.gs931;

import java.util.List;
import java.util.Map;

public class ivr_12FlowPackageBusi extends _00Int15CommonOneSqlTest{

    @Override
    String getSqlFilePrefix() {
        'ivr_12'
    }

    @Override
    String getDistinctName() {
        '移动数据流量套餐'
    }

    @Override
    String getDepKey() {
        ''
    }
    @Override
    Map getInIntfMap() {
        ['path': 'business/gs/flowPackageBusiTrans', 'method': 'POST' ]
    }

    @Override
    List getInParams() {
        ['userMobile','prodId', 'actionType','veType']
    }

    @Override
    Map getOutIntfMap() {
        [ 'cls':'gsIvrZnyydhFlowTransactService', 'path': '/openapi/V1/partner/ability/production/productChangePlanProd4cmcc', 'method': 'POST' ]
    }
}
