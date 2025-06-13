package Rest.Practice.RestApiPractice.Repository;

import Rest.Practice.RestApiPractice.Entity.TodoEntry;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface TodoRepository extends MongoRepository<TodoEntry, ObjectId> {
}
