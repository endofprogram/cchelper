package org.eop.java.cchelper.test

import org.eop.groovy.cchelper.test.AbstractCommonGroovyTest
import org.eop.java.cchelper.Builder
import org.eop.java.cchelper.Clawer
import org.eop.java.cchelper.Parser
import org.junit.Assert
import org.junit.Test

/**
 * @author lixinjie
 * @since 2017-09-24
 */
class ParserTest extends AbstractCommonGroovyTest {

	@Test
	void test01() {
		def json = '''{
    "rspCode":"A0000",
    "rspDesc":"成功",
    "dynamicToken":"60121fd513a6024028d74c26f6f1c8253cc80cd5",
    "expiretime":"20151224184847"
}'''
		Clawer clawer = Clawer.fromFastJson(com.alibaba.fastjson.JSON.parseObject(json))
		def template = '''#kv(code,rspCode<>)
	#kv(desc,rspDesc<>)
'''
		Builder b = Parser.from(template, clawer).build();
		Assert.assertEquals('{"code":"A0000","desc":"成功"}', b.toJson())
	}
	
	@Test
	void test02() {
		def json = '''{
    "interBOSS":{
        "version":"1.0",
        "testFlag":"1",
        "appId":"A2016033115142400018",
        "dynamicToken":"c77e261f3c5bb4a4097ed9ee76cd93f3f157a05c",
        "userPhoneNumber":"13919318036",
        "transInfo":{
            "sessionId":"adafsafasfsdf",
            "originalId":"4",
            "originalTime":"20151215150756"
        },
        "authorization":{
            "userAuthorizationCode":"1"
        },
        "otherInfo":[
            {
                "attributeName":"fee",
                "value":"44"
            }
        ],
        "serviceContent":{
            "phoneId":"18896728888",
            "promoId":"12345",
            "condId":"12345",
            "actType":"1"
        }
    }
}'''
		Clawer clawer = Clawer.fromFastJson(com.alibaba.fastjson.JSON.parseObject(json))
		def template = '''#kv(appId,interBOSS{}.appId<>)
		#kv(dynamicToken,interBOSS{}.dynamicToken<>)
'''
		Builder b = Parser.from(template, clawer).build()
		Assert.assertEquals('{"appId":"A2016033115142400018","dynamicToken":"c77e261f3c5bb4a4097ed9ee76cd93f3f157a05c"}', b.toJson())
	}
	
	@Test
	void test03() {
		def json = '''{
    "interBOSS":{
        "version":"1.0",
        "testFlag":"1",
        "appId":"A2016033115142400018",
        "dynamicToken":"c77e261f3c5bb4a4097ed9ee76cd93f3f157a05c",
        "userPhoneNumber":"13919318036",
        "transInfo":{
            "sessionId":"adafsafasfsdf",
            "originalId":"4",
            "originalTime":"20151215150756"
        },
        "authorization":{
            "userAuthorizationCode":"1"
        },
        "otherInfo":[
            {
                "attributeName":"fee",
                "value":"44"
            }
        ],
        "serviceContent":{
            "phoneId":"18896728888",
            "promoId":"12345",
            "condId":"12345",
            "actType":"1"
        }
    }
}'''
		Clawer clawer = Clawer.fromFastJson(com.alibaba.fastjson.JSON.parseObject(json))
		def template = '''#kv(phoneId,interBOSS{}.serviceContent{}.phoneId<>)
		#kv(actType,interBOSS{}.serviceContent{}.actType<>)
'''
		Builder b = Parser.from(template, clawer).build()
		Assert.assertEquals('{"phoneId":"18896728888","actType":"1"}', b.toJson())
	}
	
	@Test
	void test04() {
		def json = '''{
    "interBOSS":{
        "version":"1.0",
        "testFlag":"1",
        "appId":"A2016033115142400018",
        "dynamicToken":"c77e261f3c5bb4a4097ed9ee76cd93f3f157a05c",
        "userPhoneNumber":"13919318036",
        "transInfo":{
            "sessionId":"adafsafasfsdf",
            "originalId":"4",
            "originalTime":"20151215150756"
        },
        "authorization":{
            "userAuthorizationCode":"1"
        },
        "otherInfo":[
            {
                "attributeName":"fee",
                "value":"44"
            }
        ],
        "serviceContent":{
            "phoneId":"18896728888",
            "promoId":"12345",
            "condId":"12345",
            "actType":"1"
        }
    }
}'''
		Clawer clawer = Clawer.fromFastJson(com.alibaba.fastjson.JSON.parseObject(json))
		def template = '''#ko(interBOSS,interBOSS{})
		#kv(appId,appId<>)
		#kv(userPhoneNumber,userPhoneNumber<>)
		#ok
'''
		Builder b = Parser.from(template, clawer).build()
		Assert.assertEquals('{"interBOSS":{"appId":"A2016033115142400018","userPhoneNumber":"13919318036"}}', b.toJson())
	}
	
