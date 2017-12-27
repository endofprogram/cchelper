package com.cmos.crmpfcore;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.cmos.core.bean.InputObject;
import com.cmos.core.bean.OutputObject;
import com.cmos.core.logger.Logger;
import com.cmos.core.logger.LoggerFactory;
import com.cmos.core.util.JsonUtil;
import com.cmos.esbclient.bean.EsbInObject;
import com.cmos.esbclient.bean.EsbOutObject;
import com.cmos.esbclient.bean.MessageInfo;
import com.cmos.esbclient.bean.RestMethodType;


/**
 * FUPIN系统远程调用FUPINBUSI系统服务 (调用方式HTTP RESTFUL)
 */
public class RestfulManager {
    private static final Logger logger = LoggerFactory.getUtilLog(RestfulManager.class);

    public static void main(String[] args) {
        InputObject inputObject = new InputObject();
        // 封装参数开始
        Map<String, Object> params = new HashMap<String, Object>();
//        params.put("oprNumb", "0048123"+DateUtil.date2String(new Date(),DATE_PATTERN.YYYYMMDDHHMMSS)+(new Random().nextInt(900000000)+100000000));
//        params.put("contactId","CONT"+DateUtil.date2String(new Date(),DATE_PATTERN.YYYYMMDD)+"CSVC0048"+(new Random().nextInt(9000000)+1000000) );
//        params.put("iDItemRange", "18303713360");
//        params.put("acceptStaff", "X000000");
//        params.put("provCode", "591");//流量产品查询
       // params.put("NccPasswd", "123456");
       // params.put("OprType", "01");
//        params.put("userMobile", "13608828787");  //云南手机归属地查询
//        params.put("userMobile", "13623757644");
//          params.put("userMobile", "15074378469");//15074378469
//          params.put("userMobile", "18789918417");
//        params.put("userMobile", "5911853341");
//        params.put("productId", "22");
//        params.put("userMobile", "13783556313");
       // params.put("userMobile", "13623757644");
//        params.put("productId", "H");
//        params.put("productName", "");
//        params.put("amount", "");
//        params.put("discount", "");
//        params.put("productValue", "");
 //       params.put("orderId", "20160721154400");
//        params.put("custId", "");
//        params.put("serverCode", "");
//        params.put("orderTime", "");
        
        
        
        
//        params.put("oprNumb", "ZYZX20120304120945");
//        params.put("contactId", "CONT20120304CSVC3710001001");
//        params.put("msisdn", "13953350030");
//        params.put("qryMonth", "201601");
//        params.put("acceptStaff", "X810068张荣勋");
//        params.put("identCode", "0000000000000016031199c024072806");
        
        
        //湖南流量充值接口参数
//        params.put("userMobile", "15074378469");//15074378469
//        params.put("productId", "99");
//        params.put("productName", "");
//        params.put("amount", "");
//        params.put("discount", "");
//        params.put("productValue", "");
//        params.put("orderId", "");
//        params.put("serverCode", "");
//        params.put("orderTime", "");
        
        
      //天津流量充值接口参数
//      params.put("userMobile", "18322702076");//18867101970   13820761234
//      params.put("productId", "99");
//      params.put("productName", "");
//      params.put("amount", "");
//      params.put("discount", "");
//      params.put("productValue", "");
//      params.put("orderId", "");
//      params.put("serverCode", "");
//      params.put("orderTime", "");
        

        
      //福建已订购流量关系查询
//      params.put("userMobile", "13599392643");
      
        //福建流量订单状态查询
//        params.put("userMobile", "13599392643");
//        params.put("orderId", "24039048test");
//        params.put("custId", "");
      
        //福建流量产品查询
//        params.put("provCode", "471");//流量产品查询
        
        //福建流量充值
//      params.put("Number", "13599392643");
//      params.put("ECCode", "5911853341");
//      params.put("DealID", "3831001001");//3241801420
//      params.put("ECOrderID", "123123");
//      params.put("Mode", "7");
//      params.put("Discount", "99");
//      params.put("EffType", "1");
//      params.put("orderId", "123123123");
        
        
        //福建流量充值
//      params.put("userMobile", "13599392643");//userMobile->Number
//      params.put("productId", "3831001001");//productId->DealID
//      params.put("orderId", "123123123");
//      params.put("productName", "1");//productName->ECOrderID  需要填产品查询出来的productDesc  “产品描述”的值
//      params.put("amount", "7");//amount->Mode 需要填产品查询出来的productCost  “产品价格”的值
//      params.put("discount", "100");//discount->Discount  需要填产品查询出来的productValue  “产品的大小”的值
//      params.put("productValue", "1");//productValue->EffType   代表生效模式（1=立即生效 2=次月生效）
//      params.put("serverCode", "");
//      params.put("orderTime", "");
        
//        /**贵州新平台---当前套餐查询*/
//        params.put("serviceNum", "18224726484");
//        params.put("type", null);
//        params.put("code", null);        
//        params.put("prochoice", null);

        /**贵州新平台---查询账户余额*/
//        params.put("serviceNum", "18224726484");
//        params.put("accoutId", null);
//        params.put("isNotUseCache", null); 
        
//		        /**贵州新平台---办理流量套餐*/
//		   params.put("serviceNum", "18308533841");
//		   params.put("type", "2");
//		   params.put("code", "212080400020"); 
//		   params.put("prochoice", "N"); 
//        
//        /**贵州新平台---4G资费套餐的办理接口*/
//        params.put("serviceNum", "13595173982");
//        params.put("offerId", "211086803574");
     
        
//        /**贵州新平台---是否可订购指定营销活动接口*/
//        params.put("serviceNum", "13595173982");
//        params.put("offerId", "211086803574");
        
//        /**贵州新平台---是否可订购指定营销活动接口*/
//	      params.put("serviceNum", "15086355173");
//	      params.put("offerId", "310000483901");
        
//            /**贵州新平台---订购指定营销活动*/
//	      params.put("settleDate", "20170316");
//	      params.put("serviceNum", "18285355131");
//	      Map<String, Object> vasOfferInfoList = new HashMap<String, Object>();
//	      List<Map<String, Object>> vasOfferInfo = new<Map<String, Object>> ArrayList();
//	      vasOfferInfoList.put("offerId", "310000459102");
//	      vasOfferInfoList.put("operType", "0");
//	      vasOfferInfo.add(vasOfferInfoList);
//	      params.put("vasOfferInfo", vasOfferInfo);
	     
//        	/**贵州新平台---营销活动撤单接口*/
//	      params.put("serviceNum", "13608576525");
//	      params.put("orderCode", "85113992267526");
		   
		   
		   
//       	/**贵州新平台---营销活动订单查询接口*/
//	      params.put("serviceNum", "13765632393");
//	      params.put("startDate", "2017-03-11 20:57:34");
//	      params.put("endDate", "2017-03-11 20:57:34");
	      
//	      	/**贵州新平台---话费充值接口*/
//		  params.put("serviceNum", "13765316197");
//		  params.put("channelPaySN", "3320170314000102374655");
//		  params.put("payAmount", "10000");
//		  params.put("payedAmount", "9950");
//		  params.put("discount", "0.995");
//		  params.put("actionDate", "20170314");
//		  params.put("actionTime", "20170314000120");
//		  params.put("isPreInvoice", "10000001");
//		  params.put("settleDate", "20170314");
//		  params.put("commision", null);
//		  params.put("channelSN", "9");
//		  params.put("busiType", "2");
		  
//	      	/**贵州新平台---话费充值冲正接口*/
//		params.put("serviceNum", "13765316197");
//		params.put("actionTime", "20170314000120");
//      params.put("settleDate", "20170314");
//	    params.put("settlePayDate", "20170314");
//		params.put("channelPaySN", "3320170314000102374655");
//		params.put("channelType", "5");
//		params.put("revokeReason", "201");
//		params.put("money", "1000");
//		params.put("sN", "20");
	
	      	/**贵州新平台---话费订单查询接口*/
//		params.put("serviceNum", "15185979932");
//		params.put("merId", "CMCC_OPEN_1008510");
//        params.put("accountDate", "201703");
//	    params.put("amount", "995");
//		params.put("peerSeq", "1561532418752523");
//		params.put("actionDate", "20170311");
	 
	 
        //天津流量充值接口参数
//      params.put("userMobile", "15004718124");//18867101970   13820761234
//      params.put("productId", "99");
//      params.put("orderId", "123123123");
//      params.put("productName", "");
//      params.put("amount", "");
//      params.put("discount", "");
//      params.put("productValue", "");
//      params.put("serverCode", "");
//      params.put("orderTime", "");
        
        
      params.put("userMobile", "15004718124");//18867101970   13820761234
      params.put("custId", "");
      params.put("orderId", "5e792fa288214e4583eda0301012a264");
        
        
//      params.put("provCode", "471");//流量产品查询
        
      inputObject.setParams(params);
        

        try {
            System.out.println("请求报文：" + JsonUtil.convertObject2Json(inputObject));
            // 请求方法
             RestMethodType i_RestMethodType = RestMethodType.GET;
//            RestMethodType i_RestMethodType = RestMethodType.POST;
            // 开始请求
            System.out.println("响应报文：" + pubMethod(inputObject, i_RestMethodType));
        } catch (Exception e) {
        	logger.error("",e);
        }
    }

