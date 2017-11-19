package org.eop.groovy.cchelper.test.inter.gs931;

import com.cmos.esbclient.bean.RestMethodType;
import org.eop.groovy.cchelper.test.inter.AbstractInterTest;

/***
 {
 "userMobile":"13919318036"
 }
 ***/
/**
 * 号码归属地查询查询（查询号码归属地1.0(3.2.9)）
 * @author zhangniuniu
 */
class ivr_09NumAttributionQry  extends AbstractInterTest {

    @Override
    RestMethodType getMethod() {
        RestMethodType.GET
    }

    @Override
    String getUri() {
        'business/gs/phoneAreaQry'
    }
}