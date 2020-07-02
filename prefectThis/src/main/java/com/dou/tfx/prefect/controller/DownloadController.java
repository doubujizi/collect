package com.dou.tfx.prefect.controller;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * @author tianfuxian
 * @Description:
 * @Date: 2020/6/24 15:14
 */
@RestController
@RequestMapping("/download")
public class DownloadController {
    @GetMapping("/file")
    public void findFile(HttpServletResponse response) throws IOException {
        ServletOutputStream out = null;
        FileInputStream ips = null;
        try {
            //此处为业务需要  如果是测试可以指定路径
            Resource resource = new ClassPathResource("static/WMS-master.zip");
            //获取文件存放的路径
            File file = resource.getFile();
            //获取到文字 数据库里对应的附件名字加上老的文件名字：filename 截取到后面的文件类型 例：txt  组成一个新的文件名字：newFileName
            String newFileName = "百川浏览器插件.zip";
            if (!file.exists()) {
                //如果文件不存在就跳出
                return;
            }
            ips = new FileInputStream(file);
            response.setContentType("multipart/form-data");
            //为文件重新设置名字，采用数据库内存储的文件名称
            response.addHeader("Content-Disposition", "attachment; filename=\"" + new String(newFileName.getBytes("UTF-8"), "ISO8859-1") + "\"");
            response.addHeader("Content-Type","application/zip"); //zip格式的
            response.addHeader("Content-Transfer-Encoding","binary"); //告诉浏览器，这是二进制文件
            out = response.getOutputStream();
            //读取文件流
            int len;
            byte[] buffer = new byte[1024 * 10];
            while ((len = ips.read(buffer)) != -1) {
                out.write(buffer, 0, len);
            }
            out.flush();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                out.close();
                ips.close();
            } catch (IOException e) {
                System.out.println("关闭流出现异常");
                e.printStackTrace();
            }
        }

        return;
    }
}
