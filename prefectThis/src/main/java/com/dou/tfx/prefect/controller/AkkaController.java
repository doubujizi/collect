package com.dou.tfx.prefect.controller;

import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.util.Timeout;
import com.dou.tfx.prefect.akka.CountingActor;
import com.dou.tfx.prefect.akka.SpringExt;
import com.dou.tfx.prefect.service.CountingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import scala.concurrent.Await;
import scala.concurrent.duration.FiniteDuration;

import java.util.concurrent.TimeUnit;

/**
 * @author tianfuxian
 * @Description:
 * @Date: 2022/10/12 16:36
 */
@RestController
@RequestMapping("/akka")
public class AkkaController {
    @Autowired
    private ActorSystem actorSystem;

    @Autowired
    private SpringExt springExt;

    @GetMapping("a")
    public String aaa(){
        ActorRef counter = actorSystem.actorOf(springExt.props("CountingActor"), "counter"+System.currentTimeMillis());
        counter.tell("1", ActorRef.noSender());

        return "";
    }
    @GetMapping("b")
    public String bbb(){
        ActorRef counter = actorSystem.actorOf(springExt.props("CountingActor"), "counter"+System.currentTimeMillis());
        counter.tell("2", ActorRef.noSender());
        return "";
    }

}
