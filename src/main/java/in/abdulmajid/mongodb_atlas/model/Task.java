package in.abdulmajid.mongodb_atlas.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "tasks")
public class Task {
    @Id
    private String taskId;
    private String description;
    private Integer severity;
    private  String assignee;
    private Integer storyPoint;
}
