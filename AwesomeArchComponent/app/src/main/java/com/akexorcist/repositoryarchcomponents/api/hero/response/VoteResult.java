package com.akexorcist.repositoryarchcomponents.api.hero.response;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

/**
 * Created by Akexorcist on 10/6/2017 AD.
 */
@Entity(tableName = "vote_result")
public class VoteResult {
    @PrimaryKey
    private String status;
    private String message;

    public VoteResult() {
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
