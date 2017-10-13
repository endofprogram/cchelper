package org.eop.groovy.cchelper.test.sql.ah551

import java.util.List
import java.util.Map

import org.eop.groovy.cchelper.test.sql.AbstractSqlTest
import org.junit.Test

/**
 * @author lixinjie
 */
class _00Test extends AbstractSqlTest {

	@Override
	Map getSqlFile() {
		[dir:'E:\\yaxin\\需求\\安徽众包接口\\数据库\\生产环境\\', name:'00系统渠道']
	}
	
	@Override
	Map getDb() {
		[name:'interfacepf']
	}
	
	@Override
	Map getBusiSystem() {
		[name:'安徽能力开发平台', desc:'安徽能力开发平台', prov:'551', code:'AH_NL_PLTFM']
	}

	@Override
	Map getChannel() {
		[name:'安徽能力开发平台', addr:'http://120.209.204.229:81']
	}
	
	@Override
	List getStaticConfig() {
		def list = []
		list << [type:'AH_NL_PLTFM', fst:'fstConfigItem201705', sec:'appKey', val:'10001338', rmk:'']
		list << [type:'AH_NL_PLTFM', fst:'fstConfigItem201705', sec:'userName', val:'zyzxahfgs', rmk:'']
		list << [type:'AH_NL_PLTFM', fst:'fstConfigItem201705', sec:'privateKey', val:'MIICdgIBADANBgkqhkiG9w0BAQEFAASCAmAwggJcAgEAAoGBANRuvfmoIApoDEo0MEP6huKlaBJV/RBxuyz3lInrOT3UEs1sT9VYF/E2NS+4MFeM7YzMeIlyZ0UW2KygUZ7SNp8mB0KGUTvDvuKUTai+Bb6l5FeRACW2usCvLDBjzWoq922nZwePDcL2FAULMiDywxbo063Nlo3CdPPK028Lc+z3AgMBAAECgYEAhE00I/iBe/mxLcWzCaNNvnolhsXnBgbO/AJ1kC/fRpJ941JBpi1nO+L23PFpqh0rFTWDHJcTmgPQjjKKos9pFDGcvWcFA8/h+FLKk5aXD4oUu1wV/Oj+VOVRqU6Y8VcHb2K9ytWG+lLzPLB9ifpwAvVkmVkSF3xbCfdPl/p5ZYECQQD+L57z8c/q5i/7x32vKO0KPBt/gX5ypTBbEvtJX37z1ve/CCFA7TF9+Iqt9d2U19FnaMv9tjL0oQw0Ypsy/U1lAkEA1fLXOtmVQxV1wIvy2mlf5rG76aVu+XObi41ssnMjNl6J6hgqhjaL4zL2eixXfN2KHOq9TFersrd3E9Jf+avpKwJAcu6TX9gp3Bui/KRyNv45WBRflqK1yx7YI4YMq1uLqrO7p9wENThK1ZvJEOmH/GItZCWlfx2gIq6jNxiS9lZEZQJAPLyk51sPqay08gWI2wJhLE+2pfzGBWERfkuW2Q4gp/Wst11G7TUc/1HfcQ2XhKYr6Eunk72ry5+T2Xe2sV1hYwJAO+ItiIIHrNFh286QOYlAlNnXbgdwShB4gLjNOepxEEzfrhvoHgqTbChbsDAbZjCBYYHwwWuTGXrf4Ahl+Hjr9Q==', rmk:'']
		list << [type:'AH_NL_PLTFM', fst:'fstConfigItem201705', sec:'status', val:'1', rmk:'']
		list
	}

	@Override
	Map getInInterface() {
		[route:'1', name:'直连_查询_流量查询', clsnm:'userMobileCommonIntfService', type:'1', path:'business/gs/flowQuery', bizcode:'', method:'GET', fmttype:'json', entid:'', desc:'直连_查询_流量查询(20170411_in)', biztype:'001']
	}
	
	@Override
	Map getOutInterface() {
		[route:'1', name:'河南_查询_流量查询', clsnm:'hnResultIsArrayQueryService', type:'1', path:'/oppf?postSysParam=true&busiKey=jsonParams', bizcode:'ESB_NEW_WAP_161108', method:'POST', fmttype:'json', entid:'10', desc:'河南_查询_流量查询(20170411_out)', biztype:'001']
	}
	
	@Override
	List getInInterfaceParams() {
		def list = []
		list
	}
	
	@Override
	List getOutInterfaceParams() {
		def list = []
		list
	}
	
	@Override
	List getInterfaceParamsMapping() {
		def list = []
		list
	}
	
	@Override
	List getOutInterfaceParamsStatic() {
		def list = []
		list << [name:'', value:'', seqno:'']
		list
	}
	
	@Override
	Map getEncryptRel() {
		[stgid:'3']
	}
	
	@Override
	Map getSecretKey() {
		[stgid:'3', key1:'a67aae2843b7e6dc83298b9532082522,504089', key2:'a67aae2843b7e6dc83298b9532082522']
	}
	
	@Override
	Map getCallbackMapping() {
		[addr:'/dualmicro/releaseNotice', clsnm:'dualmicroCallBackService']
	}
	
	@Override
	Map getCallback() {
		[code:'1', method:'POST', addr:'/business/flows/mobiles/gs/resultNotice']
	}
	
	@Test
	void testExecute() {
		def file = new File(sqlFile.dir + sqlFile.name + '.sql')
		file.write('')
		file << busiSystemSql
		file << channelSql
		staticConfigSql.each{
			file << it
		}
	}
}
