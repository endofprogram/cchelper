package org.eop.groovy.cchelper.test.utils

/**
 * @author lixinjie
 */
class TestUtils {

	static main(args) {
	
	}

	static String getProjectPath() {
		new File('').getAbsolutePath()
	}
	
	static String getTestPath() {
		'\\src\\main\\groovy\\'
	}
	
	static String getFileName(Class<?> cls) {
		cls.getName().replaceAll('\\.', '\\\\') + '.groovy'
	}
	
	static String getFilePath(Class<?> cls) {
		getProjectPath() + getTestPath() + getFileName(cls)
	}
	
	static String getParamStr(Class<?> cls) {
		try {
			def br = new BufferedReader(new InputStreamReader(new FileInputStream(getFilePath(cls)), 'UTF-8'))
			def sb = new StringBuilder()
			def line
			def begin = false
			while(true) {
				line = br.readLine()
				if (line == null) {
					break
				}
				if (!begin) {
					begin = line.trim().startsWith('/***')
					continue
				}
				if (line.trim().endsWith('***/')) {
					break
				}
				println line
				sb.append(line)
			}
			br.close()
			sb.toString()
		} catch(Exception e) {
			e.printStackTrace()
		}
	}
}
