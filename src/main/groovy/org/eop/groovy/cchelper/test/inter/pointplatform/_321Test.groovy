package org.eop.groovy.cchelper.test.inter.pointplatform

import org.eop.groovy.cchelper.test.inter.AbstractInterTest

import com.cmos.esbclient.bean.RestMethodType
/***
{
"userMobile": "15002003400"
}
***/
/**
 * @author lixinjie
 */
class _321Test extends AbstractInterTest {

	@Override
	RestMethodType getMethod() {
		RestMethodType.GET
	}

	@Override
	String getUri() {
		'business/pointplatform/pointQry'
	}

}
