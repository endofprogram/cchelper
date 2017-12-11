package org.eop.groovy.cchelper.test.sql.gs931;

import java.util.List;
import java.util.Map;

public class ivr_102MobilePayBusi extends _00Int15CommonOneSqlTest{

    @Override
    String getSqlFilePrefix() {
        'ivr_102'
    }

    @Override
    String getDistinctName() {
        '手机支付'
    }

    @Override
    String getDepKey() {
        ''
    }
    @Override
    Map getInIntfMap() {
        ['path': 'business/gs/mobilePayBusiTrans', 'method': 'POST' ]
    }

    @Override
    List getInParams() {
        ['userMobile', 'actType']
    }

    @Override
    Map getOutIntfMap() {
        [ 'cls':'gsIvrZnyydhMobilePayTransactService', 'path': '/openapi/V1/partner/ability/production/so_userRadiusAccept4cmcc', 'method': 'POST' ]
    }
}
