package com.vino.test.entity;

import java.util.Date;

/**
 * @ClassName: WebSocketMessage
 * @Description: websocket信息实体
 * @author: wenjie.fei
 * @date: 2019/1/5 10:37
 * @version: V1.0
 */
public class WebSocketMsg {

    // 发送者
    private Long from;
    // 发送者名称
    private String fromName;
    // 接收者
    private Long to;
    // 发送的文本
    private String text;
    // 发送日期
    private Date date;

    public Long getFrom() {
        return from;
    }

    public void setFrom(Long from) {
        this.from = from;
    }

    public Long getTo() {
        return to;
    }

    public void setTo(Long to) {
        this.to = to;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getFromName() {
        return fromName;
    }

    public void setFromName(String fromName) {
        this.fromName = fromName;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

}