    // 服务调用
    public static String pubMethod(InputObject inputObject, RestMethodType i_RestMethodType) {
//        String uri = "http://127.0.0.1:8082/crmpfcore/ws/business/gz851/getUserMainOffer";
//        String uri = "http://127.0.0.1:8081/crmpfcore/ws/business/gs/OrderPlansQry";//福建流量订购查询
//    	String uri = "http://127.0.0.1:8081/crmpfcore/ws/business/gs/OrderPlansQry1";
//        String uri = "http://127.0.0.1:8081/crmpfcore/ws/business/phoneAreaQry/";//云南手机号归属地查询
        //"http://127.0.0.1:8080/crmpfcore/ws/business/gs/memberReturnQuery";
//    	String uri = "http://127.0.0.1:8081/crmpfcore/ws/business/product/";//13608828787  云南手机号套餐产品查询
//    	String uri = "http://127.0.0.1:8081/crmpfcore/ws/business/gs/products/";//流量产品查询
//    	String uri = "http://127.0.0.1:8081/crmpfcore/ws/business/gs/memberDealOper";
    	
    	String uri = "http://127.0.0.1:8081/crmpfcore/ws/business/gs/memberReturnQuery";

//    	String uri = "http://127.0.0.1:8081/crmpfcore/ws/business/bill/";
//    	String uri = "http://127.0.0.1:8080/crmpfcore/ws/business/uip/fareBalance";
//        String uri = "http://127.0.0.1:8081/crmpfcore/ws/business/gs/memberDealQuery";
//        String uri = "http://127.0.0.1:8080/crmpfcore/ws/business/phoneAreaQry/";
//    	String uri = "http://127.0.0.1:8081/crmpfcore/ws/business/gs/memberReturnQuery";
        //String uri = "http://127.0.0.1:8080/crmpfcore/ws/business/gs/memberDealQuery";
        //String uri = "http://127.0.0.1:8080/crmpfcore/ws/business/bootup";
        String clientId = "com.cmos.esb.out.crmpfcore";

        // 封装公用对象
        EsbInObject esbInObject = new EsbInObject();
        esbInObject.setParams((Map<String, String>)(Object)inputObject.getParams());
//        esbInObject.setObject(inputObject.getParams());

        esbInObject.setBeans(convertListObject2String(inputObject.getBeans()));
        String json = JsonUtil.convertObject2Json(esbInObject);

        MessageInfo messageInfo = new MessageInfo(uri, clientId, json, i_RestMethodType);
        System.out.println(messageInfo.toString());
        String result=null;
		try {
			result = RestClientUtil.invoke(messageInfo);
		} catch (Exception e) {
			logger.error("",e);
		}
        System.out.println("result="+result);
        EsbOutObject outOjbect = JsonUtil.convertJson2Object(result, EsbOutObject.class);
        OutputObject output = convertEsbOut2Output(outOjbect);
        return JsonUtil.convertObject2Json(output);
    }