	@Test
	void test05() {
		def json = '''{
    "interBOSS":{
        "version":"1.0",
        "testFlag":"1",
        "appId":"A2016033115142400018",
        "dynamicToken":"c77e261f3c5bb4a4097ed9ee76cd93f3f157a05c",
        "userPhoneNumber":"13919318036",
        "transInfo":{
            "sessionId":"adafsafasfsdf",
            "originalId":"4",
            "originalTime":"20151215150756"
        },
        "authorization":{
            "userAuthorizationCode":"1"
        },
        "otherInfo":[
            {
                "attributeName":"fee",
                "value":"44"
            }
        ],
        "serviceContent":{
            "phoneId":"18896728888",
            "promoId":"12345",
            "condId":"12345",
            "actType":"1"
        }
    }
}'''
		Clawer clawer = Clawer.fromFastJson(com.alibaba.fastjson.JSON.parseObject(json))
		def template = '''#ko(interBOSS,interBOSS{})
							#kv(appId,appId<>)
							#kv(userPhoneNumber,userPhoneNumber<>)
							#ko(serviceContent,serviceContent{})
								#kv(promoId,promoId<>)
								#kv(actType,actType<>)
							#ok
						#ok
'''
		Builder b = Parser.from(template, clawer).build()
		Assert.assertEquals('{"interBOSS":{"appId":"A2016033115142400018","userPhoneNumber":"13919318036","serviceContent":{"promoId":"12345","actType":"1"}}}', b.toJson())
	}
	
	@Test
	void test06() {
		def json = '''{
    "interBOSS":{
        "version":"1.0",
        "testFlag":"1",
        "appId":"A2016033115142400018",
        "dynamicToken":"c77e261f3c5bb4a4097ed9ee76cd93f3f157a05c",
        "userPhoneNumber":"13919318036",
        "transInfo":{
            "sessionId":"adafsafasfsdf",
            "originalId":"4",
            "originalTime":"20151215150756"
        },
        "authorization":{
            "userAuthorizationCode":"1"
        },
        "otherInfo":[
            {
                "attributeName":"fee",
                "value":"44"
            }
        ],
        "serviceContent":{
            "phoneId":"18896728888",
            "promoId":"12345",
            "condId":"12345",
            "actType":"1"
        }
    }
}'''
		Clawer clawer = Clawer.fromFastJson(com.alibaba.fastjson.JSON.parseObject(json))
		def template = '''#ko(interBOSS,interBOSS{})
							#kv(appId,appId<>)
							#kv(userPhoneNumber,userPhoneNumber<>)
							#ka(otherInfo,otherInfo[])
								#io
									#kv(attributeName,attributeName<>)
									#kv(value,value<>)
								#oi
							#ak
						#ok
'''
		Builder b = Parser.from(template, clawer).build()
		Assert.assertEquals('{"interBOSS":{"appId":"A2016033115142400018","userPhoneNumber":"13919318036","otherInfo":[{"attributeName":"fee","value":"44"}]}}', b.toJson())
	}
	
