package Rest.Practice.RestApiPractice.Controller;


import Rest.Practice.RestApiPractice.Entity.UserEntry;
import Rest.Practice.RestApiPractice.Service.UserService;
import Rest.Practice.RestApiPractice.Service.UserServiceImpl;
import Rest.Practice.RestApiPractice.Utility.JwtUtil;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user")
public class UserController {
    @Autowired
    private UserService userService;



@PutMapping("/{id}")
    public ResponseEntity<?> updateUser(@RequestBody UserEntry user,@PathVariable ObjectId id) {
    UserEntry old = userService.getUserById(id).orElse(null);
    if (old != null) {
        old.setEmail(user.getEmail()!=null && !user.getEmail().equals("")?user.getEmail():old.getEmail());
    }
    userService.createUser(old);
    return new ResponseEntity<>(HttpStatus.OK);
}
@GetMapping()
    public ResponseEntity<?> getUserById() {
    Authentication authentication= SecurityContextHolder.getContext().getAuthentication();
    String userName= authentication.getName();
  UserEntry old =userService.getUserByEmail(userName);
    return new ResponseEntity<>(old,HttpStatus.OK);
}

}
