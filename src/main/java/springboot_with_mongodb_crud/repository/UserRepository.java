package springboot_with_mongodb_crud.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import springboot_with_mongodb_crud.entity.User;

@Repository
public interface UserRepository extends MongoRepository<User,Integer> {
}
