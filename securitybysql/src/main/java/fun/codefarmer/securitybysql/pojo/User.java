package fun.codefarmer.securitybysql.pojo;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * @ @ClassName User
 * @ Descriotion TODO
 * @ Author admin
 * @ Date 2020/2/8 16:44
 **/
public class User implements UserDetails {
    private Integer id;
    private String username;
    private String password;
    private Boolean enabled;
    private Boolean locked;

    //可能会有多个角色
    private List<Role> roles;

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    @Override
    public String getUsername() {
        return username;
    }

    @Override
    //此处数据库中应该有一个字段 表示账户是否过期，查询时返回此数据。
    // 这个没有这个字段，所以写成定值true
    public boolean isAccountNonExpired() {//账户是否未过期
        return true;
    }

    @Override
    //次数数据库有字段表示 ，所以返回 locked，这个相当时get方法。所以需要删除，
    public boolean isAccountNonLocked() {//账户是否未锁定

        return !locked;
    }
    //上面方法与此方法原理一直，删除防止重复
//    public Boolean getLocked() {
//        return locked;
//    }

    public void setLocked(Boolean locked) {
        this.locked = locked;
    }
    @Override
    //数据库没有代表字段，写成定值 true
    public boolean isCredentialsNonExpired() {// 密码是否未过期
        return true;
    }

    @Override
    public boolean isEnabled() {
        return enabled;
    }
    // 与账户锁定道理相同，需要删除
//    public Boolean getEnabled() {
//        return enabled;
//    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }
    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<SimpleGrantedAuthority> authorities = new ArrayList<>();
        for (Role role : roles) {
                                            // spring security 角色认证需要在前面加 ROLE_；数据库中如果加入，此处就不需要加了
            authorities.add(new SimpleGrantedAuthority("ROLE_"+role.getName()));
        }
        return authorities;
    }
    @Override
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }




}
