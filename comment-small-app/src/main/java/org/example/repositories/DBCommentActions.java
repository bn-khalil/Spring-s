package org.example.repositories;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Repository
public class DBCommentActions implements CommentRepository {

    @Override
    public void storeComment() {
        System.out.println("message stored correct");
    }
}
