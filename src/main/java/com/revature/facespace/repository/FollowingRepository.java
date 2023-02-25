package com.revature.facespace.repository;

import com.revature.facespace.model.Following;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FollowingRepository extends JpaRepository<Following, Integer> {
    List<Following> findAllFollowingsByFollowerId(Integer followingId);
    List<Following> findAllFollowingsByFollowingId(Integer followingId);
}