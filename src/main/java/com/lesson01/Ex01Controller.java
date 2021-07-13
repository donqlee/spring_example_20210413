package com.lesson01;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@RequestMapping("/lesson01/ex01") // 메소드에 붙은 mapping보다 먼저 적용
@Controller // controller spring bean
public class Ex01Controller {
	
	// 요청 url :http//localhost/lesson01/ex01/1
	@RequestMapping("/1") // URL 주소 매핑
	@ResponseBody // 리턴되는 값을 HTML Response body로 보낸다.
	public String printString() {
		String text = "예제1번<br>문자열을 response body로 보내는 예제";
				return text;
	}
	// 요청 url : http://localhost/lesson01/ex01/2
	@RequestMapping("/2")
	public @ResponseBody Map<String, Object> printMap(){
		Map<String, Object> map = new HashMap<>();
		map.put("apple", 4);
		map.put("banana", 10);
		map.put("orange", 125);
		map.put("grape", 67);
		
		// map을 리턴하면 json으로 나타난다.
		// web starter에 jackson 이라는 라이브러리가 포함되어있기 때문
		return map;
	}
}
