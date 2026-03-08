package com.atguigu.java.ai.langchain4j.controller;

import com.atguigu.java.ai.langchain4j.Bean.ChatForm;
import com.atguigu.java.ai.langchain4j.assistant.XiaozhiAgent;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@RestController
@Tag(name = "小智")
@RequestMapping("/xiaozhi")
public class XiaoZhiController {
    @Autowired
    private XiaozhiAgent xiaozhiAgent;
    @PostMapping(value = "/chat",produces = "text/stream;charset=UTF-8")
    @Operation(summary = "对话")
    public Flux<String> chat(@RequestBody ChatForm chatForm){
        return xiaozhiAgent.chat(chatForm.getMemoryId(),chatForm.getMessage());
    }
}
