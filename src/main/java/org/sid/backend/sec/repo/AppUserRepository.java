package org.sid.backend.sec.repo;

import org.sid.backend.sec.entities.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AppUserRepository extends JpaRepository<AppUser,Long> {
     AppUser findByUsername(String username);

     //find by id



}