	@Test
	void test07() {
		def json = '''{
  "interBOSS": {
    "rspCode": "A0000",
    "rspDesc": "成功",
    "originalId": "36UUID0022",
    "eshubReserve": {
      "eshubTransactionId": "CALL20160407153952918263",
      "cutOffDay": "20160407",
      "processTime": "20160407154003"
    },
    "serviceContent": {
      "bookSchemeCondAllot": [
        {
          "bookSchemeCondBase": {
            "relateName": "5890",
            "promoId": "620562",
            "condName": "A类连号[一级号码]",
            "schemeType": "1",
            "resPackName": "",
            "expireDate": "2030-01-01T00:00:00.000Z",
            "validDate": "2012-02-01T00:00:00.000Z",
            "schemeFee": "1",
            "resHoldMonth": "36",
            "condId": "100001",
            "condHoldMonth": "",
            "preFee": "6000000"
          },
          "bookSchemeAllot": [
            {
              "explicitMonth": "0",
              "allotBookEnd": "0",
              "allotBookBegin": "0",
              "allotAmount": "6000000",
              "bookItemId": "80302",
              "allotBeginMonth": "0",
              "bookType": "1",
              "allotBookLimit": "0",
              "allotMonth": "1"
            }
          ]
        },
        {
          "bookSchemeCondBase": {
            "relateName": "5891",
            "promoId": "620562",
            "condName": "A类连号[二级号码]",
            "schemeType": "1",
            "resPackName": "",
            "expireDate": "2030-01-01T00:00:00.000Z",
            "validDate": "2012-02-01T00:00:00.000Z",
            "schemeFee": "1",
            "resHoldMonth": "36",
            "condId": "100002",
            "condHoldMonth": "",
            "preFee": "4000000"
          },
          "bookSchemeAllot": [
            {
              "explicitMonth": "0",
              "allotBookEnd": "0",
              "allotBookBegin": "0",
              "allotAmount": "4000000",
              "bookItemId": "80302",
              "allotBeginMonth": "0",
              "bookType": "1",
              "allotBookLimit": "0",
              "allotMonth": "1"
            }
          ]
        },
        {
          "bookSchemeCondBase": {
            "relateName": "5892",
            "promoId": "620562",
            "condName": "A类连号[三级号码]",
            "schemeType": "1",
            "resPackName": "",
            "expireDate": "2030-01-01T00:00:00.000Z",
            "validDate": "2012-02-01T00:00:00.000Z",
            "schemeFee": "1",
            "resHoldMonth": "36",
            "condId": "100003",
            "condHoldMonth": "",
            "preFee": "3000000"
          },
          "bookSchemeAllot": [
            {
              "explicitMonth": "0",
              "allotBookEnd": "0",
              "allotBookBegin": "0",
              "allotAmount": "3000000",
              "bookItemId": "80302",
              "allotBeginMonth": "0",
              "bookType": "1",
              "allotBookLimit": "0",
              "allotMonth": "1"
            }
          ]
        },
        {
          "bookSchemeCondBase": {
            "relateName": "5893",
            "promoId": "620562",
            "condName": "A类连号[四级号码]",
            "schemeType": "1",
            "resPackName": "",
            "expireDate": "2030-01-01T00:00:00.000Z",
            "validDate": "2012-02-01T00:00:00.000Z",
            "schemeFee": "1",
            "resHoldMonth": "24",
            "condId": "100004",
            "condHoldMonth": "",
            "preFee": "2000000"
          },
          "bookSchemeAllot": [
            {
              "explicitMonth": "0",
              "allotBookEnd": "0",
              "allotBookBegin": "0",
              "allotAmount": "2000000",
              "bookItemId": "80302",
              "allotBeginMonth": "0",
              "bookType": "1",
              "allotBookLimit": "0",
              "allotMonth": "1"
            }
          ]
        },
        {
          "bookSchemeCondBase": {
            "relateName": "5894",
            "promoId": "620562",
            "condName": "A类连号[五级号码]",
            "schemeType": "1",
            "resPackName": "",
            "expireDate": "2030-01-01T00:00:00.000Z",
            "validDate": "2012-02-01T00:00:00.000Z",
            "schemeFee": "1",
            "resHoldMonth": "24",
            "condId": "100005",
            "condHoldMonth": "",
            "preFee": "2000000"
          },
          "bookSchemeAllot": [
            {
              "explicitMonth": "0",
              "allotBookEnd": "0",
              "allotBookBegin": "0",
              "allotAmount": "2000000",
              "bookItemId": "80302",
              "allotBeginMonth": "0",
              "bookType": "1",
              "allotBookLimit": "0",
              "allotMonth": "1"
            }
          ]
        },
        {
          "bookSchemeCondBase": {
            "relateName": "5895",
            "promoId": "620562",
            "condName": "A类连号[六级号码]",
            "schemeType": "1",
            "resPackName": "",
            "expireDate": "2030-01-01T00:00:00.000Z",
            "validDate": "2012-02-01T00:00:00.000Z",
            "schemeFee": "1",
            "resHoldMonth": "24",
            "condId": "100006",
            "condHoldMonth": "",
            "preFee": "1500000"
          },
          "bookSchemeAllot": [
            {
              "explicitMonth": "0",
              "allotBookEnd": "0",
              "allotBookBegin": "0",
              "allotAmount": "1500000",
              "bookItemId": "80302",
              "allotBeginMonth": "0",
              "bookType": "1",
              "allotBookLimit": "0",
              "allotMonth": "1"
            }
          ]
        },
        {
          "bookSchemeCondBase": {
            "relateName": "5896",
            "promoId": "620562",
            "condName": "A类连号[七级号码]",
            "schemeType": "1",
            "resPackName": "",
            "expireDate": "2030-01-01T00:00:00.000Z",
            "validDate": "2012-02-01T00:00:00.000Z",
            "schemeFee": "1",
            "resHoldMonth": "24",
            "condId": "100007",
            "condHoldMonth": "",
            "preFee": "1000000"
          },
          "bookSchemeAllot": [
            {
              "explicitMonth": "0",
              "allotBookEnd": "0",
              "allotBookBegin": "0",
              "allotAmount": "1000000",
              "bookItemId": "80302",
              "allotBeginMonth": "0",
              "bookType": "1",
              "allotBookLimit": "0",
              "allotMonth": "1"
            }
          ]
        },
        {
          "bookSchemeCondBase": {
            "relateName": "5897",
            "promoId": "620562",
            "condName": "A类连号[八级号码]",
            "schemeType": "1",
            "resPackName": "",
            "expireDate": "2030-01-01T00:00:00.000Z",
            "validDate": "2012-02-01T00:00:00.000Z",
            "schemeFee": "1",
            "resHoldMonth": "12",
            "condId": "100008",
            "condHoldMonth": "",
            "preFee": "800000"
          },
          "bookSchemeAllot": [
            {
              "explicitMonth": "0",
              "allotBookEnd": "0",
              "allotBookBegin": "0",
              "allotAmount": "800000",
              "bookItemId": "80302",
              "allotBeginMonth": "0",
              "bookType": "1",
              "allotBookLimit": "0",
              "allotMonth": "1"
            }
          ]
        },
        {
          "bookSchemeCondBase": {
            "relateName": "5898",
            "promoId": "620562",
            "condName": "A类连号[九级号码]",
            "schemeType": "1",
            "resPackName": "",
            "expireDate": "2030-01-01T00:00:00.000Z",
            "validDate": "2012-02-01T00:00:00.000Z",
            "schemeFee": "1",
            "resHoldMonth": "12",
            "condId": "100009",
            "condHoldMonth": "",
            "preFee": "500000"
          },
          "bookSchemeAllot": [
            {
              "explicitMonth": "0",
              "allotBookEnd": "0",
              "allotBookBegin": "0",
              "allotAmount": "500000",
              "bookItemId": "80302",
              "allotBeginMonth": "0",
              "bookType": "1",
              "allotBookLimit": "0",
              "allotMonth": "1"
            }
          ]
        },
        {
          "bookSchemeCondBase": {
            "relateName": "4860",
            "promoId": "620562",
            "condName": "A类连号[十级号码",
            "schemeType": "1",
            "resPackName": "",
            "expireDate": "2030-01-01T00:00:00.000Z",
            "validDate": "2012-02-01T00:00:00.000Z",
            "schemeFee": "1",
            "resHoldMonth": "12",
            "condId": "100010",
            "condHoldMonth": "",
            "preFee": "200000"
          },
          "bookSchemeAllot": [
            {
              "explicitMonth": "0",
              "allotBookEnd": "0",
              "allotBookBegin": "0",
              "allotAmount": "200000",
              "bookItemId": "80302",
              "allotBeginMonth": "0",
              "bookType": "1",
              "allotBookLimit": "0",
              "allotMonth": "1"
            }
          ]
        },
        {
          "bookSchemeCondBase": {
            "relateName": "5900",
            "promoId": "620562",
            "condName": "A类连号[十一级号码]",
            "schemeType": "1",
            "resPackName": "",
            "expireDate": "2030-01-01T00:00:00.000Z",
            "validDate": "2012-02-01T00:00:00.000Z",
            "schemeFee": "1",
            "resHoldMonth": "6",
            "condId": "100011",
            "condHoldMonth": "",
            "preFee": "50000"
          },
          "bookSchemeAllot": [
            {
              "explicitMonth": "0",
              "allotBookEnd": "0",
              "allotBookBegin": "0",
              "allotAmount": "50000",
              "bookItemId": "80302",
              "allotBeginMonth": "0",
              "bookType": "1",
              "allotBookLimit": "0",
              "allotMonth": "1"
            }
          ]
        },
        {
          "bookSchemeCondBase": {
            "relateName": "5901",
            "promoId": "620562",
            "condName": "B类重号[一级号码]",
            "schemeType": "1",
            "resPackName": "",
            "expireDate": "2030-01-01T00:00:00.000Z",
            "validDate": "2012-02-01T00:00:00.000Z",
            "schemeFee": "1",
            "resHoldMonth": "36",
            "condId": "100012",
            "condHoldMonth": "",
            "preFee": "2000000"
          },
          "bookSchemeAllot": [
            {
              "explicitMonth": "0",
              "allotBookEnd": "0",
              "allotBookBegin": "0",
              "allotAmount": "2000000",
              "bookItemId": "80302",
              "allotBeginMonth": "0",
              "bookType": "1",
              "allotBookLimit": "0",
              "allotMonth": "1"
            }
          ]
        },
        {
          "bookSchemeCondBase": {
            "relateName": "5902",
            "promoId": "620562",
            "condName": "B类重号[二级号码]",
            "schemeType": "1",
            "resPackName": "",
            "expireDate": "2030-01-01T00:00:00.000Z",
            "validDate": "2012-02-01T00:00:00.000Z",
            "schemeFee": "1",
            "resHoldMonth": "24",
            "condId": "100013",
            "condHoldMonth": "",
            "preFee": "800000"
          },
          "bookSchemeAllot": [
            {
              "explicitMonth": "0",
              "allotBookEnd": "0",
              "allotBookBegin": "0",
              "allotAmount": "800000",
              "bookItemId": "80302",
              "allotBeginMonth": "0",
              "bookType": "1",
              "allotBookLimit": "0",
              "allotMonth": "1"
            }
          ]
        },
        {
          "bookSchemeCondBase": {
            "relateName": "5903",
            "promoId": "620562",
            "condName": "B类重号[三级号码]",
            "schemeType": "1",
            "resPackName": "",
            "expireDate": "2030-01-01T00:00:00.000Z",
            "validDate": "2012-02-01T00:00:00.000Z",
            "schemeFee": "1",
            "resHoldMonth": "12",
            "condId": "100014",
            "condHoldMonth": "",
            "preFee": "500000"
          },
          "bookSchemeAllot": [
            {
              "explicitMonth": "0",
              "allotBookEnd": "0",
              "allotBookBegin": "0",
              "allotAmount": "500000",
              "bookItemId": "80302",
              "allotBeginMonth": "0",
              "bookType": "1",
              "allotBookLimit": "0",
              "allotMonth": "1"
            }
          ]
        },
        {
          "bookSchemeCondBase": {
            "relateName": "5904",
            "promoId": "620562",
            "condName": "B类重号[四级号码]",
            "schemeType": "1",
            "resPackName": "",
            "expireDate": "2030-01-01T00:00:00.000Z",
            "validDate": "2012-02-01T00:00:00.000Z",
            "schemeFee": "1",
            "resHoldMonth": "12",
            "condId": "100015",
            "condHoldMonth": "",
            "preFee": "300000"
          },
          "bookSchemeAllot": [
            {
              "explicitMonth": "0",
              "allotBookEnd": "0",
              "allotBookBegin": "0",
              "allotAmount": "300000",
              "bookItemId": "80302",
              "allotBeginMonth": "0",
              "bookType": "1",
              "allotBookLimit": "0",
              "allotMonth": "1"
            }
          ]
        },
        {
          "bookSchemeCondBase": {
            "relateName": "4861",
            "promoId": "620562",
            "condName": "B类重号[五级号码]",
            "schemeType": "1",
            "resPackName": "",
            "expireDate": "2030-01-01T00:00:00.000Z",
            "validDate": "2012-02-01T00:00:00.000Z",
            "schemeFee": "1",
            "resHoldMonth": "12",
            "condId": "100016",
            "condHoldMonth": "",
            "preFee": "200000"
          },
          "bookSchemeAllot": [
            {
              "explicitMonth": "0",
              "allotBookEnd": "0",
              "allotBookBegin": "0",
              "allotAmount": "200000",
              "bookItemId": "80302",
              "allotBeginMonth": "0",
              "bookType": "1",
              "allotBookLimit": "0",
              "allotMonth": "1"
            }
          ]
        },
        {
          "bookSchemeCondBase": {
            "relateName": "5906",
            "promoId": "620562",
            "condName": "B类重号[六级号码]",
            "schemeType": "1",
            "resPackName": "",
            "expireDate": "2030-01-01T00:00:00.000Z",
            "validDate": "2012-02-01T00:00:00.000Z",
            "schemeFee": "1",
            "resHoldMonth": "12",
            "condId": "100017",
            "condHoldMonth": "",
            "preFee": "100000"
          },
          "bookSchemeAllot": [
            {
              "explicitMonth": "0",
              "allotBookEnd": "0",
              "allotBookBegin": "0",
              "allotAmount": "100000",
              "bookItemId": "80302",
              "allotBeginMonth": "0",
              "bookType": "1",
              "allotBookLimit": "0",
              "allotMonth": "1"
            }
          ]
        },
        {
          "bookSchemeCondBase": {
            "relateName": "5907",
            "promoId": "620562",
            "condName": "C类顺号[一级号码]",
            "schemeType": "1",
            "resPackName": "",
            "expireDate": "2030-01-01T00:00:00.000Z",
            "validDate": "2012-02-01T00:00:00.000Z",
            "schemeFee": "1",
            "resHoldMonth": "36",
            "condId": "100018",
            "condHoldMonth": "",
            "preFee": "6000000"
          },
          "bookSchemeAllot": [
            {
              "explicitMonth": "0",
              "allotBookEnd": "0",
              "allotBookBegin": "0",
              "allotAmount": "6000000",
              "bookItemId": "80302",
              "allotBeginMonth": "0",
              "bookType": "1",
              "allotBookLimit": "0",
              "allotMonth": "1"
            }
          ]
        },
        {
          "bookSchemeCondBase": {
            "relateName": "5908",
            "promoId": "620562",
            "condName": "C类顺号[二级号码]",
            "schemeType": "1",
            "resPackName": "",
            "expireDate": "2030-01-01T00:00:00.000Z",
            "validDate": "2012-02-01T00:00:00.000Z",
            "schemeFee": "1",
            "resHoldMonth": "36",
            "condId": "100019",
            "condHoldMonth": "",
            "preFee": "4000000"
          },
          "bookSchemeAllot": [
            {
              "explicitMonth": "0",
              "allotBookEnd": "0",
              "allotBookBegin": "0",
              "allotAmount": "4000000",
              "bookItemId": "80302",
              "allotBeginMonth": "0",
              "bookType": "1",
              "allotBookLimit": "0",
              "allotMonth": "1"
            }
          ]
        },
        {
          "bookSchemeCondBase": {
            "relateName": "5909",
            "promoId": "620562",
            "condName": "C类顺号[三级号码]",
            "schemeType": "1",
            "resPackName": "",
            "expireDate": "2030-01-01T00:00:00.000Z",
            "validDate": "2012-02-01T00:00:00.000Z",
            "schemeFee": "1",
            "resHoldMonth": "36",
            "condId": "100020",
            "condHoldMonth": "",
            "preFee": "3000000"
          },
          "bookSchemeAllot": [
            {
              "explicitMonth": "0",
              "allotBookEnd": "0",
              "allotBookBegin": "0",
              "allotAmount": "3000000",
              "bookItemId": "80302",
              "allotBeginMonth": "0",
              "bookType": "1",
              "allotBookLimit": "0",
              "allotMonth": "1"
            }
          ]
        },
        {
          "bookSchemeCondBase": {
            "relateName": "5910",
            "promoId": "620562",
            "condName": "C类顺号[四级号码]",
            "schemeType": "1",
            "resPackName": "",
            "expireDate": "2030-01-01T00:00:00.000Z",
            "validDate": "2012-02-01T00:00:00.000Z",
            "schemeFee": "1",
            "resHoldMonth": "36",
            "condId": "100021",
            "condHoldMonth": "",
            "preFee": "2000000"
          },
          "bookSchemeAllot": [
            {
              "explicitMonth": "0",
              "allotBookEnd": "0",
              "allotBookBegin": "0",
              "allotAmount": "2000000",
              "bookItemId": "80302",
              "allotBeginMonth": "0",
              "bookType": "1",
              "allotBookLimit": "0",
              "allotMonth": "1"
            }
          ]
        },
        {
          "bookSchemeCondBase": {
            "relateName": "5911",
            "promoId": "620562",
            "condName": "C类顺号[五级号码]",
            "schemeType": "1",
            "resPackName": "",
            "expireDate": "2030-01-01T00:00:00.000Z",
            "validDate": "2012-02-01T00:00:00.000Z",
            "schemeFee": "1",
            "resHoldMonth": "24",
            "condId": "100022",
            "condHoldMonth": "",
            "preFee": "1500000"
          },
          "bookSchemeAllot": [
            {
              "explicitMonth": "0",
              "allotBookEnd": "0",
              "allotBookBegin": "0",
              "allotAmount": "1500000",
              "bookItemId": "80302",
              "allotBeginMonth": "0",
              "bookType": "1",
              "allotBookLimit": "0",
              "allotMonth": "1"
            }
          ]
        },
        {
          "bookSchemeCondBase": {
            "relateName": "5912",
            "promoId": "620562",
            "condName": "C类顺号[六级号码]",
            "schemeType": "1",
            "resPackName": "",
            "expireDate": "2030-01-01T00:00:00.000Z",
            "validDate": "2012-02-01T00:00:00.000Z",
            "schemeFee": "1",
            "resHoldMonth": "24",
            "condId": "100023",
            "condHoldMonth": "",
            "preFee": "1000000"
          },
          "bookSchemeAllot": [
            {
              "explicitMonth": "0",
              "allotBookEnd": "0",
              "allotBookBegin": "0",
              "allotAmount": "1000000",
              "bookItemId": "80302",
              "allotBeginMonth": "0",
              "bookType": "1",
              "allotBookLimit": "0",
              "allotMonth": "1"
            }
          ]
        },
        {
          "bookSchemeCondBase": {
            "relateName": "0",
            "promoId": "620562",
            "condName": "D类号码[4/7号码]",
            "schemeType": "1",
            "resPackName": "",
            "expireDate": "2030-01-01T00:00:00.000Z",
            "validDate": "2012-02-01T00:00:00.000Z",
            "schemeFee": "1",
            "resHoldMonth": "6",
            "condId": "100024",
            "condHoldMonth": "",
            "preFee": "1"
          },
          "bookSchemeAllot": [
            {
              "explicitMonth": "0",
              "allotBookEnd": "0",
              "allotBookBegin": "0",
              "allotAmount": "0",
              "bookItemId": "80302",
              "allotBeginMonth": "0",
              "bookType": "5",
              "allotBookLimit": "0",
              "allotMonth": "1"
            }
          ]
        },
        {
          "bookSchemeCondBase": {
            "relateName": "5913",
            "promoId": "620562",
            "condName": "E类号码",
            "schemeType": "1",
            "resPackName": "",
            "expireDate": "2030-01-01T00:00:00.000Z",
            "validDate": "2012-02-01T00:00:00.000Z",
            "schemeFee": "1",
            "resHoldMonth": "6",
            "condId": "100025",
            "condHoldMonth": "",
            "preFee": "20000"
          },
          "bookSchemeAllot": [
            {
              "explicitMonth": "0",
              "allotBookEnd": "0",
              "allotBookBegin": "0",
              "allotAmount": "20000",
              "bookItemId": "80302",
              "allotBeginMonth": "0",
              "bookType": "1",
              "allotBookLimit": "0",
              "allotMonth": "1"
            }
          ]
        },
        {
          "bookSchemeCondBase": {
            "relateName": "3331",
            "promoId": "620562",
            "condName": "G类吉祥号码",
            "schemeType": "1",
            "resPackName": "",
            "expireDate": "2030-01-01T00:00:00.000Z",
            "validDate": "2014-12-01T00:00:00.000Z",
            "schemeFee": "1",
            "resHoldMonth": "6",
            "condId": "100026",
            "condHoldMonth": "",
            "preFee": "10000"
          },
          "bookSchemeAllot": [
            {
              "explicitMonth": "0",
              "allotBookEnd": "0",
              "allotBookBegin": "0",
              "allotAmount": "10000",
              "bookItemId": "80302",
              "allotBeginMonth": "0",
              "bookType": "1",
              "allotBookLimit": "0",
              "allotMonth": "1"
            }
          ]
        },
        {
          "bookSchemeCondBase": {
            "relateName": "2033",
            "promoId": "620562",
            "condName": "G类城市靓号",
            "schemeType": "1",
            "resPackName": "",
            "expireDate": "2030-01-01T00:00:00.000Z",
            "validDate": "2014-12-01T00:00:00.000Z",
            "schemeFee": "1",
            "resHoldMonth": "6",
            "condId": "100027",
            "condHoldMonth": "",
            "preFee": "0"
          },
          "bookSchemeAllot": []
        }
      ]
    }
  }
}'''	
		com.alibaba.fastjson.JSONObject jsonObject = com.alibaba.fastjson.JSON.parseObject(json)
		jsonObject.put('respCode', '00000')
		jsonObject.put('respDesc', '成功')
		Clawer clawer = Clawer.fromFastJson(jsonObject)
		def template = '''#kv(respCode,respCode<>)
						#kv(respDesc,respDesc<>)
						#ko(result,interBOSS{}.serviceContent{})
							#ka(conds,bookSchemeCondAllot[])
								#io(bookSchemeCondBase{})
									#kv(condName,condName<>)
									#kv(condId,condId<>)
								#oi
							#ak
						#ok
'''
		Builder b = Parser.from(template, clawer).build()
		Assert.assertEquals('{"respCode":"00000","respDesc":"成功","result":{"conds":[{"condName":"A类连号[一级号码]","condId":"100001"},{"condName":"A类连号[二级号码]","condId":"100002"},{"condName":"A类连号[三级号码]","condId":"100003"},{"condName":"A类连号[四级号码]","condId":"100004"},{"condName":"A类连号[五级号码]","condId":"100005"},{"condName":"A类连号[六级号码]","condId":"100006"},{"condName":"A类连号[七级号码]","condId":"100007"},{"condName":"A类连号[八级号码]","condId":"100008"},{"condName":"A类连号[九级号码]","condId":"100009"},{"condName":"A类连号[十级号码","condId":"100010"},{"condName":"A类连号[十一级号码]","condId":"100011"},{"condName":"B类重号[一级号码]","condId":"100012"},{"condName":"B类重号[二级号码]","condId":"100013"},{"condName":"B类重号[三级号码]","condId":"100014"},{"condName":"B类重号[四级号码]","condId":"100015"},{"condName":"B类重号[五级号码]","condId":"100016"},{"condName":"B类重号[六级号码]","condId":"100017"},{"condName":"C类顺号[一级号码]","condId":"100018"},{"condName":"C类顺号[二级号码]","condId":"100019"},{"condName":"C类顺号[三级号码]","condId":"100020"},{"condName":"C类顺号[四级号码]","condId":"100021"},{"condName":"C类顺号[五级号码]","condId":"100022"},{"condName":"C类顺号[六级号码]","condId":"100023"},{"condName":"D类号码[4/7号码]","condId":"100024"},{"condName":"E类号码","condId":"100025"},{"condName":"G类吉祥号码","condId":"100026"},{"condName":"G类城市靓号","condId":"100027"}]}}', b.toJson())
	}
	
