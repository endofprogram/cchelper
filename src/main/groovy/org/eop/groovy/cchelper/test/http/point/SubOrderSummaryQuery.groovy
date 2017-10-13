package org.eop.groovy.cchelper.test.http.point

import java.util.Map

import org.eop.groovy.cchelper.test.http.AbstractHttpTest

/**
 * @author lixinjie
 */
class SubOrderSummaryQuery extends AbstractHttpTest {

	@Override
	String getUrl() {
		'http://218.206.190.10:7701/Trans/Receiver'
		'http://218.206.190.26:6627/Trans/Receiver'
	}

	@Override
	String getMethod() {
		'POST'
	}

	@Override
	Map getHeaders() {
		['Content-Type':'multipart/form-data; boundary=---------------------------7e12bf3440dbc']
	}

	@Override
	Map getReqParams() {
		[:]
	}

	@Override
	String getReqContent() {
		'''\
-----------------------------7e12bf3440dbc
Content-Disposition: form-data; name="xmlhead"

<?xml version="1.0" encoding="UTF-8"?>
<InterBOSS>
	<Version>0100</Version>
	<TestFlag>0</TestFlag>
	<BIPType>
		<BIPCode>BIP2B422</BIPCode>
		<ActivityCode>T2040092</ActivityCode>
		<ActionCode>0</ActionCode>
    </BIPType>
    <RoutingInfo>
		<OrigDomain>SSBK</OrigDomain>
		<RouteType>00</RouteType>
		<Routing>
			<HomeDomain>UPSM</HomeDomain>
			<RouteValue>998</RouteValue>
		</Routing>
	</RoutingInfo>
    <TransInfo>
		<SessionID>2014042514225401010102</SessionID>
		<TransIDO>2014042514225420202021</TransIDO>
		<TransIDOTime>20140425142254</TransIDOTime>
	</TransInfo>
</InterBOSS>\r\n
-----------------------------7e12bf3440dbc
Content-Disposition: form-data; name="xmlbody"

<?xml version="1.0" encoding="UTF-8"?>
<InterBOSS>
	<SvcCont>
		<![CDATA[
			<OrderReq>
				<Mobile>13676969793</Mobile>
				<OrderID>2020202020</OrderID>
				<SubOrderID>10101010</SubOrderID>
				<ItemPayType>03</ItemPayType>
				<ItemPayStatus>99</ItemPayStatus>
				<OrdStatus>003</OrdStatus>
				<OrderStartTime>20140421100954</OrderStartTime>
				<OrderEndTime>20140421101854</OrderEndTime>
				<SRowNum>1</SRowNum>
				<ERowNum>9</ERowNum>
			</OrderReq>
		]]>
	</SvcCont>
</InterBOSS>\r\n
-----------------------------7e12bf3440dbc--
'''
	}

	@Override
	Map getProtocols() {
		[socketTimeout:'3000', connectTimeout:'3000', requestCharset:'UTF-8', contentType:'multipart/form-data']
	}

}
