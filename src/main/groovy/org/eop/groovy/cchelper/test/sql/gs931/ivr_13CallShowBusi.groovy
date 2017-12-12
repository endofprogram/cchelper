package org.eop.groovy.cchelper.test.sql.gs931;

import java.util.List;
import java.util.Map;

public class ivr_13CallShowBusi extends _00Int15CommonOneSqlTest{

    @Override
    String getSqlFilePrefix() {
        'ivr_13'
    }

    @Override
    String getDistinctName() {
        '来电显示'
    }

    @Override
    String getDepKey() {
        ''
    }
    @Override
    Map getInIntfMap() {
        ['path': 'business/gs/callShowBusiTrans', 'method': 'POST' ]
    }

    @Override
    List getInParams() {
        ['userMobile', 'actionType','veType']
    }

    @Override
    Map getOutIntfMap() {
        [ 'cls':'gsIvrZnyydhCallDisplayTransactService', 'path': '/openapi/V1/partner/ability/production/productChangePlanProd4cmcc', 'method': 'POST' ]
    }
}
