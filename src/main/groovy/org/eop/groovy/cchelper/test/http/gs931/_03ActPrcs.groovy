package org.eop.groovy.cchelper.test.http.gs931

import org.eop.groovy.cchelper.test.http.AbstractHttpTest

/**
 * @author lixinjie
 */
class _03ActPrcs extends AbstractHttpTest {

	@Override
	String getUrl() {
		'https://partner.cmccgs.cn/openapi/V1/partner/ability/production/soUserPromoCommon4cmcc'
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
        "dynamicToken":"c77e261f3c5bb4a4097ed9ee76cd93f3f157a05c",
        "userPhoneNumber":"13919318036",
        "transInfo":{
            "sessionId":"adafsafasfsdf",
            "originalId":"4xxxxxx",
            "originalTime":"20151215150756"
        },
        "serviceContent":{
            "promoId":"62000754",
            "condId":"100000",
            "actType":"1"
        }
    }
}'''
	}

	@Override
	Map getProtocols() {
		[socketTimeout:'3000', connectTimeout:'3000', requestCharset:'UTF-8', contentType:'application/json']
	}

}
