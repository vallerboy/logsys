package pl.oskarpolak.logsys.models.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.oskarpolak.logsys.models.UserEntity;

@Repository
public interface UserRepository extends CrudRepository<UserEntity, Integer> {
}
