package com.swirebev.utils;

import org.apache.commons.codec.digest.DigestUtils;

public class TokenUtils {
	public static String generateToken(String appKey){
		//Token逻辑可以扩展
		return  DigestUtils.md5Hex(appKey);
	}
	public static boolean validateToken(String appKey,String token){
		if(token==null || token.isEmpty()||appKey==null || appKey.isEmpty())  return  false;
		String tmpToken=generateToken(appKey);
		boolean result=token.equals(tmpToken);
		return result;
	}
}
