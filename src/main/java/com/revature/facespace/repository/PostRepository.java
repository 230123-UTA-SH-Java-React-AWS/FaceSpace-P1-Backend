package com.revature.facespace.repository;

import com.revature.facespace.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
public interface PostRepository extends JpaRepository<Post, Integer> {
}
