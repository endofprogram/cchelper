package org.eop.groovy.cchelper.test.http.gs931

import org.eop.groovy.cchelper.test.http.AbstractHttpTest

/**
 * @author lixinjie
 */
class _01DynTok extends AbstractHttpTest {

	@Override
	String getUrl() {
		'https://partner.cmccgs.cn/openapi/V1/partner/ability/dynamicToken'
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
"appId":"A2017083117061000024",
"accessToken":"4920cb16c8bdf0442c3aca5b5a7123b37fb10b5a"
}'''
	}

	@Override
	Map getProtocols() {
		[socketTimeout:'3000', connectTimeout:'3000', requestCharset:'UTF-8', contentType:'application/json']
	}

}
