package org.eop.groovy.cchelper.test.sql.gs931

class i03_02GprsRmnQry extends _00Int15CommonOneSqlTest {

    @Override
    String getSqlFilePrefix() {
        'i03_02'
    }

    @Override
    String getDistinctName() {
        '流量使用带产品'
    }

    @Override
    String getDepKey() {
        'dinnerRemain'
    }

    @Override
    Map getInIntfMap() {
        ['path': 'business/gs/gprsRmnQry', 'method': 'GET']
    }

    @Override
    List getInParams() {
        ['userMobile']
    }

    @Override
    Map getOutIntfMap() {
        ['cls': 'gsFeeResourceWithProdService', 'path': '/openapi/V1/partner/ability/production/feeResourceWithProd', 'method': 'POST']
    }
}


