package org.eop.groovy.cchelper.test.inter.hn371

import org.eop.groovy.cchelper.test.inter.AbstractInterTest

import com.cmos.esbclient.bean.RestMethodType
/***
{
"userMobile": "13592415494",
"billingCycle": "201610",
"beginDate": "2016-10-01 00:00:00",
"endDate": "2016-10-31 23:59:59",
"optrId": "202020"
}
***/
/**
 * @author lixinjie
 */
class _08ZDDSFYWFYTest extends AbstractInterTest {

	@Override
	RestMethodType getMethod() {
		RestMethodType.GET
	}

	@Override
	String getUri() {
		'business/gs/billAgencyFeeBusi'
	}

}
