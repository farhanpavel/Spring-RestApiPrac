package Rest.Practice.RestApiPractice.Entity;


import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

@Document(collection = "user")
@Data
@NoArgsConstructor
public class UserEntry {
    @Id
private ObjectId id;
private String email;
private String password;
private List<String> roles;
@DBRef
    private List<TodoEntry> todoEntries=new ArrayList<>();
}
