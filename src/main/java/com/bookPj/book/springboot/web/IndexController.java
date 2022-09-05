package com.bookPj.book.springboot.web;

import com.bookPj.book.springboot.config.auth.LoginUser;
import com.bookPj.book.springboot.config.auth.dto.SessionUser;
import com.bookPj.book.springboot.service.posts.PostsService;
import com.bookPj.book.springboot.web.dto.PostsResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.Map;

@RequiredArgsConstructor
@Controller
public class IndexController {

	private final PostsService postsService;
	private final HttpSession httpSession;

	@GetMapping("/")
	public String index(Model model, @LoginUser SessionUser user){
		model.addAttribute("posts", postsService.findAllDesc());
		if(user !=null){
			model.addAttribute("userName",user.getName());
		}
		return "index";
	}

//	@GetMapping("/")
//	public ModelAndView index(Map<String,Object> model){
//		ModelAndView mv = new ModelAndView();
//		mv.setViewName("index");
//		model.put("posts", postsService.findAllDesc());
//		SessionUser user = (SessionUser) httpSession.getAttribute("user");
//		if(user !=null){
//			model.put("userName",user.getName());
//		}
//		mv.addObject(model);
//		return mv;
//	}

	@GetMapping("/posts/save")
	public String postsSave(){
		return "posts-save";
	}

	@GetMapping("/posts/update/{id}")
	public String postsUpdate(@PathVariable Long id, Model model){
		PostsResponseDto dto = postsService.findById(id);
		model.addAttribute("post",dto);

		return "posts-update";
	}
}
