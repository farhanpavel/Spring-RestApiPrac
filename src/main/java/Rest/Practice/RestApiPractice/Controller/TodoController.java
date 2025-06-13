package Rest.Practice.RestApiPractice.Controller;


import Rest.Practice.RestApiPractice.Entity.TodoEntry;
import Rest.Practice.RestApiPractice.Service.TodoService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/todo")
public class TodoController {
    @Autowired
    private TodoService todoService;
    @PostMapping
    public ResponseEntity<?>createTodo(@RequestBody TodoEntry todoEntry) {
        try{
            Authentication authentication= SecurityContextHolder.getContext().getAuthentication();
            String userEmail= authentication.getName();
             todoService.createTodo(todoEntry,userEmail);
            return new ResponseEntity<>(HttpStatus.CREATED);
        }
        catch(Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @GetMapping
    public ResponseEntity<?> getAllTodos() {
        Authentication authentication= SecurityContextHolder.getContext().getAuthentication();
        String userEmail= authentication.getName();
        List<TodoEntry> todos = todoService.getAllTodos(userEmail);
        return new ResponseEntity<>(todos, HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteTodo(@PathVariable ObjectId id) {
        Authentication authentication= SecurityContextHolder.getContext().getAuthentication();
        String userEmail= authentication.getName();
        todoService.deleteTodoById(id,userEmail);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
