package com.dww.jms;

import com.dww.service.User.ApiSupplementService;
import com.dww.util.NumberOper;
import com.dww.util.PageData;
import com.dww.util.UuidUtil;
import net.sf.json.JSONObject;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Component
public class TradeReceive {

    @Resource
    private ApiSupplementService ap;

    @JmsListener(destination = "Order.AliGateWay")
    public void receiveQueue(String msg)throws Exception {

        System.out.println("------------进入商户请求入库接口--------------");
        try{
            JSONObject jsonObject = JSONObject.fromObject(msg);
            System.out.println(jsonObject.get("merchant_uuid"));

            PageData pg = new PageData();

            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
            String system = df.format(new Date());
            String paydate = system.replaceAll("-","").substring(0,8);
            String paytime = system.replaceAll("-","").replaceAll(" ","").replaceAll(":","").substring(8,14);


            pg.put("uuid", UuidUtil.get32UUID());
            pg.put("mer_uuid", String.valueOf(jsonObject.get("merchant_uuid")));

            List<PageData> list =  ap.findByMerLayout(pg);

            if(list.size()==1){
                for(PageData pd : list){
                    String profit = NumberOper.format20(Double.parseDouble(String.valueOf(jsonObject.get("amount")))
                            * Double.parseDouble(String.valueOf(pd

                            .get("rate_value7"))));
                    pg.put("rate_value12", String.valueOf(pd.get("rate_value7")));
                    pg.put("profits_3", profit);
                }
            }else{
                System.out.println("------------商户请求入库失败--------------");
            }
            pg.put("mer_pay_order", String.valueOf(jsonObject.get("trade_no")));
            pg.put("trade_no", String.valueOf(jsonObject.get("uuid")));
            pg.put("money_1", String.valueOf(jsonObject.get("Amount_")));
            pg.put("money_2", String.valueOf(jsonObject.get("amount")));
            pg.put("number", String.valueOf(jsonObject.get("number")));
            pg.put("trade_status", "TRADE_STAR");
            pg.put("pay_date", paydate);
            pg.put("pay_time", paytime);
            pg.put("pay_name", String.valueOf(jsonObject.get("product_type")));
            pg.put("random_str", String.valueOf(jsonObject.get("random_str")));
            pg.put("sign_str", String.valueOf(jsonObject.get("sign")));
            pg.put("return_url", String.valueOf(jsonObject.get("return_url")));
            pg.put("notify_url", String.valueOf(jsonObject.get("return_url")));
            pg.put("call_type", String.valueOf(jsonObject.get("return_type")));
            pg.put("memo1", "");
            pg.put("source_status", "0");
            pg.put("bank_no", "");
            pg.put("bank_type", "");
            pg.put("writetime", system);
            if(1 == ap.addH5PayInfo(pg)) {
                System.out.println("------------商户请求入库成功--------------");
            }else{
                System.out.println("------------商户请求入库失败--------------");
            }
        }catch (Exception e){
            System.out.println("------------商户请求入库异常结束--------------");
        }
    }
}

