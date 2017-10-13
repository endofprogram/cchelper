package org.eop.groovy.cchelper.test.inter.ln240

import org.eop.groovy.cchelper.test.inter.AbstractInterTest

import com.cmos.esbclient.bean.RestMethodType
/***
{
"iDItemRange":"15998306105",
"productType":"2",
"productId":"xx111153001057",
"spId":"123",
"bizCode":"11",
"flag":"U",
"payPath":"A"
}
***/
/**
 * @author lixinjie
 */
class _04Test extends AbstractInterTest {

	@Override
	RestMethodType getMethod() {
		RestMethodType.PUT
	}

	@Override
	String getUri() {
		'business/gs/product'
	}

}
