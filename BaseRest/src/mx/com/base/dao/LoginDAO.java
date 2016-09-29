package mx.com.base.dao;

import javax.sql.DataSource;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import mx.com.base.bean.Usuario;

public class LoginDAO {

	private DataSource dataSource;
	private JdbcTemplate jdbcTemplateObject;

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
		this.jdbcTemplateObject = new JdbcTemplate(dataSource);
	}


	@SuppressWarnings({ "rawtypes", "unchecked" })
	public Usuario getUsuario(String user, String password){
		String sql = "SELECT * FROM Usuario WHERE usuario = ? and password = ?";
		Usuario usuario= (Usuario)jdbcTemplateObject.queryForObject(
				sql, new Object[] { user,password }, new BeanPropertyRowMapper(Usuario.class));

		return usuario;

	}


	public DataSource getDataSource() {
		return dataSource;
	}



}
