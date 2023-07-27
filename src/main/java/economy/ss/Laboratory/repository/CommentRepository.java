package economy.ss.Laboratory.repository;

import economy.ss.Laboratory.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment, Long> {
}
