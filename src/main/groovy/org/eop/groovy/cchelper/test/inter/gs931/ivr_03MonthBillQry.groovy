package org.eop.groovy.cchelper.test.inter.gs931;

import com.cmos.esbclient.bean.RestMethodType;
import org.eop.groovy.cchelper.test.inter.AbstractInterTest;

/***
 {
     "billMonth":"201512"
 }
 ***/
/**
 * 账单查询（月账单明细查询1.0/集团1.0(3.2.61/3.2.60)）
 * @author zhangniuniu
 */
class ivr_03MonthBillQry extends AbstractInterTest {

    @Override
    RestMethodType getMethod() {
        RestMethodType.POST
    }

    @Override
    String getUri() {
        'business/gs/query_monthBillFee'
    }
}