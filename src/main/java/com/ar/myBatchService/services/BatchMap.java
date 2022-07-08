package com.ar.myBatchService.services;

import com.ar.myBatchService.model.Batch;
import com.ar.myBatchService.model.Transaction;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class BatchMap {

    private Map<Long, Batch> batch = new HashMap<>();

    public Transaction addEntry(Transaction transaction){

        // batch exists and party key exists
        if(batch.values().stream().map(entry -> entry.getPartyKey()).collect(Collectors.toList()).contains(transaction.getPartyKey()))
        {
            //System.out.println("XX - Party key Exists");
            batch.forEach((key, batchEntry) -> {
                if(batchEntry.getPartyKey().matches(transaction.getPartyKey()))
                {
                    //System.out.println("Size: "+batchEntry.getTransactions().size());
                    batchEntry.addEntry(transaction);
                    //System.out.println("Size: "+batchEntry.getTransactions().size());
                }

            });


        }else{

            // new entry batch is null
            System.out.println("XX  - New party Key");
            HashSet trxSet = new HashSet<Transaction>();
            trxSet.add(transaction);
            Batch newBatch = new Batch(transaction.getPartyKey(), trxSet);

            batch.put(getNextId(), newBatch);

        }


        return transaction;

    }

    private Long getNextId(){

        Long nextId = null;

        try {
            nextId = Collections.max(batch.keySet()) + 1;
        } catch (NoSuchElementException e) {
            nextId = 1L;
        }

        return nextId;
    }

    public Collection<Batch> getAll(){
        return batch.values();
    }

}
