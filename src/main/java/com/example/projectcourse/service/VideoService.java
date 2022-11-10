package com.example.projectcourse.service;

import com.example.projectcourse.model.Video;
import com.example.projectcourse.repository.VideoRepository;
import com.sun.istack.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VideoService {
    private final VideoRepository videoRepository;

    @Autowired
    public VideoService(VideoRepository videoRepository){
        this.videoRepository=videoRepository;
    }

    public List<Video> getAllVideos(){
        return videoRepository.findAll();
    }

    public Video getVideoById(long id){
        Optional<Video> v=videoRepository.findById(id);
        return v.get();
    }

    public void addVideo(Video video){
        videoRepository.save(video);
    }

    public void addVideoLink(@NotNull Video video, String link){
        video.setLink(link);
        videoRepository.save(video);
    }

    public void addVideoTitle(@NotNull Video video, String title){
        video.setTitle(title);
        videoRepository.save(video);
    }
}
