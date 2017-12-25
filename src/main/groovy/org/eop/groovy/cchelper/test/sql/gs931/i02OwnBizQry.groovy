package org.eop.groovy.cchelper.test.sql.gs931

class i02OwnBizQry extends _00Int15CommonUnionSqlTest {

    @Override
    String getSqlFilePrefix() {
        'i02'
    }

    @Override
    String getDistinctName() {
        '已订业务查询'
    }

    @Override
    List getDeps() {
        ['已有计划和产品', '办理活动查询', '查询在用梦网业务']
    }

    @Override
    Map getInIntfMap() {
        ['path': 'business/gs/ownBizQry', 'method': 'GET']
    }

    @Override
    List getInParams() {
        ['userMobile']
    }

    @Override
    Map getOutIntfMap() {
        ['cls': 'gsUserCurBizQueryService']
    }
}
