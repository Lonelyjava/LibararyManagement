package com.lib.mana.reposistory;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lib.mana.entity.PublisherEntity;

@Repository
public interface PublisherReposistory extends JpaRepository<PublisherEntity, Long>{

}
