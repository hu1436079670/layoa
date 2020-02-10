/**
 * @Company:中享思途   
 * @Title:CodeUtil.java 
 * @Author:胡鑫卓   
 * @Date:2020年2月5日 上午11:54:26     
 */ 
package com.situ.layoa.utils;

import java.io.Serializable;
import java.text.DecimalFormat;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/** 
 * @ClassName:CodeUtil 
 * @Description:(生成各种编码的工具类)  
 */
public class CodeUtil implements Serializable {

	private static final long serialVersionUID = 1L;
	private static SimpleDateFormat FORMAT_YY_MM_DD = new SimpleDateFormat("yyMMdd");
	private static final Format FORMAT_000 = new DecimalFormat("000");
	//注入序列表的DAO
	public static String buildOrderNum() {
		Calendar calendar = Calendar.getInstance();
		StringBuffer numBuffer = new StringBuffer();
		numBuffer.append(FORMAT_YY_MM_DD.format(calendar.getTime()));
		//通过序列表的DAO查询出当前序列的数：比如说当前序列 是 2
		
		//将当前的序列 加一 ，然后 append到numBuffer 中
		int index=1;
		numBuffer.append(FORMAT_000.format(index));
		
		//将这个序列的最新值更新回数据库。
		
		return numBuffer.toString();
	}
}
