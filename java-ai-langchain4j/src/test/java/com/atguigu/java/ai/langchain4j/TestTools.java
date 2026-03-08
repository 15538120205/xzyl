package com.atguigu.java.ai.langchain4j;

import com.atguigu.java.ai.langchain4j.assistant.SeperateChatAssistant;
import com.atguigu.java.ai.langchain4j.assistant.XiaozhiAgent;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class TestTools {
    @Autowired
    private XiaozhiAgent xiaozhiAgent;
    @Autowired
    private SeperateChatAssistant seperateChatAssistant;
    @Test
    void testTools() {
        //8,116.3114775
        String answer = seperateChatAssistant.chat(102, "请计算1+1,计算65874512的平方根");
        System.out.println(answer);
    }

}
