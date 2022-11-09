package net.jfuentes.springsessionredis;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@Slf4j
public class DemoController {

    private final Counter counterBean;

    @Value("${nodeName}")
    private String nodeName;

    public DemoController(Counter counterBean) {
        this.counterBean = counterBean;
    }


    @GetMapping("/")
    public String demo(HttpSession session, Model m) {
        log.info("[m:demo] Running in node: {}", nodeName);

        // VALOR COMO ATRIBUTO DE LA HTTP-SESSION
        Integer counter = (Integer) session.getAttribute("counter");
        if (counter == null) {
            counter = 0;
        }
        counter++;
        session.setAttribute("counter", counter);
        m.addAttribute("counter", counter);

        // VALOR GUARDADO EN UN BEAN CON SESSION-SCOPE
        m.addAttribute("counterValue", this.counterBean.incrAndGet());


        // VALOR RECOGIDO DE LA CONFIGURACIÓN
        m.addAttribute("nodeName", this.nodeName);

        return "demo";
    }
}
