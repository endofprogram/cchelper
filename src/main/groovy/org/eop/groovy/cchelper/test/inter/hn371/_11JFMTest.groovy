package org.eop.groovy.cchelper.test.inter.hn371

import org.eop.groovy.cchelper.test.inter.AbstractInterTest

import com.cmos.esbclient.bean.RestMethodType
/***
{
"userMobile": "13676969793"
}
***/
/**
 * @author lixinjie
 */
class _11JFMTest extends AbstractInterTest {

	@Override
	RestMethodType getMethod() {
		RestMethodType.GET
	}

	@Override
	String getUri() {
		'business/gs/pointMValueQty'
	}

}
