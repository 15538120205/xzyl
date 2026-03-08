package com.atguigu.java.ai.langchain4j.assistant;

import dev.langchain4j.service.MemoryId;
import dev.langchain4j.service.SystemMessage;
import dev.langchain4j.service.UserMessage;
import dev.langchain4j.service.spring.AiService;
import dev.langchain4j.service.spring.AiServiceWiringMode;
import reactor.core.publisher.Flux;

@AiService(wiringMode = AiServiceWiringMode.EXPLICIT/*,chatModel = "openAiChatModel"*/,streamingChatModel = "qwenStreamingChatModel"//流式输出
        ,chatMemoryProvider = "chatMemoryProviderXiaozhi"
        ,tools = "appointmentTools"//配置工具
        ,contentRetriever = "contentRetrieverXiaozhiPincone"
)
public interface XiaozhiAgent {
    @SystemMessage(fromResource = "zhaozhi-prompt-template.txt")

    Flux<String> chat(@MemoryId Long memoryId, @UserMessage String userMessage);
}
