package org.example.services;

import org.example.aspacts.ToLog;
import org.example.model.Comment;
import org.example.proxy.CommentNotificationProxy;
import org.example.repositories.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import java.util.logging.Logger;

@Service
//@Lazy
@Scope("prototype")
public class CommentService {

    private final CommentRepository commentRepository;
    private final CommentNotificationProxy commentNotificationProxy;
    private Logger logger = Logger.getLogger(CommentService.class.getName());

    @Autowired
    public CommentService(CommentRepository commentRepository,
                          @Qualifier("Email") CommentNotificationProxy commentNotificationProxy)
            throws InterruptedException {
//        System.out.println("comment service bean created!");
//        Thread.sleep(2000);
        this.commentRepository = commentRepository;
        this.commentNotificationProxy = commentNotificationProxy;
    }

    @ToLog
    public void publishComment(Comment comment) {
        this.commentRepository.storeComment();
        this.commentNotificationProxy.sendComment();
        logger.info("Publishing comment:" + comment.getMessage());
    }

//    public void checkPublishComment() {
//        logger.info("publishing checked");
//    }

}
