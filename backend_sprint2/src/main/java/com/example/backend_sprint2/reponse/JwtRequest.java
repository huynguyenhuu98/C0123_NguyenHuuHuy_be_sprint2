package com.example.backend_sprint2.reponse;

public class JwtRequest {
    private String usersname;
    private String passwords;

    public JwtRequest() {}

    public JwtRequest(String usersname, String passwords) {
        this.usersname = usersname;
        this.passwords = passwords;
    }

    public String getUsersname() {
        return usersname;
    }

    public void setUsersname(String usersname) {
        this.usersname = usersname;
    }

    public String getPasswords() {
        return passwords;
    }

    public void setPasswords(String passwords) {
        this.passwords = passwords;
    }
}
