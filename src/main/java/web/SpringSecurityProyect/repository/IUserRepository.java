package web.SpringSecurityProyect.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import web.SpringSecurityProyect.models.User;

@Repository
public interface IUserRepository extends JpaRepository<User, Integer>{
    


    public Optional<User> findByUsername(String username);
    
}