	@Test
	void test08() {
		def json = '''{
    "interBOSS":{
        "version":"1.0",
        "testFlag":"1",
        "appId":"A2016033115142400018",
        "dynamicToken":"c77e261f3c5bb4a4097ed9ee76cd93f3f157a05c",
        "userPhoneNumber":"13919318036",
        "transInfo":{
            "sessionId":"adafsafasfsdf",
            "originalId":"4",
            "originalTime":"20151215150756"
        },
        "authorization":{
            "userAuthorizationCode":"1"
        },
        "otherInfo":[
            {
                "attributeName":"fee",
                "value":"44"
            }
        ],
        "serviceContent":{
            "phoneId":"18896728888",
            "promoId":"12345",
            "condId":"12345",
            "actType":"1"
        }
    }
}'''
		Clawer clawer = Clawer.fromFastJson(com.alibaba.fastjson.JSON.parseObject(json))
		def template = '''#ko(interBOSS,interBOSS{})
							#ka(otherInfo)
								#io()
									#kv(attributeName,version<>)
									#kv(value,testFlag<>)
								#oi
							#ak
						#ok
'''
		Builder b = Parser.from(template, clawer).build()
		Assert.assertEquals('{"interBOSS":{"otherInfo":[{"attributeName":"1.0","value":"1"}]}}', b.toJson())
	}
	
