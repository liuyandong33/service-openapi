package build.dream.openapi.controllers;

import build.dream.common.constants.Constants;
import build.dream.common.utils.ConfigurationUtils;
import build.dream.common.utils.RocketMQUtils;
import com.aliyun.openservices.ons.api.Message;
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
        Message message = new Message();
        message.setTopic(ConfigurationUtils.getConfiguration("delayed.or.timed.rocket.mq.topic"));
        message.setBody(UUID.randomUUID().toString().getBytes(Constants.CHARSET_UTF_8));
        message.setStartDeliverTime(System.currentTimeMillis() + 30000);
        RocketMQUtils.send(message);
        return Constants.SUCCESS;
    }
}
