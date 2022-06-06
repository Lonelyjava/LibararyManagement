package com.lib.mana.reposistory;


import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.lib.mana.entity.UserEntity;

@Repository
public interface UserReposistory extends JpaRepository<UserEntity, Long>{

	public Optional<UserEntity> findByMobile(String mobile);
	
	Optional<UserEntity> findByUsernameOrEmail(String username, String email);

	@Transactional
	@Modifying
	@Query("update UserEntity u set u.password=:password ,u.confPassword =:confPassword where u.mobile =:mobile")
	public void updatePassword(@Param("mobile") String mobile,@Param("password")  String password,@Param("confPassword")  String confPassword);

}

