package com.ilegra.jt.lancamentodehoras.repository;

import com.ilegra.jt.lancamentodehoras.pojo.Activity;
import com.ilegra.jt.lancamentodehoras.pojo.User;
import java.util.List;
import java.util.Optional;

public interface ActivityRepository {

    public Long add(User user, Activity activity);

    public void delete(User user,Activity activity);

    public void update(User user,Activity activity);
    
    public Optional<Activity> find(Long id);

    public List<Activity> listByMonth(User user,Short month);

    public List<Activity> listAll();
}
