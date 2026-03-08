package com.atguigu.java.ai.langchain4j;

import com.atguigu.java.ai.langchain4j.Bean.ChatMessages;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;

@SpringBootTest
public class MongoCrudTest {
    @Autowired
    private MongoTemplate mongoTemplate;
//    @Test
//    void testMongoCrud(){
//        ChatMessages chatMessages = new ChatMessages(1L, "聊天记录");
//        mongoTemplate.insert(chatMessages);
//    }

    /**
     * 插入
     */
    @Test
    void testMongo2(){
        ChatMessages chatMessages = new ChatMessages();
        chatMessages.setContent("聊天记录");
        mongoTemplate.insert(chatMessages);
    }
    /**
     * 查询
     */
    @Test
    void testMongo3(){
        ChatMessages chatMessages = mongoTemplate.findById("69ad162d5bcfd2528b14335e", ChatMessages.class);
        System.out.println(chatMessages);
    }
    /**
     * 更新
     */
    @Test
    void testMongo4(){
        Criteria criteria = Criteria.where("_id").is("69ad162d5bcfd2528b14335e");
        Query query = new Query(criteria);
        Update update = new Update();
        update.set("content", "更新后的聊天记录");
        //修改/新增
        mongoTemplate.upsert(query, update, ChatMessages.class);
    }
    /**
     * 删除
     */
    @Test
    void testMongo5(){
        Criteria criteria = Criteria.where("_id").is("1000");
        Query query = new Query(criteria);
        mongoTemplate.remove(query, ChatMessages.class);
    }
}
