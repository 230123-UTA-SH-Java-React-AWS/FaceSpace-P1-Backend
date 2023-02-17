package com.revature.facespace.repository;

import com.revature.facespace.model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
public interface CommentRepository extends JpaRepository<Comment, Integer>{
}
