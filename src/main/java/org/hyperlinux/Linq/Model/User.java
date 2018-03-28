package org.hyperlinux.Linq.Model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class User {
    @JsonProperty
    private String pseudo;
    @JsonProperty
    private boolean ready;

    public User() {
    }

    public User(String pseudo, boolean ready) {
        this.pseudo = pseudo;
        this.ready = ready;
    }

    public String getPseudo() {
        return pseudo;
    }

    public void setPseudo(String pseudo) {
        this.pseudo = pseudo;
    }

    public boolean isReady() {
        return ready;
    }

    public void setReady(boolean ready) {
        this.ready = ready;
    }

    @Override
    public String toString() {
        return "{\"pseudo\":\"" + pseudo + "\"" +
                ", \"ready\":\"" + ready + "\"}";
    }
}
