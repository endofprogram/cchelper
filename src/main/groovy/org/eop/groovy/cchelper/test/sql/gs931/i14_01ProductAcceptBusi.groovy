package org.eop.groovy.cchelper.test.sql.gs931

class i14_01ProductAcceptBusi extends _00Int15CommonOneSqlTest{

    @Override
    String getSqlFilePrefix() {
        'i14_01'
    }

    @Override
    String getDistinctName() {
        '业务办理产品受理'
    }

    @Override
    String getDepKey() {
        'prodTrans'
    }

    @Override
    Map getInIntfMap() {
        ['path': 'business/gs/productAcceptBusiTrans', 'method': 'post']
    }

    @Override
    List getInParams() {
        ['userMobile','oprCode','productId','prodType','effectiveType']
    }

    @Override
    Map getOutIntfMap() {
        [ 'cls':'gsProductAcceptService', 'path': '/openapi/V1/partner/ability/production/productChangePlanProd4cmcc', 'method': 'POST']
    }

}
