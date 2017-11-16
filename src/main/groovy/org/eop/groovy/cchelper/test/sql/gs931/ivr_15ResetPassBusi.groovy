package org.eop.groovy.cchelper.test.sql.gs931;

import java.util.List;
import java.util.Map;

public class ivr_15ResetPassBusi extends _00Int15CommonOneSqlTest{

    @Override
    String getSqlFilePrefix() {
        'ivr_15'
    }

    @Override
    String getDistinctName() {
        '重置密码'
    }

    @Override
    Map getInIntfMap() {
        ['path': 'business/gs/get_userPassword', 'method': 'POST', 'depkey':'']
    }

    @Override
    List getInParams() {
        []
    }

    @Override
    Map getOutIntfMap() {
        [ 'cls':'gsIvrZnyydhPwdResetTransactService', 'path': '/openapi/V1/partner/ability/sandbox/passwordReset', 'method': 'POST', 'depkey':'']
    }
}
