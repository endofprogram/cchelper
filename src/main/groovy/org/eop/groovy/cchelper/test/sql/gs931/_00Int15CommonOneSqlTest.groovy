package org.eop.groovy.cchelper.test.sql.gs931

import org.eop.groovy.cchelper.test.sql.AbstractSqlTest
import org.junit.Test

abstract class _00Int15CommonOneSqlTest extends AbstractSqlTest {

    abstract String getSqlFilePrefix()

    abstract String getDistinctName()

    abstract Map getInIntfMap()

    abstract Map getOutIntfMap()

    abstract List getInParams()

    String getVersion() {
        '20170922'
    }
    
    @Override
    Map getSqlFile() {
        [dir: 'E:\\Work\\甘肃在线公司\\甘肃在线公司\\需求\\互联网15个接口\\数据库\\测试环境\\', name: """${sqlFilePrefix}${distinctName}"""]
    }

    @Override
    Map getDb() {
        []
    }

    @Override
    Map getBusiSystem() {
        []
    }

    @Override
    Map getChannel() {
        []
    }

    @Override
    List getStaticConfig() {
        []
    }

    @Override
    Map getInInterface() {
        [route: '', name: """甘肃能开_接入_${distinctName}""", clsnm: 'userMobileCommonIntfService', type: '1', path: """$inIntfMap.path""", bizcode: """i-${inIntfMap.depkey}-00""", method: """$inIntfMap.method""", fmttype: 'json', entid: '', desc: """甘肃能开_接入_${distinctName}(${version}_in)""", biztype: '001']
    }

    @Override
    Map getOutInterface() {
        [route: '', name: """甘肃能开_转接_${distinctName}""", clsnm: """$outIntfMap.cls""", type: '1', path: """$outIntfMap.path""", bizcode: """o-${outIntfMap.depkey}-00""", method: """$outIntfMap.method""", fmttype: 'json', entid: '10', desc: """甘肃能开_转接_${distinctName}(${version}_out)""", biztype: '001']
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
    }
}
