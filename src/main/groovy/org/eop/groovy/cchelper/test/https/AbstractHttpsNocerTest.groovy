package org.eop.groovy.cchelper.test.https

import org.eop.groovy.cchelper.test.AbstractCommonTest
import org.junit.Test

import com.cmos.crmpfesb.bean.RequestEntity
import com.cmos.crmpfesb.service.https.oneway.nocer.get.HttpsGetNocerService
import com.cmos.crmpfesb.service.https.oneway.nocer.post.HttpsPostNocerService

/**
 * @author lixinjie
 */
abstract class AbstractHttpsNocerTest extends AbstractCommonTest {

	abstract String getUrl()
	
	abstract String getMethod()
	
	abstract Map getHeaders()
	
	abstract Map getReqParams()
	
	abstract String getReqContent()
	
	abstract Map getProtocols()
	
	@Test
	void testExecute() {
		if ('GET' == getMethod()) {
			HttpsGetNocerService httpsGet = new HttpsGetNocerService()
			println httpsGet.doRequest(getRequestEntity())
		} else if ('POST' == getMethod()) {
			HttpsPostNocerService httpsPost = new HttpsPostNocerService()
			println httpsPost.doRequest(getRequestEntity())
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
