
package com.palhotel.sweet_shop_backend;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController // Tells Spring that this class will handle web requests
public class HomeController {

    @GetMapping("/") // Maps this method to the root URL (like your homepage)
    public String sayHello() {
        return "Hello World from Pal Hotel!";
    }

}