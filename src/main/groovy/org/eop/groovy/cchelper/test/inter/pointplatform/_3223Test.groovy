package org.eop.groovy.cchelper.test.inter.pointplatform

import org.eop.groovy.cchelper.test.inter.AbstractInterTest

import com.cmos.esbclient.bean.RestMethodType
/***
{
"userMobile": "13910456637",
"startRowNum": "-9",
"endRowNum": "-9"
}
***/
/**
 * @author lixinjie
 */
class _3223Test extends AbstractInterTest {

	@Override
	RestMethodType getMethod() {
		RestMethodType.GET
	}

	@Override
	String getUri() {
		'business/pointplatform/trsfPeplInfoQry'
	}

}
