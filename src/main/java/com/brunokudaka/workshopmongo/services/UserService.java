package com.brunokudaka.workshopmongo.services;

import com.brunokudaka.workshopmongo.domain.User;
import com.brunokudaka.workshopmongo.dto.UserDTO;
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

    public User insert(User user){
        return repository.insert(user);
    }

    public void delete(String id){
        findById(id);
        repository.deleteById(id);
    }


    public User update(User user){
        User userUpdate = findById(user.getId());
        updateUser(userUpdate, user);
        return repository.save(userUpdate);
    }

    public User fromDTO(UserDTO dto){
        return new User(dto.getId(), dto.getName(), dto.getEmail());
    }

    private void updateUser(User userUpdate, User user) {
        userUpdate.setName(user.getName());
        userUpdate.setEmail(user.getEmail());
    }

}
