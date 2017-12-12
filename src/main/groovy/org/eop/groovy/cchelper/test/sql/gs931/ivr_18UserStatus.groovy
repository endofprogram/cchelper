package org.eop.groovy.cchelper.test.sql.gs931
    import org.eop.groovy.cchelper.test.sql.AbstractSqlTest;
    import org.junit.Test;

    import java.io.File;
    import java.util.List;
    import java.util.Map;

/**
 * @author mafuliang
 */
    class ivr_18UserStatus extends _00Int15CommonOneSqlTest {


        @Override
        String getSqlFilePrefix() {
            'ivr_18'
        }

        @Override
        String getDistinctName() {
            '用户停开机状态查询'
        }

        @Override
        String getDepKey() {
            'usertkjStatus'
        }
        @Override
        Map getInIntfMap() {
            ['path': 'business/gs/myUserStatus', 'method': 'GET' ]
        }

        @Override
        List getInParams() {
            ["userMobile"]
        }

        @Override
        Map getOutIntfMap() {
            [ 'cls':'gsIvrZnyydhUserStatusQueryService', 'path': '/openapi/V1/partner/ability/production/userStopStatus', 'method': 'POST' ]
        }

    }

