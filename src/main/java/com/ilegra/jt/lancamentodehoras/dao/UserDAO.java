
package com.ilegra.jt.lancamentodehoras.dao;

import com.ilegra.jt.lancamentodehoras.config.Memory;
import com.ilegra.jt.lancamentodehoras.model.User;
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
    
}
