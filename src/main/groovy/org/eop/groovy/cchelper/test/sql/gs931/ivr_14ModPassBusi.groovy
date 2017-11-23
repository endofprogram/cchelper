package org.eop.groovy.cchelper.test.sql.gs931;

import java.util.List;
import java.util.Map;

public class ivr_14ModPassBusi extends _00Int15CommonOneSqlTest{

    @Override
    String getSqlFilePrefix() {
        'ivr_14'
    }

    @Override
    String getDistinctName() {
        '修改密码'
    }

    @Override
    String getDepKey() {
        ''
    }
    @Override
    Map getInIntfMap() {
        ['path': 'business/gs/modifyPwdTrans', 'method': 'POST' ]
    }

    @Override
    List getInParams() {
        ['userMobile', 'oldPassword','newPassword']
    }

    @Override
    Map getOutIntfMap() {
        [ 'cls':'gsIvrZnyydhPwdChangeTransactService', 'path': '/openapi/V1/partner/ability/production/changePwd', 'method': 'POST' ]
    }
}
