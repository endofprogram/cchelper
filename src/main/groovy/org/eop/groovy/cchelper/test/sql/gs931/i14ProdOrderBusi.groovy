package org.eop.groovy.cchelper.test.sql.gs931

class i14ProdOrderBusi extends _00Int15CommonUnionSqlTest{

    @Override
    String getSqlFilePrefix() {
        'i14'
    }

    @Override
    String getDistinctName() {
        '业务办理'
    }

    @Override
    List getDeps() {
        ['业务办理产品受理', '业务办理省数据业务受理']
    }

    @Override
    Map getInIntfMap() {
        ['path': 'business/gs/prodOrderBusiTrans', 'method': 'post']
    }

    @Override
    List getInParams() {
        ['userMobile','productType','oprCode','productId','prodType','effectiveType','busiType','spId','bizCode']
    }

    @Override
    Map getOutIntfMap() {
        ['cls': 'gsProdOrderService']
    }


}
