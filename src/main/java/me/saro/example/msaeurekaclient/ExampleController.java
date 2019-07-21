package me.saro.example.msaeurekaclient;

import com.netflix.discovery.EurekaClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Lazy;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ExampleController {

    @Autowired
    @Lazy
    private EurekaClient eurekaClient;

    @Value("${spring.application.name}")
    private String appName;

    String id;

    String getId() {
        if (id == null) {
            id = Integer.toString ((int)(Math.random() * 1000));
        }
        return id;
    }

    @GetMapping("/hello")
    String hello() {
        System.out.println("call " + id);
        return "hello, i am from " + eurekaClient.getApplication(appName).getName() + " : " + getId();
    }

//    @RequestMapping("/health")
//    public String health() {
//        System.out.println("헬스체크");
//        return "OK";
//    }
}
