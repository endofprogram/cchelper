package org.eop.groovy.cchelper.test.http

import org.eop.groovy.cchelper.test.AbstractCommonTest
import org.junit.Test

import com.cmos.crmpfesb.bean.RequestEntity
import com.cmos.crmpfesb.service.http.get.HttpGetServiceImpl
import com.cmos.crmpfesb.service.http.post.HttpPostServiceImpl

/**
 * @author lixinjie
 */
abstract class AbstractHttpTest extends AbstractCommonTest {

	abstract String getUrl()
	
	abstract String getMethod()
	
	abstract Map getHeaders()
	
	abstract Map getReqParams()
	
	abstract String getReqContent()
	
	abstract Map getProtocols()
	
	@Test
	void testExecute() {
		if ('GET' == getMethod()) {
			HttpGetServiceImpl httpGet = new HttpGetServiceImpl()
			println httpGet.doRequest(getRequestEntity())
		} else if ('POST' == getMethod()) {
			HttpPostServiceImpl httpPost = new HttpPostServiceImpl()
			println httpPost.doRequest(getRequestEntity())
		}
	}
	
	RequestEntity getRequestEntity() {
		RequestEntity requestEntity = new RequestEntity()
		requestEntity.url = getUrl()
		requestEntity.headerParams = getHeaders()
		requestEntity.reqParams = getReqParams()
		requestEntity.reqContent = getReqContent()
		requestEntity.protocolElementMap = getProtocols()
		requestEntity
	}
	
}
