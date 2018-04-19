package org.eop.groovy.cchelper.test.sql.gs931.intnet15

class bd_queryUserPointInfo extends Intnet15ByNengkaiCommonUnionSqlTest{
    @Override
    String getSqlFilePrefix() {
        'int03'
    }

    @Override
    String getDistinctName() {
        '总积分查询'
    }

    @Override
    List getDeps() {
        ['查询用户信息', '积分查询']
    }

    @Override
    Map getInIntfMap() {
        ['path': 'business/gs/pointQry', 'method': 'GET']
    }

    @Override
    List getInParams() {
        ['userMobile']
    }

    @Override
    Map getOutIntfMap() {
        ['cls': 'gsUniCoinPointsQueryOutService']
    }
}