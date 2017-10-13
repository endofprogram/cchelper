package org.eop.groovy.cchelper.test.inter.migu.reading

import org.eop.groovy.cchelper.test.inter.AbstractInterTest

import com.cmos.esbclient.bean.RestMethodType
/***
{
"indictSeq":"1010101010",
"callerNo":"",
"calledNo":"",
"subsName":"",
"subsLevel":"",
"subsBrand":"",
"svcTypeId":"10",
"homeProv":"371",
"svcCity":"12",
"originTime":"2017-06-21 16:18:21",
"acceptTime":"2017-06-21 16:19:21",
"acceptStaff":"",
"contactChannel":"20",
"queryPageNum":"2",
"userMobile":"13676969795"
}
***/
/**
 * @author lixinjie
 */
class _101MthRecQry extends AbstractInterTest {

	@Override
	RestMethodType getMethod() {
		RestMethodType.GET
	}

	@Override
	String getUri() {
		'business/migu/reading/mthRecQry'
	}

}
