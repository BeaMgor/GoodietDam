package com.goodiet.goodietbackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.goodiet.goodietbackend.domain.Usuario;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<Usuario, Integer> {

    List<Usuario> findAll();

    Usuario findByUsername(String username);
    
    Usuario findUsuarioById(Long id);

    Usuario findUsuarioByUsername(String username);
}
