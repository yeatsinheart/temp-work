package com.max.core.utils;//package com.max.core.utils;
//
///**
// * Created by ken on 2018/3/16.
// */
//
//import com.alibaba.fastjson.JSON;
//import com.alibaba.fastjson.JSONObject;
//import com.betball.core.model.GlSystemApi;
//import com.betball.core.paymentutils.HttpUtils;
//import com.betball.core.apiUtils.showApi.ShowApiRequest;
//import com.betball.core.apiUtils.wangyiApi.HttpClient4Utils;
//import com.betball.core.apiUtils.wangyiApi.SignatureUtils;
//import com.betball.core.apiUtils.yunApi.RestTest;
//import org.apache.http.Consts;
//import org.apache.http.client.HttpClient;
////
//import java.io.*;
//import java.net.HttpURLConnection;
//import java.net.URL;
//import java.net.URLEncoder;
//import java.util.HashMap;
//import java.util.Map;
//import java.util.UUID;
//
////用户请使用UTF-8作为源码文件的保存格式，避免出现乱码问题
//public class MessageAPIStore {
//    /**
//     * HTTP的Post请求方式
//     *
//     * @param strUrl 访问地址
//     * @param param  参数字符串
//     */
//    public static String doPost(String strUrl, String param) {
//        String returnStr = null; // 返回结果定义
//        URL url = null;
//        HttpURLConnection httpURLConnection = null;
//
//        try {
//            url = new URL(strUrl);
//            httpURLConnection = (HttpURLConnection) url.openConnection();
//            httpURLConnection.setRequestProperty("Accept-Charset", "utf-8");
//            httpURLConnection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
//            httpURLConnection.setDoOutput(true);
//            httpURLConnection.setDoInput(true);
//            httpURLConnection.setRequestMethod("POST"); // post方式
//            httpURLConnection.setConnectTimeout(3000);
//            httpURLConnection.connect();
//            //System.out.println("ResponseCode:" + httpURLConnection.getResponseCode());
//            //POST方法时使用
//            byte[] byteParam = param.getBytes("UTF-8");
//            DataOutputStream out = new DataOutputStream(httpURLConnection.getOutputStream());
//            out.write(byteParam);
//            out.flush();
//            out.close();
//            BufferedReader reader = new BufferedReader(
//                    new InputStreamReader(httpURLConnection.getInputStream(), "utf-8"));
//            StringBuffer buffer = new StringBuffer();
//            String line = "";
//            while ((line = reader.readLine()) != null) {
//                buffer.append(line);
//            }
//
//            reader.close();
//            returnStr = buffer.toString();
//        } catch (Exception e) {
//            e.printStackTrace();
//            return null;
//        } finally {
//            if (httpURLConnection != null) {
//                httpURLConnection.disconnect();
//            }
//        }
//        return returnStr;
//    }
//
//
//    //将map型转为请求参数型
//    public static String urlencode(Map<String, String> data) {
//        StringBuilder apistore = new StringBuilder();
//        for (Map.Entry<String, String> i : data.entrySet()) {
//            try {
//                apistore.append(i.getKey()).append("=").append(URLEncoder.encode(i.getValue() + "", "UTF-8")).append("&");
//            } catch (UnsupportedEncodingException e) {
//                e.printStackTrace();
//            }
//        }
//        return apistore.toString();
//    }
//
//    // 发起请求,获取内容
//    public static void sendMsg(String mobile, String text, String appId, String secretId, String secertKey, String url) {
//        //请求地址
////        String url = "https://v.apistore.cn/api/v14/send";
//        //您申请的key
//        String APPKEY = "6043f2035fe97b5181f73f30396bbe94";
//        //请求参数
//        Map params = new HashMap();
//        params.put("key", APPKEY);
//        params.put("mobile", mobile);
//        params.put("content", text);
//
//        String result = doPost(url, urlencode(params));
//        //输出结果
//        System.out.println(result);
//        //JSON
//        JSONObject object = JSON.parseObject(result);
//        //输出状态码
//        System.out.println(object.getInteger("error_code"));
//        //输出返回结果
//        System.out.println(object.get("reason"));
//    }
//
//    public static void sendMsgShowApi(String mobile, String text, GlSystemApi glSystemApi) {
//        String res = new ShowApiRequest(glSystemApi.getUrl(), glSystemApi.getTempleteId(), glSystemApi.getSecretKey())
//                .addTextPara("mobile", mobile)
//                .addTextPara("content", "{\"code\":" + text + "}")
//                .addTextPara("tNum", glSystemApi.getExt())
//                .post();
//        System.out.println("show api response=" + res);
//    }
//
//    public static void sendMsgWYApi(String telArea, String mobile, String text, GlSystemApi glSystemApi) {
//        try {
//            System.out.println("glSystemApi=" + JSON.toJSONString(glSystemApi));
//
//            HttpClient httpClient = HttpClient4Utils.createHttpClient(100, 20, 3000, 2000, 2000);
//            String params = "code=" + text;
//            Map paramMap = new HashMap<String, String>();
//            paramMap.put("businessId", glSystemApi.getAppId());
//            paramMap.put("timestamp", String.valueOf(System.currentTimeMillis()));
//            paramMap.put("version", "v2");
//            paramMap.put("needUp", "false");
//            paramMap.put("templateId", glSystemApi.getTempleteId());
//            paramMap.put("mobile", mobile);
//            paramMap.put("params", params);
//            //国际短信
//            if ("86".equals(telArea)) {
//
//            } else if ("886".equals(telArea) || "852".equals(telArea) || "853".equals(telArea)) {
//                paramMap.put("internationalCode", telArea);
//                paramMap.put("templateId", "10244");
//            } else {
//                paramMap.put("internationalCode", telArea);
//            }
//            paramMap.put("nonce", UUID.randomUUID().toString().replace("-", ""));
//            paramMap.put("secretId", glSystemApi.getSecretId());
//            String sign = SignatureUtils.genSignature(glSystemApi.getSecretKey(), paramMap);
//            paramMap.put("signature", sign);
//            System.out.println("wangyi api req=" + JSON.toJSONString(paramMap));
//            String result = HttpClient4Utils.sendPost(httpClient, glSystemApi.getUrl(), paramMap, Consts.UTF_8);
//            System.out.println("wangyi api response=" + result);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//
//    public static void sendMsgYunApi(String mobile, String param, GlSystemApi glSystemApi) {
//        RestTest.testSendSms(glSystemApi.getSecretId(), glSystemApi.getSecretKey(), glSystemApi.getAppId(), glSystemApi.getTempleteId(), param, mobile, glSystemApi.getExt(), glSystemApi.getUrl());
//    }
//
//
//    //国际通道
//    public static void sendMsgYunPianApi(String telArea, String mobile, String content, GlSystemApi glSystemApi) {
//        System.out.println("glSystemApi=" + JSON.toJSONString(glSystemApi));
//        Map<String, String> params = new HashMap<String, String>();
//        params.put("apikey", glSystemApi.getSecretKey());
//        params.put("text", content);
//        params.put("mobile", "+" + telArea + mobile);
//        System.out.println("telArea=" + telArea);
//        System.out.println("params=" + JSON.toJSONString(params));
//        System.out.println("glSystemApi.getUrl()=" + glSystemApi.getUrl());
//        String result = HttpUtils.post(glSystemApi.getUrl(), params);
//        System.out.println("result=" + result);
//    }
//    //da0f5462c42653d46202944f7d32ed94
////    public static void main(String[] args) throws IOException {
////        String res = new ShowApiRequest("http://route.showapi.com/28-1", "82971", "a7d8eb0757d64690b97e43d5e80cd55c")
////                .addTextPara("mobile", "18924795615")
////                .addTextPara("content", "{\"code\":" + 3333 + "}")
////                .addTextPara("tNum", "T170317003818")
////                .post();
////        System.out.println("show api response=" + res);
////    }
//
//}
