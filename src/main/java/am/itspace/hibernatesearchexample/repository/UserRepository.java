package am.itspace.hibernatesearchexample.repository;

import am.itspace.hibernatesearchexample.model.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User,Integer> {
}
