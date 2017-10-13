package org.eop.groovy.cchelper.test.inter.hn371

import org.eop.groovy.cchelper.test.inter.AbstractInterTest

import com.cmos.esbclient.bean.RestMethodType
/***
{
"userMobile": "15981933922",
"billingCycle": "201704",
"beginDate": "2017-04-01 00:00:00",
"endDate": "2017-04-30 23:59:59",
"endDay": "20140430"
}
***/
/**
 * @author lixinjie
 */
class _09YJZDBGTest extends AbstractInterTest {

	@Override
	RestMethodType getMethod() {
		RestMethodType.GET
	}

	@Override
	String getUri() {
		'business/gs/levelOneBillTable'
	}

}
