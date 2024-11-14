package com.digest.journelApp.Controller;


import com.digest.journelApp.Entity.JournalEntry;
import com.digest.journelApp.JournelApplication;
import com.digest.journelApp.services.Entryservice;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.security.KeyStore;
import java.time.LocalDateTime;
import java.util.*;

@RestController
//@RequestMapping("/abc")
public class EntryController {


    @Autowired
    private Entryservice entryservice;

    @GetMapping("/get")
    public List<JournalEntry> getAll(){

        return entryservice.getAll();


    }
    @PostMapping ("/post")
    public boolean createEntry (@RequestBody JournalEntry myEntry){
        myEntry.setDate(LocalDateTime.now() );
        entryservice.saveEntry(myEntry);
        return true;
    }
    @GetMapping("/get/id/{id}")
    public JournalEntry getbyid(@PathVariable ObjectId id){

//        return journelentries.get(id);
       return entryservice.getbyID(id).orElse(null);
    }

    @DeleteMapping("/delete/{id}")
    public boolean deletebyid(@PathVariable ObjectId id){
        entryservice.DeleteByID(id);
        return true;

    }
    @PutMapping("/update/{id}")
    public JournalEntry updateByID(@PathVariable ObjectId id, @RequestBody JournalEntry newEntry) {
        JournalEntry existingEntry = entryservice.getbyID(id).orElse(null);

        if (existingEntry != null) {
            // Update title only if the new title is non-null and non-empty
            if (newEntry.getTitle() != null && !newEntry.getTitle().isEmpty()) {
                existingEntry.setTitle(newEntry.getTitle());
            }
            // Update additional fields here if needed, following a similar pattern

            // Save the updated entry
            entryservice.saveEntry(existingEntry);
        }

        // Return the updated or null (if not found) entry
        return existingEntry;
    }

}
