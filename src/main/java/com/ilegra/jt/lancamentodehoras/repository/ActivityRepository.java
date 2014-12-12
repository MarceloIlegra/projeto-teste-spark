package com.ilegra.jt.lancamentodehoras.repository;

import com.ilegra.jt.lancamentodehoras.pojo.Activity;
import com.ilegra.jt.lancamentodehoras.pojo.Project;
import com.ilegra.jt.lancamentodehoras.pojo.User;
import java.util.List;
import java.util.Optional;

public interface ActivityRepository {

    public Long add(User user, Activity activity);

    public void delete(User user, Project project, Activity activity);

    public void update(User user, Project project, Activity activity);
    
    public Optional<Activity> find(Long id);

    public List<Activity> listByMonth(User user,Project project, Short month);

    public List<Activity> listAll();
    
    public String getTotalTimeFormated();
    
    public long getTotalTimeInMinutes();
}
