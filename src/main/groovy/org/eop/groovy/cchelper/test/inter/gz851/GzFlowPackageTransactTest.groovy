package org.eop.groovy.cchelper.test.inter.gz851

import org.eop.groovy.cchelper.test.inter.AbstractInterTest

import com.cmos.esbclient.bean.RestMethodType
/***
 {
"iDItemRange": "13595173982",
"productType": "1",
"productId": "212080400020",
"spId": "",
"bizCode": "",
"flag": "",
"payPath": ""
}
***/
/**
 * @author lixinjie
 */
class GzFlowPackageTransactTest extends AbstractInterTest {

	@Override
	RestMethodType getMethod() {
		RestMethodType.PUT
	}

	@Override
	String getUri() {
		'business/gs/product'
	}

}
