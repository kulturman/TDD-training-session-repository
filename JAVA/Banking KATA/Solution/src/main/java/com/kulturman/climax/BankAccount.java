package com.kulturman.climax;

import java.time.DayOfWeek;

public class BankAccount {
    private final BankAccountRepository bankAccountRepository;
    private final DateProvider dateProvider;

    public BankAccount(
        BankAccountRepository bankAccountRepository,
        DateProvider dateProvider
    ) {
        this.bankAccountRepository = bankAccountRepository;
        this.dateProvider = dateProvider;
    }

    public void deposit(int amount) {
        if (dateProvider.now().getDayOfWeek() == DayOfWeek.SUNDAY) {
            amount = (int) (amount * 0.9);
        }
        bankAccountRepository.save(new Transaction(dateProvider.now(), amount));
    }
}
