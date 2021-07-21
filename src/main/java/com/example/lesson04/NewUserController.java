package com.example.lesson04;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.lesson04.bo.NewUserBO;
import com.example.lesson04.model.NewUser;

@RequestMapping("/lesson04/ex01")
@Controller
public class NewUserController {
	
	@Autowired
	private NewUserBO newUserBO;
	
	@RequestMapping(path = "/1", method = RequestMethod.GET)
	public String addUserView() {
		return "lesson04/addUser";
	}
	@PostMapping("/add_user")
	public String addUser(
			@RequestParam("name") String name,
			@RequestParam("yyyymmdd") String yyyymmdd,
			@RequestParam(value = "email", required=false) String email,
			@RequestParam(value = "introduce", required=false) String introduce 
	) {
		newUserBO.insertNewUser(name, yyyymmdd, email, introduce);
		// db insert
		
		// 결과 jsp
		return "lesson04/afterAddUser";
		
	}
	/**
	 * 가장 최근에 추가된 사람 한명 가져오기
	 * @return
	 */
	// http://localhost:8080/lesson04/ex01/get_last_user
	@GetMapping("/get_last_user")
	public String getLastUserView(Model model) { // view 화면에 데이터를 넘겨주는 객체(ModelAndView 객체는 요즘 잘 사용하지 않는다)
		NewUser newUser = newUserBO.getLastUser();
		model.addAttribute("result", newUser); // 결과 jsp view에 결과 객체값을 넘겨준다.
		model.addAttribute("subject", "회원정보");
		return "lesson04/getLastUser";
	}
}
