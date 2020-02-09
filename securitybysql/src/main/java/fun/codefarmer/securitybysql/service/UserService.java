package fun.codefarmer.securitybysql.service;

import fun.codefarmer.securitybysql.mapper.UserMapper;
import fun.codefarmer.securitybysql.pojo.Role;
import fun.codefarmer.securitybysql.pojo.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @ @ClassName UserService
 * @ Descriotion TODO
 * @ Author admin
 * @ Date 2020/2/8 17:24
 **/
@Service
public class UserService implements UserDetailsService {
    @Resource
    private UserMapper userMapper;
    @Override
    // 根据用户名去数据库查询
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userMapper.loadUserByUsername(username);
        if (user == null) {
            //抛出异常，也会报badsql 错误
            throw new UsernameNotFoundException("用户不存在");
        }
        List<Role> role = userMapper.getUserRolesById(user.getId());
        user.setRoles(role);
        return user;
    }
}
