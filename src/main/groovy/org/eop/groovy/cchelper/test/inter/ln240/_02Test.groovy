package org.eop.groovy.cchelper.test.inter.ln240

import org.eop.groovy.cchelper.test.inter.AbstractInterTest

import com.cmos.esbclient.bean.RestMethodType
/***
{
"userMobile":"15998306105",
"acceptStaff":"123456789",
"oprTime":"20161104144243",
"busiCode":"13",
"newProdId":"123456"
}
***/
/**
 * @author lixinjie
 */
class _02Test extends AbstractInterTest {

	@Override
	RestMethodType getMethod() {
		RestMethodType.GET
	}

	@Override
	String getUri() {
		'business/ln240/queriesBelongings'
	}

}
