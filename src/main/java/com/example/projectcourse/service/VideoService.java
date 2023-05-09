package com.example.projectcourse.service;

import com.example.projectcourse.exceptions.AllVideosNotFoundException;
import com.example.projectcourse.exceptions.VideoNotFoundException;
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
        try {
            return videoRepository.findAll();
        }catch (Exception e){
            throw new AllVideosNotFoundException();
        }

    }

    public Video getVideoById(long id){
        try {
            Optional<Video> v=videoRepository.findById(id);
            return v.get();
        }catch (Exception e){
            throw new VideoNotFoundException(id);
        }

    }

    public void addVideo(@NotNull Video video){
        videoRepository.save(video);
    }

    public void addVideoLink(long id, String link){
        Video video=this.getVideoById(id);
        video.setLink(link);
        videoRepository.save(video);
    }

    public void addVideoTitle(long id, String title){
        Video video=this.getVideoById(id);
        video.setTitle(title);
        videoRepository.save(video);
    }

    public void deleteVideo(long id){
        Video video=this.getVideoById(id);
        videoRepository.delete(video);
    }
}
