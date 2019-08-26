package com.max.core.utils;//package com.max.core.utils;
//
//import com.alibaba.fastjson.JSON;
//import com.alibaba.fastjson.JSONObject;
//import com.sun.deploy.net.HttpUtils;
//import org.apache.commons.codec.digest.DigestUtils;
//import org.apache.commons.lang3.StringUtils;
//import org.springframework.stereotype.Service;
//
//import java.io.UnsupportedEncodingException;
//import java.util.HashMap;
//import java.util.Map;
//
//@Service
//public class AddressUtils {
//
//    private final static String API_ID = "48818";
//    private final static String API_SIGN = "9611726b11f94c89a38703ac9406cd60";
//
//    /**
//     * 根据IP地址获取详细地址信息
//     *
//     * @param ip
//     * @return
//     */
//    public static String getAddrByIp(String ip) {
//        try {
//            Map<String, String> params = new HashMap<>();
//            params.put("showapi_appid", API_ID);
//            params.put("ip", ip);
//            String toSign = "ip" + params.get("ip") + "showapi_appid" + params.get("showapi_appid") + API_SIGN;
//            params.put("showapi_sign", DigestUtils.md5Hex(toSign.getBytes("utf-8")));
//
//            String result = HttpUtils.doPost("http://route.showapi.com/20-1", params);
//            System.out.println("result: " + result);
//            if (StringUtils.isEmpty(result)) {
//                return "未知地址";
//            }
//            JSONObject obj = JSON.parseObject(result);
//            if (obj != null) {
//                JSONObject bodyObj = obj.getJSONObject("showapi_res_body");
//                if (bodyObj != null && bodyObj.getInteger("ret_code") != null && bodyObj.getInteger("ret_code") == 0) {
//                    String country = bodyObj.getString("country");
//                    String region = bodyObj.getString("region");
//                    String city = bodyObj.getString("city");
//                    return country + region + city;
//                }
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return "未知地址";
//    }
//
//}
