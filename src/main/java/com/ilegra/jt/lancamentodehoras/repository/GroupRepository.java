package com.ilegra.jt.lancamentodehoras.repository;

import com.ilegra.jt.lancamentodehoras.pojo.User;
import com.ilegra.jt.lancamentodehoras.pojo.Group;
import java.util.List;
import java.util.Optional;

public interface GroupRepository {

    public List<Group> listByGroup(User user,Group Group);
    
    public List<Group> listAll();
    
    public Optional<Group> getById(int id);
}
