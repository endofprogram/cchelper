package org.eop.groovy.cchelper.test.inter.gs931;

import com.cmos.esbclient.bean.RestMethodType;
import org.eop.groovy.cchelper.test.inter.AbstractInterTest;

/***
 {

 }
 ***/
/**
 * 重置密码
 * @author zhangniuniu
 */
class ivr_15ResetPassBusi  extends AbstractInterTest {

    @Override
    RestMethodType getMethod() {
        RestMethodType.POST
    }

    @Override
    String getUri() {
        'business/gs/get_userPassword'
    }
}