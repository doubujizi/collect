package com.dou.tfx.prefect.pdf;

import lombok.SneakyThrows;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.text.PDFTextStripper;

import java.io.File;
import java.time.LocalDateTime;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static java.util.regex.Pattern.*;

/**
 * @author tianfuxian
 * @Description:
 * @Date: 2023/3/15 11:04
 */
public class TestPDF {
    @SneakyThrows
    public static void main(String[] args) {
        File file = new File("/Users/tianfuxian/Downloads/太保交强2.pdf");
        PDDocument document = PDDocument.load(file);
        PDPage page = document.getPage(0);
        PDPage page1 = document.getPage(1);
        PDDocument mergedDoc = new PDDocument();
        mergedDoc.addPage(page);
        mergedDoc.addPage(page1);
        PDFTextStripper pdfStripper = new PDFTextStripper();
        //pdfStripper.setSortByPosition(true);
        String text = pdfStripper.getText(document).replace("福清市广川办公设备有限公司", "车与车科技(香港)有限公司");


        System.out.println(text);
        document.close();
        mergedDoc.close();
        TestPDF testPDF = new TestPDF();
        //testPDF.aaa(text,"保险单号：([a-zA-z0-9]{20,20})");
        //System.out.println(testPDF.aaa(text,"保险单号：([a-zA-z0-9]{20,20})"));
        //System.out.println(testPDF.aaa(text,"被保险人：([\\u4e00-\\u9fa5]+)"));
        //System.out.println(testPDF.aaa(text,"手机号：(1[0-9]+.*[0-9]+)"));
        //System.out.println(testPDF.aaa(text,"证件类型：([\\u4e00-\\u9fa5]+)"));
        //System.out.println(testPDF.aaa(text,"证件号：([a-zA-z0-9]+)"));
        //System.out.println(testPDF.aaa(text,"地址：([\\u4e00-\\u9fa5]+)"));
        //System.out.println(testPDF.aaa(text,"车主：([\\u4e00-\\u9fa5]+)"));
        //System.out.println(testPDF.aaa(text,"投保人：([\\u4e00-\\u9fa5]+)"));
        //System.out.println(testPDF.aaa(text,"号牌号码 ([\\u4e00-\\u9fa5]+)"));
        //System.out.println(testPDF.aaa(text,"厂牌型号\\s([\\w\\u4e00-\\u9fa5]+\\s[\\w\\u4e00-\\u9fa5]+)").replace("\n", ""));
        //System.out.println(testPDF.aaa(text,"初次登记日期\\s([0-9]+/[0-9]+/[0-9]+)").replaceAll("/","-"));
        //System.out.println(testPDF.aaa(text,"能源.*种类\\s([\\u4e00-\\u9fa5]+)"));
        //System.out.println(testPDF.aaa(text,"发动机号\\s([a-zA-z0-9]+)"));
        //System.out.println(testPDF.aaa(text,"VIN码/车架号\\s([a-zA-z0-9]+)"));
        //System.out.println(testPDF.aaa(text,"机动车种类\\s([0-9\\u4e00-\\u9fa5]+)"));
        //System.out.println(testPDF.aaa(text,"使用性质\\s([\\u4e00-\\u9fa5]+)"));
        //System.out.println(testPDF.aaa(text,"核定载质量\\s(.*)千克"));
        //System.out.println(testPDF.aaa(text,"核定载客\\s([0-9])[\\u4e00-\\u9fa5]"));
        //System.out.println(testPDF.aaa(text,"新能源车损失险\\s([0-9]+)[\\u4e00-\\u9fa5]"));
        //System.out.println(testPDF.aaa(text,"新能源车损失险\\s[0-9]+[\\u4e00-\\u9fa5]\\s+([0-9\\.]+)"));
        //System.out.println(testPDF.aaa(text,"第三者责任保险\\s([0-9]+)[\\u4e00-\\u9fa5]"));
        //System.out.println(testPDF.aaa(text,"第三者责任保险\\s[0-9]+[\\u4e00-\\u9fa5]\\s+([0-9\\.]+)"));
        //System.out.println(testPDF.aaa(text,"车上司机责任险\\s([0-9]+)[\\u4e00-\\u9fa5]"));
        //System.out.println(testPDF.aaa(text,"车上司机责任险\\s[0-9]+[\\u4e00-\\u9fa5]\\s+([0-9\\.]+)"));
        //System.out.println(testPDF.aaa(text,"车上乘客责任险\\s([0-9]+)[\\u4e00-\\u9fa5]"));
        //System.out.println(testPDF.aaa(text,"车上乘客责任险\\s([0-9]+)[\\u4e00-\\u9fa5]"));
        ////乘客险价格
        //System.out.println(testPDF.aaa(text,"车上乘客责任险\\s[0-9]+[\\u4e00-\\u9fa5]×\\s+[0-9]座\\s+([0-9\\.]+)"));
        //System.out.println(testPDF.aaa(text,"道路救援增值服务特约条款\\s([0-9]+)[\\u4e00-\\u9fa5]"));
        //System.out.println(testPDF.aaa(text,"道路救援增值服务特约条款\\s[0-9]+[\\u4e00-\\u9fa5]\\s+([0-9\\.]+)"));
        //System.out.println(testPDF.aaa(text,"外部电网故障损失险\\s+([0-9\\.]+)"));
        //System.out.println(testPDF.aaa(text,"保险费合计.*￥：([0-9\\.]+)"));
        //System.out.println(testPDF.aaa(text,"保单生成时间：([0-9]+/[0-9]+/[0-9]+ [0-9]+:[0-9]+:[0-9]+)").replaceAll("/","-"));
        ////保险期间：2023 年 3 月 2 日 00:00 时起至 2024 年 3 月 1 日 24:00 时止

        //（\d+\.\d{2}）


        //交强
        //System.out.println(testPDF.aaa(text,"保单生成时间：([0-9]+/[0-9]+/[0-9]+ [0-9]+:[0-9]+:[0-9]+)").replaceAll("/","-"));
        //System.out.println(testPDF.aaa(text,"(\\w+)保险单号："));
        //System.out.println(testPDF.aaa(text, "被\\s+保\\s+险\\s+人\\s([\\u4e00-\\u9fa5\\(\\)（）\\da-zA-Z&]{2,50})"));
        //System.out.println(testPDF.aaa(text,"被保险人身份.*\\s(\\w+)"));
        //System.out.println(testPDF.aaa(text,"地\\s+址\\s([\\u4e00-\\u9fa5\\(\\)（）\\da-zA-Z&]{2,50})"));
        //System.out.println(testPDF.aaa(text,"联\\s+系\\s+电\\s+话\\s+(1[0-9]+.*[0-9]+)"));
        //System.out.println(testPDF.aaa(text,"号\\s+牌\\s+号\\s+码\\s+([\\w\\u4e00-\\u9fa5]+)"));
        //System.out.println(testPDF.aaa(text,"机动车种类\\s+([\\w\\u4e00-\\u9fa5]+)"));
        //System.out.println(testPDF.aaa(text,"使\\s+用\\s+性\\s+质\\s+([\\w\\u4e00-\\u9fa5]+)"));
        //System.out.println(testPDF.aaa(text,"发动机号码\\s+([\\w]+)"));
        //System.out.println(testPDF.aaa(text,"识别代码\\(车架号\\)\\s+([\\w]+)"));
        System.out.println(testPDF.aaa(text,"厂\\s+牌\\s+型\\s+号\\s(.*\\s.*)").replace("\n", ""));
        //System.out.println(testPDF.aaa(text,"核定载质量\\s([0-9\\.]+)[\\u4e00-\\u9fa5]+"));
        //System.out.println(testPDF.aaa(text,"核\\s+定\\s+载\\s+客\\s([0-9])[\\u4e00-\\u9fa5]"));
        //System.out.println(testPDF.aaa(text,"排\\s+量\\s+([0-9\\.]+)\\sL"));
        //System.out.println(testPDF.aaa(text,"功\\s+率\\s+([0-9]+)KW"));
        //System.out.println(testPDF.aaa(text,"登\\s+记\\s+日\\s+期\\s([0-9]+/[0-9]+/[0-9]+)").replaceAll("/","-"));
        //System.out.println(testPDF.aaa(text,"保险费合计.*（￥：([0-9\\.]+)"));
        //System.out.println(testPDF.aaa(text,"保险期间自([0-9]+年[0-9]+月[0-9]+日[0-9]+:[0-9]+时)"));
        //System.out.println(testPDF.aaa(text,"保险合同争议解决方式\\s([\\u4e00-\\u9fa5]+)"));
        //System.out.println(testPDF.aaa(text,"仲裁机构：([\\u4e00-\\u9fa5]+)"));
        //System.out.println(testPDF.aaa(text,"整备质量\\s([0-9\\.]+)\\w+"));
        //System.out.println(testPDF.aaa(text,"纳税人识别号\\s(\\w+)"));
        //System.out.println(testPDF.aaa(text,"开具税务机关\\s([\\u4e00-\\u9fa5]+)"));
        //System.out.println(testPDF.aaa(text,"当年应缴 ￥([0-9\\.]+)"));

        //非车
        //System.out.println(testPDF.aaa(text, "保险单号:(\\w+)"));
        //System.out.println(testPDF.aaa(text, "投保人名称：([\\u4e00-\\u9fa5\\(\\)（）\\da-zA-Z&]{2,50})"));
        //System.out.println(testPDF.aaa(text, "证件号码：(\\w+)"));
        //System.out.println(testPDF.aaa(text, "投保人手机号码：\\s+(1[0-9]+)"));
        //System.out.println(testPDF.aaa(text, "电子邮箱（E-mail）：([a-zA-Z0-9]+@[a-zA-Z0-9]+\\.[a-zA-Z0-9]+)"));
        //System.out.println(testPDF.aaa(text, "购买份数：([0-9]+)"));
        //System.out.println(testPDF.aaa(text, "RMB: ￥([0-9\\.]+)"));


    }


    public String aaa(String text, String regex) {
        Pattern p = compile(regex);
        Matcher m = p.matcher(text);
        String result = "";
        while (m.find()) {
            System.out.println(m.group());
            result = m.group(1);
        }
        return result;
    }

}
