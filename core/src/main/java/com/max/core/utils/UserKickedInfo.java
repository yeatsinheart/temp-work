package com.max.core.utils;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class UserKickedInfo implements Serializable {
    private static final long serialVersionUID = -1807885374181767691L;
    private String kickedIp;
    private Date kickedTime;
}
