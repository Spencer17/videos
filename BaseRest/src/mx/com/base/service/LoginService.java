package mx.com.base.service;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mx.com.base.bean.Usuario;
import mx.com.base.dao.LoginDAO;

@Service
public class LoginService {

	final static Logger logger = Logger.getLogger(LoginService.class);

	
	@Autowired
	private LoginDAO loginDao;
	
	public Usuario getUsuario(String user,String password){
		logger.debug("dentro del metodo getUsuario()");
		return loginDao.getUsuario(user, password);
	}
	
//	public static void main(String[] args) {
//		for (int i = 0; i < 10000; i++) {
//			logger.error("error" +i);
//			
//		}
//		
//	}

	public LoginDAO getLoginDao() {
		return loginDao;
	}

	public void setLoginDao(LoginDAO loginDao) {
		this.loginDao = loginDao;
	}
	

	
}
