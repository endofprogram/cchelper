package org.eop.groovy.cchelper.test.inter.ah551

import org.eop.groovy.cchelper.test.inter.AbstractInterTest

import com.cmos.esbclient.bean.RestMethodType
/***
{
"userMobile":"13615608599",
"productId":"BP0016"
}
***/
/**
 * @author lixinjie
 */
class _04Test extends AbstractInterTest {

	@Override
	RestMethodType getMethod() {
		RestMethodType.GET
	}

	@Override
	String getUri() {
		'business/gs/userOrdInfoQry'
	}

}
