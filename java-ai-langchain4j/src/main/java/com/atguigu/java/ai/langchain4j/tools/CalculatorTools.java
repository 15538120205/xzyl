package com.atguigu.java.ai.langchain4j.tools;

import dev.langchain4j.agent.tool.P;
import dev.langchain4j.agent.tool.Tool;
import dev.langchain4j.agent.tool.ToolMemoryId;
import dev.langchain4j.service.MemoryId;
import org.springframework.stereotype.Component;

@Component
public class CalculatorTools {

    @Tool(name = "加法运算",value = "将两个参数a和b相加，返回结果")
    double sum(@ToolMemoryId Long memoryId, @P(value = "加数1", required = true) double a, double b) {
        System.out.println("调用加法运算"+memoryId);
        return a + b;
    }

    @Tool(name = "平方根运算",value = "对参数x进行平方根运算，返回结果")
    double squareRoot(@ToolMemoryId Long memoryId,double x) {
        System.out.println("调用平方根运算"+memoryId);
        return Math.sqrt(x);
    }
}
