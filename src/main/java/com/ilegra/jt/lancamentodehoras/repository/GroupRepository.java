package com.ilegra.jt.lancamentodehoras.repository;

import com.ilegra.jt.lancamentodehoras.model.User;
import com.ilegra.jt.lancamentodehoras.model.Group;
import java.util.List;
import java.util.Optional;

public interface GroupRepository {

    public List<Group> listByGroup(User user,Group Group);
    public List<Group> listAll();
    public Optional<Group> getById(int id);
}
