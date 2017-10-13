package org.eop.groovy.cchelper.test.inter.ln240

import org.eop.groovy.cchelper.test.inter.AbstractInterTest

import com.cmos.esbclient.bean.RestMethodType
/***
{
        "userMobile":"15998306105",
        "acceptStaff":"123456789",
        "oprTime":"20161104112356",
        "busiCode":"03",
        "prodId":"123456",
        "offerList":[
            {
                "offerId":"123",
                "operType":"1"
            },
	    {
                "offerId":"456",
                "operType":"1"
            },
	    {
                "offerId":"789",
                "operType":"1"
            }
        ]
}
***/
/**
 * @author lixinjie
 */
class _01Test extends AbstractInterTest {

	@Override
	RestMethodType getMethod() {
		RestMethodType.PUT
	}

	@Override
	String getUri() {
		'business/ln240/packageChanger'
	}

	@Override
	boolean isSetObject() {
		true
	}
}
