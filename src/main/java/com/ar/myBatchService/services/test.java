package com.ar.myBatchService.services;

import com.ar.myBatchService.model.Batch;
import com.ar.myBatchService.model.Transaction;

import java.util.*;
import java.util.stream.Collectors;

public class test {

    public static void main(String[] args){

        System.out.println("hello");

        Map<Long, Batch> batch = new HashMap<>();

        List<Transaction> trxs = new ArrayList<Transaction>();



        Transaction trx1 = new Transaction("Party001", "Ben00A", "1000", "trx001x001" );
        Transaction trx2 = new Transaction("Party001", "Ben00B", "100", "trx001x002" );
        Transaction trx3 = new Transaction("Party002", "Ben00C", "10000", "trx001x003" );
        Transaction trx4 = new Transaction("Party002", "Ben00D", "10003", "trx001x004" );
        Transaction trx5 = new Transaction("Party003", "Ben00E", "10009", "trx001x005" );

        HashSet set1 = new HashSet<Transaction>();
        set1.add(trx1);
        set1.add(trx2);
        Batch batch1 = new Batch("Party001", set1);

        batch.put(1L, batch1);

        HashSet set2 = new HashSet<Transaction>();
        set2.add(trx3);
        set2.add(trx4);
        Batch batch2 = new Batch("Party002", set2);

        batch.put(2L, batch2);

        HashSet set3 = new HashSet<Transaction>();
        set3.add(trx5);

        Batch batch3 = new Batch("Party003", set3);

        batch.put(3L, batch3);


        Transaction trx6 = new Transaction("Party001", "Ben00F", "1000", "trx001x006" );

        /*

        for(Batch entries : batch.values()){
            System.out.println("Party: "+entries.getPartyId());
            for(Transaction trx : entries.getTransactions()){
                System.out.println("TRX: "+ trx.getTrxId()+ "Ben "+trx.getBeneficiaryKey());
            }

        }

         */

        for(Batch entries : batch.values()){
            if(entries.getPartyKey() == trx6.getPartyKey()){
                System.out.println("Party Already exists");

                entries.getTransactions().add(trx6);

                break;
            }


        }


        for(Batch entries : batch.values()){
            System.out.println("Party: "+entries.getPartyKey());
            for(Transaction trx : entries.getTransactions()){
                System.out.println("TRX: "+ trx.getTrxId()+ "Ben "+trx.getBeneficiaryKey());
            }

        }


        System.out.printf("list: "+ batch.values().stream().map(entry -> entry.getPartyKey()).collect(Collectors.toList()).contains("Party001"));





    }
}
