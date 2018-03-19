package pl.oskarpolak.logsys.models.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.oskarpolak.logsys.models.KeyEntity;

import javax.persistence.criteria.CriteriaBuilder;

@Repository
public interface KeyRepository  extends CrudRepository<KeyEntity, Integer> {

}
