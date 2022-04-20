package com.dou.tfx.prefect.jsoup;

import com.google.common.base.Joiner;
import org.dom4j.io.SAXReader;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author tianfuxian
 * @Description:
 * @Date: 2021/3/30 6:06 下午
 */
public class TestJsoup {
    public static void main(String[] args) throws Exception {
        String filePath = "/Users/tianfuxian/Downloads/666.txt";
        Path path = Paths.get(filePath);
        String s = new String(Files.readAllBytes(path), StandardCharsets.UTF_8);

        Document doc = Jsoup.parse(s);
        Element uploadFileType3 = doc.getElementById("uploadFileType3");
        Elements options = uploadFileType3.getElementsByTag("option");
        options.stream().forEach(element -> {
            System.out.println(element.val());
            System.out.println(element.text());

        });
        System.out.println(444);
        Map<String,Object> pathMap = new LinkedHashMap<>();
        pathMap.put("111","1111");
        pathMap.put("222","2222");
        pathMap.put("aaa","aaaa");
        String join = Joiner.on("/").join(pathMap.values()).concat("/");
        System.out.println(join);


        //Element baseDiv = doc.getElementById("base_ifno");
        //Element firstTable = baseDiv.select("table").first();
        //String accidentProposeCode = firstTable.select("tr:eq(1) td:eq(1)").text();
        //String accidentPolicyCode = firstTable.select("tr:eq(2) td:eq(1)").text();
        //String accidentPremium = firstTable.select("[name=premium]").val();
        //String product = doc.select("#productCode").select("[selected]").text();
        //String disputedSettleMode = firstTable.select("[name=disputedSettleMode]").get(0).child(0).text();
        //String totalAgreePremium = doc.select("[name=totalAgreePremium]").val();
        //String totalRatio =doc.select("name=totalRatio").val();
        //String startDate = doc.select("#startDate").val();
        //String endDate = doc.select("#endDate").val();
        //String paymentBeginDateString = doc.select("name=paymentBeginDateString").val();
        //String paymentEndDateString = doc.select("paymentEndDateString").val();
        //String paymentModeChinese = doc.select("name=paymentMode").get(0).child(0).text();
        //String paymentMode = doc.select("name=paymentMode").get(0).child(0).val();
        //Elements select = doc.select(":containsOwnText(短期系数)");

    }
}
