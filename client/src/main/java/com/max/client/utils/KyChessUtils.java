//package com.max.client.utils;
//
//import org.apache.commons.httpclient.HttpClient;
//import org.apache.commons.httpclient.methods.GetMethod;
//import sun.misc.BASE64Decoder;
//import sun.misc.BASE64Encoder;
//
//import javax.crypto.Cipher;
//import javax.crypto.spec.SecretKeySpec;
//import java.io.UnsupportedEncodingException;
//import java.net.URLDecoder;
//import java.net.URLEncoder;
//import java.security.MessageDigest;
//import java.security.NoSuchAlgorithmException;
//
//public class KyChessUtils {
//    /**
//     * MD5 32位加密
//     * @param sourceStr
//     * @return
//     */
//    public static String MD5(String sourceStr) {
//        String result = "";
//        try {
//            MessageDigest md = MessageDigest.getInstance("MD5");
//            md.update(sourceStr.getBytes("UTF-8"));
//            byte b[] = md.digest();
//            int i;
//            StringBuffer buf = new StringBuffer("");
//            for (int offset = 0; offset < b.length; offset++) {
//                i = b[offset];
//                if (i < 0)
//                    i += 256;
//                if (i < 16)
//                    buf.append("0");
//                buf.append(Integer.toHexString(i));
//            }
//            result = buf.toString();
//
//        } catch (NoSuchAlgorithmException e) {
//            e.printStackTrace();
//        } catch (UnsupportedEncodingException e) {
//            e.printStackTrace();
//        }
//        return result;
//    }
//
//
//    /**
//     * AES加密
//     * @param sSrc
//     * @return
//     * @throws Exception
//     */
//    public static String AESEncrypt(String value,String key) throws Exception {
//        Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
//        byte[] raw = key.getBytes("UTF-8");
//        SecretKeySpec skeySpec = new SecretKeySpec(raw, "AES");
//        cipher.init(Cipher.ENCRYPT_MODE, skeySpec);
//        byte[] encrypted = cipher.doFinal(value.getBytes("UTF-8"));
//        String base64 = new BASE64Encoder().encode(encrypted);// 此处使用BASE64做转码
//        return URLEncoder.encode(base64, "UTF-8");//URL加密
//    }
//
//    /**
//     * AES加密 不进行URLEncoder
//     * @param sSrc
//     * @return
//     * @throws Exception
//     */
//    public static String AESUNURLEncrypt(String value,String key) throws Exception {
//        Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
//        byte[] raw = key.getBytes("UTF-8");
//        SecretKeySpec skeySpec = new SecretKeySpec(raw, "AES");
//        cipher.init(Cipher.ENCRYPT_MODE, skeySpec);
//        byte[] encrypted = cipher.doFinal(value.getBytes("UTF-8"));
//        return new BASE64Encoder().encode(encrypted);// 此处使用BASE64做转码
//    }
//
//    /**
//     * AES 解密
//     * @param sSrc
//     * @return
//     * @throws Exception
//     */
//    public static String AESDecrypt(String value,String key,boolean isDecodeURL) throws Exception {
//        try {
//            byte[] raw = key.getBytes("UTF-8");
//            SecretKeySpec skeySpec = new SecretKeySpec(raw, "AES");
//            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
//            cipher.init(Cipher.DECRYPT_MODE, skeySpec);
//            if(isDecodeURL)	value = URLDecoder.decode(value, "UTF-8");
//            byte[] encrypted1 = new BASE64Decoder().decodeBuffer(value);// 先用base64解密
//            byte[] original = cipher.doFinal(encrypted1);
//            String originalString = new String(original, "UTF-8");
//            return originalString;
//        } catch (Exception ex) {
//            ex.printStackTrace();
//            return null;
//        }
//    }
//
//    /**
//     * POST提交数据方法
//     * @author temdy
//     * @Date 2016-08-26
//     * @param postUrl POST提交URL
//     * @return String
//     */
//    public static String get(String postUrl) {
//        String obj = null;
//        HttpClient client = new HttpClient();
//        GetMethod method = null;
//        try {
//            method = new GetMethod(postUrl);
//            client.executeMethod(method);
//            client.getHttpConnectionManager().getParams().setConnectionTimeout(8000);
//            client.getHttpConnectionManager().getParams().setSoTimeout(8000);
//            obj = method.getResponseBodyAsString();
////			System.out.println(method.getStatusCode());
////			System.out.println(obj);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return obj;
//    }
//    public static void main(String[] a){
//        //http://14.29.47.112:89/channelHandle?agent=10066&timestamp=1497024103000&param=dTYWCf9V7KZWweVuRJ%2Fjr2T6TH4Ckzx3vwkSJJ%2FcNPE%3D&key=7d41837eaaf324d408e8ee2029f0d49e
//        String value = "vWappyp5yL1zQH9G6NUlo%2FXZrsfPX0aWm0CAz75eK1hmJ4rgb6wApu9JmgIwgDN3QVxNz1otN2DndepbzZYrXA%3D%3D";
//        try {
//            System.out.println(AESDecrypt(value, "8092955993034d57",true));
////			System.out.println(AESEncrypt("s=0&account=KYTest_001&money=0&orderid=1003120170713094921095&ip=127.0.0.1&lineCode=10031", "c42e60b1d28a45f2"));
////			System.out.println(MD5("10031149991023934690ad30d5286d451a"));
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//}
