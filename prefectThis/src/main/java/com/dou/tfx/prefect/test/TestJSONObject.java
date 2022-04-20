package com.dou.tfx.prefect.test;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.springframework.util.CollectionUtils;

import java.util.*;

/**
 * @author tianfuxian
 * @Description:
 * @Date: 2021/6/2 2:19 下午
 */
public class TestJSONObject {
    public static void jsonIterator(String father, String json, List<String> list) {
        //如果字符串中没有":"说明json中不可能是json
        if (json.indexOf(":") == -1) {
            return;
        }
        //判断传入数据是否是一个json数组
        if (json.startsWith("[{")) {
            JSONArray jsonArray = JSONArray.parseArray(json);
            for (int i = 0; i < 1; i++) {
                jsonIterator(father, jsonArray.get(i).toString(), list);
            }
        } else {
            JSONObject jsonObject = JSONObject.parseObject(json);
            Iterator<String> iterator = jsonObject.keySet().iterator();
            while (iterator.hasNext()) {
                String key = iterator.next();
                String val = jsonObject.getString(key);
                //如果value的值是一个josnarray 或者是jsonobject则再次递归
                if (val.startsWith("[{")) {
                    list.add("JSONArray " + key + "=new JSONArray()");
                    //list.add("JSONArray " + key + "=new JSONArray()" + ":" + val);
                    jsonIterator(key, val, list);
                } else if (val.startsWith("{")) {
                    list.add("JSONObject " + key + "=new JSONObject()");
                    //list.add("JSONObject " + key + "=new JSONObject()" + ":" + val);
                    jsonIterator(key, val, list);
                } else {
                    list.add(father+".put(" + key+")");
                   //list.add(father+".put(" + key+")" + ":" + val);
                }
            }
        }
    }

    public static void jsonIterator1(String father, String json, Map<String,Object> map) {
        //如果字符串中没有":"说明json中不可能是json
        if (json.indexOf(":") == -1) {
            return;
        }
        //判断传入数据是否是一个json数组
        if (json.startsWith("[{")) {
            JSONArray jsonArray = JSONArray.parseArray(json);
            for (int i = 0; i < 1; i++) {
                jsonIterator1(father, jsonArray.get(i).toString(), map);
            }
        } else {
            JSONObject jsonObject = JSONObject.parseObject(json);
            Iterator<String> iterator = jsonObject.keySet().iterator();
            while (iterator.hasNext()) {
                String key = iterator.next();
                String val = jsonObject.getString(key);
                //如果value的值是一个josnarray 或者是jsonobject则再次递归
                if (val.startsWith("[{")) {
                    map.put("JSONArray " + key + "=new JSONArray()","1");
                    //list.add("JSONArray " + key + "=new JSONArray()" + ":" + val);
                    jsonIterator1(key, val, map);
                } else if (val.startsWith("{")) {
                    map.put("JSONObject " + key + "=new JSONObject()","2");
                    JSONObject jsonObject1 = JSONObject.parseObject(val);
                    Set<String> strings = jsonObject1.keySet();
                    if(!CollectionUtils.isEmpty(strings)){
                        strings.forEach(s -> {
                            map.put(key+".put(" + s+")","");
                        });
                    }


                    //list.add("JSONObject " + key + "=new JSONObject()" + ":" + val);
                    jsonIterator1(key, val, map);
                } else {
                    map.put(father+".put(" + key+")","");
                    //list.add(father+".put(" + key+")" + ":" + val);
                }
            }
        }
    }

