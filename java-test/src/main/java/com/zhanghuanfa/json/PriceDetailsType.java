package com.zhanghuanfa.json;

import lombok.Data;

import java.io.Serializable;

/**
 * @author zhanghuanfa 2019-04-04 15:37
 */
@Data
public class PriceDetailsType implements Serializable {
    private static final long serialVersionUID = -122775412162460317L;

    private String CheckOutDate;
    private String CheckInDate;
}
