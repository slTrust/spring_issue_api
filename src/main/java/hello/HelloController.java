package hello;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
public class HelloController {

    @RequestMapping("/")
    public String index() {
        return "Greetings from Spring Boot!";
    }

    @RequestMapping("/search")
    public String search(@RequestParam String q) {
        //  localhost:8080/search?q=123 时
        System.out.println(q);
        return "search query word is:" + q;
    }

    @RequestMapping("/search2")
    public String search2(@RequestParam String q ,
                          @RequestParam(value="charset",required = false) String charset) {

        return "search query word is:" + q + ",and charset is :" + charset;
    }



}