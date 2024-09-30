package me.vibhishanranga.bookmyshowdesign.repositories;

import me.vibhishanranga.bookmyshowdesign.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User save(User user);

    Optional<User> findById(Long id);
}
