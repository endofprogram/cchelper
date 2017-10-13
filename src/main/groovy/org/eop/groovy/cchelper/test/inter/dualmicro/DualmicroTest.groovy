package org.eop.groovy.cchelper.test.inter.dualmicro

import org.eop.groovy.cchelper.test.inter.AbstractInterTest

import com.cmos.esbclient.bean.RestMethodType
/***
{
		"target":  "A",
		"busiCode": "loginAuth",
		"reqSource":  "04",
		"reqParam":  {
			"tradeTime": "2015-11-19 17:14:07",
			"tradeId": "1a76c000-9449-4c0c-a75f-82a6daeadd85",
			"reqData": {
				"idItemRange":"13653824211",
				"password": "123456",
				"userType": "01"
			}
		}
}
***/
/**
 * @author lixinjie
 */
class DualmicroTest extends AbstractInterTest {

	@Override
	RestMethodType getMethod() {
		RestMethodType.POST
	}

	@Override
	String getUri() {
		'dualmicro/auth/identCode'
	}

}
