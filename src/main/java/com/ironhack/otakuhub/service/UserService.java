package com.ironhack.otakuhub.service;

import com.ironhack.otakuhub.dto.UserDTO;
import com.ironhack.otakuhub.enums.Level;
import com.ironhack.otakuhub.exception.UsernameNotFoundException;
import com.ironhack.otakuhub.model.Anime;
import com.ironhack.otakuhub.model.Quote;
import com.ironhack.otakuhub.model.User;
import com.ironhack.otakuhub.repository.UserRepository;
import com.ironhack.otakuhub.exception.UserNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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
        return userRepository.save(user);

    }

    public void deleteUser(String username) {
        userRepository.deleteByUsername(username);
    }

    public User updateUserByAdmin (String username,
                                    Optional<String> password,
                                    Optional<String> roles,
                                    Optional<Boolean> isAccountNonLocked,
                                    Optional<Integer> points,
                                    Optional<Level> level,
                                    Optional<Anime> anime,
                                    Optional<Quote> animeQuote) {

        var userToUpdate = (username);

        username.ifPresent(userToUpdate::setUsername);
        password.ifPresent(userToUpdate::setPassword);
        roles.ifPresent(userToUpdate::setRoles);
        isAccountNonLocked.ifPresent(userToUpdate::setIsAccountNonLocked);
        points.ifPresent(userToUpdate::setPoints);
        level.ifPresent(userToUpdate::setLevel);
        anime.ifPresent(userToUpdate::addAnimeToAnimeList);
        animeQuote.ifPresent(userToUpdate::addQuoteToQuoteList);

        return userRepository.save(userToUpdate);
    }

    private User findUserById(Long id) {
        return userRepository.findById(id).orElseThrow(() -> new UserNotFoundException(id));
    }

    public User updateUserByUser(Long id, Optional<String> username, Optional<String> password, Optional<Anime> anime) {

        var userToUpdate = findUserById (id);

        username.ifPresent(userToUpdate::setUsername);
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
