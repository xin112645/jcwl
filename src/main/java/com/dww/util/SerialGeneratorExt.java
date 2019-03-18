package com.dww.util;

import java.security.SecureRandom;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import java.util.UUID;

/**
 * 随机序列生成器
 * 
 */
public class SerialGeneratorExt {

	/**
	 * 以随机种子初始化random对象
	 */
	private static final Random RANDOM = new SecureRandom();
	
	/**
	 * 内部交易码长度
	 */
	private static int INTER_TRANS_ID_LENGTH = 32;

	/**
	 * 日期格式化模板
	 */
	private static ThreadLocal<SimpleDateFormat> dateFormatFactory = new ThreadLocal<SimpleDateFormat>() {
		@Override
		protected SimpleDateFormat initialValue() {
			return new SimpleDateFormat("yyyyMMddHHmmssSSS");
		}
	};
	private static ThreadLocal<SimpleDateFormat> pay_dateFormatFactory = new ThreadLocal<SimpleDateFormat>() {
		@Override
		protected SimpleDateFormat initialValue() {
			return new  SimpleDateFormat("yyyyMMdd_HHmmssSSS_");
		}
	};


	private static final String DEFAULT_TANSID_TYPE = "10";

	private static final char[] mm = new char[] { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9' };


	/**
	 * 生成规则 17位日期毫秒数 + 消息类型（10) + 随机数补齐32位
	 * 
	 */
	public static String getOrder() {
		StringBuilder sb = new StringBuilder();
		sb.append(dateFormatFactory.get().format(new Date())).append(DEFAULT_TANSID_TYPE)
				.append(generateRandomSerial(INTER_TRANS_ID_LENGTH - sb.length()));
		return sb.toString();
	}
	//绑卡订单号
	public static String getBindCardOrder() {
		StringBuilder sb = new StringBuilder();
		sb.append("bc_"+pay_dateFormatFactory.get().format(new Date())).append(DEFAULT_TANSID_TYPE)
		.append(generateRandomSerial(INTER_TRANS_ID_LENGTH - sb.length()));
		return sb.toString();
	}
	//绑卡确认订单号
	public static String getBindCardOkOrder() {
		StringBuilder sb = new StringBuilder();
		sb.append("bo_"+pay_dateFormatFactory.get().format(new Date())).append(DEFAULT_TANSID_TYPE)
		.append(generateRandomSerial(INTER_TRANS_ID_LENGTH - sb.length()));
		return sb.toString();
	}
	//解卡订单号
	public static String getRemoveCardOrder() {
		StringBuilder sb = new StringBuilder();
		sb.append("rc_"+pay_dateFormatFactory.get().format(new Date())).append(DEFAULT_TANSID_TYPE)
		.append(generateRandomSerial(INTER_TRANS_ID_LENGTH - sb.length()));
		return sb.toString();
	}
	//卡状态查询订单号
	public static String getSearchCardStatusOrder() {
		StringBuilder sb = new StringBuilder();
		sb.append("sc_"+pay_dateFormatFactory.get().format(new Date())).append(DEFAULT_TANSID_TYPE)
		.append(generateRandomSerial(INTER_TRANS_ID_LENGTH - sb.length()));
		return sb.toString();
	}
	//卡列表查询订单号
	public static String getSearchCardListOrder() {
		StringBuilder sb = new StringBuilder();
		sb.append("cl_"+pay_dateFormatFactory.get().format(new Date())).append(DEFAULT_TANSID_TYPE)
		.append(generateRandomSerial(INTER_TRANS_ID_LENGTH - sb.length()));
		return sb.toString();
	}
	//收款订单号*********（消费）
	public static String getPayOrder() {
		StringBuilder sb = new StringBuilder();
		sb.append("pa_"+pay_dateFormatFactory.get().format(new Date())).append(DEFAULT_TANSID_TYPE)
		.append(generateRandomSerial(INTER_TRANS_ID_LENGTH - sb.length()));
		return sb.toString();
	}
	
	//查询收款订单号
	public static String getSearchPayStatusOrder() {
		StringBuilder sb = new StringBuilder();
		sb.append("sp_"+pay_dateFormatFactory.get().format(new Date())).append(DEFAULT_TANSID_TYPE)
		.append(generateRandomSerial(INTER_TRANS_ID_LENGTH - sb.length()));
		return sb.toString();
	}
	
	//付款订单号（还款）
	public static String getRePayMentOrder() {
		StringBuilder sb = new StringBuilder();
		sb.append("re_"+pay_dateFormatFactory.get().format(new Date())).append(DEFAULT_TANSID_TYPE)
		.append(generateRandomSerial(INTER_TRANS_ID_LENGTH - sb.length()));
		return sb.toString();
	}
	//查询付款订单号
	public static String getSearchRePayMentStatusOrder() {
		StringBuilder sb = new StringBuilder();
		sb.append("sr_"+pay_dateFormatFactory.get().format(new Date())).append(DEFAULT_TANSID_TYPE)
		.append(generateRandomSerial(INTER_TRANS_ID_LENGTH - sb.length()));
		return sb.toString();
	}

	//提现请求
	public static String getMoneyApplyOrder() {
		StringBuilder sb = new StringBuilder();
		sb.append("ma_"+pay_dateFormatFactory.get().format(new Date())).append(DEFAULT_TANSID_TYPE)
		.append(generateRandomSerial(INTER_TRANS_ID_LENGTH - sb.length()));
		return sb.toString();
	}
	
	/**
	 * 生成len长度的随机数序列
	 * @param len
	 * @return String randomString
	 */
	public static String generateRandomSerial(int len) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < len; i++) {
			sb.append(mm[RANDOM.nextInt(mm.length)]);
		}
		return sb.toString();
	}
	
	public static String generateUUID() {  
        UUID uuid = UUID.randomUUID();  
        String str = uuid.toString().replace("-", ""); 
       
        return str;  
    }  
	public static String formatDouble1(double d) {
        double dd =  (double)Math.round(d*100)/100;
        String res = String.format("%.2f", dd);
        return res;
    }
	public static String generateCurrentDateTime1() {
		String sRe = null;
		Date d = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
		sRe = sdf.format(d);
		return sRe;
	}
	public static String generateCurrentDateTime3() {
		String sRe = null;
		Date d = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmssSSS");
		sRe = sdf.format(d);
		return sRe;
	}
	public static String generateCurrentDateTime2() {
		String sRe = null;
		Date d = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		sRe = sdf.format(d);
		return sRe;
	}


}