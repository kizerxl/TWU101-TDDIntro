package com.thoughtworks.tddintro.exercises.accountbalance;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import java.io.PrintStream;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

import static org.junit.Assert.assertThat;

public class AccountTests {
    private Account account;

    @Before
    public void setUp() throws Exception {
        this.account = new Account(100);
    }

    @Test
    public void shouldIncreaseMyBalanceWhenIDepositMoney(){
        account.addMoney(50);

       assertThat(account.getCurrentBalance(), is(150));
    }

    @Test
    public void shouldDecreaseMyBalanceWhenIWithdrawMoney(){
        account.withdraw(50);

        assertThat(account.getCurrentBalance(), is(50));
    }

    @Test
    public void shouldNotDecreaseMyBalanceWhenIWithdrawMoneyAndDoNotHaveEnoughToCoverTheWithdrawal(){
        account = new Account(50);

        account.withdraw(100);

        assertThat(account.getCurrentBalance(), is(50));
    }
}
