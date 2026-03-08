package com.atguigu.java.ai.langchain4j.assistant;

import dev.langchain4j.service.MemoryId;
import dev.langchain4j.service.SystemMessage;
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
    @SystemMessage("你是一个地地道道的北京人北京话回答我")
    String chat(@MemoryId Integer userId,@UserMessage String userMessage);
}


