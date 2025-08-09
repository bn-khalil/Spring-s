package org.example.proxy;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
//@Primary
@Qualifier(value = "Message")
public class MessageCommentNotificationProxy implements CommentNotificationProxy{
    @Override
    public void sendComment() {
        System.out.println("Message sand success!");
    }
}
