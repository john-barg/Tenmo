package com.techelevator.tenmo.dao;

import java.math.BigDecimal;

public interface AccountDAO {

    BigDecimal returnBalance(String username);
}