package mx.com.base.dao;

import java.util.List;

import javax.sql.DataSource;

import org.apache.log4j.Logger;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import mx.com.base.bean.Video;

public class VideoDAO {

	final static Logger logger = Logger.getLogger(VideoDAO.class);


	private DataSource dataSource;
	private JdbcTemplate jdbcTemplateObject;

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
		this.jdbcTemplateObject = new JdbcTemplate(dataSource);
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public Video getVideoPrincipal(){
		Video video= null;
		try{
			String sql = "SELECT * FROM video WHERE principal = 1";
			video=(Video)jdbcTemplateObject.queryForObject(
					sql, new Object[] {}, new BeanPropertyRowMapper(Video.class));
		}catch (EmptyResultDataAccessException e) {
			logger.error(e);
		}
		return video;

	}
	public Video getImagen(){
		
		Video imagen=null;
		try{
			String sql= "SELECT * FROM video WHERE imagen = 0" ;
			imagen=(Video)jdbcTemplateObject.queryForObject(sql, 
					new Object[] {}, new BeanPropertyRowMapper(Video.class));
					
		}catch (EmptyResultDataAccessException e	){
			logger.error(e);
		}
		return imagen;
	}
	


	public DataSource getDataSource() {
		return dataSource;
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public List<Video> getVideoLista() {

		List<Video> videos= null;
		try{
			String sql = "SELECT * FROM video WHERE principal = 0";
			videos=(List<Video>)jdbcTemplateObject.query(
					sql, new Object[] {}, new BeanPropertyRowMapper(Video.class));
		}catch (EmptyResultDataAccessException e) {
			logger.error(e);
		}
		return videos;
	}

}
