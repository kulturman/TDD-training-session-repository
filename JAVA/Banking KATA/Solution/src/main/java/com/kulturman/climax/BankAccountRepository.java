package com.kulturman.climax;

import java.util.List;

public interface BankAccountRepository {
    void save(Transaction transaction);
    List<Transaction> getTransactions();
}
