package org.eop.groovy.cchelper.test.inter.gs931;
import com.cmos.esbclient.bean.RestMethodType;
import org.eop.groovy.cchelper.test.inter.AbstractInterTest;
/***
 {
 "newBrand":"1",
 "newPlanId":"1",
 "validType":"0",
 "prodInfoList":[
 {
 "prodId":"01",
 "actionType":"1",
 "veType":"2",
 "prodType":"4",
 "busType":"shouli","serviceId":"001",
 "preProdId":"p001"
 },
 {
 "prodId":"02",
 "actionType":"1",
 "veType":"2",
 "prodType":"4",
 "busType":"shouli",
 "serviceId":"001",
 "preProdId":"p001"
 }
 ]
 }
 ***/
/**
 * 移动数据流量套餐
 * @author zhangniuniu
 */
class ivr_12FlowPackageBusi  extends AbstractInterTest {

    @Override
    RestMethodType getMethod() {
        RestMethodType.POST
    }

    @Override
    String getUri() {
        'business/gs/busi_acceptProm'
    }
}