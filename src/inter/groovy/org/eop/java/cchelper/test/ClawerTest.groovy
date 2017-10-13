package org.eop.java.cchelper.test

import org.eop.groovy.cchelper.test.AbstractCommonGroovyTest
import org.eop.java.cchelper.Clawer
import org.junit.Assert
import org.junit.Test

/**
 * @author lixinjie
 * @since 2017-09-23
 */
class ClawerTest extends AbstractCommonGroovyTest {

	@Test
	void test01() {
		def json = '''{
    "rspCode":"A0000",
    "rspDesc":"成功",
    "dynamicToken":"60121fd513a6024028d74c26f6f1c8253cc80cd5",
    "expiretime":"20151224184847"
}'''
		Clawer clawer = Clawer.fromFastJson(com.alibaba.fastjson.JSON.parseObject(json))
		Assert.assertEquals("60121fd513a6024028d74c26f6f1c8253cc80cd5", clawer.getValue("dynamicToken<>"))
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
		Assert.assertEquals("13919318036", clawer.getClawer("interBOSS{}").getValue("userPhoneNumber<>"))
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
		Assert.assertEquals("20151215150756", clawer.getClawer("interBOSS{}.transInfo{}").getValue("originalTime<>"))
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
		Assert.assertEquals("fee", clawer.getClawer("interBOSS{}.otherInfo[].#0{}").getValue("attributeName<>"))
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
		Assert.assertEquals("fee", clawer.getValue("interBOSS{}.otherInfo[].#0{}.attributeName<>"))
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
		Assert.assertEquals("18896728888", clawer.getValue("interBOSS{}.serviceContent{}.phoneId<>"))
	}
	
	@Test
	void test07() {
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
		Assert.assertEquals('[{"attributeName":"fee","value":"44"}]', clawer.getArray("interBOSS{}.otherInfo[]").toString())
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
		Assert.assertEquals('{"originalTime":"20151215150756","sessionId":"adafsafasfsdf","originalId":"4"}', clawer.getObject("interBOSS{}.transInfo{}").toString())
	}
	
	@Test
	void test09() {
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
		Clawer clawer = Clawer.fromFastJson(com.alibaba.fastjson.JSON.parseObject(json))
		Assert.assertEquals('A类连号[一级号码]', clawer.getValue("interBOSS{}.serviceContent{}.bookSchemeCondAllot[].#0{}.bookSchemeCondBase{}.condName<>"))
	}
	
	@Test
	void test10() {
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
		Clawer clawer = Clawer.fromFastJson(com.alibaba.fastjson.JSON.parseObject(json))
		Assert.assertEquals('G类城市靓号', clawer.getValue("interBOSS{}.serviceContent{}.bookSchemeCondAllot[].#-1{}.bookSchemeCondBase{}.condName<>"))
	}
}
