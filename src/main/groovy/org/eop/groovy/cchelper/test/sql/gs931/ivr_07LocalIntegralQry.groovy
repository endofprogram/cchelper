package org.eop.groovy.cchelper.test.sql.gs931;

import org.eop.groovy.cchelper.test.sql.AbstractSqlTest;
import org.junit.Test;

import java.io.File;
import java.util.List;
import java.util.Map;

/**
 * @author zhangniuniu
 */
class ivr_07LocalIntegralQry extends _00Int15CommonOneSqlTest {


    @Override
    String getSqlFilePrefix() {
        'ivr_07'
    }

    @Override
    String getDistinctName() {
        '本机积分查询'
    }

    @Override
    Map getInIntfMap() {
        ['path': 'business/gs/query_jfjlhd', 'method': 'POST', 'depkey':'']
    }

    @Override
    List getInParams() {
        ['yearMonth']
    }

    @Override
    Map getOutIntfMap() {
        [ 'cls':'gsIvrZnyydhPointQueryService', 'path': '/openapi/V1/partner/ability/sandbox/userCoinPeriodRec4cmcc', 'method': 'POST', 'depkey':'']
    }

}
