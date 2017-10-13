package org.eop.groovy.cchelper.test.inter.ah551

import org.eop.groovy.cchelper.test.inter.AbstractInterTest

import com.cmos.esbclient.bean.RestMethodType
/***
{
"iDItemRange":"18715062558",
"prodId":"D7000206"
}
***/
/**
 * @author lixinjie
 */
class _01Test extends AbstractInterTest {

	@Override
	RestMethodType getMethod() {
		RestMethodType.PUT
	}

	@Override
	String getUri() {
		'business/basicPackage'
	}

}
