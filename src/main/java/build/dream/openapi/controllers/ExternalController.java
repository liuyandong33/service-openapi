package build.dream.openapi.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.UUID;

@Controller
@RequestMapping(value = "/external")
public class ExternalController {
    @RequestMapping(value = "/index")
    @ResponseBody
    public String index() {
        return UUID.randomUUID().toString();
    }
}
