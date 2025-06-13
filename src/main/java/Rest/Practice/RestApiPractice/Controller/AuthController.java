package Rest.Practice.RestApiPractice.Controller;


import Rest.Practice.RestApiPractice.Entity.UserEntry;
import Rest.Practice.RestApiPractice.Service.UserService;
import Rest.Practice.RestApiPractice.Service.UserServiceImpl;
import Rest.Practice.RestApiPractice.Utility.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
    @Autowired
    private UserService userService;
    @Autowired
    private UserServiceImpl userServiceImpl;
    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtUtil jwtUtil;
    @PostMapping("/signin")
    public ResponseEntity<?> addUser(@RequestBody UserEntry userEntry) {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(userEntry.getEmail(), userEntry.getPassword()));
            UserDetails userDetails=userServiceImpl.loadUserByUsername(userEntry.getEmail());
            String jwt= jwtUtil.generateToken(userDetails.getUsername());
            return new ResponseEntity<>(jwt, HttpStatus.CREATED);
        }
        catch (Exception e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/signup")
    public ResponseEntity<?> signup(@RequestBody UserEntry userEntry) {
        try{
            userService.createNewUser(userEntry);
            return new ResponseEntity<>(userEntry, HttpStatus.CREATED);

        }
        catch(Exception e){
            return new ResponseEntity<>( HttpStatus.BAD_REQUEST);
        }
    }

}
