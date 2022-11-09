package net.jfuentes.springsessionredis;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

import java.io.Serializable;

@Component
@SessionScope
public class Counter implements Serializable {

    private Integer value = 0;

    public Integer incrAndGet() {
        this.value++;
        return this.value;
    }

}
