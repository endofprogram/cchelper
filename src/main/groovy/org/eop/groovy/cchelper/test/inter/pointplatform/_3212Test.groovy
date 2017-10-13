package org.eop.groovy.cchelper.test.inter.pointplatform

import org.eop.groovy.cchelper.test.inter.AbstractInterTest

import com.cmos.esbclient.bean.RestMethodType
/***
{
"userMobile": "15002003400",
"subOrderId": "20160602170831701010",
"startTime": "20160601000000",
"endTime": "20160701000000"
}
***/
/**
 * @author lixinjie
 */
class _3212Test extends AbstractInterTest {

	@Override
	RestMethodType getMethod() {
		RestMethodType.GET
	}

	@Override
	String getUri() {
		'business/pointplatform/pwdSedHisQry'
	}

}
