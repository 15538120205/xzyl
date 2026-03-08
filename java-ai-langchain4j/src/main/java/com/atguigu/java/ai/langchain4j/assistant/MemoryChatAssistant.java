package com.atguigu.java.ai.langchain4j.assistant;

import dev.langchain4j.service.UserMessage;
import dev.langchain4j.service.V;
import dev.langchain4j.service.spring.AiService;

import static dev.langchain4j.service.spring.AiServiceWiringMode.EXPLICIT;

@AiService(wiringMode = EXPLICIT,chatModel = "openAiChatModel",chatMemory = "chatMemory")
public interface MemoryChatAssistant {

    @UserMessage("你是我的好朋友，请用地地道道的北京话回答问题，回答问题的时候适当添加表情符号。{{userMessage}}")
    String chat(@V("userMessage") String userMessage);
}


