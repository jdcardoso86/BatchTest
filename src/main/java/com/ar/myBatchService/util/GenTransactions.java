package com.ar.myBatchService.util;


import com.ar.myBatchService.model.Transaction;
import com.ar.myBatchService.services.BatchMap;
import com.ar.myBatchService.services.TransactionMap;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Random;
import java.util.stream.Collectors;

@Component
public class GenTransactions {

    TransactionMap transactions = new TransactionMap();

    BatchMap batch = new BatchMap();

    //@Scheduled(fixedRate = 1000)
    private void loadTrx1() {
        System.out.println("I'm here and alive");

        char randomChar = (char) ('a' + new Random().nextInt(26));

        Transaction trx1 = new Transaction("Party00"+randomChar, "Ben001", Long.toString(new Random().nextLong()), "trx001x001" );

        transactions.save(trx1);



    }


/*
    public GenTransactions(BatchService batchService, TransactionService transactionService) {
        this.batchService = batchService;
        this.transactionService = transactionService;
    }


    @Scheduled(fixedRate = 1000)
    private void loadTrx1(){
        System.out.println("I'm here and alive");

        Transaction trx1 = new Transaction(new Random().nextLong(), "Party001", "Ben001", "1000", "trx001x001" );

        Transaction savedTrx = transactionService.save(trx1);

        transactionService.findAll().forEach(trx -> {
            System.out.println(trx.getTrxId());
        });


    }

 */
    @Scheduled(fixedRate = 100)
    private void loadTrx2() {


        char randomChar = (char) ('a' + new Random().nextInt(20));
        char randomCharBen = (char) ('a' + new Random().nextInt(26));
        Transaction trx1 = new Transaction("Party00"+randomChar, "Ben00"+randomCharBen, Long.toString(new Random().nextLong()), "trx001x00"+randomCharBen );

        System.out.println("new TRX");
        if(batch.getAll().stream().map(entry -> entry.getPartyKey().matches(trx1.getPartyKey())).collect(Collectors.toList()).contains(true)){
            System.out.println("Party already exists");
        }

        batch.addEntry(trx1);

        System.out.println("Entries "+ batch.getAll().size());

        System.out.println(batch.getAll().stream().map(entry -> entry.getTransactions().size()).collect(Collectors.toList()).toString());
        System.out.println(batch.getAll().stream().map(entry -> entry.getPartyKey().matches(trx1.getPartyKey())).collect(Collectors.toList()).toString());
        /*
        for(Batch entries : batch.getAll()){
            System.out.println("Party: "+entries.getPartyId());
            System.out.println("trxs: "+entries.getTransactions().size());

        }

         */


    }



    private void clearConsole() {
        System.out.println(System.lineSeparator().repeat(100));
    }



}
