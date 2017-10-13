package org.eop.groovy.cchelper.test.inter.hn371

import org.eop.groovy.cchelper.test.inter.AbstractInterTest

import com.cmos.esbclient.bean.RestMethodType
/***
{
"userMobile": "15038308163",
"startDay": "20170401",
"endDay": "20170430"
}
***/
/**
 * @author lixinjie
 */
class _03LLRBTest extends AbstractInterTest {

	@Override
	RestMethodType getMethod() {
		RestMethodType.GET
	}

	@Override
	String getUri() {
		'business/gs/flowDailyReport'
	}

}
