package com.atguigu.java.ai.langchain4j.Bean;

import lombok.Data;

@Data
public class ChatForm {
    private Long memoryId;//对话id
    private String message;//用户问题
}
