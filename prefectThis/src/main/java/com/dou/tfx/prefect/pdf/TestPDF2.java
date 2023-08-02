package com.dou.tfx.prefect.pdf;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.text.PDFTextStripper;
import org.apache.pdfbox.text.PDFTextStripperByArea;

import java.io.File;
import java.io.IOException;

/**
 * @author tianfuxian
 * @Description:
 * @Date: 2023/3/16 10:07
 */
public class TestPDF2 {
    public static void main(String[] args) throws IOException {
        File file = new File("/Users/tianfuxian/Downloads/AFUZI31CTP23B002423G_LS502966.pdf");
        PDDocument document = PDDocument.load(file);
        PDFTextStripper stripper = new PDFTextStripper();
        String text = stripper.getText(document);
        //System.out.println(text);

        PDFTextStripperByArea stripperByArea = new PDFTextStripperByArea();
        stripperByArea.setSortByPosition(true);
        PDPage firstPage = document.getPage(0);
        stripperByArea.addRegion("regionName", new java.awt.Rectangle(10, 10, 100, 100));
        stripperByArea.extractRegions(firstPage);
        String textByArea = stripperByArea.getTextForRegion("regionName");
        System.out.println(textByArea);

        document.close();
    }
}
