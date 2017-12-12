package org.eop.groovy.cchelper.test.sql.gs931;

import java.util.List;
import java.util.Map;

public class ivr_10OpenOnlineBusi extends _00Int15CommonOneSqlTest{
    @Override
    String getSqlFilePrefix() {
        'ivr_10'
    }

    @Override
    String getDistinctName() {
        '开通上网功能'
    }
    @Override
    String getDepKey() {
        ''
    }
    @Override
    Map getInIntfMap() {
        ['path': 'business/gs/networkBusiTrans', 'method': 'PUT' ]
    }

    @Override
    List getInParams() {
        ['userMobile', 'actionType','veType']
    }

    @Override
    Map getOutIntfMap() {
        [ 'cls':'gsIvrZnyydhNetworkTransactService', 'path': '/openapi/V1/partner/ability/production/productChangePlanProd4cmcc', 'method': 'POST' ]
    }
}

