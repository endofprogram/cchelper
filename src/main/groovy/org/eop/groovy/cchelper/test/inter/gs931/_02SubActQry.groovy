package org.eop.groovy.cchelper.test.inter.gs931

import org.eop.groovy.cchelper.test.inter.AbstractInterTest

import com.cmos.esbclient.bean.RestMethodType
/***
{
"userMobile":"13919318036",
"promoId":"620562"
}
***/
/**
 * @author lixinjie
 */
class _02SubActQry extends AbstractInterTest {

	@Override
	RestMethodType getMethod() {
		RestMethodType.GET
	}

	@Override
	String getUri() {
		'business/gs/subActQry'
	}

}
