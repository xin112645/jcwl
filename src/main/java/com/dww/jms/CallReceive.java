package com.dww.jms;

import com.dww.service.User.ApiSupplementService;
import com.dww.util.HttpUitl;
import com.dww.util.HttpUrlConnectionUitl;
import com.dww.util.PageData;
import com.dww.util.UuidUtil;
import net.sf.json.JSONObject;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Component
public class CallReceive {

    @Resource
    private ApiSupplementService ap;

    @JmsListener(destination = "Order.AliGateWay.Listener")
    public void receiveQueue(String msg)throws Exception {
        System.out.println("----------进入网关自动回调接口--------------");
        try{
            JSONObject jsonObject = JSONObject.fromObject(msg);
            System.out.println(jsonObject.get("merchant_uuid"));

            PageData pg = new PageData();

            String money = String.valueOf(jsonObject.get("money"));
            String no = String.valueOf(jsonObject.get("no"));
            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
            String system = df.format(new Date());

            System.out.println("回调时间："+system);
            System.out.println("交易金额："+money);
            System.out.println("交易单号："+no);

            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Calendar rightNow = Calendar.getInstance();
            Date dt=dateFormat.parse(dateFormat.format(new Date()));
            rightNow.setTime(dt);
            rightNow.add(Calendar.MINUTE,-20);//日期减20分钟
            Date dt1=rightNow.getTime();
            String reStr = dateFormat.format(dt1);
            System.out.println(reStr);

            pg.put("money", money);
            pg.put("writetime", reStr);
            List<PageData> list =  ap.findByTrade(pg);

            if(list.size()==0){
                System.out.println("异常数据，暂无此金额数据："+money +";异常单号："+no);
                return;
            }
            if(list.size()>1){
                System.out.println("异常数据，此金额："+money +"有多条数据;共有"+list.size()+"条；");
                return;
            }
            String uuid = "";
            String mer_uuid = "";
            for(PageData pd : list){
                System.out.println("交易单号："+no);
                pg.put("uuid",pd.get("uuid"));
                pg.put("no",no);
                if(1 == ap.updateTrade(pg)){
                    String getvalueString = "merchant_uuid="
                            + pd.get("uuid")+ "&out_trade_no="
                            + pd.get("mer_pay_order") + "" + "&trade_no="
                            + pd.get("trade_no") + "" + "&trade_status="
                            + "TRADE_SUCCESS" + "" + "&total_amount="
                            + pd.get("money_1") + "" + "&actual_amount="
                            + pd.get("money_2") + "" + "&random_str="
                            + pd.get("random_str") + "" + "&sign_str="
                            + pd.get("sign_str") + "" ;

                    String jsonHttpUrlPost = "";
                    System.out.println("----------开始回调下游--------------");
                    System.out.println("回调内容："+getvalueString);
                    if ("get".equals(pd.get("call_type")) || "GET".equals(pd.get("call_type"))) {
                        jsonHttpUrlPost = HttpUitl.sendGet(String.valueOf(pd.get("notify_url")),getvalueString);
                    } else {
                        jsonHttpUrlPost = HttpUrlConnectionUitl.getJsonHttpUrlPost(String.valueOf(pd.get("notify_url")),
                                getvalueString);
                    }
                    System.out.println("----------回调通知成功--------------");
                }else{
                    System.out.println("交易状态更新失敗：uuid="+pd.get("uuid"));
                }
            }
        }catch (Exception e){
            System.out.println("----------网关自动回调异常结束--------------");
        }
    }
}

