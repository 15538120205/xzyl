package com.atguigu.java.ai.langchain4j;

import com.atguigu.java.ai.langchain4j.assistant.Assistant;
import com.atguigu.java.ai.langchain4j.assistant.MemoryChatAssistant;
import com.atguigu.java.ai.langchain4j.assistant.SeperateChatAssistant;
import dev.langchain4j.data.message.AiMessage;
import dev.langchain4j.data.message.UserMessage;
import dev.langchain4j.memory.chat.MessageWindowChatMemory;
import dev.langchain4j.model.chat.response.ChatResponse;
import dev.langchain4j.model.openai.OpenAiChatModel;
import dev.langchain4j.service.AiServices;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;

@SpringBootTest
public class testMemory {
    @Autowired
    private Assistant assistant;
    @Test
    void testMemory(){
        System.out.println(assistant.chat("我是老王"));
        System.out.println("***********************************************");
        System.out.println(assistant.chat("我是谁,只需要给我名字就行"));
    }

    @Autowired
    private OpenAiChatModel qwenChatModel;
    @Test
    public void testChatMemory2() {

        //第一轮对话
        UserMessage userMessage1 = UserMessage.userMessage("记住我的名字是老王,记住了就回答记住了");
        ChatResponse chatResponse1 = qwenChatModel.chat(userMessage1);
        AiMessage aiMessage1 = chatResponse1.aiMessage();
        //输出大语言模型的回复
        System.out.println(aiMessage1.text());

        //第二轮对话
        UserMessage userMessage2 = UserMessage.userMessage("你知道我是谁吗,只回答我的名字");
        ChatResponse chatResponse2 = qwenChatModel.chat(Arrays.asList(userMessage1, aiMessage1, userMessage2));
        AiMessage aiMessage2 = chatResponse2.aiMessage();
        //输出大语言模型的回复
        System.out.println(aiMessage2.text());
    }

    @Test
    public void testChatMemory3() {

        //创建chatMemory
        MessageWindowChatMemory chatMemory = MessageWindowChatMemory.withMaxMessages(10);

        //创建AIService
        Assistant assistant = AiServices
                .builder(Assistant.class)
                .chatLanguageModel(qwenChatModel)
                .chatMemory(chatMemory)
                .build();
        //调用service的接口
        String answer1 = assistant.chat("记住我的名字是老王,记住了就回答记住了");
        System.out.println(answer1);
        String answer2 = assistant.chat("你知道我是谁吗,只回答我的名字");
        System.out.println(answer2);
    }

    @Autowired
    private OpenAiChatModel openAiChatModel;
    @Autowired
    private MemoryChatAssistant memoryChatAssistant;

    @Test
    void testMemory2(){
        System.out.println(memoryChatAssistant.chat("记住我的名字是老王,记住了就回答记住了"));
        System.out.println(memoryChatAssistant.chat("你知道我是谁吗,只回答我的名字"));
    }

    @Autowired
    private SeperateChatAssistant separateChatAssistant;
    @Test
    void testMemory3(){
        System.out.println(separateChatAssistant.chat(1,"记住我的名字是老王,记住了就回答记住了"));
        System.out.println("-------------------------------------------");
        System.out.println(separateChatAssistant.chat(2,"记住我的名字是张三,记住了就回答记住了"));
        System.out.println("-------------------------------------------");
        System.out.println(separateChatAssistant.chat(1,"你知道我是谁吗,只回答我的名字"));
        System.out.println("-------------------------------------------");
        System.out.println(separateChatAssistant.chat(2,"你知道我是谁吗,只回答我的名字"));
    }
}
