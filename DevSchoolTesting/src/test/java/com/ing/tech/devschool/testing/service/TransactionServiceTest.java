package com.ing.tech.devschool.testing.service;

import com.ing.tech.devschool.testing.api.model.Account;
import com.ing.tech.devschool.testing.api.repository.AccountRepository;
import com.ing.tech.devschool.testing.api.repository.TransactionRepository;
import com.ing.tech.devschool.testing.api.service.TransactionService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Optional;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class TransactionServiceTest {

    @Mock
    private AccountRepository accountRepository;

    @Mock
    private TransactionRepository transactionRepository;

    @InjectMocks
    TransactionService transactionService;


    @Test
    public void shouldTransferAmountAndUpdateBalances() {
        Account sender = Account.builder().accountNumber(1L).totalBalance(1000.0).build();
        Account receiver = Account.builder().accountNumber(2L).totalBalance(1000.0).build();

        when(accountRepository.findById(1L)).thenReturn(Optional.of(sender));
        when(accountRepository.findById(2L)).thenReturn(Optional.of(receiver));

        assertTrue(transactionService.transfer(sender.getAccountNumber(),
            receiver.getAccountNumber(),
            500.0));
        verify(transactionRepository, times(1)).save(any());
        //when you assert two float/double numbers you have to use assertEquals(expected, actual, delta)
        assertEquals(500.0, sender.getTotalBalance(), 0.01);
        assertEquals(1500.0, receiver.getTotalBalance(), 0.01);
    }

    @Test
    public void shouldNotTransferIfNegativeAmount() {
        Account sender = Account.builder().accountNumber(1L).totalBalance(1000.0).build();
        Account receiver = Account.builder().accountNumber(2L).totalBalance(1000.0).build();

        when(accountRepository.findById(1L)).thenReturn(Optional.of(sender));
        when(accountRepository.findById(2L)).thenReturn(Optional.of(receiver));

        assertFalse(transactionService.transfer(sender.getAccountNumber(),
                receiver.getAccountNumber(),
                -500.0));
        verify(transactionRepository, times(0)).save(any());
        //when you assert two float/double numbers you have to use assertEquals(expected, actual, delta)
        assertEquals(1000.0, sender.getTotalBalance(), 0.01);
        assertEquals(1000.0, receiver.getTotalBalance(), 0.01);

    }

    @Test
    public void shouldNotTransferIfInsufficientBalance() {
        Account sender = Account.builder().accountNumber(1L).totalBalance(100.0).build();
        Account receiver = Account.builder().accountNumber(2L).totalBalance(1000.0).build();

        when(accountRepository.findById(1L)).thenReturn(Optional.of(sender));
        when(accountRepository.findById(2L)).thenReturn(Optional.of(receiver));

        assertFalse(transactionService.transfer(sender.getAccountNumber(),
                receiver.getAccountNumber(),
                500.0));
        verify(transactionRepository, times(0)).save(any());
        //when you assert two float/double numbers you have to use assertEquals(expected, actual, delta)
        assertEquals(100.0, sender.getTotalBalance(), 0.01);
        assertEquals(1000.0, receiver.getTotalBalance(), 0.01);

    }

    @Test
    public void shouldNotTransferIfSenderOrReceiverNotPresent() {
        Account sender = Account.builder().accountNumber(1L).totalBalance(100.0).build();
        Account receiver = Account.builder().accountNumber(2L).totalBalance(1000.0).build();

        when(accountRepository.findById(1L)).thenReturn(Optional.of(sender));
        when(accountRepository.findById(2L)).thenReturn(Optional.of(receiver));

        assertFalse(transactionService.transfer(sender.getAccountNumber(),
                null,
                500.0));
        verify(transactionRepository, times(0)).save(any());

        assertFalse(transactionService.transfer(null,
                receiver.getAccountNumber(),
                500.0));
        verify(transactionRepository, times(0)).save(any());

        //when you assert two float/double numbers you have to use assertEquals(expected, actual, delta)
        assertEquals(100.0, sender.getTotalBalance(), 0.01);
        assertEquals(1000.0, receiver.getTotalBalance(), 0.01);
    }

    @Test
    public void shouldDepositAmount() {
        Account account = Account.builder().accountNumber(1L).totalBalance(1000.0).build();

        when(accountRepository.findById(1L)).thenReturn(Optional.of(account));

        assertTrue(transactionService.atmTransaction(account.getAccountNumber(),
                500.0));
        verify(transactionRepository, times(1)).save(any());
        //when you assert two float/double numbers you have to use assertEquals(expected, actual, delta)
        assertEquals(1500.0, account.getTotalBalance(), 0.01);
    }

    @Test
    public void shouldWithdrawAmount() {
        Account account = Account.builder().accountNumber(1L).totalBalance(1000.0).build();

        when(accountRepository.findById(1L)).thenReturn(Optional.of(account));

        assertTrue(transactionService.atmTransaction(account.getAccountNumber(),
                -500.0));
        verify(transactionRepository, times(1)).save(any());
        //when you assert two float/double numbers you have to use assertEquals(expected, actual, delta)
        assertEquals(500.0, account.getTotalBalance(), 0.01);

    }

    @Test
    public void shouldNotWithdrawIfInsufficientBalance() {
        Account account = Account.builder().accountNumber(1L).totalBalance(100.0).build();

        when(accountRepository.findById(1L)).thenReturn(Optional.of(account));

        assertFalse(transactionService.atmTransaction(account.getAccountNumber(),
                -500.0));
        verify(transactionRepository, times(0)).save(any());
        //when you assert two float/double numbers you have to use assertEquals(expected, actual, delta)
        assertEquals(100.0, account.getTotalBalance(), 0.01);

    }

}
