package com.springsecurity.formbased;

import com.springsecurity.formbased.model.Authority;
import com.springsecurity.formbased.model.User;
import com.springsecurity.formbased.repository.AuthorityRepository;
import com.springsecurity.formbased.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
@RequiredArgsConstructor
public class DbInit implements CommandLineRunner {

    private final AuthorityRepository authorityRepository;
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public void run(String... args) throws Exception {

        Authority role_user = new Authority("ROLE_USER");
        Authority role_manager = new Authority("ROLE_MANAGER");
        Authority role_admin = new Authority("ROLE_ADMIN");

        Authority access_test1 = new Authority("ACCESS_TEST1");
        Authority access_test2 = new Authority("ACCESS_TEST2");

        authorityRepository.saveAll(Set.of(role_user, role_manager, role_admin, access_test1, access_test2));

        User user = new User("user", passwordEncoder.encode("u123"), role_user, Set.of());
        User manager = new User("manager", passwordEncoder.encode( "m123"), role_manager, Set.of(access_test1));
        User admin = new User("admin", passwordEncoder.encode("a123"), role_admin, Set.of(access_test1, access_test2));

        userRepository.saveAll(Set.of(user, manager, admin));
    }
}
