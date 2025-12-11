package com.veterinary;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PetRecordRepository extends MongoRepository<PetRecord, String> {
}