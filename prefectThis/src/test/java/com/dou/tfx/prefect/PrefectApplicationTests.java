package com.dou.tfx.prefect;

import com.dou.tfx.prefect.algorithm.BinarySearchTest;
import com.dou.tfx.prefect.service.TestDataSourceService;
import com.dou.tfx.prefect.service.TestTransactionalService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PrefectApplicationTests {
    @Autowired
    private TestTransactionalService testTransactionalService;
    @Autowired
    private TestDataSourceService testDataSourceService;

    @Test
    public void contextLoads() {
        int [] aaa= {0,1,2,3,4,5,6,7,8,9};
        BinarySearchTest binarySearchTest = new BinarySearchTest();
        int i = binarySearchTest.binarySearch(aaa, 8);
        System.out.println(aaa[i]);
    }

}
