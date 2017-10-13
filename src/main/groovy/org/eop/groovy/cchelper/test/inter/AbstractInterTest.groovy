package org.eop.groovy.cchelper.test.inter

import org.eop.groovy.cchelper.test.AbstractCommonTest
import org.junit.Test

import com.cmos.core.bean.InputObject
import com.cmos.core.bean.OutputObject
import com.cmos.core.util.JsonUtil
import com.cmos.crmpfcore.RestClientUtil
import com.cmos.esbclient.bean.EsbInObject
import com.cmos.esbclient.bean.EsbOutObject
import com.cmos.esbclient.bean.MessageInfo
import com.cmos.esbclient.bean.RestMethodType

/**
 * @author lixinjie
 */
abstract class AbstractInterTest extends AbstractCommonTest {

	abstract RestMethodType getMethod()
	
	abstract String getUri()
	
	@Test
	void testExecute() {
		String result = invoke(getMessageInfo(getInputObject()))
		println getRspJson(getOutputObject(getEsbOutObject(result)))
	}
	
	def getUrl() {
		'http://192.168.100.59:10001/crmpfcore/ws/' + getUri()
		'http://127.0.0.1:8080/crmpfcore/ws/' + getUri()
	}
	
	def getClientId() {
		'com.cmos.esb.out.crmpfcore'
	}
	
	String getRspJson(OutputObject outputObject) {
		JsonUtil.convertObject2Json(outputObject)
	}
	
	OutputObject getOutputObject(EsbOutObject esbOutObject) {
		OutputObject outputObject = new OutputObject()
		outputObject.setBean(esbOutObject.getBean())
		outputObject.setBeans(esbOutObject.getBeans())
		outputObject.setReturnCode(esbOutObject.getRtnCode())
		outputObject.setReturnMessage(esbOutObject.getRtnMsg())
		outputObject.setObject(esbOutObject.getObject())
		outputObject
	}
	
	EsbOutObject getEsbOutObject(String result) {
		JsonUtil.convertJson2Object(result, EsbOutObject.class)
	}
	
	String invoke(MessageInfo messageInfo) {
		RestClientUtil.invoke(messageInfo)
	}
	
	MessageInfo getMessageInfo(InputObject inputObject) {
		new MessageInfo(getUrl(), getClientId(), getReqJson(getEsbInObject(inputObject)), getMethod())
	}
	
	String getReqJson(EsbInObject esbInObject) {
		JsonUtil.convertObject2Json(esbInObject)
	}
	
	EsbInObject getEsbInObject(InputObject inputObject) {
		EsbInObject esbInObject = new EsbInObject()
		if (isSetObject()) {
			esbInObject.setObject(inputObject.getParams())
		} else {
			esbInObject.setParams(inputObject.getParams())
		}
		esbInObject.setBeans(inputObject.getBeans())
		esbInObject
	}
	
	boolean isSetObject() {
		false
	}
	
	InputObject getInputObject() {
		InputObject inputObject = new InputObject()
		inputObject.setParams(JsonUtil.convertJson2Object(paramStr, HashMap.class))
		inputObject
	}
}
