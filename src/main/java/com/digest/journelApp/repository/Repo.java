package com.digest.journelApp.repository;
import com.digest.journelApp.Entity.JournalEntry;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface Repo extends MongoRepository<JournalEntry, ObjectId> {


}
