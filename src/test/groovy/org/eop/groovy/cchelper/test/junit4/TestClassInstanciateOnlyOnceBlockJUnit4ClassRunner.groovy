package org.eop.groovy.cchelper.test.junit4

import org.junit.runners.BlockJUnit4ClassRunner
import org.junit.runners.model.InitializationError

/**
 * @author lixinjie
 */
class TestClassInstanciateOnlyOnceBlockJUnit4ClassRunner extends BlockJUnit4ClassRunner {
	
	def testClassInstance
	
	TestClassInstanciateOnlyOnceBlockJUnit4ClassRunner(Class<?> klass) throws InitializationError {
		super(klass)
	}
	
	@Override
	protected Object createTest() throws Exception {
		if (!testClassInstance) {
			testClassInstance = super.createTest()
		}
		testClassInstance
	}
}
