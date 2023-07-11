package com.leo.fly.websocket;

import com.leo.fly.common.entity.vo.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/test")
public class TestController {
    @Autowired
    WebSocketServer server;
    @GetMapping(value = "/{id}")
    public JsonResult get(@PathVariable String id) {
        //log.debug("get with id:{}", id);
        server.sendMessageTo(id,"say hello");
        return JsonResult.success();
    }
}
