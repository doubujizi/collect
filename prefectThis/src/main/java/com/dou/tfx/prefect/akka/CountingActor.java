package com.dou.tfx.prefect.akka;

import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.actor.Props;
import akka.actor.UntypedAbstractActor;
import com.dou.tfx.prefect.service.CountingService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author tianfuxian
 * @Description:
 * @Date: 2022/10/12 16:31
 */
@Component("CountingActor")
@Scope("prototype")
@Slf4j
public class CountingActor extends UntypedAbstractActor {

    // the service that will be automatically injected
    @Autowired
    private CountingService countingService;
    @Autowired
    private ActorSystem actorSystem;

    @Autowired
    private SpringExt springExt;

    private int count = 0;

    @Override
    public void onReceive(Object message) throws Exception {
        System.out.println(message);
        if ("1".equals(message)) {
            count = countingService.increment(count);
            List<String> collect = Stream.of("1", "2", "3", "4").collect(Collectors.toList());
            collect.forEach(s->{
                ActorRef sonActor = context().actorOf(springExt.props("SonActor"), "SonActor" + s);
                sonActor.tell("1", self());
            });

        } else if ("2".equals(message)) {
            self().tell(count, ActorRef.noSender());
        } else {
            unhandled(message);
        }
    }

    @Override
    public void preStart() throws Exception {
        log.info("累加窗口启动");
        super.preStart();
    }

    @Override
    public void postStop() throws Exception {
        log.info("公司窗口停止");
        super.postStop();
    }
}
