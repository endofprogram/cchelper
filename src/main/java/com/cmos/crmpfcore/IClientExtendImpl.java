package com.cmos.crmpfcore;

import java.util.HashMap;
import java.util.Map;

import com.cmos.csf.api.client.extend.IClientExtend;

/**
 *@author zhang xiaoming
 *@since 2017年1月18日 下午9:30:48
 */
public class IClientExtendImpl implements IClientExtend{

	@Override
	public Map customSystemParams() {
		Map<String,String> map = new HashMap<String,String>();
		map.put("X-Channel-Id", "crmpf");
		return map;
	}

	@Override
	public boolean isCross() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public String routeByRegion() {
		// TODO Auto-generated method stub
		return null;
	}

}
