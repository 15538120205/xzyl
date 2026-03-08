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

@RestController
@Tag(name = "小智")
@RequestMapping("/xiaoZhi")
public class XiaoZhiController {
    @Autowired
    private XiaozhiAgent xiaozhiAgent;
    @PostMapping("/chat")
    @Operation(summary = "对话")
    public String chat(@RequestBody ChatForm chatForm){
        return xiaozhiAgent.chat(chatForm.getMemoryId(),chatForm.getMessage());
    }
}
