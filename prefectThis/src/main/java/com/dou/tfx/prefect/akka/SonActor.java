package com.dou.tfx.prefect.akka;

import akka.actor.ActorRef;
import akka.actor.UntypedAbstractActor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * @author tianfuxian
 * @Description:
 * @Date: 2022/10/13 14:46
 */
@Slf4j
@Component("SonActor")
@Scope("prototype")
public class SonActor extends UntypedAbstractActor {
    @Autowired
    private SpringExt springExt;

    @Override
    public void onReceive(Object message) throws Exception {
        if ("1".equals(message)) {
            System.out.println(1111);
            ActorRef sonActor = context().actorOf(springExt.props("ProcessActor"), "SonActor" + System.currentTimeMillis());
            sonActor.tell("1", self());
        } else if ("2".equals(message)) {
            System.out.println(22222);
        } else {
            unhandled(message);
        }
    }

    @Override
    public void preStart() throws Exception {
        log.info("公司窗口启动");
        super.preStart();
    }

    @Override
    public void postStop() throws Exception {
        log.info("公司窗口停止");
        super.postStop();
    }
}
