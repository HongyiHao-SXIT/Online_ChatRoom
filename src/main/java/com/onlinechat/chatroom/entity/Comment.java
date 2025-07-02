package com.onlinechat.chatroom.entity;


import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Comment {
    private Integer id;

    private String content;

    private String account;

    private Integer roomId;

    private String type;

    private Date createTime;

    private String icon;
}
