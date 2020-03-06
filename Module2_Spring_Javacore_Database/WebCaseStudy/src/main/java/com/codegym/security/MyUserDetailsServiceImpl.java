package com.codegym.security;

import com.codegym.repository.UserRePository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MyUserDetailsServiceImpl implements UserDetailsService
{
    @Autowired
    private UserRePository userRePository;
    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException
    {
        User user=userRePository.findByUsername(s);
        if(user==null) throw new UsernameNotFoundException("User {"+s+"} not found!");

        System.out.printf("Load user w/ username: {%s}",s);
        return new MyUserDetails(user);
    }
}
