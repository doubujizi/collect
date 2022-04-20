package com.dou.tfx.prefect.test;

import java.io.*;
import java.util.Enumeration;
import java.util.zip.InflaterInputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

/**
 * @author tianfuxian
 * @Description:
 * @Date: 2021/6/21 1:59 下午
 */
public class TestZip1 {
    /**
     *
     * @param input Zip文件的流
     * @throws Exception
     */
    public void upload(InputStream input,String destPath) throws Exception {

        ZipInputStream zis = new ZipInputStream(input);
        java.util.zip.ZipEntry entry = null;
        while ((entry = zis.getNextEntry()) != null) {
            // System.out.printf("条目信息： 名称%1$b, 大小%2$d, 压缩时间%3$d \n",
            // entry.getName(), entry.getSize(), entry.getTime());
            if (entry.isDirectory()) { // is dir
                // System.out.println(entry.getName() + "是一个目录");
                File f = new File(destPath + File.separator + entry.getName());
                if (!f.exists())
                    f.mkdirs();
            } else { //
                byte[] data = getByte(zis); // 获取当前条目的字节数组
                InputStream is = new ByteArrayInputStream(data); // 把当前条目的字节数据转换成Inputstream流
                String[] names = entry.getName().split("/");
                String path = destPath + File.separator;
                path += join(names, File.separator);
                //System.out.println(path);
                File file = new File(path);
                if (!file.exists()) {
                    file.createNewFile();
                    toWrite(is, file);
                }
            }
        }
    }
    /**
     * 向file文件写入字节
     * @param ins
     * @param file
     */
    public static void toWrite(InputStream ins, File file) {
        try {
            OutputStream os = new FileOutputStream(file);
            int bytesRead = 0;
            byte[] buffer = new byte[8192];
            while ((bytesRead = ins.read(buffer, 0, 8192)) != -1) {
                os.write(buffer, 0, bytesRead);
            }
            os.close();
            ins.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 获取条目byte[]字节
     * @param zis
     * @return
     */
    public byte[] getByte(InflaterInputStream zis) {
        try {
            ByteArrayOutputStream bout = new ByteArrayOutputStream();
            byte[] temp = new byte[1024];
            byte[] buf = null;
            int length = 0;

            while ((length = zis.read(temp, 0, 1024)) != -1) {
                bout.write(temp, 0, length);
            }

            buf = bout.toByteArray();
            bout.close();
            return buf;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static String join(Object[] o, String flag) {
        StringBuffer str_buff = new StringBuffer();

        for (int i = 0, len = o.length; i < len; i++) {
            str_buff.append(String.valueOf(o[i]));
            if (i < len - 1)
                str_buff.append(flag);
        }

        return str_buff.toString();
    }

    public static void main(String[] args) throws Exception {
        TestZip1 test = new TestZip1();
        String filePath = "src/main/resources/unzipTest/LSCABN3E4JE268126.zip";
        // File file = new File(filePath);
        InputStream input = new BufferedInputStream(new FileInputStream(filePath));
        test.upload(input,"src/main/resources/unzipTest");
    }


}
