package org.eop.groovy.cchelper.test.inter.hn371

import org.eop.groovy.cchelper.test.inter.AbstractInterTest

import com.cmos.esbclient.bean.RestMethodType
/***
{
"userMobile": "15981933922"
}
***/
/**
 * @author lixinjie
 */
class _10YHHFTest extends AbstractInterTest {

	@Override
	RestMethodType getMethod() {
		RestMethodType.GET
	}

	@Override
	String getUri() {
		'business/gs/userPhoneFee'
	}

}
