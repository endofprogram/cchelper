package org.eop.groovy.cchelper.test.sql

/**
 * @author lixinjie
 */
class MergeSqlFileMain {

	static main(args) {
		mergeFile()
	}

	static String getSqlDir() {
		'E:\\yaxin\\需求\\咪咕公司接口\\数据库\\测试环境\\'
	}
	
	static String getMergedSqlFile() {
		'99咪咕公司接口.sql'
	}
	
	static void mergeFile() {
		def dir = new File(getSqlDir())
		def mergedFile = new File(getSqlDir() + getMergedSqlFile())
		mergedFile.write('''\
/*\r\n
Host           : 192.168.111.47:23312\r\n
Database       : interfacepf\r\n
User           : \r\n
\r\n
Author:  lixinjie\r\n
Tel:  13676969793\r\n
Date: 2017-06-01\r\n
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
