package net.jfuentes.springsession;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

@Component
@SessionScope
public class Counter {

    private Integer value = 0;

    public Integer incrAndGet() {
        this.value++;
        return this.value;
    }

}
