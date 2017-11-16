package org.eop.groovy.cchelper.test.sql.gs931

import org.eop.groovy.cchelper.test.sql.AbstractSqlTest
import org.junit.Test

class ivr_06ValueAddedServiceQry  extends _00Int15CommonOneSqlTest {

    @Override
    String getSqlFilePrefix() {
        'ivr_06'
    }

    @Override
    String getDistinctName() {
        '增值业务查询'
    }

    @Override
    Map getInIntfMap() {
        ['path': 'business/gs/send_sms', 'method': 'POST', 'depkey':'']
    }

    @Override
    List getInParams() {
        ['feeItemId','beginDate','endDate']
    }

    @Override
    Map getOutIntfMap() {
        [ 'cls':'gsIvrZnyydhValuedBusinessQueryService', 'path': '/openapi/V1/partner/ability/sandbox/feeSpInfo4cmcc', 'method': 'POST', 'depkey':'']
    }
}

