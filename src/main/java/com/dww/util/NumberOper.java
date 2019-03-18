package com.dww.util;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Random;
import java.util.regex.Pattern;

public class NumberOper {
	/**
	 * 保留2位小数
	 * @param double number
	 * @return String number
	 */
	public static String format2(double number){
		NumberFormat nf = NumberFormat.getNumberInstance();
		nf.setGroupingUsed(false);
        nf.setMaximumFractionDigits(2);
		return nf.format(number);
	}
	
	/**
	 * 保留2位小数 补零
	 * @param double number
	 * @return String number
	 */
	public static String format20(double number){
		DecimalFormat df = new DecimalFormat("########.00");
		if(".00".equals(df.format(number))){
			return "0.00";
		}else{
			String str = df.format(number);
			if(str.indexOf(".")==0){
				str = "0"+str;
			}
			return str;
		}
        
	}
	
	/**
	 * 保留2位小数 补零 加千位分隔符
	 * @param double number
	 * @return String number
	 */
	public static String format20BD(double number){
		BigDecimal bd = new BigDecimal(number);
		DecimalFormat df = new DecimalFormat(",###,###.00");
		if(".00".equals(df.format(bd))){
			return "0.00";
		}else{
			String str = df.format(bd);
			if(str.indexOf(".")==0){
				str = "0"+str;
			}
			return str;
		}
        
	}
	
	/**
	 * 保留2位小数 并四舍五入
	 * @param double number
	 * @return double number
	 */
	public static double formatDouble2(double number) {
        // 新方法，如果不需要四舍五入，可以使用RoundingMode.DOWN
        BigDecimal bg = new BigDecimal(number).setScale(2, RoundingMode.UP);
        return bg.doubleValue();
    }
	
	/**
	 * 保留2位小数 并四舍五入
	 * @param double number
	 * @return double number
	 */
	public static double formatDoubleHALF_UP(double number) {
        // 新方法，如果不需要四舍五入，可以使用RoundingMode.DOWN
        BigDecimal bg = new BigDecimal(number).setScale(2, RoundingMode.HALF_UP);
        return bg.doubleValue();
    }
	
	/**
	 * 保留2位小数 后边截掉
	 * @param double number
	 * @return double number
	 */
	public static double formatDownDouble2(double number) {
        // 新方法，如果不需要四舍五入，可以使用RoundingMode.DOWN
        BigDecimal bg = new BigDecimal(number).setScale(2, RoundingMode.DOWN);
        return bg.doubleValue();
    }
	
	/**
	 * 保留2位小数 并四舍五入
	 * @param double number
	 * @return double number
	 */
	public static double formatDouble1(double number) {
        // 新方法，如果不需要四舍五入，可以使用RoundingMode.DOWN
        BigDecimal bg = new BigDecimal(number).setScale(1, RoundingMode.UP);
        return bg.doubleValue();
    }
	
	/**
	 * 判断是否是数字
	 * @param String str
	 * @return boolean
	 */
	public static boolean isNumBer(String str){ 
	    Pattern pattern = Pattern.compile("^[-+]?(([0-9]+)([.]([0-9]+))?|([.]([0-9]+))?)$"); 
	    return pattern.matcher(str).matches();    
	 }
	
	/**
	 * 生成n位的随机数
	 * @param n
	 * @return String
	 */
	public static String createNum(int n){
		if (n < 1 || n > 10) {
            throw new IllegalArgumentException("cannot random " + n + " bit number");
        }
        Random ran = new Random();
        if (n == 1) {
            return String.valueOf(ran.nextInt(10));
        }
        int bitField = 0;
        char[] chs = new char[n];
        for (int i = 0; i < n; i++) {
            while(true) {
                int k = ran.nextInt(10);
                if( (bitField & (1 << k)) == 0) {
                    bitField |= 1 << k;
                    chs[i] = (char)(k + '0');
                    break;
                }
            }
        }
        return new String(chs);
	}
	
	public static String trimSpaces(String str){
		return str.replaceAll("[　*| *| *|//s*]*", "");
	}
	
	public static int getRandomNum(int min,int max){
		Random random = new Random();
        int s = random.nextInt(max)%(max-min+1) + min;
        random = null;
        return s;
	}
	
}
