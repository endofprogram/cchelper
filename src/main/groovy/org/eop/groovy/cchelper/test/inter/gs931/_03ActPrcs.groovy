package org.eop.groovy.cchelper.test.inter.gs931

import org.eop.groovy.cchelper.test.inter.AbstractInterTest

import com.cmos.esbclient.bean.RestMethodType
/***
{
"userMobile":"13919318036",
"attributeName":"",
"value":"",
"promoId":"620562",
"condId":"10001",
"actType":"1"
}
***/
/**
 * @author lixinjie
 */
class _03ActPrcs extends AbstractInterTest {

	@Override
	RestMethodType getMethod() {
		RestMethodType.POST
	}

	@Override
	String getUri() {
		'business/gs/actPrcs'
	}

}
