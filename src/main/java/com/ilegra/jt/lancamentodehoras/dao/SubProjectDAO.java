package com.ilegra.jt.lancamentodehoras.dao;

import com.ilegra.jt.lancamentodehoras.exceptions.SubProjectNotFoundException;
import com.ilegra.jt.lancamentodehoras.model.SubProject;
import com.ilegra.jt.lancamentodehoras.model.User;
import com.ilegra.jt.lancamentodehoras.repository.SubProjectRepository;
import java.util.ArrayList;
import java.util.List;

public class SubProjectDAO implements SubProjectRepository {

    @Override
    public List<SubProject> listBySubProject(User user, SubProject subproject) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public SubProject getById(int id) throws SubProjectNotFoundException {

        SubProject subProject = null;

        try {
            subProject = Memory.subProjects.get(id);
        } catch (java.lang.IndexOutOfBoundsException exceptionMessage) {
            throw new SubProjectNotFoundException();
        }

        return subProject;
    }

    @Override
    public List<SubProject> listAll() {

        return Memory.subProjects == null
                ? new ArrayList<>()
                : Memory.subProjects;
    }

}
