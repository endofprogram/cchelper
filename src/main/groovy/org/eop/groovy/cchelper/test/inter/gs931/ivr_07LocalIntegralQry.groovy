package org.eop.groovy.cchelper.test.inter.gs931;

import com.cmos.esbclient.bean.RestMethodType;
import org.eop.groovy.cchelper.test.inter.AbstractInterTest;

/***
 {
 "userMobile":"13919318036",
 "yearMonth":"201602"
 }
 ***/
/**
 * 本机积分查询（查询用户积分的月初与月末余额电商1.0/(3.2.19)）
 * @author zhangniuniu
 */
class ivr_07LocalIntegralQry  extends AbstractInterTest {

    @Override
    RestMethodType getMethod() {
        RestMethodType.GET
    }

    @Override
    String getUri() {
        'business/gs/myPointQry'
    }
}