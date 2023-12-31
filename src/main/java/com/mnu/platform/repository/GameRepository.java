package com.mnu.platform.repository;

import com.mnu.platform.entity.Game;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface GameRepository extends JpaRepository<Game,Long> {

    Optional<Game> findById(Long id);
}
