package com.dami.wintersoldier.util;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;

@Component	// @Component 어노테이션은 Spring Framework에서 bean으로 등록되는 클래스를 나타내기 위해 사용됩니다.
public class CommonUtils {
	
	// 현재 시간과 날짜를 저장하는 메소드입니다.
	public static String currentTime() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss", Locale.KOREA);
		Date currentDate = new Date();
		
		return sdf.format(currentDate);
	}
	
	// 클라이언트의 ip 주소를 추출해내는 메소드입니다.
	public static String getClientIP(HttpServletRequest req) {
		// ip는 getHeader("X-Forwarded-For"); 를 통해 X-Forwarded-For 헤더를 확인하여 ip 주소를 추출합니다.
		// 만일 이 헤더를 찾을 수 없다면 다음 if문으로 이동하여 다른 헤더를 확인합니다.
		// 이 헤드들 중 어떤 것도 찾을 수 없다면 getRemoteAddr() 메소드를 통해 클라이언트 IP 주소를 추출합니다.
		
		String ip = req.getHeader("X-Forwarded-For");
		
		if(ip == null)
			ip = req.getHeader("Proxy-Client-IP");
		if (ip == null)
			ip = req.getHeader("WL-Proxy-Client-IP");
		if (ip == null)
			ip = req.getHeader("HTTP_CLIENT_IP");
		if (ip == null)
			ip = req.getHeader("HTTP_X_FORWARDED_FOR");
		if (ip == null) 
			ip = req.getRemoteAddr();	// 웹 브라우저와 통신하는 서버측 애플리케이션이 요청을 보낸 클라이언트의 IP 주소를 반환합니다.
		if(ip.equals("0:0:0:0:0:0:0:1"))
			 ip = ip.replace("0:0:0:0:0:0:0:1", "127.0.0.1");
			 // 0:0:0:0:0:0:0:1 은 클라이언트가 로컬호스트에서 요청을 보낸 경우를 처리하기 위함이기에 이를 127.0.0.1 로 변경합니다.
		
		return ip;
	}
	
	
	// auth redirect
	public static void redirect(String alertText, String redirectPath, HttpServletResponse response) throws IOException {
		response.setContentType("text/html; charset=UTF-8");
		
		PrintWriter out = response.getWriter();
		ModelAndView mav = new ModelAndView();
		
		// 개발용 리다이렉트
		out.println("<script>alert('" + alertText + "'); location.herf=" + redirectPath + "'</script>");
		out.flush();
	}
}
