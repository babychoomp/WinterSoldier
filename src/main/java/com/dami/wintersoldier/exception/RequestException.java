package com.dami.wintersoldier.exception;

import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;

import com.dami.wintersoldier.code.Code;

import lombok.Getter;

@Getter
public class RequestException extends RuntimeException {
	// RuntimeException 클래스를 상속 받았기에, 이 예외를 던지는 메소드를 호출한 상위 메소드들은
	// 예외 처리할 필요 없이 예외를 무시할 수 있습니다.
	
	private static final long serialVersionUID = 855926457087732200L;  
	// 이기종간 충돌방지 / 클래스에서 클릭 - ?
	
	private Code code;
	private String errMsg;
	private HttpStatus httpStatus;
	private Exception exception;
	private BindingResult result;
	private String reqNo;
	
	
	// 생성자
	// RequestException 클래스에는 위에만 보더라도 다양한 생성자를 가지고 있습니다.
	// 인스턴스가 어떤 것이 얼마나 반환되도 그 상황에 발생할 수 있는 모든 경우의 수를 클래스로 만들어두었습니다.
	public RequestException(Code code) {
		this.code = code;
	}
	
	public RequestException(Code code, String errMsg) {
		this.code = code;
		this.errMsg = errMsg;
	}
	
	
	public RequestException(Code code, String errMsg, HttpStatus httpStatus) {
		this.code = code;
		this.errMsg = errMsg;
		this.httpStatus = httpStatus;
	}
	
	public RequestException(Code code, String errMsg, HttpStatus httpStatus, Exception exception) {
		this.code = code;
		this.errMsg = errMsg;
		this.httpStatus = httpStatus;
		this.exception = exception;
	}
	
	public RequestException(Code code, String errMsg, HttpStatus httpStatus, Exception exception, BindingResult result,
			String reqNo) {
		this.code = code;
		this.errMsg = errMsg;
		this.httpStatus = httpStatus;
		this.exception = exception;
		this.result = result;
		this.reqNo = reqNo;
	}
	
	
	//생성자 이용 객체생성
	// fire() : RequestException 객체를 생성하기 위해 생성자를 호출하는 간단한 팩토리 메서드입니다.
	// 예외 상황이 발생할 때, 이 메서드를 호출하여 중복을 막거나 예외를 무시할 수 있습니다.
	public static RequestException fire(Code code) {
		return new RequestException(code);
	}
	
	public static RequestException fire(Code code, String errMsg) {
		return new RequestException(code, errMsg);
	}
	
	public static RequestException fire(Code code, String errMsg, HttpStatus httpStatus) {
		return new RequestException(code, errMsg, httpStatus);
	}
	
	public static RequestException fire(Code code, String errMsg, HttpStatus httpStatus, Exception exception) {
		return new RequestException(code, errMsg, httpStatus, exception);
	}
	
	public static RequestException fire(Code code, String errMsg, HttpStatus httpStatus, Exception exception, BindingResult result, String reqNo) {
		return new RequestException(code);
	}
}
