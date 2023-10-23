package economy.ss.Laboratory.controller;

import economy.ss.Laboratory.dto.PostFormDto;
import economy.ss.Laboratory.entity.Post;
import economy.ss.Laboratory.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@RequestMapping("/posts")
@Controller
@RequiredArgsConstructor
public class PostController {

    private final PostService postService;

    @GetMapping(value="/new")
    public String postForm(Model model) {
        model.addAttribute("postFormDto", new PostFormDto());
        return "post/postForm";
    }

    @PostMapping(value="/new")
    public String newPost(@Valid PostFormDto postFormDto, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            return "post/postForm";
        }

        try {
            Post post = Post.createPost(postFormDto);
            postService.savePost(post);
        } catch (IllegalStateException e) {
            model.addAttribute("errorMessage", e.getMessage());
            return "post/postForm";
        }

        return "redirect:/";
    }
}
