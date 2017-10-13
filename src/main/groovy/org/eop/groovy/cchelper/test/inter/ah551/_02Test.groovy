package org.eop.groovy.cchelper.test.inter.ah551

import org.eop.groovy.cchelper.test.inter.AbstractInterTest

import com.cmos.esbclient.bean.RestMethodType
/***
{
"iDItemRange":"13615608599",
"productType":"2",
"productId":"PIBP0024",
"spId":"",
"bizCode":"",
"flag":"",
"payPath":""
}
***/
/**
 * @author lixinjie
 */
class _02Test extends AbstractInterTest {

	@Override
	RestMethodType getMethod() {
		RestMethodType.PUT
	}

	@Override
	String getUri() {
		'business/gs/product'
	}

}
