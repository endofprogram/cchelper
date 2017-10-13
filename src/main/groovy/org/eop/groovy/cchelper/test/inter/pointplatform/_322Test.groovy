package org.eop.groovy.cchelper.test.inter.pointplatform

import org.eop.groovy.cchelper.test.inter.AbstractInterTest

import com.cmos.esbclient.bean.RestMethodType
/***
{
"userMobile": "15101545517",
"orderId": "20170711154204365068",
"subOrderId": "20170711153200651016",
"itemPayType": "01",
"itemPayStatus": "02",
"orderStatus": "001",
"orderStartTime": "20170427144325",
"orderEndTime": "20170427144525",
"startRowNum": "1",
"endRowNum": "5"
}
***/
/**
 * @author lixinjie
 */
class _322Test extends AbstractInterTest {

	@Override
	RestMethodType getMethod() {
		RestMethodType.GET
	}

	@Override
	String getUri() {
		'business/pointplatform/subOdrSmryQry'
	}

}
