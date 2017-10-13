package org.eop.groovy.cchelper.test.http.dualmicro

import java.util.Map

import org.eop.groovy.cchelper.test.http.AbstractHttpTest

/**
 * @author lixinjie
 */
class DualmicroHttpTest extends AbstractHttpTest {

	@Override
	String getUrl() {
		'http://127.0.0.1:28090/crmpfesb/callback/dualmicro/releaseNotice'
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
'''\
<?xml version="1.0" encoding="utf-8"?>
<env:Envelope xmlns:env="http://www.w3.org/2003/05/soap-envelope">
    <env:Header>
        <h:InterBOSS xmlns:h="http://cmcc.trans">
            <h:Version>0200</h:Version>
            <h:TestFlag>0</h:TestFlag>
            <h:RoutingInfo>
                <h:OrigDomain>CSPT</h:OrigDomain>
                <h:RouteType>00</h:RouteType>
                <h:Routing>
                    <h:HomeDomain>CSVC</h:HomeDomain>
                    <h:RouteValue>998</h:RouteValue>
                </h:Routing>
            </h:RoutingInfo>
            <h:TransInfo>
                <h:SessionID>20170210093525578336420</h:SessionID>
                <h:TransIDO>20170210093525578336420</h:TransIDO>
                <h:TransIDOTime>20170210093526</h:TransIDOTime>
            </h:TransInfo>
        </h:InterBOSS>
    </env:Header>
    <env:Body>
        <b:releaseNotice xmlns:b="http://cmcc.trans">
            <b:mSISDN>18837599797</b:mSISDN>
            <b:OprNumb>026720170210093526136085</b:OprNumb>
			<b:UserType>01</b:UserType>
            <b:MicroAccount>abc</b:MicroAccount>
        </b:releaseNotice>
    </env:Body>
</env:Envelope>\
'''
	}

	@Override
	Map getProtocols() {
		[socketTimeout:'3000', connectTimeout:'3000', requestCharset:'UTF-8', contentType:'application/xml']
	}

}
