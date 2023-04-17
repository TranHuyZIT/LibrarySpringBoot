package com.ctu.Library.config.Cache;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface CacheRepository extends CrudRepository<CacheData, String> {
    List<CacheData> findByKeyContainingIgnoreCase(String key);
}