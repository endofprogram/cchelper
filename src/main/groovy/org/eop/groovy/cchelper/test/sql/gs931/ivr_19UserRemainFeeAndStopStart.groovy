package org.eop.groovy.cchelper.test.sql.gs931

class ivr_19UserRemainFeeAndStopStart extends _00Int15CommonUnionSqlTest{
    @Override
    String getSqlFilePrefix() {
        'ivr_19'
    }

    @Override
    String getDistinctName() {
        '用户停开机及余额查询'
    }

    @Override
    Map getInIntfMap() {
        ['path': 'business/gs/myUserRemainFeeAndStopStart', 'method': 'GET' ]
    }

    @Override
    Map getOutIntfMap() {
        [ 'cls':'gsIvrZnyydhRemainFeeAndStopStartQueryService']
    }

    @Override
    List getInParams() {
        ["userMobile"]
    }

    @Override
    List getDeps() {
        ['用户停开机状态查询', '余额查询']
    }
}
