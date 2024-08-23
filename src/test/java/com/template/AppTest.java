package com.template;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static com.template.App.*;
import static org.junit.jupiter.api.Assertions.*;

class AppTest {

    @Test
    void addAccountTest() {
        Map<String, Integer> accounts = add("juan");
        assertEquals(0, accounts.get("juan"));
    }

    @Test
    void depositValidAmountTest() {
        Map<String, Integer> accounts = new HashMap<>();
        accounts.put("juan", 10);
        Map<String, Integer> updatedAccounts = deposit(accounts, "juan", 5);
        assertEquals(15, updatedAccounts.get("juan"));
    }

    @Test
    void depositNegativeAmountTest() {
        Map<String, Integer> accounts = new HashMap<>();
        accounts.put("juan", 10);
        Map<String, Integer> updatedAccounts = deposit(accounts, "juan", -5);
        assertEquals(10, updatedAccounts.get("juan"));
    }

    @Test
    void depositToNonExistingAccountTest() {
        Map<String, Integer> accounts = new HashMap<>();
        Map<String, Integer> updatedAccounts = deposit(accounts, "juan", 10);
        assertNull(updatedAccounts.get("juan"));
    }

    @Test
    void withdrawValidAmountTest() {
        Map<String, Integer> accounts = new HashMap<>();
        accounts.put("juan", 10);
        Map<String, Integer> updatedAccounts = withdraw(accounts, "juan", 5);
        assertEquals(5, updatedAccounts.get("juan"));
    }

    @Test
    void withdrawNegativeAmountTest() {
        Map<String, Integer> accounts = new HashMap<>();
        accounts.put("juan", 10);
        Map<String, Integer> updatedAccounts = withdraw(accounts, "juan", -5);
        assertEquals(10, updatedAccounts.get("juan"));
    }

    @Test
    void withdrawMoreThanBalanceTest() {
        Map<String, Integer> accounts = new HashMap<>();
        accounts.put("juan", 10);
        Map<String, Integer> updatedAccounts = withdraw(accounts, "juan", 15);
        assertEquals(10, updatedAccounts.get("juan"));
    }

    @Test
    void withdrawFromNonExistingAccountTest() {
        Map<String, Integer> accounts = new HashMap<>();
        Map<String, Integer> updatedAccounts = withdraw(accounts, "juan", 5);
        assertNull(updatedAccounts.get("juan"));
    }

    @Test
    void transferValidAmountTest() {
        Map<String, Integer> accounts = new HashMap<>();
        accounts.put("juan", 10);
        accounts.put("Cuchu", 5);
        Map<String, Integer> updatedAccounts = transfer(accounts, "juan", "Cuchu", 5);
        assertEquals(5, updatedAccounts.get("juan"));
        assertEquals(10, updatedAccounts.get("Cuchu"));
    }

    @Test
    void transferNegativeAmountTest() {
        Map<String, Integer> accounts = new HashMap<>();
        accounts.put("juan", 10);
        accounts.put("Cuchu", 5);
        Map<String, Integer> updatedAccounts = transfer(accounts, "juan", "Cuchu", -5);
        assertEquals(10, updatedAccounts.get("juan"));
        assertEquals(5, updatedAccounts.get("Cuchu"));
    }

    @Test
    void transferMoreThanBalanceTest() {
        Map<String, Integer> accounts = new HashMap<>();
        accounts.put("juan", 10);
        accounts.put("Cuchu", 5);
        Map<String, Integer> updatedAccounts = transfer(accounts, "juan", "Cuchu", 15);
        assertEquals(10, updatedAccounts.get("juan"));
        assertEquals(5, updatedAccounts.get("Cuchu"));
    }

    @Test
    void transferToSameAccountTest() {
        Map<String, Integer> accounts = new HashMap<>();
        accounts.put("juan", 10);
        Map<String, Integer> updatedAccounts = transfer(accounts, "juan", "juan", 5);
        assertEquals(10, updatedAccounts.get("juan"));
    }

    @Test
    void transferFromNonExistingAccountTest() {
        Map<String, Integer> accounts = new HashMap<>();
        accounts.put("Cuchu", 5);
        Map<String, Integer> updatedAccounts = transfer(accounts, "juan", "Cuchu", 5);
        assertEquals(5, updatedAccounts.get("Cuchu"));
        assertNull(updatedAccounts.get("juan"));
    }

    @Test
    void transferToNonExistingAccountTest() {
        Map<String, Integer> accounts = new HashMap<>();
        accounts.put("juan", 10);
        Map<String, Integer> updatedAccounts = transfer(accounts, "juan", "Cuchu", 5);
        assertEquals(10, updatedAccounts.get("juan"));
        assertNull(updatedAccounts.get("Cuchu"));
    }

    @Test
    void transferBetweenNonExistingAccountsTest() {
        Map<String, Integer> accounts = new HashMap<>();
        Map<String, Integer> updatedAccounts = transfer(accounts, "juan", "Cuchu", 5);
        assertNull(updatedAccounts.get("juan"));
        assertNull(updatedAccounts.get("Cuchu"));
    }
}
