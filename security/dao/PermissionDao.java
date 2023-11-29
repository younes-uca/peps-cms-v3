package com.chanel.fsh.peps.nextgen.cms.zouani.util.security.dao;

import com.chanel.fsh.peps.nextgen.cms.zouani.util.security.bean.Permission;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PermissionDao extends JpaRepository<Permission, Long> {
    public Permission findByName(String name);
}
