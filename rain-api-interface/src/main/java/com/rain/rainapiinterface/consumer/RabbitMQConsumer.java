package com.rain.rainapiinterface.consumer;

import com.rain.rainapiinterface.model.dto.ArticleRequest;
import com.rain.rainapiinterface.service.ArticleService;
import com.rain.rainapiinterface.websocket.WebSocketServer;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component
public class RabbitMQConsumer {
    @Resource
    private ArticleService articleService;
    @RabbitListener(queues = "article_queue")
    public void handleTaskRequest(ArticleRequest articleRequest) {
        String article = articleService.getArticle(articleRequest);
        WebSocketServer.sendArticle(article,articleRequest.getArticleId());
    }
}
