package com.cjw.common.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Locale;
import java.util.ResourceBundle;

public class International {

	private static Logger logger = LoggerFactory.getLogger(International.class);
	/**
	 * 中国
	 */
	public static final String CN = "CN";
	/**
	 * 香港
	 */
	public static final String HK = "HK";
	/**
	 * 澳门
	 */
	public static final String MC = "MC";
	/**
	 * 台湾
	 */
	public static final String TW = "TW";
	/**
	 * 美国
	 */
	public static final String US = "US";
	/**
	 * 英国
	 */
	public static final String UK = "UK";

	/**
	 * 取国际化后的消息
	 * @param langCode sc/tc/en
	 * @param countryCode CN/MC/TW/HK/US/UK
	 * @param key
	 * @param defalutMessage
	 * @return
	 */
	public static String getMessage(String langCode, String countryCode, String key, String defalutMessage){
		if(StringUtils.isBlank(langCode) || StringUtils.isBlank(countryCode)){
			return defalutMessage;
		}
		
		String message = null;
		try{
			ResourceBundle bundle = ResourceBundle.getBundle("ucmp2_messages", getLocale(langCode, countryCode));
			message = bundle.getString(key);
		}catch(Exception e){
			logger.warn(e.getMessage());
			return defalutMessage;
		}
		return StringUtils.isBlank(message) ? defalutMessage : message;
	}
	
	public static String getMessage(String langCode, String countryCode, String key){
		ResourceBundle bundle = ResourceBundle.getBundle("ucmp2_messages", getLocale(langCode, countryCode));
		String string = bundle.getString(key);
		return string;
	}

	public static String getMessage(String key){
		return getMessage("sc", "CN", key);
	}

	private static Locale getLocale(String langCode, String countryCode) {
		
		if(HK.equals(countryCode) || MC.equals(countryCode)){
			countryCode = TW;
		}
		
		if("en".equals(langCode))
			countryCode = US;
		
		return new Locale(langCode, countryCode);

	}
	
}
