package com.revature.facespace.repository;

import com.revature.facespace.model.Likes;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LikesRepository extends JpaRepository<Likes, Integer>{
    int countByPostId(Integer postId);
}
