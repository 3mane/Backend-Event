package org.sid.backend.sec.repo;

import org.sid.backend.sec.entities.AppRole;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppRoleRepository extends JpaRepository<AppRole,Long> {
     AppRole findByRoleName(String roleName);


}
