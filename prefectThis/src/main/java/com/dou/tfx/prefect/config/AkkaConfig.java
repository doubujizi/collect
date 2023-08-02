package com.dou.tfx.prefect.config;

import akka.actor.ActorSystem;
import com.dou.tfx.prefect.akka.SpringExt;
import com.typesafe.config.Config;
import com.typesafe.config.ConfigFactory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author tianfuxian
 * @Description:
 * @Date: 2022/10/12 16:42
 */
@Configuration
@Slf4j
public class AkkaConfig {
    @Autowired
    private SpringExt springExtension;
    @Bean
    public ActorSystem actorSystem() {
        String akkaPath="akka.conf";
        //创建akka系统
        log.info("加载akka配置,路径:{}",akkaPath);
        Config config = ConfigFactory.load(akkaPath);
        log.info("ActorSystem 初始化...");
        log.info("akka.default-dispatcher 初始化参数 parallelism-min:{}",config.getInt("akka.actor.default-dispatcher.fork-join-executor.parallelism-min"));
        log.info("akka.default-dispatcher 初始化参数 parallelism-factor:{}",config.getInt("akka.actor.default-dispatcher.fork-join-executor.parallelism-factor"));
        log.info("akka.default-dispatcher 初始化参数 parallelism-max:{}",config.getInt("akka.actor.default-dispatcher.fork-join-executor.parallelism-max"));
        ActorSystem actorSystem = ActorSystem.create("test-project", config);
        actorSystem.actorOf(springExtension.props("CountingActor"), "CountingActorZ");
        return actorSystem;
    }
}
