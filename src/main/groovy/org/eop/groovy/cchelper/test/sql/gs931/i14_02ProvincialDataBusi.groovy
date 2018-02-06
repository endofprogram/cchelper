package org.eop.groovy.cchelper.test.sql.gs931

class i14_02ProvincialDataBusi extends _00Int15CommonOneSqlTest{

    @Override
    String getSqlFilePrefix() {
        'i14_02'
    }

    @Override
    String getDistinctName() {
        '业务办理省数据业务受理'
    }

    @Override
    String getDepKey() {
        'dataTrans'
    }

    @Override
    Map getInIntfMap() {
        ['path': 'business/gs/provincialDataBusiTrans', 'method': 'POST']
    }

    @Override
    List getInParams() {
        ['userMobile','busiType','spId','servCode','oprCode']
    }

    @Override
    Map getOutIntfMap() {
        [ 'cls':'gsProvincialDataBusiService', 'path': '/openapi/V1/partner/ability/production/so_userRadiusAccept4cmcc', 'method': 'POST']
    }
}
