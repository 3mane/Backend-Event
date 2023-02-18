package org.sid.backend.sec.service;

import org.sid.backend.sec.entities.AppRole;
import org.sid.backend.sec.entities.AppUser;

import java.util.List;

public interface AccountService {
     AppUser addNewUser(AppUser appUser);
     AppRole addNewRole(AppRole appRole);

     void addRoleToUser(String username, String roleName);
     AppUser loadUserByUsername(String username);
     List<AppUser> listUsers();

  //  List<AppUser> listUsersWithRoles();
}
