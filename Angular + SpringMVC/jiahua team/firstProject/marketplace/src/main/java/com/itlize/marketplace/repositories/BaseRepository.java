package com.itlize.marketplace.repositories;

import java.io.Serializable;
import com.itlize.marketplace.entities.BaseEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

public interface BaseRepository<T extends BaseEntity> extends JpaRepository<T, Serializable>,
                JpaSpecificationExecutor<T>, QuerydslPredicateExecutor<T> {

}
