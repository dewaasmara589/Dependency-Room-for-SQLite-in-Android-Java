package com.alfastore.bcaecr;

public enum enuTxMOde {
    // Hex Value
    txSALE(0x1),
    txSALECASH(0x2),
    txREFUND(0x3),
    txAUTH(0x5),
    txOFFLINE(0x7),
    txVOID(0x8),
    txADJUSTMENT(0xC),
    txECHO(0x11),
    txREPRINT(0x13),
    txINQUIRY (0x14),
    txTOPUP (0x15),
    txTOPUPTUNAI(0x16),
    txGETINFO (0x17),
    txSETTLEMENT (0xA),
    txFlazzPayment (0x6),
    txSAKUKU (0x1A),
    txNextSakuKu (0x1B),
    TxInquerySakuku (0x1C);

    private int TransType;
    enuTxMOde(int TransType) {
        this.TransType = TransType;
    }

    int getValue() {
        return TransType;
    }
}
