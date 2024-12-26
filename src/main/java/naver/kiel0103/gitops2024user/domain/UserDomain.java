package naver.kiel0103.gitops2024user.domain;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public class UserDomain {

    private final Long id;
    private final String username;
    private final String password;
}
