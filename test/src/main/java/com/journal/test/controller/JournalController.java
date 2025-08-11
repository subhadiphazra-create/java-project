package com.journal.test.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.bson.types.ObjectId;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.journal.test.entity.JournalEntry;
@RestController
@RequestMapping("_/journal")
public class JournalController {
  
  private Map<ObjectId,JournalEntry> journalEnteries = new HashMap<>();

  @GetMapping
  public List<JournalEntry> getAll(){
    return new ArrayList<>(journalEnteries.values());
  }

  @PostMapping
  public boolean createEntry( @RequestBody JournalEntry myEntry ){
    journalEnteries.put(myEntry.getId(),myEntry);
    return true;
  }

  @GetMapping("/id/{myId}")
  public JournalEntry getJournalById(@PathVariable ObjectId myId){
    return journalEnteries.get(myId);
  }

  @DeleteMapping("/id/{myId}")
  public JournalEntry deleteJournalById(@PathVariable ObjectId myId){
    return journalEnteries.remove(myId);
  }

  @PutMapping("/id/{myId}")
  public JournalEntry getEntryById( @PathVariable ObjectId myId, @RequestBody JournalEntry myEntry){
    journalEnteries.put(myId,myEntry);
    return myEntry;
  }
}
