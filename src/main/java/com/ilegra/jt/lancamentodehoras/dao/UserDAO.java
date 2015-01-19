package com.ilegra.jt.lancamentodehoras.dao;

import com.ilegra.jt.lancamentodehoras.pojo.User;
import com.ilegra.jt.lancamentodehoras.repository.UserRepository;
import java.util.Optional;

public class UserDAO implements UserRepository{

    @Override
    public Optional<User> login(String login, String password) {
           
        return  Memory.users
                .stream()
                .filter((valor)->valor.getLogin().equals(login) && valor.getPassword().equals(password))
                .findFirst();     
    }
    
    @Override
    public Optional<User> getById(int id) {
        return Memory.users
                .stream()
                .filter((user) -> id == user.getId())
                .findFirst();
    }
}
