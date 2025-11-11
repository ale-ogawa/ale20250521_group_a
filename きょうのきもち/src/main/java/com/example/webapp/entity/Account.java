
package com.example.webapp.entity;

import lombok.Data;

@Data
public class Account {
    private Integer id;
    private String address;
    private String password;
    private String nickname;
    private Boolean attribute;  // true: 患者, false: 招待者
    private Integer groupId;
    private Integer followId;
    private String share;
}
