package org.eop.groovy.cchelper.test.sql.gs931


/**
 * @deprecated 月份可为空，注意修改sql
 */
class ivr_08RechargeQry  extends _00Int15CommonOneSqlTest {

    @Override
    String getSqlFilePrefix() {
        'ivr_08'
    }

    @Override
    String getDistinctName() {
        '充值查询'
    }

    @Override
    String getDepKey() {
        ''
    }

    @Override
    Map getInIntfMap() {
        ['path': 'business/gs/chargeRecQry', 'method': 'GET' ]
    }

    @Override
    List getInParams() {
        //月份可为空，注意修改sql
        ["userMobile",'beginDate','endDate']
    }

    @Override
    Map getOutIntfMap() {
        [ 'cls':'gsIvrZnyydhRechargeQueryService', 'path': '/openapi/V1/partner/ability/production/busiRec4cmcc', 'method': 'POST' ]
    }
}

