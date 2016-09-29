package mx.com.base.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mx.com.base.bean.Video;
import mx.com.base.dao.VideoDAO;

@Service
public class VideoService {

	
	@Autowired
	private VideoDAO videoDAO;
	
	
	public Video getVideoPrincipal(){
		Video video = videoDAO.getVideoPrincipal();
		return video;
	}
	

	public VideoDAO getVideoDAO() {
		return videoDAO;
	}

	public void setVideoDAO(VideoDAO videoDAO) {
		this.videoDAO = videoDAO;
	}


	public List<Video> getVideoLista() {
		return  videoDAO.getVideoLista();
	}
	
	
	
}
