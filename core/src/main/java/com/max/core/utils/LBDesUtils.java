package com.max.core.utils;

import lombok.extern.slf4j.Slf4j;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.security.MessageDigest;
import java.util.Base64;

@Slf4j
public class LBDesUtils {
    public static String encryptDES3(String source, String privateKey) {
        byte[] md5Key = getMd5(privateKey);
        SecretKey key = new SecretKeySpec(md5Key, "DESede");
        String encryptedString = null;
        try {
            Cipher ecipher = Cipher.getInstance("DESede/ECB/PKCS5Padding");

            ecipher.init(Cipher.ENCRYPT_MODE, key);
            byte[] data = source.getBytes("UTF-8");
            byte[] encryptedArray = ecipher.doFinal(data);
//            encryptedString=new Base64().encodeToString(encryptedArray);
            encryptedString = Base64.getEncoder().encodeToString(encryptedArray);

        } catch (Exception e) {
            log.error(String.valueOf(e));

        }
        return encryptedString;
    }
    public static byte[] getMd5(String keyString){
        byte[] rawKey=new byte[24];
        try{
            MessageDigest messageDigest=MessageDigest.getInstance("MD5");
            messageDigest.update(keyString.getBytes("UTF-8"),0,keyString.length());
            byte[] md5=messageDigest.digest();
            System.arraycopy(md5,0,rawKey,0,16);
            System.arraycopy(md5,0,rawKey,16,8);
        }catch (Exception e){
            log.error(String.valueOf(e));
        }
        return rawKey;
    }
}
