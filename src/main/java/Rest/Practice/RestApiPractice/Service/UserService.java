package Rest.Practice.RestApiPractice.Service;


import Rest.Practice.RestApiPractice.Entity.UserEntry;
import Rest.Practice.RestApiPractice.Repository.UserRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Component
public class UserService {
@Autowired
    private UserRepository userRepository;
    private static final PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
    public void createNewUser(UserEntry userEntry) {
        userEntry.setPassword(passwordEncoder.encode(userEntry.getPassword()));
        userEntry.setRoles(Arrays.asList("USER"));
        userRepository.save(userEntry);

    }
public void createUser(UserEntry user) {
    userRepository.save(user);
}
public List<UserEntry> getAllUsers() {
    return userRepository.findAll();
}
public Optional<UserEntry> getUserById(ObjectId id) {
    return userRepository.findById(id);
}
public void deleteUserById(ObjectId id) {
    userRepository.deleteById(id);
}

    public UserEntry getUserByEmail(String email) {
       return userRepository.findByEmail(email);

    }
}
