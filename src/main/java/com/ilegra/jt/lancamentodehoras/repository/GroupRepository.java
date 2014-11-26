package com.ilegra.jt.lancamentodehoras.repository;

import com.ilegra.jt.lancamentodehoras.model.Project;
import com.ilegra.jt.lancamentodehoras.model.SubProject;
import com.ilegra.jt.lancamentodehoras.model.User;
import com.ilegra.jt.lancamentodehoras.model.Group;
import java.util.List;

public interface GroupRepository {

    public List<Group> listByUserAndProjectAndSubProject(User user, Project project, SubProject subProject);

}
