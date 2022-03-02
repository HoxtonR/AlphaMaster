package com.hoxtonr.apis.binanceapi;

public class DefaultAccount implements AccountApi{
    private String apikey = "";
    private String secretkey = "";
    private final String username = "";
    private static DefaultAccount account;
    private DefaultAccount(){

    }

    public synchronized static DefaultAccount getInstance(){
        if(account == null){
            account = new DefaultAccount();
        }
        return account;
    }
    @Override
    public  String getApikey(){
        return apikey;
    }
    @Override
    public  String getSecretkey(){
        return secretkey;
    }

    @Override
    public String getUsername() {
        return username;
    }

}
