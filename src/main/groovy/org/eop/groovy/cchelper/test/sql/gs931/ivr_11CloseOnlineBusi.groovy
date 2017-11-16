package org.eop.groovy.cchelper.test.sql.gs931;

import java.util.List;
import java.util.Map;

public class ivr_11CloseOnlineBusi extends _00Int15CommonOneSqlTest{

    @Override
    String getSqlFilePrefix() {
        'ivr_11'
    }

    @Override
    String getDistinctName() {
        '关闭上网功能'
    }

    @Override
    String getDepKey() {
        ''
    }
    @Override
    Map getInIntfMap() {
        ['path': 'business/gs/query_closeOnlineBusi', 'method': 'POST' ]
    }

    @Override
    List getInParams() {
        []
    }

    @Override
    Map getOutIntfMap() {
        [ 'cls':'gsIvrZnyydhNetworkTransactService', 'path': '/openapi/V1/partner/ability/sandbox/productChangePlanProd4cmcc', 'method': 'POST' ]
    }
}
