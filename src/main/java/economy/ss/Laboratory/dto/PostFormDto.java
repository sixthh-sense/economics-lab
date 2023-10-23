package economy.ss.Laboratory.dto;

import economy.ss.Laboratory.entity.Category;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
public class PostFormDto {
    @NotBlank(message = "제목은 필수 입력 값입니다.")
    @Length(min = 2, message = "제목은 2글자 이상으로 입력해주세요.")
    private String title;

    @NotBlank(message = "게시글 내용을 입력해주세요.")
    private String content;

    @NotBlank(message = "분류를 선택해주세요.")
    private Category category;
}
