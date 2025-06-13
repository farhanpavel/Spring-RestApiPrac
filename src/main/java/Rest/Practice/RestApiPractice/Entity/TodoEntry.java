package Rest.Practice.RestApiPractice.Entity;


import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Todo")
@Data
@NoArgsConstructor
public class TodoEntry {
    @Id
private ObjectId id;
private String title;
private String description;
}
