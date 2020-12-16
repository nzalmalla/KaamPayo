package com.kaampayo.job.search.features.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobService {
    @Autowired
    private JobRepository repo;

    public List<JobResource> listAll(String keyword) {
        if (keyword != null) {
            return repo.search(keyword);
        }
        return (List<JobResource>) repo.findAll();
    }

    public void save(JobResource jobResource) {
        repo.save(jobResource);
    }

    public JobResource get(Long id) {
        return repo.findById(id).get();
    }

    public void delete(Long id) {
        repo.deleteById(id);
    }
}
