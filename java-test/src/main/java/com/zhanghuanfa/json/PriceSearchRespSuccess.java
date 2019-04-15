package com.zhanghuanfa.json;

import lombok.Data;

import java.io.Serializable;

/**
 * @author zhanghuanfa 2019-04-04 15:37
 */
@Data
public class PriceSearchRespSuccess implements Serializable {

    private static final long serialVersionUID = 8553794753923038931L;

    private PriceDetailsType PriceDetails;
}
