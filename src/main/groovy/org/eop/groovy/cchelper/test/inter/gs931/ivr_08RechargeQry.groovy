package org.eop.groovy.cchelper.test.inter.gs931;

import com.cmos.esbclient.bean.RestMethodType;
import org.eop.groovy.cchelper.test.inter.AbstractInterTest;

/***
 {
 "beginDate":"2015-1-1",
 "endDate":"2015-5-1",
 "queryType":"1"
 }
 ***/
/**
 * 充值查询（缴费历史查询电商1.0(3.2.36)）
 * @author zhangniuniu
 */
class ivr_08RechargeQry  extends AbstractInterTest {

    @Override
    RestMethodType getMethod() {
        RestMethodType.POST
    }

    @Override
    String getUri() {
        'business/gs/query_payHistory'
    }
}