package com.ku.quizzical;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
public final class TestController {

    @GetMapping("/test")
    public String test() {
        return "\"Test\"";
    }
}
