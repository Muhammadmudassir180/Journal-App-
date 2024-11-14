package com.digest.journelApp.services;
import com.digest.journelApp.Entity.JournalEntry;
import com.digest.journelApp.repository.Repo;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Component
public class Entryservice {
    @Autowired
    private Repo repo ;
    //Function to save all the post request body in MongoDB.
    public void saveEntry(JournalEntry journalEntry)
    {
        repo.save(journalEntry);
    }
    //Function to get all the documents from the MongoDB
    public List<JournalEntry> getAll(){
        return repo.findAll();
    }
    //Function to get the document by ID from the MongoDB
    public Optional<JournalEntry> getbyID(ObjectId id){
        return repo.findById(id);
    }

    //Function to delete the document by ID;
    public void DeleteByID(ObjectId id){
        repo.deleteById(id);
    }




}
