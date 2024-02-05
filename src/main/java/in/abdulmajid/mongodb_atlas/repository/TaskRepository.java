package in.abdulmajid.mongodb_atlas.repository;

import in.abdulmajid.mongodb_atlas.model.Task;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface TaskRepository extends MongoRepository<Task,String> {
    List<Task> findTaskBySeverity(int severity);

   // List<Task> getTasksByAssignee(String assignee); //use a manual query for achieve this, don't follow findBy...
    // we create my own method name
  //for multiple argument @Query("{ assignee: ?0, fieldName : ?1 ,fieldName : ?2}")
    @Query("{ assignee: ?0}")
     List<Task> getTasksByAssignee(String assignee);
}
