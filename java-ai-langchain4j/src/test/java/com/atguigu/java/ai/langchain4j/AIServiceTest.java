package com.atguigu.java.ai.langchain4j;

import com.atguigu.java.ai.langchain4j.assistant.Assistant;
import dev.langchain4j.model.openai.OpenAiChatModel;
import dev.langchain4j.service.AiServices;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class AIServiceTest {
    @Autowired
    private OpenAiChatModel openAiChatModel;

    @Test
    void testChat(){
        Assistant assistant = AiServices.create(Assistant.class, openAiChatModel);
        System.out.println(assistant.chat("你好"));
    }
    @Autowired
    private Assistant assistant;
    @Test
    void testChat2(){
        System.out.println(assistant.chat("你好"));
    }

}
