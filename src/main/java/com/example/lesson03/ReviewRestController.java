package com.example.lesson03;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.lesson03.bo.ReviewBO;
import com.example.lesson03.model.Review;

@RestController //@Controller + @ResponseBody => 데이터만 response로 내릴 때 사용
public class ReviewRestController {
	
	@Autowired
	private ReviewBO reviewBO;
	// 요청 URL : http://localhost:8080/lesson03/ex01
	
	@RequestMapping("/lesson03/ex01")
	public Review ex01(
			//@RequestParam(value="id") int id // 필수파라미터
			//@RequestParam(value="id", required=true) int id //필수파라미터
			//@RequestParam(value="id", required=false) Integer id // 비필수 파라미터 (값이 없을수 있기 때문에 null을 저장하기 위해 Integer)
			@RequestParam(value="id", defaultValue="1") int id
	) {
		System.out.println("### id : " + id);
		return reviewBO.getReview(id);
	}
	
	// 요청 URL: http://localhost/lesson03/ex02
	@RequestMapping("/lesson03/ex02")
	public String ex02() {
		Review review = new Review();
		review.setStoreName("보람 삼겹살");
		review.setMenu("삼겹혼밥세트");
		review.setUserName("신보람");
		review.setPoint(4.5);
		review.setReview("혼자 먹기 적당하네요.");
		
		int row = reviewBO.insertReview(review); // insert된 row수를 리턴 받는다.
		
		return "success row count: " + row; // @ResponseBody로 인해 String 값 자체가 responseBody에 담긴다.
	}
	// 요청 URL: http://localhost/lesson03/ex02/2
	@RequestMapping("/lesson03/ex02/2")
	public String ex02_2() {
		int row = reviewBO.insertReviewAsField("도미노피자", "콤비네이션R", "신바다", 5.0, "역시 맛있다!!!");
		return "success row count:" + row;
	}
	
	// 요청 URL : http://localhost:8080/lesson03/ex03?id=23&review=삼결살은 역시 맛있어~~~
	@RequestMapping("/lesson03/ex03")
	public String ex03(
			@RequestParam("id") int id,
			@RequestParam("review") String review) {
		
		int row = reviewBO.updateReview(id, review);
		return "변경 완료" + row;
	}
	
	// 요창 URL : http://localhost:8080/lesson03/ex04?id=23
	@RequestMapping("/lesson03/ex04")
	public String ex04(
			@RequestParam("id") int id) {
		int row = reviewBO.deleteReviewById(id);
		return "삭제 완료 " + row; 
	}
	
	
}
