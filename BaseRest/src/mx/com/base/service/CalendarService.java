package mx.com.base.service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import org.springframework.stereotype.Service;

import mx.com.base.bean.CalendarDTO;



@Service
public class CalendarService {

	
	public List<CalendarDTO> listEvents(String doctor){
		List<CalendarDTO> evt= new ArrayList<CalendarDTO>();
		 Calendar calendar= GregorianCalendar.getInstance();
		 SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		 for (int i = 1; i <= 100; i++) {
			 CalendarDTO c = new CalendarDTO();
			 c.setId(i);
			 calendar.add(Calendar.DATE, 1);
			 String inicio = sdf.format(calendar.getTime());
			 c.setStart(inicio);
			 calendar.add(Calendar.MINUTE, 30);
			 String fin = sdf.format(calendar.getTime());
			 c.setEnd(fin);
			 c.setTitle("Mi cita: "+i);
			 c.setAllDay(false);
			 evt.add(c);
			 calendar.add(Calendar.MINUTE, -30);
		}
		 
		
		return evt;
	}
	
	public static void main(String[] args) {
		CalendarService cs =new CalendarService();
		 List<CalendarDTO> ca =cs.listEvents("1");
		for (CalendarDTO calendarDTO : ca) {
			System.out.println(calendarDTO.start);
			System.out.println(calendarDTO.end);
			System.out.println("-----------------");
		}
		
	}
	
}
