package economy.ss.Laboratory.entity;

import economy.ss.Laboratory.dto.PostFormDto;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@ToString
@Builder
@Table(name = "post")
@NoArgsConstructor
@AllArgsConstructor
public class Post  extends BaseEntity{
    @Id
    @Column(name = "post_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String title;

    @Column
    private String contents;

    @ManyToOne
    @JoinColumn(name = "member_id")
    private Member member;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    public static Post createPost(PostFormDto postFormDto) {
        return Post.builder()
                .title(postFormDto.getTitle())
                .contents(postFormDto.getContent())
                .category(postFormDto.getCategory())
                .build();
    }
}
