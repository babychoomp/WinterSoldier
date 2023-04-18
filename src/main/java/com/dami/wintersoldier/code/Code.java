package com.dami.wintersoldier.code;

import lombok.Getter;

@Getter  // @Getter은 Lombok 라이브러리에서 제공하는 annotation입니다.
	     // 일반적으로는 Java에서 클래스의 필드에 접근하기 위해 getter 메소드를 작성해야 하지만,
         // 이 annotation을 사용하면 해당 필드를 읽어오는 getter 메소드를 자동으로 생성해줍니다.
public enum Code {
	// enum은 Java에서 서로 연관된 상수들의 집합을 정의할 때 사용하는 데이터 타입입니다.
	// enum은 클래스와 비슷한 구조를 가지고 있으며, 새로운 객체를 생성하는 것이 아닌
	// 정의된 상수 중 하나를 선택하는 것입니다.
	
	S200(0, "Success"), // 성공
	S201(201, "데이터 없음"),
	E100(-100, "필수 파라메터 에러"),
	E101(-101, "cmd 에러"),
	E102(-102, "허용 범위 초과"),
	E200(-200, "Auth fail ( 인증 실패 -인증토큰 / 허용 IP / 허용 mac 에러 )"),
	E300(-300, "DB 연동 실패"),
	E301(-301, "DB 정보 암호화 실패"),
	E400(-400, "처리 실패"),
	E404(-404, "파일 없음"),
	E500(-500, "서버 처리 실패"),
	E701(-701, "가입자 회선이 존재하지 않습니다."),
	E702(-702, "중복된 트랜잭션 요청 입니다.");
	
	// Code enum은 S200, S201, E100과 같은 상수들을 포함합니다.
	// 각 상수는 해당 코드와 메세지를 가지고 있고, 여기서 정의된 상수 중 하나를 선택합니다.
	
	
	private String resultDesc;
	private Integer result;
	
	Code(Integer result, String resultDesc){
		this.result = result;
		this.resultDesc = resultDesc;
		
		// this는 클래스 내부에서 현재 인스턴스 객체를 참조하기 위해 사용되며, 
		// 클래스에 정의된 필드나 메소드를 호출할 때 사용됩니다.
	}
	
}
