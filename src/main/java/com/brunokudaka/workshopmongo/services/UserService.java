package com.brunokudaka.workshopmongo.services;

import com.brunokudaka.workshopmongo.domain.User;
import com.brunokudaka.workshopmongo.repository.UserRepository;
import com.brunokudaka.workshopmongo.services.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    public List<User> findAll(){
        return repository.findAll();
    }

    public User findById(String id){
        return repository.findById(id).orElseThrow(() -> new ObjectNotFoundException("Usuário não encontrado"));
    }

}
