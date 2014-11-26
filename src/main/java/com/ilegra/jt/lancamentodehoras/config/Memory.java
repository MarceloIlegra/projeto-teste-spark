
package com.ilegra.jt.lancamentodehoras.config;

import com.ilegra.jt.lancamentodehoras.model.User;
import java.util.ArrayList;

public class Memory {

    public static ArrayList<User> users = new ArrayList<User>();
    
    public void start(){
        users.add(new User("marcelo", "123"));
        users.add(new User("admin", "123"));
    }
    
}
