package com.qunar.fresh;

import java.util.Date;

/**
 * Created by liyingsong on 16-5-16.
 */
public class ChatRecord {
    private Date date;
    private String name;
    private int id;
    private String text;

    public ChatRecord() {

    }

    public ChatRecord(Date date, String name, int id, String text) {
        this.date = date;
        this.name = name;
        this.id = id;
        this.text = text;
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

    public String getText() {
        return text;
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

    public void setText(String text) {
        if(this.text == null)
            this.text = text;
        else
            this.text = this.text + "\n" + text;
    }

//    @Override
//    public int compareTo(CharRecord cr) {
//        if (cr.date.getTime() < this.date.getTime())
//            return 1;
//        else if (cr.date.getTime() > this.date.getTime())
//            return -1;
//        else
//            //return cr.getId().compareTo();
//        return 0;
//    }
}
