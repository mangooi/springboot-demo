package club.mangooi.springboot.demo.mapper;

import club.mangooi.springboot.demo.repository.UserRole;
import club.mangooi.springboot.demo.utils.model.PWDModel;

public interface UserRoleMapper {
    boolean register(UserRole userRole);
    PWDModel getPWDModel(String name);
}
