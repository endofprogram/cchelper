package org.eop.groovy.cchelper.test.inter.ln240.flow

import org.eop.groovy.cchelper.test.inter.AbstractInterTest

import com.cmos.esbclient.bean.RestMethodType
/***
{
"userMobile":"15904002605",
"productId":"11111111",
"productName":"",
"amount":"",
"discount":"",
"productValue":"",
"orderId":"",
"serverCode":"",
"orderTime":""
}
***/
/**
 * @author lixinjie
 */
class _02Test extends AbstractInterTest {

	@Override
	RestMethodType getMethod() {
		RestMethodType.POST
	}

	@Override
	String getUri() {
		'business/gs/memberDealOper'
	}

}
