package com.userRegistration.security;

import com.userRegistration.entity.Profile;
import com.userRegistration.entity.User;
import com.userRegistration.repository.UserRepository;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Collections;
import java.util.stream.Collectors;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    private UserRepository userRepository;

    public CustomUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = userRepository.findByEmail(email);

        if (user != null) {
            return new org.springframework.security.core.userdetails.User(user.getEmail(),
                    user.getPassword(),
                    mapRolesToAuthorities((user.getProfile())));
        }else{
            throw new UsernameNotFoundException("Usuário ou senha inválidos.");
        }
    }

    private Collection < ? extends GrantedAuthority> mapRolesToAuthorities(Profile profile) {
        Collection < ? extends GrantedAuthority> mapRoles = Collections.singleton(new SimpleGrantedAuthority(profile.getName()));
        return mapRoles;
    }
}

