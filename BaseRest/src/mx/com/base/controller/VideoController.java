package mx.com.base.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import mx.com.base.bean.Video;
import mx.com.base.service.VideoService;

@RestController
@RequestMapping("/video")

public class VideoController {

	@Autowired
	private VideoService videoService;
	
	@CrossOrigin(origins = "http://localhost:8000")
    @RequestMapping("/getVideoPrincipal")
    public  Video getVideoPrincipal() {
    	return videoService.getVideoPrincipal();
    }
	
	@CrossOrigin(origins = "http://localhost:8000")
    @RequestMapping("/getVideoLista")
    public  List<Video> getVideoLista() {
    	return videoService.getVideoLista();
    }

	public VideoService getVideoService() {
		return videoService;
	}

	public void setVideoService(VideoService videoService) {
		this.videoService = videoService;
	}
	
}
