package org.eop.groovy.cchelper.test.sql.gs931

/**
 * Created by 10130 on 2017/12/5.
 */
class ivr_16StopStartMachine extends  _00Int15CommonOneSqlTest{
    @Override
    String getSqlFilePrefix() {
        'ivr_16'
    }

    @Override
    String getDistinctName() {
        '停开机服务查询'
    }

    @Override
    Map getInIntfMap() {
        ['path': 'business/gs/queryStopStartMachine', 'method': 'GET' ]
    }

    @Override
    Map getOutIntfMap() {
        [ 'cls':'gslvrZnyydhStopStartMachineQueryService', 'path': '/openapi/V1/partner/ability/production/userStopStatus', 'method': 'POST' ]
    }

    @Override
    List getInParams() {
        ['userMobile']
    }

    @Override
    String getDepKey() {
       'stopStartMachine'
    }
}
