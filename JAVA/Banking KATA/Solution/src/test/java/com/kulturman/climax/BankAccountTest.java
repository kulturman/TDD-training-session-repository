package com.kulturman.climax;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class BankAccountTest {
    @Mock
    private DateProvider dateProvider;
    private BankAccount bankAccount;
    @Mock
    private BankAccountRepository bankAccountRepository;

    @BeforeEach
    void beforeEach() {
        bankAccount = new BankAccount(
            bankAccountRepository,
            dateProvider
        );
    }

    @Test
    void addsDeposit() {
        when(dateProvider.now()).thenReturn(LocalDateTime.of(2023, 10, 28, 0, 0, 0));
        bankAccount.deposit(500);

        verify(bankAccountRepository).save(new Transaction(dateProvider.now(), 500));

    }

    @Test
    void adds90PercentOfDepositIfItsSunday() {
        when(dateProvider.now()).thenReturn(LocalDateTime.of(2023, 10, 29, 0, 0, 0));

        bankAccount.deposit(500);
        verify(bankAccountRepository).save(new Transaction(dateProvider.now(), 450));

    }
}

