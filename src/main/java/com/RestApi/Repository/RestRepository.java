package com.RestApi.Repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.RestApi.entity.RestEntity;


@Transactional
@Repository
public interface RestRepository extends JpaRepository<RestEntity, Integer> {
	RestEntity findById (int id);

	List<RestEntity> deleteByName (String name);

}
