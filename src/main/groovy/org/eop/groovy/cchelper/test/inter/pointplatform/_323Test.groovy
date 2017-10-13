package org.eop.groovy.cchelper.test.inter.pointplatform

import org.eop.groovy.cchelper.test.inter.AbstractInterTest

import com.cmos.esbclient.bean.RestMethodType
/***
{
"subOrderId": "20170711154204365068"
}
***/
/**
 * @author lixinjie
 */
class _323Test extends AbstractInterTest {

	@Override
	RestMethodType getMethod() {
		RestMethodType.GET
	}

	@Override
	String getUri() {
		'business/pointplatform/subOdrDtalQry'
	}

}