	@Test
	void test09() {
		def json = '''{
    "interBOSS":{
        "version":"1.0",
        "testFlag":"1",
        "appId":"A2016033115142400018",
        "dynamicToken":"c77e261f3c5bb4a4097ed9ee76cd93f3f157a05c",
        "userPhoneNumber":"13919318036",
        "transInfo":{
            "sessionId":"adafsafasfsdf",
            "originalId":"4",
            "originalTime":"20151215150756"
        },
        "authorization":{
            "userAuthorizationCode":"1"
        },
        "otherInfo":[
            {
                "attributeName":"fee",
                "value":"44"
            }
        ],
        "serviceContent":{
            "phoneId":"18896728888",
            "promoId":"12345",
            "condId":"12345",
            "actType":"1"
        }
    }
}'''
		Clawer clawer = Clawer.fromFastJson(com.alibaba.fastjson.JSON.parseObject(json))
		def template = '''#ko(interBOSS,interBOSS{})
							#ka(otherInfo)
								#io
									#kv(attributeName,version<>)
									#kv(value,testFlag<>)
								#oi
								#io
									#kv(attributeName,appId<>)
									#kv(value,userPhoneNumber<>)
								#oi
							#ak
						#ok
'''
		Builder b = Parser.from(template, clawer).build()
		Assert.assertEquals('{"interBOSS":{"otherInfo":[{"attributeName":"1.0","value":"1"},{"attributeName":"A2016033115142400018","value":"13919318036"}]}}', b.toJson())
	}
	
