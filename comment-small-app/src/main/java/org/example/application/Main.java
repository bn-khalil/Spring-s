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
        System.out.println(":)");
        CommentService service = (CommentService) context.getBean(CommentService.class);
        CommentService service1 = (CommentService) context.getBean(CommentService.class);
        System.out.println(service1 == service);
        service.publishComment();
        context.close();
    }
}