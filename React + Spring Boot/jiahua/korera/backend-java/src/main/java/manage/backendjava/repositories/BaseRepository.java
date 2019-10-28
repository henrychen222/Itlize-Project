package manage.backendjava.repositories;

import java.io.Serializable;
import org.springframework.data.jpa.repository.JpaRepository;
import manage.backendjava.entities.BaseEntity;

public interface BaseRepository<T extends BaseEntity> extends JpaRepository<T, Serializable> {

}
