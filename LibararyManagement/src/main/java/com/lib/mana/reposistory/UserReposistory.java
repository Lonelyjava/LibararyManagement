package com.lib.mana.reposistory;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lib.mana.entity.UserEntity;

@Repository
public interface UserReposistory extends JpaRepository<UserEntity, Long>{

}
