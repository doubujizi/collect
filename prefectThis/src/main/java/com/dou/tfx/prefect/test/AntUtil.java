package com.dou.tfx.prefect.test;


import org.apache.tools.tar.TarEntry;
import org.apache.tools.tar.TarInputStream;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.GZIPInputStream;

/**
 * @author tianfuxian
 * @Description:
 * @Date: 2021/6/29 11:25 上午
 */
public class AntUtil {
    /**
     * * 解压tar.gz 文件
     * * @param file 要解压的tar.gz文件对象
     * * @param outputDir 要解压到某个指定的目录下
     * * @throws IOException
     */
    public static void unTarGz(File file, String outputDir) throws IOException {
        TarInputStream tarIn = null;
        try {
            tarIn = new TarInputStream(new GZIPInputStream(
                    new BufferedInputStream(new FileInputStream(file))),
                    1024 * 2);
            //创建输出目录
            createDirectory(outputDir, null);

            TarEntry entry = null;
            while ((entry = tarIn.getNextEntry()) != null) {
                //是目录
                if (entry.isDirectory()) {
                    entry.getName();
                    //创建空目录
                    createDirectory(outputDir, entry.getName());
                } else {//是文件
                    File tmpFile = new File(outputDir + "/" + entry.getName());
                    createDirectory(tmpFile.getParent() + "/", null);//创建输出目录
                    OutputStream out = null;
                    try {
                        out = new FileOutputStream(tmpFile);
                        int length = 0;

                        byte[] b = new byte[2048];

                        while ((length = tarIn.read(b)) != -1) {
                            out.write(b, 0, length);
                        }

                    } catch (IOException ex) {
                        throw ex;
                    } finally {
                        if (out != null)
                            out.close();
                    }
                }
            }
        } catch (IOException ex) {
            throw new IOException("解压归档文件出现异常", ex);
        } finally {
            try {
                if (tarIn != null) {
                    tarIn.close();
                }
            } catch (IOException ex) {
                throw new IOException("关闭tarFile出现异常", ex);
            }
        }
    }

    //解压文件
    public static void getAllFileName(String targetDir,String lastDir) {
        Path paths = Paths.get(targetDir);
        try {
            Files.list(paths).forEach(path -> {
                try {
                    unTarGz(path.toFile(), lastDir);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //移动文件
    public static void moveAllFile(String targetDir, String firstDir,String secondDir,String thirdDir) throws Exception {
        Path paths = Paths.get(targetDir);
        List<Path> pathList = new ArrayList<>();
        List<Path> detailsList = new ArrayList<>();
        Files.list(paths).filter(path ->
                Files.isDirectory(path)
        ).forEach(path -> {
            try {
                Files.list(path).filter(p -> {
                    if (p.toString().contains(".zip")) {
                        return true;
                    } else {
                        pathList.add(p);
                        return false;
                    }
                })
                        .forEach(p -> {
                            try {
                                Files.move(p,Paths.get(firstDir+"/"+p.getFileName().toString()), StandardCopyOption.REPLACE_EXISTING);
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        });
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        pathList.stream().filter(path -> {
            if(path.getFileName().toString().contains("_list")){
                return true;
            }else {
                detailsList.add(path);
                return false;
            }
        })
                .forEach(path -> {
                    try {
                        Files.move(path,Paths.get(secondDir+"/"+path.getFileName().toString()),StandardCopyOption.REPLACE_EXISTING);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                });
        detailsList.forEach(path -> {
            try {
                Files.move(path,Paths.get(thirdDir+"/"+path.getFileName().toString()),StandardCopyOption.REPLACE_EXISTING);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

    }

    /**
     * * 构建目录
     * * @param outputDir
     * * @param subDir
     */
    public static void createDirectory(String outputDir, String subDir) {
        File file = new File(outputDir);
        //子目录不为空
        if (!(subDir == null || "".equals(subDir.trim()))) {
            file = new File(outputDir + "/" + subDir);
        }
        if (!file.exists()) {
            if (!file.getParentFile().exists()) {
                file.getParentFile().mkdirs();
            }
            file.mkdirs();
        }
    }

    public static void main(String[] args) throws Exception {
        //将.tar.gz文件解压缩
        //AntUtil.getAllFileName("/Users/tianfuxian/Documents/testZip","/Users/tianfuxian/Documents/testZip/testT");
        // 将.zip .csv 文件分类
        AntUtil.moveAllFile("/Users/tianfuxian/Documents/testZip/testT", "/Users/tianfuxian/Documents/testZip/testZ","/Users/tianfuxian/Documents/testZip/testList","/Users/tianfuxian/Documents/testZip/testD");

    }
}

