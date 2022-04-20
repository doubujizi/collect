package com.dou.tfx.prefect.test;

import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Comparator;
import java.util.stream.Stream;

/**
 * @author tianfuxian
 * @Description:
 * @Date: 2021/6/22 3:19 下午
 */
public class TestDelete {
    void testDeleteFileDir6() throws IOException {
        Path path = Paths.get("D:\\data\\test1\\test2");

        try (Stream<Path> walk = Files.walk(path)) {
            walk.sorted(Comparator.reverseOrder())
                    .forEach(TestDelete::deleteDirectoryStream);
        }

    }

    private static void deleteDirectoryStream(Path path) {
        try {
            Files.delete(path);
            System.out.printf("删除文件成功：%s%n",path.toString());
        } catch (IOException e) {
            System.err.printf("无法删除的路径 %s%n%s", path, e);
        }
    }

    public static void main(String[] args) {
        Path pwd = Paths.get("").toAbsolutePath();
        System.out.println(111);
        URL resource = Thread.currentThread().getContextClassLoader().getResource("");
        System.out.println(111);
    }
}
