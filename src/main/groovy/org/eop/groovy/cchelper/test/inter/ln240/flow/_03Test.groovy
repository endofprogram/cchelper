package org.eop.groovy.cchelper.test.inter.ln240.flow

import org.eop.groovy.cchelper.test.inter.AbstractInterTest

import com.cmos.esbclient.bean.RestMethodType
/***
{
"userMobile":"15904002605",
"orderId":"11111111",
"custId":""
}
***/
/**
 * @author lixinjie
 */
class _03Test extends AbstractInterTest {

	@Override
	RestMethodType getMethod() {
		RestMethodType.GET
	}

	@Override
	String getUri() {
		'business/gs/memberReturnQuery'
	}

}
