package com.dou.tfx.prefect.test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Enumeration;
import java.util.zip.ZipInputStream;

import org.apache.tools.ant.BuildException;
import org.apache.tools.ant.Project;
import org.apache.tools.ant.taskdefs.Expand;
import org.apache.tools.zip.ZipEntry;
import org.apache.tools.zip.ZipFile;

/**
 * @author tianfuxian
 * @Description:
 * @Date: 2021/6/21 11:56 上午
 */
public class TestZip {
    public final static String encoding = "GBK";

    public static void unzip(String zipFilepath, String destDir) throws BuildException, RuntimeException {
        if (!new File(zipFilepath).exists()) {
            throw new RuntimeException("zip file " + zipFilepath + " does not exist.");
        }

        Project proj = new Project();
        Expand expand = new Expand();
        expand.setProject(proj);
        expand.setTaskType("unzip");
        expand.setTaskName("unzip");
        expand.setEncoding(encoding);

        expand.setSrc(new File(zipFilepath));
        expand.setDest(new File(destDir));
        expand.execute();

        System.out.println("uncompress successed.");
    }

    public static void main(String[] args) throws Exception {
        //被解压的压缩文件
        String fileZip = "src/main/resources/unzipTest/LSCABN3E4JE268126.zip";
        //解压的目标目录
        String destDir = "src/main/resources/unzipTest";
        TestZip.unzip(fileZip, destDir);


        //String s = printZipTxt("src/main/resources/unzipTest/LSCABN3E4JE268126.zip");
        System.out.println(111);
    }

    public static String printZipTxt(String zipPath) throws IOException {
        String mFileName = "";
        String mFileChange = "";
        ZipFile zipFile = new ZipFile(zipPath);
        for (Enumeration<? extends ZipEntry> e = zipFile.getEntries(); e.hasMoreElements(); ) {
            ZipEntry entry = e.nextElement();
            System.out.println("保单文件名:" + entry.getName() + ", 内容如下:");
            if (entry.getName().toLowerCase().endsWith(".pdf")) {
                mFileName = entry.getName();
                System.out.println(mFileName.substring(mFileName.lastIndexOf("/") + 1, mFileName.lastIndexOf(".")));
                mFileChange += mFileName.substring(mFileName.lastIndexOf("/") + 1, mFileName.lastIndexOf(".")) + "\n";
            }
        }
        System.out.println("拼接后的文件名称为：" + mFileChange);
        return mFileChange;

    }


}

