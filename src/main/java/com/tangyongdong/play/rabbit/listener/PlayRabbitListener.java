package com.tangyongdong.play.rabbit.listener;

import com.alibaba.fastjson.JSON;
import com.tangyongdong.play.rabbit.dto.EntityDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @author tangyongdong
 * @create 2018-05-09 19:18
 */
@Component
@Slf4j
public class PlayRabbitListener {

    @RabbitListener(queues = "rabbit_hello")
    public void hello(String id) {
        log.info("hello message : {}", id);
    }

    @RabbitListener(queues = "rabbit_work")
    public void workA(String id){
        log.info("workA message : {}", id);
    }

    @RabbitListener(queues = "rabbit_work")
    public void workB(String id){
        log.info("workB message : {}", id);
    }

    @RabbitListener(queues = "rabbit_entity")
    public void entity(EntityDTO dto){
        log.info("entity message : {}", JSON.toJSONString(dto));
    }

    @RabbitListener(queues = "rabbit_fanout_a")
    public void fanoutA(String id){
        log.info("fanoutA message : {}", id);
    }

    @RabbitListener(queues = "rabbit_fanout_b")
    public void fanoutB(String id){
        log.info("fanoutB message : {}", id);
    }

    @RabbitListener(queues = "rabbit_fanout_c")
    public void fanoutC(String id){
        log.info("fanoutC message : {}", id);
    }

    @RabbitListener(queues = "red.topic.a")
    public void redTopicA(String id){
        log.info("redTopicA message : {}", id);
    }

    @RabbitListener(queues = "red.topic.b")
    public void redTopicB(String id){
        log.info("redTopicB message : {}", id);
    }

    @RabbitListener(queues = "blue.topic.a")
    public void blueTopicA(String id){
        log.info("blueTopicA message : {}", id);
    }
}
