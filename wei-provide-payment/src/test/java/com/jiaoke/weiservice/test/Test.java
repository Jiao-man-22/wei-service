package com.jiaoke.weiservice.test;


import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.json.JSONString;
import org.json.JSONObject;
import org.springframework.util.StringUtils;
import org.wlld.distinguish.Distinguish;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.TreeSet;

import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.toCollection;

public class Test {
    public static void main(String[] args) throws Exception {
//        t1();
//        generatorInfo("");
//        test();
//        way1();
//        Distinguish distinguish = new Distinguish();
    }

     static String generatorInfo(){
        String truckingBillNo = "12345";
        String transBillNo = "65498";
        String stackNo = "11231";
        String signNo = "da123-131weq-12ewa-128";
        String lastNo = "001";
        if (StringUtils.isEmpty(signNo)) {
            lastNo ="001";
        } else {
            // 最后三位序列号
            DecimalFormat decimalFormat = new DecimalFormat("000");
            int i = Integer.parseInt(signNo.substring(signNo.length() - 3, signNo.length())) + 1;
            lastNo = decimalFormat.format(i);
        }
        String pattern = "%s-%s-%s-%s";
        String format = String.format(pattern, truckingBillNo, transBillNo, stackNo, lastNo);
        return format;
    }

    static void t1() {
        switch ("1") {
            case "22":
            case "3":
                break;
            case "1":
                //“签约开始”；“签约失败”；“签约拒绝”；“签约中止”;“签约逾期”
                switch ("1") {
                    case "1":
                        return;
                    default:
                        break ;
                }
                System.out.println("仍旧执行了");
        }
        System.out.println("并没有终结方法");

    }



        static String generatorInfo(String req) {

            String truckingBillNo = "1111";
            String transBillNo = "2222";
            String stackNo = "3333";
            String signNo = "9999-8888-7777-001";
            String lastNo = "";
            if (StringUtils.isEmpty(signNo)) {
                if ("20".equals("20")) {
                    lastNo = "red-001";
                }else {
                    lastNo = "001";
                }
            } else {
                // 最后三位序列号
                DecimalFormat decimalFormat = new DecimalFormat("000");
                int i = Integer.parseInt(signNo.substring(signNo.length() - 3, signNo.length())) + 1;
                if ("20".equals("20")) {
                    lastNo = "red-" + decimalFormat.format(i);
                }else{
                    lastNo = decimalFormat.format(i);
                }

            }
            String pattern = "%s-%s-%s-%s";
            System.out.println( String.format(pattern, truckingBillNo, transBillNo, stackNo, lastNo));
            return "";
        }


        static void test(){
            List<OutBillHeadBo> arrayList = CollectionUtil.newArrayList();
            for (int i = 0; i < 10 ; i++) {
                OutBillHeadBo outBillHeadBo = new OutBillHeadBo();
                outBillHeadBo.setOutBillHeadId(Long.parseLong(i + ""));
                arrayList.add(outBillHeadBo);
            }
            arrayList.get(0).setOutBillHeadId(1L);
            arrayList.get(1).setOutBillHeadId(1L);
            arrayList.get(3).setOutBillHeadId(1L);
            arrayList.get(5).setOutBillHeadId(2L);
            arrayList.get(6).setOutBillHeadId(null);
            arrayList.stream().forEach(x ->{
                System.out.println(x.getOutBillHeadId());
            });
            System.out.println("---元数据----" +  arrayList.size());
            arrayList.size();
            List<OutBillHeadBo> OutBillHeadIdListDistinct = arrayList.stream().filter(x -> x.getOutBillHeadId() != null ).collect(
                    collectingAndThen(
                            toCollection(() -> new TreeSet<>(Comparator.comparing(OutBillHeadBo::getOutBillHeadId))), ArrayList::new)
            );

            System.out.println("-----去重------"  );
            OutBillHeadIdListDistinct.stream().forEach(x ->{
                System.out.println(x.getOutBillHeadId());
            });
            System.out.println("-----去重数量------" +   OutBillHeadIdListDistinct.size());
            OutBillHeadIdListDistinct.size();
        }



        public static void way1(){

            for (int i = 0; i < 10; i++) {
                System.out.println("111111");
                for (int j = 0; j < 5; j++) {
                    System.out.println("222222");
                    switch (2){
                        case 1:
                        break;
                        default:
                            return;

                    }
                }
                System.out.println("****************");
            }
            System.out.println("---------------------");
        }
}
