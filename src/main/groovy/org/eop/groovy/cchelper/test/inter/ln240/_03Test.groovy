package org.eop.groovy.cchelper.test.inter.ln240

import org.eop.groovy.cchelper.test.inter.AbstractInterTest

import com.cmos.esbclient.bean.RestMethodType
/***
{
"userMobile":"15998306105",
"acceptStaff":"100004638522",
"oprTime":"20161025143734",
"backStatus":"123456",
"goodsAddress":"123",
"goodsLinkman":"aaaa",
"goodsPhone":"15998306105",
"goodsZipCode":"450000",
"goodsRemark":"dddd",
"regionId":"4000",
"busiCode":"09",
"backCardType":"002",
"extendList":[]
}
***/
/**
 * @author lixinjie
 */
class _03Test extends AbstractInterTest {

	@Override
	RestMethodType getMethod() {
		RestMethodType.POST
	}

	@Override
	String getUri() {
		'business/gs/subscription4GCard'
	}

	@Override
	boolean isSetObject() {
		true
	}
}
