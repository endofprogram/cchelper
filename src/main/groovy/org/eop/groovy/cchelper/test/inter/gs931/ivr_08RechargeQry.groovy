package org.eop.groovy.cchelper.test.inter.gs931;

import com.cmos.esbclient.bean.RestMethodType;
import org.eop.groovy.cchelper.test.inter.AbstractInterTest;

/***
 {
 "userMobile":"13919318036"
 }
 ***/
/**
 * 充值查询（缴费历史查询电商1.0(3.2.36)）
 * @author zhangniuniu
 */
class ivr_08RechargeQry  extends AbstractInterTest {

    @Override
    RestMethodType getMethod() {
        RestMethodType.GET
    }

    @Override
    String getUri() {
        'business/gs/chargeRecQry'
    }
}