package org.eop.groovy.cchelper.test.sql.gs931

import org.eop.groovy.cchelper.test.sql.AbstractSqlTest
import org.junit.Test;

public class _608CGSHQMainPlan extends AbstractSqlTest {

    @Override
    Map getSqlFile() {
        [dir:'E:\\Work\\java\\cchelper_gen\\', name:'608主套餐查询']
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
        def list = []
        list << [type:'GS_NL_PLTFM', fst:'zhongbao20170922', sec:'appId', val:'A2017083117061000024', rmk:'']
        list << [type:'GS_NL_PLTFM', fst:'zhongbao20170922', sec:'accessToken', val:'4920cb16c8bdf0442c3aca5b5a7123b37fb10b5a', rmk:'']
        list << [type:'GS_NL_PLTFM', fst:'nengkai20170922', sec:'tokenInInterfaceId', val:'828', rmk:'']
        list << [type:'GS_NL_PLTFM', fst:'nengkai20170922', sec:'tokenOutInterfaceId', val:'829', rmk:'']
        list
    }

    @Override
    public List getStaticConfigTokenInterfaceIds() {
        []
    }
    @Override
    Map getInInterface() {
        [route:'', name:'甘肃能开_接入_主套餐查询', clsnm:'userMobileCommonIntfService', type:'1', path:'business/gs/CGSHQMainPlan', bizcode:'', method:'GET', fmttype:'json', entid:'', desc:'甘肃能开_接入_主套餐查询(201710020_in)', biztype:'001']
    }

    @Override
    Map getOutInterface() {
        [route:'', name:'甘肃能开_转接_主套餐查询', clsnm:'gsMainPlanQueryService', type:'1', path:'', bizcode:'', method:'POST', fmttype:'json', entid:'10', desc:'甘肃能开_转接_主套餐查询(201710020_out)', biztype:'001']
    }

    @Override
    List getInInterfaceParams() {
        def list = []
        list << [type:'1', name:'userMobile', nflag:'0', seqno:'01']
        list << [type:'1', name:'phoneId', nflag:'0', seqno:'02']
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
        list << [desc:'甘肃能开_接入_品牌查询(201710020_in)']
        list << [desc:'甘肃能开_转接_品牌查询(201710020_out)']
        list << [desc:'甘肃能开_接入_营销计划查询(201710020_in)']
        list << [desc:'甘肃能开_转接_营销计划查询(201710020_out)']
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
        inInterfaceParamsSql.each{
            file << it
        }
        file << channelAuthSql
        dependentInterfacesSql.each{
            file << it
        }
    }
}