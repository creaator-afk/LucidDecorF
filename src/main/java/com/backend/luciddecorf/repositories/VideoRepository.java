// src/main/java/com/example/videostreaming/repository/VideoRepository.java
package com.backend.luciddecorf.repositories;

import com.backend.luciddecorf.model.Video;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VideoRepository extends JpaRepository<Video, Long> {
}