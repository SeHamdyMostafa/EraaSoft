package com.spring.boot.springtasklec11.repo;

import com.spring.boot.springtasklec11.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepo extends JpaRepository<Post, Long> {

    List<Post> findByUserIdIn(List<Long> userIds);

}
