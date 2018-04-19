package org.eop.groovy.cchelper.test.sql.gs931.intnet15



class bd_queryUserInfo extends Intnet15ByNengkaiCommonOneSqlTest{

    @Override
    public String getSqlFilePrefix() {
        'inter_u_03'
    }

    @Override
    public String getDistinctName() {
        '查询用户信息'
    }

    @Override
    public String getDepKey() {
        'queryUserInfo'
    }

    @Override
    public Map getInIntfMap() {
        ['cls':'gsQueryUserInforQueryInService','path': 'business/gs/QueryUserInfo', 'method': 'GET']
    }
    @Override
    public List getInParams() {
        ['userMobile']
    }

    @Override
    public Map getOutIntfMap() {
        [ 'cls':'gsQueryUserInforQueryOutService', 'path': '/openapi/V1/Party/User/queryUserInfo4Online', 'method': 'POST']
    }



}
