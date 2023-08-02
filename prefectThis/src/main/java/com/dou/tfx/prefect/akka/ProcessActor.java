package com.dou.tfx.prefect.akka;

import akka.actor.UntypedAbstractActor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * @author tianfuxian
 * @Description:
 * @Date: 2022/10/13 17:58
 */
@Slf4j
@Component("ProcessActor")
@Scope("prototype")
public class ProcessActor extends UntypedAbstractActor {
    @Override
    public void onReceive(Object message) throws Exception {
        if ("1".equals(message)) {
            System.out.println(33333);
        } else if ("2".equals(message)) {
            System.out.println(44444);
        } else {
            unhandled(message);
        }
    }

    @Override
    public void preStart() throws Exception {
        log.info("逻辑窗口启动");
        super.preStart();
    }

    @Override
    public void postStop() throws Exception {
        log.info("公司窗口停止");
        super.postStop();
    }
}
