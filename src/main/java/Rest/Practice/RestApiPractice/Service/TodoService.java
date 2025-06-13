package Rest.Practice.RestApiPractice.Service;


import Rest.Practice.RestApiPractice.Entity.TodoEntry;
import Rest.Practice.RestApiPractice.Entity.UserEntry;
import Rest.Practice.RestApiPractice.Repository.TodoRepository;
import Rest.Practice.RestApiPractice.Repository.UserRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class TodoService {
@Autowired
    private TodoRepository todoRepository;
@Autowired
    private UserRepository userRepository;
public void createTodo(TodoEntry entry, String userEmail) {
    UserEntry user =  userRepository.findByEmail(userEmail);
    TodoEntry todo = todoRepository.save(entry);
    user.getTodoEntries().add(todo);
    userRepository.save(user);
    todoRepository.save(entry);
}
public List<TodoEntry> getAllTodos(String userEmail) {
    UserEntry user = userRepository.findByEmail(userEmail);
    return user.getTodoEntries();
}
public Optional<TodoEntry> getTodoById(ObjectId id) {
    return todoRepository.findById(id);
}
public void deleteTodoById(ObjectId id, String userEmail) {
    UserEntry user = userRepository.findByEmail(userEmail);
    user.getTodoEntries().remove(id);
    userRepository.save(user);
    todoRepository.deleteById(id);
}
}
