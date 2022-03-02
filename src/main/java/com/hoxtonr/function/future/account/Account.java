package com.hoxtonr.function.future.account;

import com.hoxtonr.function.future.model.SwapOrder;

public interface Account {
    public String getSwapUSDT();
    public SwapOrder getSwapOrder();
    public String getSwapBalance(String cointype);
}
