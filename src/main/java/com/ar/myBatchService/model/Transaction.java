package com.ar.myBatchService.model;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;

@Setter
@Getter
public class Transaction {

    private String partyKey;
    private String beneficiaryKey;
    private String amount;
    private String trxId;

    @Builder
    public Transaction(/*Long id,*/String partyKey, String beneficiaryKey, String amount, String trxId) {
        //super(id);
        this.partyKey = partyKey;
        this.beneficiaryKey = beneficiaryKey;
        this.amount = amount;
        this.trxId = trxId;
    }

    public String getPartyKey() {
        return partyKey;
    }

    public void setPartyKey(String partyKey) {
        this.partyKey = partyKey;
    }

    public String getBeneficiaryKey() {
        return beneficiaryKey;
    }

    public void setBeneficiaryKey(String beneficiaryKey) {
        this.beneficiaryKey = beneficiaryKey;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getTrxId() {
        return trxId;
    }

    public void setTrxId(String trxId) {
        this.trxId = trxId;
    }
}
