package com.dami.wintersoldier.exception;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.dami.wintersoldier.util.CommonUtils;

import groovy.util.logging.Slf4j;

@Slf4j		// Lombok 프레임워크의 annotation 중 하나로, 자동으로 로그를 기록하기 위한 로깅용 변수를 생성합니다.
@ControllerAdvice	// 애플리케이션에서 발생하는 예외를 전역적으로 처리할 수 있으며, 중복 코드를 제거하고 일관된 예외 처리를 수행할 수 있습니다.
public class AllExceptionHandler {

	// request error : 클라이언트의 요청 파라미터 중 일부가 누락되었을 때
	// 응답 생태 코드를 HttpStatus.BAD_REQUEST로 하여 해당 요청을 처리하지 수 없게 합니다.
	@ExceptionHandler(MissingServletRequestParameterException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public HttpEntity<ErrorResponse> handlerBindingResultException(RequestException exception) {
		
		// catch exception
		if(exception.getException() != null) {	
			// getException()은 RequestException 클래스 내에 정의된 메소드입니다.
			// 이 메소드를 통해 해당 예외 객체를 가져와서 처리할 수 있습니다.
			Exception ex = exception.getException();
			StackTraceElement [] steArr = ex.getStackTrace();
			for(StackTraceElement ste : steArr) {
				System.out.println(ste.toString()); // 예외가 발생하면 해당 예외의 스택 추적 정보를 출력합니다.
		}
		
	}
		
		
	// response 담기
	// ErrorResponse 객체를 생성하고 초기화합니다. 이를 통해 응답 정보를 담는데 사용합니다.
	ErrorResponse errRes = ErrorResponse.builder()
			.result(exception.getCode().getResult())
			.resultDesc(exception.getCode().getResultDesc())
			.resDate(CommonUtils.currentTime())
			.reqNo(exception.getReqNo())
			.httpStatus(exception.getHttpStatus())
			.build();
	
	return new ResponseEntity<ErrorResponse>(errRes, errRes.getHttpStatus());
		
	}
	
	
	
}
