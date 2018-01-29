package org.eop.groovy.cchelper.test.sql.gs931

class o16ECOrderStatusSy extends _00Int15CommonOneSqlTest{
    @Override
    String getSqlFilePrefix() {
        '_016'
    }

    @Override
    String getDistinctName() {

        '订单状态同步'
    }

    @Override
    Map getInIntfMap() {
        'orderStatusSy'
    }

    @Override
    Map getOutIntfMap() {
        ['path': 'business/gs/orderStateSynchronization', 'method': 'POST']
    }

    @Override
    List getInParams() {
        ['sourceCode','targetCode','transactionID','busiCode']
    }

    @Override
    String getDepKey() {
        [ 'cls':'gsOrderStateSynchronizationService', 'path': '/gsccwap/orderStatus/obtain.do', 'method': 'POST']

    }
}
