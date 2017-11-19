package org.eop.groovy.cchelper.test.inter.gs931;

import com.cmos.esbclient.bean.RestMethodType;
import org.eop.groovy.cchelper.test.inter.AbstractInterTest;

/***
 {
 "userMobile":"13919318036",
     "feeItemId":"80400027",
     "beginDate":"2015-12-01",
     "endDate":"2015-12-31"
 }
 ***/
/**
 * 增值业务查询（查询sp产品订购信息电商1.0(3.2.4)）
 * @author zhangniuniu
 */
class ivr_06ValueAddedServiceQry  extends AbstractInterTest {

    @Override
    RestMethodType getMethod() {
        RestMethodType.GET
    }

    @Override
    String getUri() {
        'business/gs/spBizQry'
    }
}