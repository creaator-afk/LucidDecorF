// src/main/java/com/example/videostreaming/service/VideoService.java
package com.backend.luciddecorf.service;

import com.backend.luciddecorf.model.Video;
import com.backend.luciddecorf.repositories.VideoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VideoService {

    @Autowired
    private VideoRepository videoRepository;

    public List<Video> getAllVideos() {
        return videoRepository.findAll();
    }

    public Video getVideoById(Long id) {
        return videoRepository.findById(id).orElse(null);
    }

    public Video saveVideo(Video video) {
        return videoRepository.save(video);
    }

    public void deleteVideo(Long id) {
        videoRepository.deleteById(id);
    }
}