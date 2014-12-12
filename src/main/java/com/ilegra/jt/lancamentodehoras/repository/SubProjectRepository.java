package com.ilegra.jt.lancamentodehoras.repository;

import com.ilegra.jt.lancamentodehoras.pojo.SubProject;
import com.ilegra.jt.lancamentodehoras.pojo.User;
import java.util.List;
import java.util.Optional;

public interface SubProjectRepository {

    public List<SubProject> listBySubProject(User user, SubProject subproject);

    public List<SubProject> listAll();

    public Optional<SubProject> getById(int id);

}
