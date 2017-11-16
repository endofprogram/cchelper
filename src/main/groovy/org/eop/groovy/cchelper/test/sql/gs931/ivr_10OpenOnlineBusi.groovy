package org.eop.groovy.cchelper.test.sql.gs931;

import java.util.List;
import java.util.Map;

public class ivr_10OpenOnlineBusi extends _00Int15CommonOneSqlTest{
    @Override
    String getSqlFilePrefix() {
        'ivr_10'
    }

    @Override
    String getDistinctName() {
        '开通上网功能'
    }
    @Override
    String getDepKey() {
        ''
    }
    @Override
    Map getInIntfMap() {
        ['path': 'business/gs/query_openOnlineBusi', 'method': 'POST' ]
    }

    @Override
    List getInParams() {
        []
    }

    @Override
    Map getOutIntfMap() {
        [ 'cls':'gsIvrZnyydhNetworkTransactService', 'path': '/openapi/V1/partner/ability/sandbox/productChangePlanProd4cmcc', 'method': 'POST' ]
    }
}

/**
 * "serviceContent":{
 "newBrand":"1",
 "newPlanId":"1",
 "validType":"0",
 "prodInfoList":[
 {
 "prodId":"01",
 "actionType":"1",
 "veType":"2",
 "prodType":"4",
 "busType":"shouli","serviceId":"001",
 "preProdId":"p001"
 },
 {
 "prodId":"02",
 "actionType":"1",
 "veType":"2",
 "prodType":"4",
 "busType":"shouli",
 "serviceId":"001",
 "preProdId":"p001"
 }
 ]
 }
 */
