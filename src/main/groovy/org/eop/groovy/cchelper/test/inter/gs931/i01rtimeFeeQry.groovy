package org.eop.groovy.cchelper.test.inter.gs931

import com.cmos.esbclient.bean.RestMethodType
import org.eop.groovy.cchelper.test.inter.AbstractInterTest

/***
 {
 "userMobile":"13919176115"
 }
 ***/
class i01rtimeFeeQry extends AbstractInterTest {

    @Override
    RestMethodType getMethod() {
        RestMethodType.GET
    }

    @Override
    String getUri() {
        'business/gs/rtimeFeeQry'
    }

}
