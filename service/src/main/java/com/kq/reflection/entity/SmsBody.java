package com.kq.reflection.entity;

/**
 * @author kq
 * @date 2020-09-01 14:29
 * @since 2020-0630
 */
public class SmsBody {

    private String to;
    private String from;
    private String title;
    private String message;

    private Integer type;

    public SmsBody(String to, String title, Integer type) {
        this.to = to;
        this.title = title;
        this.type = type;

        System.out.println("================SmsBody.3============================");
    }

    public SmsBody(String to, String from, String title, String message, Integer type) {
        this.to = to;
        this.from = from;
        this.title = title;
        this.message = message;
        this.type = type;
        System.out.println("================SmsBody.5============================");
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTitle() {
        System.out.println("call get title");
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "SmsBody{" +
                "to='" + to + '\'' +
                ", from='" + from + '\'' +
                ", title='" + title + '\'' +
                ", message='" + message + '\'' +
                ", type=" + type +
                '}';
    }
}