	@Test
	void test10() {
		def json = '''{
    "interBOSS":{
        "version":"1.0",
        "testFlag":"1",
        "appId":"A2016033115142400018",
        "dynamicToken":"c77e261f3c5bb4a4097ed9ee76cd93f3f157a05c",
        "userPhoneNumber":"13919318036",
        "transInfo":{
            "sessionId":"adafsafasfsdf",
            "originalId":"4",
            "originalTime":"20151215150756"
        },
        "authorization":{
            "userAuthorizationCode":"1"
        },
        "otherInfo":[
            {
                "attributeName":"fee",
                "value":"44"
            }
        ],
        "serviceContent":{
            "phoneId":"18896728888",
            "promoId":"12345",
            "condId":"12345",
            "actType":"1"
        }
    }
}'''
		Clawer clawer = Clawer.fromFastJson(com.alibaba.fastjson.JSON.parseObject(json))
		def template = '''#ko(interBOSS,interBOSS{})
							#ka(otherInfo)
								#iv(version<>)
							#ak
						#ok
'''
		Builder b = Parser.from(template, clawer).build()
		Assert.assertEquals('{"interBOSS":{"otherInfo":["1.0"]}}', b.toJson())
	}
	
	@Test
	void test11() {
		def json = '''{
    "interBOSS":{
        "version":"1.0",
        "testFlag":"1",
        "appId":"A2016033115142400018",
        "dynamicToken":"c77e261f3c5bb4a4097ed9ee76cd93f3f157a05c",
        "userPhoneNumber":"13919318036",
        "transInfo":{
            "sessionId":"adafsafasfsdf",
            "originalId":"4",
            "originalTime":"20151215150756"
        },
        "authorization":{
            "userAuthorizationCode":"1"
        },
        "otherInfo":[
            {
                "attributeName":"fee",
                "value":"44"
            }
        ],
        "serviceContent":{
            "phoneId":"18896728888",
            "promoId":"12345",
            "condId":"12345",
            "actType":"1"
        }
    }
}'''
		Clawer clawer = Clawer.fromFastJson(com.alibaba.fastjson.JSON.parseObject(json))
		def template = '''#ko(interBOSS,interBOSS{})
							#ka(otherInfo)
								#iv(version<>)
								#iv(testFlag<>)
								#iv(appId<>)
								#iv(userPhoneNumber<>)
							#ak
						#ok
'''
		Builder b = Parser.from(template, clawer).build()
		Assert.assertEquals('{"interBOSS":{"otherInfo":["1.0","1","A2016033115142400018","13919318036"]}}', b.toJson())
	}
	
