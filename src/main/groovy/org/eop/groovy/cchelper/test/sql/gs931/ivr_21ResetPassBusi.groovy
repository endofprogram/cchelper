package org.eop.groovy.cchelper.test.sql.gs931;

import java.util.List;
import java.util.Map;

public class ivr_21ResetPassBusi extends _00Int15CommonOneSqlTest{

    @Override
    String getSqlFilePrefix() {
        'ivr_21'
    }

    @Override
    String getDistinctName() {
        '重置密码'
    }

    @Override
    String getDepKey() {
        ''
    }
    @Override
    Map getInIntfMap() {
        ['path': 'business/gs/newPwdTrans', 'method': 'POST' ]
    }

    @Override
    List getInParams() {
        ['userMobile']
    }

    @Override
    Map getOutIntfMap() {
        [ 'cls':'gsIvrZnyydhPwdResetTransactService', 'path': '/openapi/V1/partner/ability/production/passwordReset', 'method': 'POST' ]
    }
}
