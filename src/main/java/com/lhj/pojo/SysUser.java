package com.lhj.pojo;

import com.sun.istack.internal.NotNull;
import lombok.Data;
import org.hibernate.validator.constraints.Length;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import java.util.Collection;

@Data
public class SysUser implements UserDetails {
    private Integer id;

    @NotEmpty(message = "用户名不能为空")
    private String username;
    @NotEmpty(message = "密码不能为空")
    private String password;
    private String role;
    private Collection<?extends GrantedAuthority> authorities;

    public SysUser( String username, String password, String role){
        this.username=username;
        this.password=password;
        this.authorities=authorities;
        this.role=role;
    }
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public boolean isAccountNonExpired() {
        return false;
    }

    @Override
    public boolean isAccountNonLocked() {
        return false;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return false;
    }

    @Override
    public boolean isEnabled() {
        return false;
    }
}