	@Test
	void test12() {
		def json = '''{
    "interBOSS":{
        "version":"1.0",
        "testFlag":"1",
        "appId":"A2016033115142400018",
        "dynamicToken":"c77e261f3c5bb4a4097ed9ee76cd93f3f157a05c",
        "userPhoneNumber":"13919318036",
        "transInfo":{
            "sessionId":"adafsafasfsdf",
            "originalId":"4",
            "originalTime":"20151215150756"
        },
        "authorization":{
            "userAuthorizationCode":"1"
        },
        "otherInfo":["attributeName","fee","value","44"],
        "serviceContent":{
            "phoneId":"18896728888",
            "promoId":"12345",
            "condId":"12345",
            "actType":"1"
        }
    }
}'''
		Clawer clawer = Clawer.fromFastJson(com.alibaba.fastjson.JSON.parseObject(json))
		def template = '''#ko(interBOSS,interBOSS{})
							#ka(otherInfo,otherInfo[])
								#iv
							#ak
						#ok
'''
		Builder b = Parser.from(template, clawer).build()
		Assert.assertEquals('{"interBOSS":{"otherInfo":["attributeName","fee","value","44"]}}', b.toJson())
	}
	
	@Test
	void test13() {
		def json = '''{
    "interBOSS":{
        "version":"1.0",
        "testFlag":"1",
        "appId":"A2016033115142400018",
        "dynamicToken":"c77e261f3c5bb4a4097ed9ee76cd93f3f157a05c",
        "userPhoneNumber":"13919318036",
        "transInfo":{
            "sessionId":"adafsafasfsdf",
            "originalId":"4",
            "originalTime":"20151215150756"
        },
        "authorization":{
            "userAuthorizationCode":"1"
        },
        "otherInfo":[
            {
                "attributeName":"fee",
                "value":"44"
            },
			{
                "attributeName":"xx",
                "value":"00"
            }
        ],
        "serviceContent":{
            "phoneId":"18896728888",
            "promoId":"12345",
            "condId":"12345",
            "actType":"1"
        }
    }
}'''
		Clawer clawer = Clawer.fromFastJson(com.alibaba.fastjson.JSON.parseObject(json))
		def template = '''#ko(interBOSS,interBOSS{})
							#ka(otherInfo,otherInfo[])
								#iv(attributeName<>)
							#ak
						#ok
'''
		Builder b = Parser.from(template, clawer).build()
		Assert.assertEquals('{"interBOSS":{"otherInfo":["fee","xx"]}}', b.toJson())
	}
	
