package com.atguigu.java.ai.langchain4j;

import com.atguigu.java.ai.langchain4j.config.Langchain4jProperties;
import dev.langchain4j.community.model.dashscope.QwenChatModel;
import dev.langchain4j.data.image.Image;
import dev.langchain4j.model.chat.ChatLanguageModel;
import dev.langchain4j.model.ollama.OllamaChatModel;
import dev.langchain4j.model.openai.OpenAiChatModel;
import dev.langchain4j.model.openai.OpenAiImageModel;
import dev.langchain4j.model.output.Response;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.net.URI;

@SpringBootTest
public class LLMTest {


    @Autowired
    private Langchain4jProperties langchain4jProperties;

    /**
     * gpt-4o-mini语言模型接入测试
     */
    @Test
    public void testGPTDemo() {
        //初始化模型
        OpenAiChatModel model = OpenAiChatModel.builder()
                .baseUrl("https://api.siliconflow.cn/v1")
                .apiKey(langchain4jProperties.getApiKey()) //设置模型apiKey
                .modelName("deepseek-ai/DeepSeek-V3.2") //设置模型名称
                .build();

        //向模型提问
        String answer = model.chat("你好");
        //输出结果
        System.out.println(answer);
    }

    @Autowired
    private OpenAiChatModel openAiChatModel;


//    private ChatLanguageModel chatLanguageModel;

    @Test
    void test() {
        String answer = openAiChatModel.chat("你好");
        System.out.println(answer);
    }

    @Autowired
    private OllamaChatModel ollamaChatModel;
    @Test
    void testOllama() {
        String answer = ollamaChatModel.chat("你好");
        System.out.println(answer);
    }

    @Autowired
    private QwenChatModel qwenChatModel;
    @Test
    void testQwen() {
        String answer = qwenChatModel.chat("你好");
        System.out.println(answer);
    }
    /**
     * 图片生成测试
     */
    @Test
    void testImg() {
        OpenAiImageModel build = OpenAiImageModel
                .builder()
                .modelName("Qwen/Qwen-Image")
                .baseUrl("https://api.siliconflow.cn/v1")
                .apiKey(langchain4jProperties.getApiKey())
                .build();
        Response<Image> imageResponse = build.generate("画一只可爱的猫");
        URI url = imageResponse.content().url();
        System.out.println(url);
    }



}