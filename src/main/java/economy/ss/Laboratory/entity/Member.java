package economy.ss.Laboratory.entity;

import economy.ss.Laboratory.constant.Role;
import economy.ss.Laboratory.dto.MemberFormDto;
import lombok.*;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.persistence.*;

@Entity
@Getter
@Setter
@ToString
@Builder
@Table(name = "member")
@NoArgsConstructor
@AllArgsConstructor
public class Member {

    @Id
    @Column(name = "member_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;

    private String password;

    @Column(unique = true)
    private String email;

    @Enumerated(EnumType.STRING)
    private Role role;

    public static Member createMember(MemberFormDto memberFormDto, PasswordEncoder passwordEncoder) { //
        return Member.builder()
                .username(memberFormDto.getUsername())
               // .password(memberFormDto.getPassword())
                .password(passwordEncoder.encode(memberFormDto.getPassword()))
                .email(memberFormDto.getEmail())
                .role(Role.ADMIN)
                .build();
    }
}
