package com.dou.tfx.prefect.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @author tianfuxian
 * @Description:
 * @Date: 2022/10/12 16:29
 */
@Service
@Slf4j
public class CountingService {
    public int increment(int count) {
        log.info("increase " + count + "by 1.");
        return count + 1;
    }
}
