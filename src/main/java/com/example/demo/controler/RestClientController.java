package com.example.demo.controler;

import com.example.demo.entity.Book;
import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

// 使用RestTemplate 访问Elastic Search
@RestController
public class RestClientController {

    @RequestMapping("/restclient/book/{id}")
    public String getLogById(@PathVariable String id) throws Exception {
        // 创建RestTempl
        RestTemplate template = new RestTemplate();
        Map<String, Object> paras = new HashMap<>();
        paras.put("id", id);
        // 得到响应的json字符串
        String str = template.getForObject("http://localhost:9200/product/book/{id}?pretty", String.class, paras);
        // 创建json解析对象
        ObjectMapper mapper = new ObjectMapper();
        JsonFactory factory = mapper.getFactory();
        JsonParser parser = factory.createParser(str);
        // 只对返回的json的_source字段感兴趣
        JsonNode root = mapper.readTree(parser);
        JsonNode sourceNode = root.get("_source");
        // 将source字段的文档部分映射到Book对象
        Book book = mapper.convertValue(sourceNode, Book.class);
        return book.getMessage();
    }
}
