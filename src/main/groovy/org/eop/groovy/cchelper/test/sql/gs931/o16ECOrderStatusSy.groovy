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
        ['path': 'business/gs/orderStateSynchronization', 'method': 'GET']
    }
    @Override
    Map getOutIntfMap() {
        [ 'cls':'gsOrderStateSynchronizationService', 'path': '/gsccwap/orderStatus/obtain.do', 'method': 'POST']

    }

    @Override
    List getInParams() {
        ['sourceCode','targetCode','transactionID','busiCode']
    }

    @Override
    String getDepKey() {
        'orderStatusSy'
    }
}
