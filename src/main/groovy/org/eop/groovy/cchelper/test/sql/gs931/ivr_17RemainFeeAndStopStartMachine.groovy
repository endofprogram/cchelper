package org.eop.groovy.cchelper.test.sql.gs931

/**
 * Created by 10130 on 2017/12/5.
 */
class ivr_17RemainFeeAndStopStartMachine extends  _00Int15CommonUnionSqlTest{

    @Override
    String getSqlFilePrefix() {
        'ivr_17'
    }

    @Override
    String getDistinctName() {
        '停开机和余额综合查询'
    }

    @Override
    Map getInIntfMap() {
        ['path': 'business/gs/queryRemainFeeAndStopStartMachine', 'method': 'GET']
    }

    @Override
    Map getOutIntfMap() {
        ['cls': 'gsIvrZnyydhRemainFeeAndStopStartQueryService']
    }

    @Override
    List getInParams() {
        ['userMobile']
    }

    @Override
    List getDeps() {
        ['停开机服务查询', '余额查询']
    }
}
