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
    Map getInIntfMap() {
        ['path': 'business/gs/busi_accept', 'method': 'POST', 'depkey':'']
    }

    @Override
    List getInParams() {
        []
    }

    @Override
    Map getOutIntfMap() {
        [ 'cls':'gsIvrZnyydhCallDisplayTransactService', 'path': '/openapi/V1/partner/ability/sandbox/productChangePlanProd4cmcc', 'method': 'POST', 'depkey':'']
    }
}
