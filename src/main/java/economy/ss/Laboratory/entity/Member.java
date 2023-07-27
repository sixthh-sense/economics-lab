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
public class Member  extends BaseEntity{

    @Id
    @Column(name = "member_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true) // 이후에 validation 등 제한 추가할 것
    private String username;

    @Column
    private String password;  // 이후에 validation 등 제한 추가할 것

    @Column(unique = true)  // 이후에 validation 등 제한 추가할 것
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
