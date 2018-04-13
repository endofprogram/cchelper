package org.eop.groovy.cchelper.test.sql.gs931.intnet15

import java.util.List
import java.util.Map

class GsFareBalanceQueryService extends Intnet15ByNengkaiCommonUnionSqlTest {

	 @Override
    String getSqlFilePrefix() {
        'int15'
    }

    @Override
    String getDistinctName() {
        '实时话费查询'
    }

    @Override
    List getDeps() {
        ['月账单查询', '欠费查询']
    }

    @Override
    Map getInIntfMap() {
        ['path': 'business/gs/FareBalance', 'method': 'GET']
    }

    @Override
    List getInParams() {
        ['userMobile']
    }

    @Override
    Map getOutIntfMap() {
        ['cls': 'gsFareBalanceQueryOutService']
    }

}
