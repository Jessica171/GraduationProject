package com.example.GradProject.Repository;

import com.example.GradProject.entities.Users;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepo extends MongoRepository<Users,String> {
}
