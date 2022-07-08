package com.ar.myBatchService.model;

import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;


@Getter
@Setter
public class Batch {

    private String partyKey;

    private Set<Transaction> transactions = new HashSet<>();

    public Batch(String partyKey, Set<Transaction> transactions) {

         if(transactions != null){
            this.transactions = transactions;
            this.partyKey = partyKey;
        }

    }

    public void addEntry(Transaction transaction)
    {
        if(transactions.stream().map(entry -> entry.getTrxId().matches(transaction.getTrxId())).collect(Collectors.toList()).contains(true)){
            System.out.println("TRX ID already exists, will be replace with a new one");
            for(Transaction entry : transactions){
                if(entry.getTrxId().matches(transaction.getTrxId())){
                    transactions.remove(entry);
                    transactions.add(transaction);
                    break;
                }
            }

        }else{
            System.out.println("New TRX ID");
            transactions.add(transaction);
        }

    }


}
