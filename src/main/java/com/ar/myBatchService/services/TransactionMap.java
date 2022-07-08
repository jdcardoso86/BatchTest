package com.ar.myBatchService.services;

import com.ar.myBatchService.model.BaseEntity;
import com.ar.myBatchService.model.Transaction;
import com.fasterxml.jackson.databind.ser.Serializers;
import jdk.jfr.TransitionTo;

import java.util.*;

public class TransactionMap {


    private Map<Long, Transaction> transactions = new HashMap<>();

    public Set<Transaction> findAll() { return new HashSet<>(transactions.values());
    }

    public Transaction save(Transaction object){
        if(object != null)
        {
           transactions.put(getNextId(), object);

        }else {
            throw new RuntimeException("Object can't be null");
        }

        return object;
    }


    private Long getNextId(){

        Long nextId = null;

        try {
            nextId = Collections.max(transactions.keySet()) + 1;
        } catch (NoSuchElementException e) {
            nextId = 1L;
        }

        return nextId;
    }

    public List getTransactions(){

        return new ArrayList<>(transactions.values());
    }

    public void deleteById(Long id){
        transactions.remove(id);

    }

    public void deleteObject(Transaction object){
        transactions.entrySet().removeIf(entry -> entry.getValue().equals(object));
    }

    public void deleteAll(){
        transactions.clear();
    }


}
