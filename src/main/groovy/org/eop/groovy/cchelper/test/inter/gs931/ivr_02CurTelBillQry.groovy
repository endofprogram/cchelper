import com.cmos.esbclient.bean.RestMethodType
import org.eop.groovy.cchelper.test.inter.AbstractInterTest
/***
 {

 }
 ***/
/**
 * 查询实时话费及余额1.0(3.2.14)
 * @author zhangniuniu
 */
class ivr_02CurTelBillQry  extends AbstractInterTest {

    @Override
    RestMethodType getMethod() {
        RestMethodType.POST
    }

    @Override
    String getUri() {
        'business/gs/query_curTelBill'
    }
}