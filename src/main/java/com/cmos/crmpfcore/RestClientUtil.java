package com.cmos.crmpfcore;

import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedHashMap;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.Response;

import com.cmos.esbclient.bean.EsbOutObject.RTN_CODE;
import com.cmos.esbclient.bean.MessageInfo;
import com.cmos.esbclient.bean.RestMethodType;
import com.cmos.esbclient.util.SHAUtil;

/**
 * Rest调用客户端
 */
public class RestClientUtil {
	// 默认编码格式
	private static final String DEFAULT_ENCODING = "UTF-8";
	// 默认时间格式
	private static final String DEFAULT_PATTERN = "yyyyMMddHHmmssSSS";
	public static String invoke(MessageInfo messageInfo) throws Exception {
		// 参数校验
		validateMessageInfo(messageInfo);

		// 获取请求参数
		String uri = messageInfo.getUri();// 获取请求地址
		String clientId = messageInfo.getClientId();// 获取客户端编号
		String input = messageInfo.getInput();// 获取请求报文
		String sn = null;
		if (isClientId(clientId)) {// 校验clientId
			String prefix = clientId.substring(clientId.lastIndexOf(".") + 1);
			String date = new SimpleDateFormat(DEFAULT_PATTERN).format(new Date());
			String random = generateRandomCode();// 生成6位随机数 
			sn = prefix + date + random;
		}
		RestMethodType requestType = messageInfo.getRestMethodType();// 获取请求类型
		
		// 调用服务
		String result = null;
		Client client = ClientBuilder.newClient();
		try {
			
			WebTarget target = null;
			Response response = null;
			
			// 请求头
			MultivaluedMap<String, Object> headers = new MultivaluedHashMap<String, Object>();
			headers.add("ClientId", clientId);
			headers.add("channel", "crmpf");
			headers.add("sn", sn);
			headers.add("secret", SHAUtil.shaEncode(input));

			switch (requestType) {
			case GET:// GET请求
				input = URLEncoder.encode(input, DEFAULT_ENCODING).replaceAll("\\+", "%20");
				target = client.target(uri + input);
				response = target.request().headers(headers).get();
				break;
			case DELETE:// DELETE 请求
				input = URLEncoder.encode(input, DEFAULT_ENCODING).replaceAll("\\+", "%20");
				target = client.target(uri + input);
				response = target.request().headers(headers).delete();
				break;
			case POST:// POST请求
				target = client.target(uri);
				response = target.request().headers(headers).buildPost(Entity.entity(input, MediaType.APPLICATION_JSON)).invoke();
				break;
			case PUT:// PUT请求
				target = client.target(uri);
				response = target.request().headers(headers).buildPut(Entity.entity(input, MediaType.APPLICATION_JSON)).invoke();
				break;
			default:
				break;
			}
			if(response!=null){
				result = response.readEntity(String.class);
				response.close();
			}
		} catch (Exception e) {
			result = "{\"rtnCode\":\"" + RTN_CODE.ERROR + "\",\"rtnMsg\":\"" + e.getMessage() + "\"}";
		}
		return result;
	}
	
	/**
	 * 校验MessageInfo
	 */
	private static void validateMessageInfo(MessageInfo messageInfo){
		/** 1、校验Url */
		String uri = messageInfo.getUri();
		if (isEmpty(uri)) {// uri不可为空
			throw new RuntimeException("目标uri不可为空!");
		} else if (!isHtml(uri)) {
			throw new RuntimeException("目标uri格式不正确!");
		} else {
			if (!uri.endsWith("/")) {
				messageInfo.setUri(uri + "/");
			}
		}
		
		/** 2、校验clientId */
		String clientId = messageInfo.getClientId();
		if (isEmpty(clientId)) {
			throw new RuntimeException("服务消费者唯一标识不能为空!");
		} else if(!isClientId(clientId)){
			throw new RuntimeException("clientId 格式不正确!");
		}
		
		/** 3、*/
		String input = messageInfo.getInput();
		if (isEmpty(input)) {
			throw new RuntimeException("请求报文不可为空!");
		}
		
		RestMethodType restMethodType = messageInfo.getRestMethodType();
		if (restMethodType == null) {
			throw new RuntimeException("请求类型不可为空!");
		}
	}
	
	/**
	 * 判断字符串是否为null || 空字符串
	 * 
	 * @param param
	 * @return
	 */
	private static boolean isEmpty(String param) {
		return param == null || "".equals(param.trim());
	}
	
	/**
	 * 判断是否为Url
	 * @param regex
	 * @return True=IS HTML 
	 */
	private static boolean isHtml(String str) {
		String regex = "[a-zA-z]+://[^\\s]*";
		return matchRegex(str, regex);
	}
	
	private static boolean isClientId(String str) {
		String regex = "([a-z]+).([a-z]+).([a-z]+).([a-z]+).([a-z]+)";
		return matchRegex(str, regex);
	}
	
	private static boolean matchRegex(String value, String regex) {
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(value);
		return matcher.matches();
	}
	
	/**
	 * 生成6位随机数
	 */
	private static String generateRandomCode(){
		return String.valueOf(new Random().nextInt(899999) + 100000);
	}
}
