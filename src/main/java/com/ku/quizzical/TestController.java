package com.ku.quizzical;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public final class TestController {

    @GetMapping("/test")
    public String test() {
        return "Test";
    }
}
