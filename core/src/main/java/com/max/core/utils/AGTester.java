package com.max.core.utils;//package com.max.core.utils;
//
//import ch.qos.logback.core.joran.spi.XMLUtil;
//import com.alibaba.fastjson.JSON;
//
//import java.io.BufferedReader;
//import java.io.File;
//import java.io.FileInputStream;
//import java.io.InputStreamReader;
//import java.util.*;
//import java.util.function.BiConsumer;
//
//public class AGTester {
//
//    public static Map<String, Integer> gameMap = new HashMap<>();
//
//    public static void main(String[] args) throws Exception {
//        Date start = DateUtils.parse("2019-02-27 00:00:00", "yyyy-MM-dd HH:mm:ss");
//        Date end = DateUtils.parse("2019-02-28 00:00:00", "yyyy-MM-dd HH:mm:ss");
//        File agDir = new File("C:\\Users\\Administrator\\Desktop\\AG数据\\newag\\ag");
//        System.out.println(agDir.listFiles().length);
//        Set<String> xmlOrderIds = new HashSet<>();
//        int fileindex = 0;
//        Map<String, Integer> userCount = new HashMap<>();
//        for (File file : agDir.listFiles()) {
//// System.out.println("xml file: " + (++fileindex));
//            BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
//            String line = reader.readLine();
//            win:
//            while (line != null) {
//                Map<String, String> map = XMLUtil.fromNode(line);
//                if (!"BR".equals(map.get("dataType"))) {
//// System.err.println("ERROR LINE: " + line);
//                    line = reader.readLine();
//                    continue win;
//                }
//                Date time = DateUtils.parse(map.get("betTime"), "yyyy-MM-dd HH:mm:ss");
//                if (time.getTime() >= start.getTime() && time.before(end) && map.get("flag").equals("1")) {
//                    String orderId = map.get("billNo").trim();
//                    if (!xmlOrderIds.contains(orderId)) {
//                        String player = map.get("playerName").trim();
//                        if ("wxg000018xd".equals(player)) {
//                            System.out.println(map.get("billNo").trim());
//                        }
//                        Integer count = userCount.get(player);
//                        if (count == null) {
//                            userCount.put(player, 1);
//                        } else {
//                            userCount.put(player, count + 1);
//                        }
//                        xmlOrderIds.add(map.get("billNo").trim());
//                    }
//// File file1 =new File("C:\\Users\\Administrator\\Desktop\\ag\\agOrder.txt");
////
//// //if file doesnt exists, then create it
//// if(!file.exists()){
//// file.createNewFile();
//// }
////
//// //true = append file
//// FileWriter fileWritter = new FileWriter(file1.getName(),true);
//// fileWritter.write(map.get("billNo")+",");
//// fileWritter.close();
//
//// System.out.println("Done");
//
//                }
//
//
//                line = reader.readLine();
//            }
//        }
//        System.out.println("xmlOrderIds size: " + xmlOrderIds.size());
//
//        System.out.println("userCount: " + JSON.toJSONString(userCount));
//        userCount.forEach(new BiConsumer<String, Integer>() {
//            @Override
//            public void accept(String key, Integer value) {
//                Integer gameCount = gameMap.get(key);
//                if (!value.equals(gameCount)) {
//                    System.out.println(key + ":" + value + ":" + gameCount);
//                }
//            }
//        });
//    }
//}