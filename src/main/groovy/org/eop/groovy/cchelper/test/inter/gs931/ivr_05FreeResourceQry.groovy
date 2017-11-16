package org.eop.groovy.cchelper.test.inter.gs931;

import com.cmos.esbclient.bean.RestMethodType;
import org.eop.groovy.cchelper.test.inter.AbstractInterTest;



/***
 {
 "month":"201601"
 }
 ***/
/**
 * 套餐及流量使用情况查询（流量使用查询1.0(3.2.37)）
 * @author zhangniuniu
 */
class ivr_05FreeResourceQry  extends AbstractInterTest {

    @Override
    RestMethodType getMethod() {
        RestMethodType.POST
    }

    @Override
    String getUri() {
        'business/gs/query_freeResource'
    }
}