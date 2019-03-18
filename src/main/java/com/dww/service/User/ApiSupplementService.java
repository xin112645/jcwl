package com.dww.service.User;


import com.dww.util.PageData;
import net.sf.json.JSONObject;

import java.util.List;

public interface ApiSupplementService {

    public List<PageData> findByproduct(PageData pd)throws Exception;//查询用户唯一标识
    public List<PageData> findByServerConfig(PageData pd)throws Exception;//查询服务器信息
    public List<PageData> findByServerAppid(PageData pd)throws Exception;//查询Appid

    public List<PageData> findByTrade(PageData pd)throws Exception;//查询交易记录
    public List<PageData> findByMerLayout(PageData pd)throws Exception;//查询商户费率

    public int addH5PayInfo(PageData pd)throws Exception;//H5入库

    public int updateTrade(PageData pd)throws Exception;//修改交易状态



}
