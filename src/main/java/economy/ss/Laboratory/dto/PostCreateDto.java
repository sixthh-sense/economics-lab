package economy.ss.Laboratory.dto;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
public class PostCreateDto {
    @NotBlank(message = "제목은 필수 입력 값입니다.")
    @Length(min = 2, message = "제목은 2글자 이상으로 입력해주세요.")
    private String title;

    @NotBlank(message = "게시글 내용을 입력해주세요.")
    private String content;
}
