package pl.jkanclerz.credit;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class HelloController {

    private Greeter greeter;

    public HelloController(Greeter greeter) {
        this.greeter = greeter;
    }

    @GetMapping("/hello")
    String hello() {
        return "Hello World";
    }

    @GetMapping("/people")
    List<String> people() {
        return Arrays.asList("Kuba", "Michał", "Aga", "Kasia")
                .stream()
                .map(name -> greeter.hello(name))
                .collect(Collectors.toList());
    }
}
