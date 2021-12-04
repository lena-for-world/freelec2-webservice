package org.example.springboot.web.dto;

import java.time.LocalDateTime;
import lombok.Getter;
import org.example.springboot.domain.posts.Posts;

@Getter
public class PostsListResponseDto {
    private Long id;
    private String title;
    private String author;
    private LocalDateTime modifiedDate;

    public PostsListResponseDto(Posts entity) {
        this.title = entity.getTitle();
        this.id = entity.getId();
        this.author = entity.getAuthor();
        this.modifiedDate = entity.getModifiedDate();
    }

}
