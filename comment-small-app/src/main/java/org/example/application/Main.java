package org.example.application;

import org.example.config.ProjectConfiguration;
import org.example.proxy.EmailCommentNotificationProxy;
import org.example.repositories.CommentRepository;
import org.example.repositories.DBCommentActions;
import org.example.services.CommentService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
//        var dbComment = new DBCommentActions();
//        var notificationComment = new EmailCommentNotificationProxy();
//        var commentService = new CommentService(dbComment, notificationComment);
//        commentService.publishComment();
        var context = new AnnotationConfigApplicationContext(ProjectConfiguration.class);
        CommentService service = (CommentService) context.getBean(CommentService.class);
        service.publishComment();
        context.close();
    }
}