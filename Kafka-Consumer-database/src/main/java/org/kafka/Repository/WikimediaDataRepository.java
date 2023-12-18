package org.kafka.Repository;

import org.kafka.Entity.WikimediaData;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WikimediaDataRepository extends JpaRepository<WikimediaData,Long>{

}
