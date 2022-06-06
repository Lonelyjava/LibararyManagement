package com.lib.mana.reposistory;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lib.mana.entity.BookEntity;

@Repository
public interface BookReposistory extends JpaRepository<BookEntity, Long> {

}
