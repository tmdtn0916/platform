package com.mnu.platform.repository;

import com.mnu.platform.entity.UserData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserData, Long> {

    UserData findByEmail(String email);

}
