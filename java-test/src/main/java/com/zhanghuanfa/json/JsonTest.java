package com.zhanghuanfa.json;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author zhanghuanfa 2019-04-04 15:36
 */
public class JsonTest {

    private static Logger logger = LoggerFactory.getLogger(JsonTest.class);

    public static void main(String[] args) {
        /*String json = "{\"Success\": {\"PriceDetails\": {\"CheckOutDate\": \"2019-04-05 00:00:00\"}}}";
        JSONObject jsonObject = JSON.parseObject(json);
        boolean success = jsonObject.containsKey("Success");
        if (success) {
            String success1 = jsonObject.getString("Success");
            System.out.println(success1);
            PriceSearchRespSuccess priceSearchRespSuccess = JSON.parseObject(success1, PriceSearchRespSuccess.class);
            logger.info("success1 = {}, result = {}", success1, priceSearchRespSuccess);
            System.out.println(priceSearchRespSuccess);
        }*/
        PriceSearchRespSuccess respSuccess = new PriceSearchRespSuccess();
//        respSuccess.setPriceDetails();

    }
}
