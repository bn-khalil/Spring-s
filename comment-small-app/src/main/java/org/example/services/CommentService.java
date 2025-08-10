package org.example.services;

import org.example.proxy.CommentNotificationProxy;
import org.example.repositories.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

@Service
@Lazy
@Scope("prototype")
public class CommentService {

    private final CommentRepository commentRepository;
    private final CommentNotificationProxy commentNotificationProxy;

    @Autowired
    public CommentService(CommentRepository commentRepository,
                          @Qualifier("Email") CommentNotificationProxy commentNotificationProxy)
            throws InterruptedException {
        System.out.println("comment service bean created!");
        Thread.sleep(2000);
        this.commentRepository = commentRepository;
        this.commentNotificationProxy = commentNotificationProxy;
    }

    public void publishComment() {
        this.commentRepository.storeComment();
        this.commentNotificationProxy.sendComment();
    }
}
