package com.atguigu.java.ai.langchain4j.assistant;

import dev.langchain4j.service.MemoryId;
import dev.langchain4j.service.UserMessage;
import dev.langchain4j.service.spring.AiService;

import static dev.langchain4j.service.spring.AiServiceWiringMode.EXPLICIT;

@AiService(wiringMode = EXPLICIT,chatModel = "openAiChatModel",chatMemoryProvider = "chatMemoryProvider")
public interface SeperateChatAssistant {
    /**
     *
     * 分离来聊天记录
     * @param userMessage
     * @return
     */
    String chat(@MemoryId Integer userId,@UserMessage String userMessage);
}


