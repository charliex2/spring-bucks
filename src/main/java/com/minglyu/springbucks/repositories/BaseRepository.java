package com.minglyu.springbucks.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.NoRepositoryBean;

import java.util.List;

// 不生成实体 Bean
@NoRepositoryBean
public interface BaseRepository<T, Long> extends CrudRepository<T, Long> {
    List<T> findTop3ByUpdateTimeDescIdAsc();
}
