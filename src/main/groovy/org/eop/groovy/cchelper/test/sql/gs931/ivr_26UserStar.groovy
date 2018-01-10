package org.eop.groovy.cchelper.test.sql.gs931
/**
 * @author mafuliang
 */
class ivr_26UserStar extends _00Int15CommonOneSqlTest {


    @Override
    String getSqlFilePrefix() {
        'ivr_26'
    }

    @Override
    String getDistinctName() {
        '用户星级查询'
    }

    @Override
    String getDepKey() {
        'userStar'
    }
    @Override
    Map getInIntfMap() {
        ['path': 'business/gs/userStar', 'method': 'GET' ]
    }

    @Override
    List getInParams() {
        ["userMobile"]
    }

    @Override
    Map getOutIntfMap() {
        [ 'cls':'gsIvrZnyydhUserStarQueryService', 'path': '/openapi/V1/partner/ability/sandbox/serviceStarGsNew', 'method': 'POST' ]
    }

}

