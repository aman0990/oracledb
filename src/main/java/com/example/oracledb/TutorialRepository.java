package com.example.oracledb;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TutorialRepository extends JpaRepository<A,Long> {
    List <A> findByPublished(boolean published);
    List<A> findByTitleContaining(String title);
}
