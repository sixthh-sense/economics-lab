package economy.ss.Laboratory.service;

import economy.ss.Laboratory.entity.Post;
import economy.ss.Laboratory.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class PostService {

    private final PostRepository postRepository;
    public void savePost(Post post) {
        postRepository.save(post);
    }
}
