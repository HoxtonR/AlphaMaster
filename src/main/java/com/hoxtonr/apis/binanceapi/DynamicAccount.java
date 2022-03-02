package com.hoxtonr.apis.binanceapi;

public class DynamicAccount {
    private String apikey;
    private String secretkey;
    private String username;

    public DynamicAccount(String apikey, String secretkey, String username){
        this.apikey = apikey;
        this.secretkey = secretkey;
        this.username = username;
    }

    public String getApikey() {
        return apikey;
    }

    public String getSecretkey() {
        return secretkey;
    }
    public void setApikey(String apikey) {
        this.apikey = apikey;
    }
    public void setSecretkey(String secretkey) {
        this.secretkey = secretkey;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
