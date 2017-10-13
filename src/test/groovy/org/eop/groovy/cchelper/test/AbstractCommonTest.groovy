package org.eop.groovy.cchelper.test

import org.eop.groovy.cchelper.test.junit4.TestClassInstanciateOnlyOnceBlockJUnit4ClassRunner
import org.eop.groovy.cchelper.test.utils.TestUtils
import org.junit.Before
import org.junit.FixMethodOrder
import org.junit.runner.RunWith
import org.junit.runners.MethodSorters

/**
 * @author lixinjie
 */
@RunWith(TestClassInstanciateOnlyOnceBlockJUnit4ClassRunner.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
abstract class AbstractCommonTest {
	
	String paramStr
	
	@Before
	void testBefore() {
		paramStr = TestUtils.getParamStr(this.getClass())
	}
}
