package org.eop.groovy.cchelper.test.sql.gs931.intnet15

import org.eop.groovy.cchelper.test.sql.AbstractSqlTest
import org.junit.Test

abstract class Intnet15ByNengkaiCommonUnionSqlTest extends AbstractSqlTest {

	abstract String getSqlFilePrefix()

	abstract String getDistinctName()

	abstract Map getInIntfMap()

	abstract Map getOutIntfMap()

	abstract List getInParams()

	abstract List getDeps()

	String getVersion() {
		'20180327'
	}

	@Override
	Map getSqlFile() {
		[dir: 'F:\\sql\\', name: """${sqlFilePrefix}${distinctName}"""]
    }

    @Override
    Map getDb() {
        [name:'interfacepf']
    }

    @Override
    Map getBusiSystem() {
        [name:'甘肃能力开发平台', desc:'甘肃能力开发平台', prov:'931', code:'GS_NL_PLTFM']
    }

    @Override
    Map getChannel() {
        [name:'甘肃能力开发平台', addr:'https://partner.cmccgs.cn']
    }

    @Override
    List getStaticConfig() {
        []
    }

    @Override
    Map getInInterface() {
        [route: '', name: """甘肃统一接口平台_互联网_接入_${distinctName}""", clsnm: 'userMobileCommonIntfService', type: '1', path: """${inIntfMap.path}""", bizcode: '', method: """${inIntfMap.method}""", fmttype: 'json', entid: '', desc: """甘肃统一接口平台_互联网_接入_${distinctName}(${version}_in)""", biztype: '001']
	}

	@Override
	Map getOutInterface() {
		[route: '', name: """甘肃能开_转接_${distinctName}""", clsnm: """${outIntfMap.cls}""", type: '1', path: '', bizcode: '', method: 'POST', fmttype: 'json', entid: '10', desc: """甘肃能开_转接_${distinctName}(${version}_out)""", biztype: '001']
    }

    @Override
    List getInInterfaceParams() {
        def list = []
        inParams.each {
            list << [type:'1', name:"""$it""", nflag:'0', seqno:'01']
		}
		list
	}

	@Override
	List getOutInterfaceParams() {
		[]
	}

	@Override
	List getInterfaceParamsMapping() {
		[]
	}

	@Override
	List getOutInterfaceParamsStatic() {
		[]
	}

	@Override
	List getDependentInterfaces() {
		def list = []
		deps.each {
			list << [desc: """甘肃统一接口平台_互联网_接入_${it}(${version}_in)"""]
            list << [desc: """甘肃能开_转接_${it}(${version}_out)"""]
		}
		list
	}

	@Override
	Map getEncryptRel() {
		[:]
	}

	@Override
	Map getSecretKey() {
		[:]
	}

	@Override
	Map getCallbackMapping() {
		[:]
	}

	@Override
	Map getCallback() {
		[:]
	}

	@Test
	void testExecute() {
		def file = new File(sqlFile.dir + sqlFile.name + '.sql')
		file.write('')
		file << inInterfaceSql
		file << outInterfaceSql
		file << interfaceMappingSql
		inInterfaceParamsSql.each {
			file << it
		}
		file << channelAuthSql
		dependentInterfacesSql.each {
			file << it
		}
	}
}
