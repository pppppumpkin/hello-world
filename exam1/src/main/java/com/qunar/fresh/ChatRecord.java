package com.qunar.fresh;

import java.util.Date;

/**
 * Created by liyingsong on 16-5-16.
 */
public class ChatRecord {
    private Date date;
    private String name;
    private int id;
    private String message;

    public ChatRecord() {

    }

    public ChatRecord(Date date, String name, int id, String text) {
        this.date = date;
        this.name = name;
        this.id = id;
        this.message = text;
    }

    public Date getDate() {
        return date;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public String getMessage() {
        return message;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;

        ChatRecord that = (ChatRecord) o;

        if (id != that.id)
            return false;
        if (date != null ? !date.equals(that.date) : that.date != null)
            return false;
        if (name != null ? !name.equals(that.name) : that.name != null)
            return false;
        if (message != null ? !message.equals(that.message) : that.message != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = date != null ? date.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + id;
        result = 31 * result + (message != null ? message.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "ChatRecord{" + "date=" + date + ", name='" + name + '\'' + ", id=" + id + ", message='" + message + '\''
                + '}';
    }
}
