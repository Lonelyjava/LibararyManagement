package com.lib.mana.reposistory;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lib.mana.entity.SellerEntity;

@Repository
public interface SellerReposistory extends JpaRepository<SellerEntity, Long>{

}
