package com.mkyong.rest;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.time.Clock;
import java.util.Calendar;

public class SigGen {


    public static void main(String[] args) {
        System.out.println(encryptMD5("tx7th2b529dqmzzzgkhhemrc" + "n6SvhpGwR5CRfh53q3frT9Sb" + unixTime()));
    }

    private static String encryptMD5(String md5) {
        try {
            byte[] bytesofMessage = md5.getBytes();
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte array[] = md.digest(bytesofMessage);
            StringBuilder sb = new StringBuilder();
            for (byte s : array) {
                sb.append(Integer.toHexString((s & 0xFF) | 0x100).substring(1, 3));
            }
            System.out.println(Calendar.getInstance().getTimeInMillis());
            return sb.toString();
        } catch (NoSuchAlgorithmException e) {
        }

        return "";
    }

    private static Long unixTime() {
        return Clock.systemUTC().instant().getEpochSecond();
    }
}
