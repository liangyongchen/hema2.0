package com.hema.assist.common.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Project: WangTouWang
 * Author: frank
 * Created: 2018/2/8:上午9:10
 * Email: 656266591@qq.com
 * Desc:
 */
public class MD5Util {
    /**
     * Md5 32位 or 16位 加密
     *
     * @param plainText
     * @return 32位加密
     */
    public static String getMd5(String plainText, boolean is16Bit) {
        StringBuilder buf = new StringBuilder("");
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(plainText.getBytes());
            byte b[] = md.digest();
            int i;
            for (int offset = 0; offset < b.length; offset++) {
                i = b[offset];
                if (i < 0) i += 256;
                if (i < 16)
                    buf.append("0");
                buf.append(Integer.toHexString(i));
            }
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        if (is16Bit) {
            return buf.toString().substring(8, 24).toUpperCase(); //16位的加密
        } else {
            return buf.toString().toUpperCase();  //32位的加密
        }
    }
}