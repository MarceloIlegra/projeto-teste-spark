package com.ilegra.jt.lancamentodehoras.repository;

import com.ilegra.jt.lancamentodehoras.model.Activity;
import com.ilegra.jt.lancamentodehoras.model.Project;
import com.ilegra.jt.lancamentodehoras.model.User;
import java.util.List;

public interface ActivityRepository {

    public Long add(User user, Project project, Activity activity);

    public void delete(User user, Project project, Activity activity);

    public void update(User user, Project project, Activity activity);

    public List<Activity> listByMonth(User user,Project project, Short month);

    public List<Activity> listAll();
    
    public String getTotalTimeFormated();
    
    public long getTotalTimeInMinutes();
}