    public static void main(String[] args) {
        //String json = "{\n" +
        //        "\t\"requestHead\": {\n" +
        //        "\t\t\"seqNo\": \"2019110157985557\",\n" +
        //        "\t\t\"requestId\": \"2019110157985557\",\n" +
        //        "\t\t\"requestTime\": \"2019-11-01 10:43:03\",\n" +
        //        "\t\t\"version\": \"3.0\"\n" +
        //        "\t},\n" +
        //        "\t\"requestBody\": {\n" +
        //        "\t\t\"autoExtendsInfo\": {\n" +
        //        "\t\t\t\"frontTransPortCode\": \"THS3301001\"\n" +
        //        "\t\t},\n" +
        //        "\t\t\"preciseQuoteRequest\": {\n" +
        //        "\t\t\t\"quotationType\": \"3\",\n" +
        //        "\t\t\t\"businessAttribute\": \"E00029\",\n" +
        //        "\t\t\t\"quotation\": {\n" +
        //        "\t\t\t\t\"orgCode\": \"\",\n" +
        //        "\t\t\t\t\"productCode\": \"DEJ\",\n" +
        //        "\t\t\t\t\"businessAttribute\": \"E00029\",\n" +
        //        "\t\t\t\t\"effectiveDate\": \"2020-01-22 00:00:00\",\n" +
        //        "\t\t\t\t\"expiryDate\": \"2021-01-22 00:00:00\",\n" +
        //        "\t\t\t\t\"agricultureRelaType\": \"N\",\n" +
        //        "\t\t\t\t\"isShortTerm\": \"N\",\n" +
        //        "\t\t\t\t\"isEffectiveImmediately\": \"N\",\n" +
        //        "\t\t\t\t\"insuredVehicleRelaCode\": \"1\",\n" +
        //        "\t\t\t\t\"policyCustomers\": [\n" +
        //        "\t\t\t\t\t{\n" +
        //        "\t\t\t\t\t\t\"customerName\": \"韦桂新\",\n" +
        //        "\t\t\t\t\t\t\"customerRoleCode\": \"1\",\n" +
        //        "\t\t\t\t\t\t\"idNo\": \"452502197910172328\",\n" +
        //        "\t\t\t\t\t\t\"idType\": \"111\",\n" +
        //        "\t\t\t\t\t\t\"isReceiveSms\": \"Y\",\n" +
        //        "\t\t\t\t\t\t\"partyCategory\": \"01\",\n" +
        //        "\t\t\t\t\t\t\"indiMobile\": \"18697946616\",\n" +
        //        "\t\t\t\t\t\t\"isPhoneHolderOneself\": \"0\",\n" +
        //        "\t\t\t\t\t\t\"phoneHolderName\": \"\",\n" +
        //        "\t\t\t\t\t\t\"phoneHolderIdType\": \"\",\n" +
        //        "\t\t\t\t\t\t\"phoneHolderIdNo\": \"\"\n" +
        //        "\t\t\t\t\t},\n" +
        //        "\t\t\t\t\t{\n" +
        //        "\t\t\t\t\t\t\"customerName\": \"韦桂新\",\n" +
        //        "\t\t\t\t\t\t\"customerRoleCode\": \"2\",\n" +
        //        "\t\t\t\t\t\t\"idNo\": \"452502197910172328\",\n" +
        //        "\t\t\t\t\t\t\"idType\": \"111\",\n" +
        //        "\t\t\t\t\t\t\"isReceiveSms\": \"Y\",\n" +
        //        "\t\t\t\t\t\t\"partyCategory\": \"01\",\n" +
        //        "\t\t\t\t\t\t\"indiMobile\": \"18697946616\",\n" +
        //        "\t\t\t\t\t\t\"isPhoneHolderOneself\": \"0\",\n" +
        //        "\t\t\t\t\t\t\"phoneHolderName\": \"\",\n" +
        //        "\t\t\t\t\t\t\"phoneHolderIdType\": \"\",\n" +
        //        "\t\t\t\t\t\t\"phoneHolderIdNo\": \"\"\n" +
        //        "\t\t\t\t\t},\n" +
        //        "\t\t\t\t\t{\n" +
        //        "\t\t\t\t\t\t\"customerName\": \"韦桂新\",\n" +
        //        "\t\t\t\t\t\t\"customerRoleCode\": \"3\",\n" +
        //        "\t\t\t\t\t\t\"idNo\": \"452502197910172328\",\n" +
        //        "\t\t\t\t\t\t\"idType\": \"111\",\n" +
        //        "\t\t\t\t\t\t\"isReceiveSms\": \"Y\",\n" +
        //        "\t\t\t\t\t\t\"partyCategory\": \"01\",\n" +
        //        "\t\t\t\t\t\t\"indiMobile\": \"18697946616\",\n" +
        //        "\t\t\t\t\t\t\"isPhoneHolderOneself\": \"0\",\n" +
        //        "\t\t\t\t\t\t\"phoneHolderName\": \"\",\n" +
        //        "\t\t\t\t\t\t\"phoneHolderIdType\": \"\",\n" +
        //        "\t\t\t\t\t\t\"phoneHolderIdNo\": \"\"\n" +
        //        "\t\t\t\t\t}\n" +
        //        "\t\t\t\t],\n" +
        //        "\t\t\t\t\"channelOpInfo\": {\n" +
        //        "\t\t\t\t\t\"channelCode\": \"E00029-001\",\n" +
        //        "\t\t\t\t\t\"channelName\": \"永安车险\",\n" +
        //        "\t\t\t\t\t\"channelComCode\": \"\",\n" +
        //        "\t\t\t\t\t\"regionCode\": \"\"\n" +
        //        "\t\t\t\t},\n" +
        //        "\t\t\t\t\"policyLob\": {\n" +
        //        "\t\t\t\t\t\"policyRisk\": {\n" +
        //        "\t\t\t\t\t\t\"vehicleKindCode\": \"11\",\n" +
        //        "\t\t\t\t\t\t\"vehicleUseNatureCode\": \"85\",\n" +
        //        "\t\t\t\t\t\t\"vehicleKindTcCode\": \"K31\",\n" +
        //        "\t\t\t\t\t\t\"isSpecialShapeVehicle\": \"N\",\n" +
        //        "\t\t\t\t\t\t\"isLoanVehicle\": \"N\",\n" +
        //        "\t\t\t\t\t\t\"announcedModel\": \"\",\n" +
        //        "\t\t\t\t\t\t\"isNotRegistered\": \"N\",\n" +
        //        "\t\t\t\t\t\t\"isNonlocalVehicle\": \"Y\",\n" +
        //        "\t\t\t\t\t\t\"licenseBackgroundCode\": \"1\",\n" +
        //        "\t\t\t\t\t\t\"isNewVehicle\": \"N\",\n" +
        //        "\t\t\t\t\t\t\"vehicleInitialRegDate\": \"2015-11-04\",\n" +
        //        "\t\t\t\t\t\t\"approvalQuality\": \"0\",\n" +
        //        "\t\t\t\t\t\t\"approvalSeatCount\": \"5\",\n" +
        //        "\t\t\t\t\t\t\"engineNo\": \"2364623\",\n" +
        //        "\t\t\t\t\t\t\"model\": \"帕萨特SVW7183MJi轿车\",\n" +
        //        "\t\t\t\t\t\t\"specialApplicationCode\": \"0\",\n" +
        //        "\t\t\t\t\t\t\"isTransferVehicle\": \"N\",\n" +
        //        "\t\t\t\t\t\t\"vehicleTransferRegDate\": \"\",\n" +
        //        "\t\t\t\t\t\t\"vin\": \"LFPH4ABC358A05466\",\n" +
        //        "\t\t\t\t\t\t\"vehicleCode\": \"HQABDD0071\",\n" +
        //        "\t\t\t\t\t\t\"licenseNo\": \"沪ZHU990\",\n" +
        //        "\t\t\t\t\t\t\"licenseType\": \"02\",\n" +
        //        "\t\t\t\t\t\t\"newVehiclePurchasePrice\": \"\",\n" +
        //        "\t\t\t\t\t\t\"purchaseInvoiceDate\": \"2015-11-04\",\n" +
        //        "\t\t\t\t\t\t\"vehicleKindDesc\": \"帕萨特SVW7183MJi轿车\",\n" +
        //        "\t\t\t\t\t\t\"policyCoverages\": [\n" +
        //        "\t\t\t\t\t\t\t{\n" +
        //        "\t\t\t\t\t\t\t\t\"isNonDeductible\": \"N\",\n" +
        //        "\t\t\t\t\t\t\t\t\"policyCoverageExtension\": {\n" +
        //        "\t\t\t\t\t\t\t\t\t\"deductible\": 0\n" +
        //        "\t\t\t\t\t\t\t\t},\n" +
        //        "\t\t\t\t\t\t\t\t\"productElementCode\": \"C101332\",\n" +
        //        "\t\t\t\t\t\t\t\t\"sumInsured\": 209800\n" +
        //        "\t\t\t\t\t\t\t},\n" +
        //        "\t\t\t\t\t\t\t{\n" +
        //        "\t\t\t\t\t\t\t\t\"isNonDeductible\": \"N\",\n" +
        //        "\t\t\t\t\t\t\t\t\"policyCoverageExtension\": {\n" +
        //        "\t\t\t\t\t\t\t\t\t\"deductibleRate\": 0.05\n" +
        //        "\t\t\t\t\t\t\t\t},\n" +
        //        "\t\t\t\t\t\t\t\t\"productElementCode\": \"C101362\",\n" +
        //        "\t\t\t\t\t\t\t\t\"sumInsured\": 0\n" +
        //        "\t\t\t\t\t\t\t},\n" +
        //        "\t\t\t\t\t\t\t{\n" +
        //        "\t\t\t\t\t\t\t\t\"isNonDeductible\": \"N\",\n" +
        //        "\t\t\t\t\t\t\t\t\"policyCoverageExtension\": {\n" +
        //        "\t\t\t\t\t\t\t\t\t\"serviceTimes\": 10\n" +
        //        "\t\t\t\t\t\t\t\t},\n" +
        //        "\t\t\t\t\t\t\t\t\"productElementCode\": \"C101372\",\n" +
        //        "\t\t\t\t\t\t\t\t\"sumInsured\": 0\n" +
        //        "\t\t\t\t\t\t\t},\n" +
        //        "\t\t\t\t\t\t\t{\n" +
        //        "\t\t\t\t\t\t\t\t\"isNonDeductible\": \"N\",\n" +
        //        "\t\t\t\t\t\t\t\t\"policyCoverageExtension\": {\n" +
        //        "\t\t\t\t\t\t\t\t\t\"serviceTimes\": 1\n" +
        //        "\t\t\t\t\t\t\t\t},\n" +
        //        "\t\t\t\t\t\t\t\t\"productElementCode\": \"C101373\",\n" +
        //        "\t\t\t\t\t\t\t\t\"sumInsured\": 0\n" +
        //        "\t\t\t\t\t\t\t},\n" +
        //        "\t\t\t\t\t\t\t{\n" +
        //        "\t\t\t\t\t\t\t\t\"isNonDeductible\": \"N\",\n" +
        //        "\t\t\t\t\t\t\t\t\"policyCoverageExtension\": {\n" +
        //        "\t\t\t\t\t\t\t\t\t\"serviceTimes\": 1\n" +
        //        "\t\t\t\t\t\t\t\t},\n" +
        //        "\t\t\t\t\t\t\t\t\"productElementCode\": \"C101374\",\n" +
        //        "\t\t\t\t\t\t\t\t\"sumInsured\": 0\n" +
        //        "\t\t\t\t\t\t\t},\n" +
        //        "\t\t\t\t\t\t\t{\n" +
        //        "\t\t\t\t\t\t\t\t\"isNonDeductible\": \"N\",\n" +
        //        "\t\t\t\t\t\t\t\t\"policyCoverageExtension\": {\n" +
        //        "\t\t\t\t\t\t\t\t\t\"serviceTimes\": 1\n" +
        //        "\t\t\t\t\t\t\t\t},\n" +
        //        "\t\t\t\t\t\t\t\t\"productElementCode\": \"C101375\",\n" +
        //        "\t\t\t\t\t\t\t\t\"sumInsured\": 0\n" +
        //        "\t\t\t\t\t\t\t}\n" +
        //        "\t\t\t\t\t\t]\n" +
        //        "\t\t\t\t\t}\n" +
        //        "\t\t\t\t}\n" +
        //        "\t\t\t},\n" +
        //        "\t\t\t\"associatedQuotation\": {\n" +
        //        "\t\t\t\t\"productCode\": \"DFA\",\n" +
        //        "\t\t\t\t\"effectiveDate\": \"2019-11-22 00:00:00\",\n" +
        //        "\t\t\t\t\"expiryDate\": \"2020-11-01 23:59:59\",\n" +
        //        "\t\t\t\t\"isShortTerm\": \"N\",\n" +
        //        "\t\t\t\t\"isEffectiveImmediately\": \"N\",\n" +
        //        "\t\t\t\t\"policyCoverages\": [\n" +
        //        "\t\t\t\t\t{\n" +
        //        "\t\t\t\t\t\t\"productElementCode\": \"C100120\",\n" +
        //        "\t\t\t\t\t\t\"sumInsured\": 122000,\n" +
        //        "\t\t\t\t\t\t\"policyCoverageExtension\": {}\n" +
        //        "\t\t\t\t\t}\n" +
        //        "\t\t\t\t]\n" +
        //        "\t\t\t}\n" +
        //        "\t\t}\n" +
        //        "\t}\n" +
        //        "}";
        String json = "{ \t\n" +
                "\t\"requestHead\": {\n" +
                "    \t\"seqNo\": \"402880ef0cd29b61010cd852e7a20099\",\n" +
                "        \"requestId\": \"550e8400e29b41d4a716446655440002\",\n" +
                "        \"requestTime\": \"2019-04-12 12:12:20\",\n" +
                "        \"version\": \"1.0\"\n" +
                "\t},\n" +
                "\t\"requestBody\": {\n" +
                "    \t\"queryType\":\"4\",\n" +
                "    \t\"policyNo\":\"PDFA19140123210000000001\",\n" +
                "        \"proposalNo\":\"\",\n" +
                "        \"effectiveDate\":\"\",\n" +
                "        \"visaNo\":\"\",\n" +
                "        \"licenseNo\":\"\",\n" +
                "        \"flightNo\":\"\",\n" +
                "        \"checkInDate\":\"\",\n" +
                "        \"rollBackDate\":\"\",\n" +
                "        \"channelSource\":\"\",\n" +
                "        \"businessAttribute\":\"\",\n" +
                "        \"customerName\":\"\",\n" +
                "        \"idNo\":\"\",\n" +
                "        \"indiIdType\":\"\"\n" +
                "       \n" +
                "\t}\n" +
                "}";
        List<String> list = new ArrayList<>();
        List<String> list1 = new ArrayList<>();
        Map<String,Object> map = new HashMap<>();
        TestJSONObject.jsonIterator1(" ",json, map);
        map.forEach((k,v)->{
            //System.out.println(k);
            if(k.contains("JSON")){
                list.add(k);
            }else {
                list1.add(k);
            }
        });
        list.forEach(s -> {
            System.out.println(s);
        });
        list1.stream().sorted().forEach(s -> {
            System.out.println(s);
        });
        //TestJSONObject.jsonIterator(" ",json, list);
        //list.forEach(s -> {
        //    System.out.println(s);
        //});
        //System.out.println(111);
    }
}
