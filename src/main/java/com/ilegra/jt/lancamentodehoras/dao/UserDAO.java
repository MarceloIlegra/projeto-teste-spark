
package com.ilegra.jt.lancamentodehoras.dao;

import com.ilegra.jt.lancamentodehoras.main.App;
import com.ilegra.jt.lancamentodehoras.model.User;
import com.ilegra.jt.lancamentodehoras.repository.UserRepository;
import java.util.Optional;

public class UserDAO implements UserRepository{

    @Override
    public Optional<User> login(String login, String password) {
           
        return  App.users
                .stream()
                .filter((valor)->valor.getLogin().equals(login) && valor.getPassword().equals(password))
                .findFirst();
     
    }
    
}
