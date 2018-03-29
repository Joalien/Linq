package org.hyperlinux.Linq.Model;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.web.socket.WebSocketSession;

public class User {
    @JsonProperty
    private String pseudo;
    @JsonProperty
    private boolean ready;
    @JsonProperty
    private int id;
    private WebSocketSession session;

    public User(){}

    public User(int id, String pseudo, boolean ready) {
        this.pseudo = pseudo;
        this.ready = ready;
        this.id = id;
        this.session=null;
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public WebSocketSession getSession() {
        return session;
    }

    public void setSession(WebSocketSession session) {
        this.session = session;
    }

    @Override
    public String toString() {
        return "{\"id\":\"" + id + "\"" +
                ", \"pseudo\":\"" + pseudo + "\"" +
                ", \"ready\":\"" + ready + "\"}";
    }
}
