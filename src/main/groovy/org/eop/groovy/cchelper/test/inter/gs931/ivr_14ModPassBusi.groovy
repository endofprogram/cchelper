package org.eop.groovy.cchelper.test.inter.gs931;

import com.cmos.esbclient.bean.RestMethodType;
import org.eop.groovy.cchelper.test.inter.AbstractInterTest;

/***
 {
 "userMobile":"13919318036",
 "oldpassword": "1",
 "newpassword": "1",
 }
 ***/
/**
 * 修改密码
 * @author zhangniuniu
 */
class ivr_14ModPassBusi  extends AbstractInterTest {

    @Override
    RestMethodType getMethod() {
        RestMethodType.POST
    }

    @Override
    String getUri() {
        'business/gs/modifyPwdTrans'
    }
}