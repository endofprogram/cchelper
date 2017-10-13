package org.eop.groovy.cchelper.test.inter.gs931

import org.eop.groovy.cchelper.test.inter.AbstractInterTest

import com.cmos.esbclient.bean.RestMethodType
/***
{
"appId":"A2017083117061000024",
"accessToken":"4920cb16c8bdf0442c3aca5b5a7123b37fb10b5a"
}
***/
/**
 * @author lixinjie
 */
class _01DynTok extends AbstractInterTest {

	@Override
	RestMethodType getMethod() {
		RestMethodType.GET
	}

	@Override
	String getUri() {
		'business/gs/dynamicToken'
	}

}
