package com.ilegra.jt.lancamentodehoras.repository;

import com.ilegra.jt.lancamentodehoras.pojo.Activity;
import java.util.List;
import java.util.Optional;

public interface ActivityRepository {

    public Long add(Activity activity);

    public void delete(Activity activity);

    public void update(Activity activity);
    
    public Optional<Activity> find(Long id);

    public List<Activity> listByMonth(Short month);

    public List<Activity> listAll();
}
