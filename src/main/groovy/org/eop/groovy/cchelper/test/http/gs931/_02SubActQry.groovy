package org.eop.groovy.cchelper.test.http.gs931

import org.eop.groovy.cchelper.test.http.AbstractHttpTest

/**
 * @author lixinjie
 */
class _02SubActQry extends AbstractHttpTest {

	@Override
	String getUrl() {
		'https://partner.cmccgs.cn/openapi/V1/partner/ability/sandbox/childPromoCond'
	}

	@Override
	String getMethod() {
		'POST'
	}

	@Override
	Map getHeaders() {
		[:]
	}

	@Override
	Map getReqParams() {
		[:]
	}

	@Override
	String getReqContent() {
		'''{
"interBOSS":{
    "version":"1.0",
    "testFlag":"1",
    "appId":"A2017083117061000024",
    "dynamicToken":"4c285ac9f0f306c4066848f69e34efb1579343ca",
    "userPhoneNumber":"13919318036",
    "transInfo":{
        "sessionId":"adafsafasfsdf0ok",
        "originalId":"4",
        "originalTime":"20151215150756"
    },
    "serviceContent":{
        "promoId":"620562"
    }
}
}'''
	}

	@Override
	Map getProtocols() {
		[socketTimeout:'3000', connectTimeout:'3000', requestCharset:'UTF-8', contentType:'application/json']
	}

}
