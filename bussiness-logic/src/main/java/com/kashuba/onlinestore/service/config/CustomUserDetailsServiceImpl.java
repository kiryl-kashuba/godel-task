package com.kashuba.onlinestore.service.config;

import com.kashuba.onlinestore.dao.ClientRepository;
import com.kashuba.onlinestore.entity.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

@Component
public class CustomUserDetailsServiceImpl implements UserDetailsService {
    private final ClientRepository clientRepository;

    @Autowired
    public CustomUserDetailsServiceImpl(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Client client = clientRepository.findByEmail(email);
        if (client == null) {
            throw new UsernameNotFoundException("No user present with email: " + email);
        }
        return new CustomUserDetails(client);
    }

}
