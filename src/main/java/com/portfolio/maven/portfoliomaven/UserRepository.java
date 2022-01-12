package com.portfolio.maven.portfoliomaven;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Component;

@Component
public interface UserRepository extends MongoRepository<PortFolio,String>{
    public PortFolio findByName(String name);
    public List<PortFolio> findAll();
}
