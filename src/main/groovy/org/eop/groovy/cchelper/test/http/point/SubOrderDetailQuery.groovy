package org.eop.groovy.cchelper.test.http.point

import java.util.Map

import org.eop.groovy.cchelper.test.http.AbstractHttpTest

/**
 * @author lixinjie
 */
class SubOrderDetailQuery extends AbstractHttpTest {

	@Override
	public String getUrl() {
		'http://218.206.190.10:7701/Trans/Receiver'
		'http://218.206.190.26:6627/Trans/Receiver'
	}

	@Override
	public String getMethod() {
		'POST'
	}

	@Override
	public Map getHeaders() {
		[:]
	}

	@Override
	public Map getReqParams() {
		[:]
	}

	@Override
	public String getReqContent() {
		'''\
xmlhead=<InterBOSS></InterBOSS>&xmlbody=<InterBOSS></InterBOSS>
'''
	}

	@Override
	public Map getProtocols() {
		[socketTimeout:'3000', connectTimeout:'3000', requestCharset:'UTF-8', contentType:'multipart/form-data']
	}

}
