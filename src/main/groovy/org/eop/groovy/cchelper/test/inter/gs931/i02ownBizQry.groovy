package org.eop.groovy.cchelper.test.inter.gs931

import com.cmos.esbclient.bean.RestMethodType
import org.eop.groovy.cchelper.test.inter.AbstractInterTest

/***
 {
 "userMobile":"13919922808"
 }
 ***/
class i02ownBizQry extends AbstractInterTest {

    @Override
    RestMethodType getMethod() {
        RestMethodType.GET
    }

    @Override
    String getUri() {
        'business/gs/ownBizQry'
    }

}

