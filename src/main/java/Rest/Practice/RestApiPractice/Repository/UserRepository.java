package Rest.Practice.RestApiPractice.Repository;

import Rest.Practice.RestApiPractice.Entity.UserEntry;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<UserEntry, ObjectId> {
    UserEntry findByEmail(String email);
}
