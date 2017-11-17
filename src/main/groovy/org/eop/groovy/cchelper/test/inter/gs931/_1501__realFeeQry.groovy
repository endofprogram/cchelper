package org.eop.groovy.cchelper.test.inter.gs931

import com.cmos.esbclient.bean.RestMethodType
import org.eop.groovy.cchelper.test.inter.AbstractInterTest

/***
 {
 "userMobile": "13888888888"
 }
***/
/**
 * @author xuwq
 */
class _1501__realFeeQry extends AbstractInterTest {

	@Override
	RestMethodType getMethod() {
		RestMethodType.GET
	}

	@Override
	String getUri() {
		'business/gs/rtimeFeeQry'
	}

}
