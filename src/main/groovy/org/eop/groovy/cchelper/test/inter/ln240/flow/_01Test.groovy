package org.eop.groovy.cchelper.test.inter.ln240.flow

import org.eop.groovy.cchelper.test.inter.AbstractInterTest

import com.cmos.esbclient.bean.RestMethodType
/***
{
"provCode":"240"
}
***/
/**
 * @author lixinjie
 */
class _01Test extends AbstractInterTest {

	@Override
	RestMethodType getMethod() {
		RestMethodType.GET
	}

	@Override
	String getUri() {
		'business/gs/products'
	}

}
