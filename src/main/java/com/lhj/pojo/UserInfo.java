package com.lhj.pojo;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sun.istack.internal.NotNull;
import lombok.Data;
import org.hibernate.validator.constraints.Length;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import java.io.PrintWriter;
import java.util.Collection;
import java.util.List;

@Data
@Entity
@Table(name="tb_user")
public class UserInfo implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotEmpty(message = "用户名不能为空")
    private String username;
    @NotEmpty(message = "密码不能为空")
    @JsonIgnore
    private String password;
    private String nickname;
    private String role;
    @Transient
    @JsonIgnore
    @TableField(exist = false)
    private Collection<? extends GrantedAuthority> authorities;

//    public UserInfo() {
//    }
//
//    public UserInfo( Integer id, String username, String password, String role ) {
//        this.id=id;
//        this.username = username;
//        this.password = password;
//        this.role = role;
//    }
//
//    public UserInfo( String username, String encode, List<GrantedAuthority> authorities ) {
//        this.username = username;
//        this.password = encode;
//        this.authorities = authorities;
//    }

    @JsonIgnore
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @JsonIgnore
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @JsonIgnore
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @JsonIgnore
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @JsonIgnore
    @Override
    public boolean isEnabled() {
        return true;
    }
}
