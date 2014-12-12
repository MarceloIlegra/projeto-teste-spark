package com.ilegra.jt.lancamentodehoras.repository;

import com.ilegra.jt.lancamentodehoras.pojo.ActivityType;
import com.ilegra.jt.lancamentodehoras.pojo.User;
import java.util.List;
import java.util.Optional;

public interface ActivityTypeRepository {

    public List<ActivityType> listByActivity(User user, ActivityType activityType);

    public List<ActivityType> listAll();

    public Optional<ActivityType> getById(int id);
}
