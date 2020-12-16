package com.kaampayo.job.search.features.user;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface JobRepository extends CrudRepository<JobResource, Long> {

    @Query("SELECT p FROM JobResource p WHERE CONCAT(p.companyname, ' ', p.address, ' ', p.wage) LIKE %?1%")
    public List<JobResource> search(String keyword);
}