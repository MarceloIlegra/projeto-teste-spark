package com.ilegra.jt.lancamentodehoras.dao;

import com.ilegra.jt.lancamentodehoras.model.SubProject;
import com.ilegra.jt.lancamentodehoras.model.User;
import com.ilegra.jt.lancamentodehoras.repository.SubProjectRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class SubProjectDAO implements SubProjectRepository {

    @Override
    public List<SubProject> listBySubProject(User user, SubProject subproject) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Optional<SubProject> getById(int id) {
        return Memory.subProjects
                .stream()
                .filter((subProject) -> id == subProject.getId())
                .findFirst();
    }

    @Override
    public List<SubProject> listAll() {

        return Memory.subProjects == null
                ? new ArrayList<>()
                : Memory.subProjects;
    }
}