	@Test
	void test14() {
		def json = '''{
    "interBOSS":{
        "version":"1.0",
        "testFlag":"1",
        "appId":"A2016033115142400018",
        "dynamicToken":"c77e261f3c5bb4a4097ed9ee76cd93f3f157a05c",
        "userPhoneNumber":"13919318036",
        "transInfo":{
            "sessionId":"adafsafasfsdf",
            "originalId":"4",
            "originalTime":"20151215150756"
        },
        "authorization":{
            "userAuthorizationCode":"1"
        },
        "otherInfo":[
            {
                "attributeName":"fee",
                "value":"44"
            },
			{
                "attributeName":"xx",
                "value":"00"
            }
        ],
        "serviceContent":{
            "phoneId":"18896728888",
            "promoId":"12345",
            "condId":"12345",
            "actType":"1"
        }
    }
}'''
		Clawer clawer = Clawer.fromFastJson(com.alibaba.fastjson.JSON.parseObject(json))
		def template = '''#ko(interBOSS,interBOSS{})
							#ka(otherInfo,otherInfo[])
								#io
									#kv(attributeName,attributeName<>)
									#kv(value,value<>)
								#oi
							#ak
						#ok
'''
		Builder b = Parser.from(template, clawer).build()
		Assert.assertEquals('{"interBOSS":{"otherInfo":[{"attributeName":"fee","value":"44"},{"attributeName":"xx","value":"00"}]}}', b.toJson())
	}
}
