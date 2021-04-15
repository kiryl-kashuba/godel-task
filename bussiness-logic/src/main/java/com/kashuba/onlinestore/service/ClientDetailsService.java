//package com.kashuba.onlinestore.service;
//
//import com.kashuba.onlinestore.dao.ClientRepository;
//import com.kashuba.onlinestore.entity.Client;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.stereotype.Component;
//
//import java.util.Arrays;
//import java.util.List;
//
//public class ClientDetailsService implements UserDetailsService {
//    @Autowired
//    private ClientRepository repository;
//
//    @Override
//    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
//        Client client = repository.findByEmail(email);
//
//        if(client == null) {
//            throw new UsernameNotFoundException("User not found");
//        }
//
//        List<SimpleGrantedAuthority> authorities = Arrays.asList(new SimpleGrantedAuthority("client"));
//
//        return new Client(client.getEmail(), client.getPassword(), authorities);
//    }
//}
//
//
