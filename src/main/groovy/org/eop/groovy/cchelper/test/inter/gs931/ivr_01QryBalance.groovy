package org.eop.groovy.cchelper.test.inter.gs931;
import org.eop.groovy.cchelper.test.inter.AbstractInterTest
import com.cmos.esbclient.bean.RestMethodType
/***
 {
 "queryType":"1"
 }
 ***/
/**
 * 余额查询
 * @author zhangniuniu
 */
class ivr_01QryBalance extends AbstractInterTest {

    @Override
    RestMethodType getMethod() {
        RestMethodType.GET
    }

    @Override
    String getUri() {
        'business/gs/query_balance'
    }

}





