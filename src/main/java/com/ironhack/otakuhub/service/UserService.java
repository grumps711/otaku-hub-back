package com.ironhack.otakuhub.service;

import com.ironhack.otakuhub.dto.UserDTO;
import com.ironhack.otakuhub.enums.Level;
import com.ironhack.otakuhub.exception.UsernameNotFoundException;
import com.ironhack.otakuhub.model.Anime;
import com.ironhack.otakuhub.model.Quote;
import com.ironhack.otakuhub.model.User;
import com.ironhack.otakuhub.repository.UserRepository;
import com.ironhack.otakuhub.exception.UserNotFoundException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static com.ironhack.otakuhub.enums.Level.NOOB;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;


    public User createUser(UserDTO userDTO) {
        var user = new User ();
        user.setPassword(passwordEncoder.encode(userDTO.getPassword()));
        user.setUsername(userDTO.getUsername());
        user.setRoles("ROLE_USER");
        user.setPoints(0);
        user.setLevel(Level.NOOB);
        return userRepository.save(user);

    }

    public List<User> deleteUserByUsername(String username) {
        findUserByUsername (username);
        return userRepository.deleteUserByUsername(username);
    }

    public User updateUserByAdmin ( String username, //as id
                                    Optional <String> username1, //username = username1
                                    Optional<String> password,
                                    Optional<String> roles,
                                    Optional<Boolean> isAccountNonLocked,
                                    Optional<Integer> points,
                                    Optional<Level> level,
                                    Optional<Anime> anime,
                                    Optional<Quote> animeQuote) {

        var userToUpdate = findUserByUsername (username);

        username1.ifPresent (userToUpdate::setUsername);
        password.ifPresent(userToUpdate::setPassword);
        roles.ifPresent(userToUpdate::setRoles);
        isAccountNonLocked.ifPresent(userToUpdate::setIsAccountNonLocked);
        points.ifPresent(userToUpdate::setPoints);
        level.ifPresent(userToUpdate::setLevel);
        anime.ifPresent(userToUpdate::addAnimeToAnimeList);
        animeQuote.ifPresent(userToUpdate::addQuoteToQuoteList);

        return userRepository.save(userToUpdate);
    }

    private User findUserByUsername(String username) {
        return userRepository.findByUsername(username).orElseThrow(() -> new UsernameNotFoundException(username));
    }

    private User findUserById(Long id) {
        return userRepository.findById(id).orElseThrow(() -> new UserNotFoundException(id));
    }

    public User updateUserByUser(String username, Optional <String> username1, Optional<String> password, Optional<Anime> anime) {

        var userToUpdate = findUserByUsername (username);

        username1.ifPresent(userToUpdate::setUsername);
        password.ifPresent(userToUpdate::setPassword);
        anime.ifPresent(userToUpdate::addAnimeToAnimeList);

        return userRepository.save(userToUpdate);
    }

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public User addPoints(String username) {
            var userToAddPoints = userRepository.findByUsername(username).orElseThrow(() -> new UsernameNotFoundException(username));
            userToAddPoints.addPoints();

        return userRepository.save (userToAddPoints);
    }

    public Boolean userExist(String username) {
        var userToCheck = userRepository.findByUsername(username).orElseThrow(() -> new UsernameNotFoundException(username));
        if (userToCheck != null) {
            return true;
        }
        else {
            return false;
        }
    }
}
