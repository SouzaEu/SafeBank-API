package br.com.fiap.BankAPI.service;

import br.com.fiap.BankAPI.model.*;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Objects;

public class AccountService {
    public void validateAccount(Account account) {
        if (isBlankOrNull(account.getNomeTitular()) || isBlankOrNull(account.getCpf())
                || isInvalidBalance(account.getSaldo()) || isInvalidType(account.getTipo())
                || isInvalidOpeningDate(account.getDataAbertura())) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Erro no corpo da resposta");
        }
    }

    public Account deposit(Account account, BigDecimal value) {
        validateValue(value);
        account.setSaldo(account.getSaldo().add(value));
        return account;
    }

    public Account withdraw(Account account, BigDecimal value) {
        validateValue(value);
        checkSufficientBalance(account.getSaldo(), value);
        account.setSaldo(account.getSaldo().subtract(value));
        return account;
    }

    public Account transfer(Account originAccount, Account destinyAccount, BigDecimal value) {
        validateValue(value);
        checkSufficientBalance(originAccount.getSaldo(), value);
        withdraw(originAccount, value);
        return deposit(destinyAccount, value);
    }

    private void validateValue(BigDecimal value) {
        if (value == null || value.compareTo(BigDecimal.ZERO) <= 0) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Valor deve ser maior que 0: " + value);
        }
    }

    private void checkSufficientBalance(BigDecimal balance, BigDecimal value) {
        if (balance.compareTo(value) < 0) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Saldo insuficiente, saldo: " + balance);
        }
    }

    private boolean isBlankOrNull(String s) {
        return s == null || s.isBlank();
    }

    private boolean isInvalidBalance(BigDecimal balance) {
        return balance == null || balance.compareTo(BigDecimal.ZERO) < 0;
    }

    private boolean isInvalidType(AccountType accountType) {
        return Objects.isNull(accountType);
    }

    private boolean isInvalidOpeningDate(LocalDate date) {
        return date == null || date.isAfter(LocalDate.now());
    }
}
