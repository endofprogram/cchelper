package org.eop.groovy.cchelper.test.sql

/**
 * @author lixinjie
 */
class MergeSqlFileMain {

	static main(args) {
		mergeFile()
	}

	static String getSqlDir() {
		'E:\\luying\\甘肃在线公司\\需求\\众包接口\\数据库\\测试环境\\'
	}
	
	static String getMergedSqlFile() {
		'99众包接口.sql'
	}
	
	static void mergeFile() {
		def dir = new File(getSqlDir())
		def mergedFile = new File(getSqlDir() + getMergedSqlFile())
		mergedFile.write('''\
/*\r\n
Host           : \r\n
Database       : \r\n
User           : \r\n
\r\n
Author:  lixinjie\r\n
Tel:  13676969793\r\n
Date: 2017-10-17\r\n
*/\r\n\r\n''')
		dir.eachFileMatch ~/^[0-8].+\.sql/, {file ->
			mergedFile << '/*----------------------------------' + file.getName() + '----------------------------------*/\r\n'
			file.eachLine{line ->
				mergedFile << line
				mergedFile << '\r\n'
			}
			mergedFile << '\r\n\r\n'
		}
	}
}
