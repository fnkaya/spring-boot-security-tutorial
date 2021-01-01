package com.spring.security.util;

import com.spring.security.entity.Authority;
import com.spring.security.entity.User;
import com.spring.security.repository.AuthorityRepository;
import com.spring.security.service.UserDetailsManagerImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class DatabasePopulator {

    private final UserDetailsManagerImpl userDetailsManager;
    private final AuthorityRepository authorityRepository;

    @Transactional
    public void populateDatabase(){
        List<Authority> authorityList = authorityRepository.saveAll(
                Set.of(new Authority(null, "READ"),
                        new Authority(null, "WRITE")));

        User admin = new User(null, "admin", "admin", Set.copyOf(authorityList));
        User user = new User(null, "user", "user", Set.of(authorityList.get(0)));
        User sys = new User(null, "sys", "sys", Set.of());

        userDetailsManager.createUser(admin);
        userDetailsManager.createUser(user);
        userDetailsManager.createUser(sys);
    }

}
