package build.dream.openapi.controllers;

import build.dream.common.api.ApiRest;
import build.dream.common.utils.ApplicationHandler;
import build.dream.common.utils.GsonUtils;
import build.dream.common.utils.WebSecurityUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;
import java.util.UUID;

@Controller
@RequestMapping(value = "/login")
public class LoginController {
    @RequestMapping(value = "/index")
    public String index() {
        return "login/index";
    }

    @RequestMapping(value = "/login")
    @ResponseBody
    public String login() {
        Map<String, String> requestParameters = ApplicationHandler.getRequestParameters();
        String loginName = requestParameters.get("loginName");
        WebSecurityUtils.authorize(loginName);

        return GsonUtils.toJson(new ApiRest());
    }

    @RequestMapping(value = "/success")
    public String success() {
        return "login/success";
    }
}
