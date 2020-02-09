package fun.codefarmer.securitybysql.mapper;

import fun.codefarmer.securitybysql.pojo.Role;
import fun.codefarmer.securitybysql.pojo.User;

import java.util.List;

/**
 * @ @ClassName UserMapper
 * @ Descriotion TODO
 * @ Author admin
 * @ Date 2020/2/8 17:24
 **/
public interface UserMapper {
    public User loadUserByUsername(String username);

    public List<Role> getUserRolesById(Integer id);
}
