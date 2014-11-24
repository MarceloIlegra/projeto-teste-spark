package com.ilegra.jt.lancamentodehoras.repository;

import com.ilegra.jt.lancamentodehoras.model.Project;
import com.ilegra.jt.lancamentodehoras.model.Time;
import com.ilegra.jt.lancamentodehoras.model.User;
import java.util.List;

/**
 *
 * @author Rafael de Paula Souza
 */
public interface TimeRepository {
    
    public Long add(User user, Project project, Time time);
    public void delete(User user, Project project, Time time);
    public void update(User user, Project project, Time time);
    public List<Time> listByMonth(User user, Short month);
    
}
