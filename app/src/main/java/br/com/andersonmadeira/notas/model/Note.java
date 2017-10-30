package br.com.andersonmadeira.notas.model;

import java.util.Date;

/**
 * Created by anderson on 29/10/17.
 */

public class Note {
    private String title, content;
    private Date createdAt, updatedAt;

    public Note() {

    }

    public Note(String title, String content) {
        this.title = title;
        this.content = content;
        this.createdAt = new Date();
        this.updatedAt = new Date();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void save() {
        // save
        this.updatedAt = new Date();
    }
}
