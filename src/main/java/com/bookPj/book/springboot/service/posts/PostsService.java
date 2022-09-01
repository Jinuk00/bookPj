package com.bookPj.book.springboot.service.posts;

import com.bookPj.book.springboot.domain.posts.Posts;
import com.bookPj.book.springboot.domain.posts.PostsRepository;
import com.bookPj.book.springboot.web.dto.PostsResponseDto;
import com.bookPj.book.springboot.web.dto.PostsSaveRequestDto;
import com.bookPj.book.springboot.web.dto.PostsUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@RequiredArgsConstructor
@Service
public class PostsService {
	private final PostsRepository postsRepository;

	@Transactional
	public Long save(PostsSaveRequestDto dto){
		return postsRepository.save(dto.toEntity()).getId();
	}

	@Transactional
	public Long update(Long id, PostsUpdateRequestDto dto){
		Posts posts = postsRepository.findById(id).orElseThrow(()->new IllegalArgumentException("해당 게시글이 없습니다. id="+id));

		posts.update(dto.getTitle(),dto.getContent());

		return id;
	}
	public PostsResponseDto findById(Long id){
		Posts entity = postsRepository.findById(id).orElseThrow(()->new IllegalArgumentException("해당 게시글이 없습니다. id="+id));

		return new PostsResponseDto(entity);
	}
}
