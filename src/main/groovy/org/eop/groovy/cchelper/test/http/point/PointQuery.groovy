package org.eop.groovy.cchelper.test.http.point

import java.util.Map

import org.eop.groovy.cchelper.test.http.AbstractHttpTest

/**
 * @author lixinjie
 */
class PointQuery extends AbstractHttpTest {

	@Override
	String getUrl() {
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
		<BIPCode>BIP2B421</BIPCode>
		<ActivityCode>T2040091</ActivityCode>
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
		<SessionID>2014042514225401010101</SessionID>
		<TransIDO>2014042514225420202033</TransIDO>
		<TransIDOTime>20140425142254</TransIDOTime>
	</TransInfo>
</InterBOSS>\r\n
-----------------------------7e12bf3440dbc
Content-Disposition: form-data; name="xmlbody"

<?xml version="1.0" encoding="UTF-8"?>
<InterBOSS>
	<SvcCont>
		<![CDATA[
			<AuthReq>
				<Mobile>13676969793</Mobile>
			</AuthReq>
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
