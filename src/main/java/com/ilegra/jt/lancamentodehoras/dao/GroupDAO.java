package com.ilegra.jt.lancamentodehoras.dao;

import com.ilegra.jt.lancamentodehoras.pojo.Group;
import com.ilegra.jt.lancamentodehoras.pojo.User;
import com.ilegra.jt.lancamentodehoras.repository.GroupRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class GroupDAO implements GroupRepository {

    @Override
    public List<Group> listByGroup(User user, Group Group) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Optional<Group> getById(int id) {
        return Memory.groups
                .stream()
                .filter((gropus) -> id == gropus.getId())
                .findFirst();
    }

    @Override
    public List<Group> listAll() {
        return Memory.groups == null
                ? new ArrayList<>()
                : Memory.groups;
    }
}
