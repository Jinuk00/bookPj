package com.bookPj.book.springboot.web;


import com.bookPj.book.springboot.service.posts.PostsService;
import com.bookPj.book.springboot.web.dto.PostsResponseDto;
import com.bookPj.book.springboot.web.dto.PostsSaveRequestDto;
import com.bookPj.book.springboot.web.dto.PostsUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
public class PostsApiController {

	private final PostsService postsService;

	@PostMapping("/api/v1/posts")
	public Long save(@RequestBody PostsSaveRequestDto dto){
		return postsService.save(dto);
	}

	@PutMapping("/api/v1/posts/{id}")
	public Long update(@PathVariable Long id, @RequestBody PostsUpdateRequestDto requsetDto){
		return postsService.update(id, requsetDto);
	}

	@GetMapping("/api/v1/posts/{id}")
	public PostsResponseDto findById (@PathVariable Long id){
		return postsService.findById(id);
	}

}
