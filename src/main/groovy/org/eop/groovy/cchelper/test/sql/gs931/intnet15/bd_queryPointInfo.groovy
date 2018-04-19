package org.eop.groovy.cchelper.test.sql.gs931.intnet15


class bd_queryPointInfo  extends Intnet15ByNengkaiCommonOneSqlTest{

    @Override
    public String getSqlFilePrefix() {
        'inter_p_03'
    }

    @Override
    public String getDistinctName() {
        '积分查询'
    }

    @Override
    public String getDepKey() {
        'queryPointInfo'
    }

    @Override
    public Map getInIntfMap() {
        ['cls':'gsPointsQueryInService','path': 'business/gs/queryPointInfo', 'method': 'GET']
    }
    @Override
    public List getInParams() {
        ['userMobile']
    }

    @Override
    public Map getOutIntfMap() {
        [ 'cls':'gsPointsQueryOutService', 'path': '/openapi/V1/Charge/Point/queryConvertiblePoint4Online', 'method': 'POST']
    }



}
