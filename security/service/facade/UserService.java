package com.chanel.fsh.peps.nextgen.cms.zouani.util.security.service.facade;

import com.chanel.fsh.peps.nextgen.cms.zouani.util.security.bean.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface UserService extends UserDetailsService {

    String cryptPassword(String value);

    boolean changePassword(String username, String newPassword);

    List<User> findAll();

    User findByUsername(String username);

    User findById(Long id);

    void deleteById(Long id);

    User save(User user);

    User update(User user);

    int delete(Long id);

    User findByUsernameWithRoles(String username);

    int deleteByUsername(String username);

    public UserDetails loadUserByUsername(String username);

}