    /**
     * 转换EsbOutObject为OutputObject
     * 
     * @param esbOut
     * @return
     */
    private static OutputObject convertEsbOut2Output(EsbOutObject esbOut) {

        if (esbOut == null) {
            return null;
        }
        OutputObject output = new OutputObject();
        output.setBean(convertMapString2Object(esbOut.getBean()));
        output.setBeans(convertListString2Object(esbOut.getBeans()));
        output.setReturnCode(esbOut.getRtnCode());
        output.setReturnMessage(esbOut.getRtnMsg());
        output.setObject(esbOut.getObject());

        return output;
    }

    /**
     * 转换Map<String, String>到Map<String, Object>
     * 
     * @param map
     * @return
     */
    private static Map<String, Object> convertMapString2Object(Map<String, String> map) {
        Map<String, Object> result = new HashMap<String, Object>();
        for (Map.Entry<String, String> entry : map.entrySet()) {
            result.put(entry.getKey(), entry.getValue());
        }
        return result;
    }

    /**
     * 转换List<Map<String, String>>到List<Map<String, Object>>
     * 
     * @param lists
     * @return
     */
    private static List<Map<String, Object>> convertListString2Object(List<Map<String, String>> lists) {
        if (lists != null && lists.size() > 0) {
            List<Map<String, Object>> results = new ArrayList<Map<String, Object>>();
            for (Map<String, String> map : lists) {
                results.add(convertMapString2Object(map));
            }
            return results;
        }
        return null;
    }

    private static Map<String, String> convertMapObject2String(Map<String, Object> map) {
        if (map != null && (!map.isEmpty())) {
            Map<String, String> result = new HashMap<String, String>();
            for (Map.Entry<String, Object> entry : map.entrySet()) {
                result.put(entry.getKey(), (String) entry.getValue());
            }
            return result;
        }
        return null;
    }

    private static List<Map<String, String>> convertListObject2String(List<Map<String, Object>> lists) {
        if (lists != null && lists.size() > 0) {
            List<Map<String, String>> results = new ArrayList<Map<String, String>>();
            for (Map<String, Object> map : lists) {
                results.add(convertMapObject2String(map));
            }
            return results;
        }
        return null;
    }
}
 