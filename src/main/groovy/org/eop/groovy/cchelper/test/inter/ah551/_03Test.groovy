package org.eop.groovy.cchelper.test.inter.ah551

import org.eop.groovy.cchelper.test.inter.AbstractInterTest

import com.cmos.esbclient.bean.RestMethodType
/***
{
"userMobile":"13955000055",
"currProductId":"PIBPG460",
"newProductId":"PIBPG493"
}
***/
/**
 * @author lixinjie
 */
class _03Test extends AbstractInterTest {

	@Override
	RestMethodType getMethod() {
		RestMethodType.PUT
	}

	@Override
	String getUri() {
		'business/gs/flowUpgrade'
	}

}
