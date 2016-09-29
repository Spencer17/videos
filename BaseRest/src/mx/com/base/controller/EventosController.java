package mx.com.base.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import mx.com.base.bean.CalendarDTO;
import mx.com.base.service.CalendarService;

@RestController
@RequestMapping("/evento")
public class EventosController {

		@Autowired
		private CalendarService calendarService;

	    @CrossOrigin(origins = "http://localhost:8080")
	    @RequestMapping("/calendar")
	    public  List<CalendarDTO> greeting(@RequestParam(value="doctor") String doctor) {
	    	System.out.println(doctor);
	    	return calendarService.listEvents(doctor);
	    }
	    @RequestMapping("/test")
	    public String test(){
	    	return "test method";
	    }
		public CalendarService getCalendarService() {
			return calendarService;
		}
		public void setCalendarService(CalendarService calendarService) {
			this.calendarService = calendarService;
		}
	    
}
