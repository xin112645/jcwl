package com.dww.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class NewMD5 {
	/**
     * 使用Hmac进行签名
     * @param aValue  加密明文
     * @return
     */
    public static String hmacSign(String aValue) {
        try {
            byte[] input = aValue.getBytes();
            MessageDigest md = MessageDigest.getInstance("MD5");
           
            return toHex(md.digest(input));
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        }
    }
 /**
     *
     * @param input
     * @return
     */
    public static String toHex(byte input[]) {
        if (input == null)
            return null;
        StringBuffer output = new StringBuffer(input.length * 2);
        for (int i = 0; i < input.length; i++) {
            int current = input[i] & 0xff;
            if (current < 16)
                output.append("0");
            output.append(Integer.toString(current, 16));
        }

        return output.toString();
    }
}
