package com.dww.service.User.impl;

import com.dww.dao.DaoSupport;
import com.dww.service.User.ApiSupplementService;
import com.dww.util.PageData;
import net.sf.json.JSONObject;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;

@Service("userService")
public class ApiapiSupplementServiceImpl implements ApiSupplementService {
    @Resource(name = "daoSupport")
    private DaoSupport dao;


    @Override
    public List<PageData> findByproduct(PageData pd) throws Exception {
        return (List<PageData>) dao.findForList("ApiSupplement.findByproduct",pd);
    }

    @Override
    public List<PageData> findByServerConfig(PageData pd) throws Exception {
        return (List<PageData>) dao.findForList("ApiSupplement.findByServerConfig",pd);
    }

    @Override
    public List<PageData> findByServerAppid(PageData pd) throws Exception {
        return (List<PageData>) dao.findForList("ApiSupplement.findByServerAppid",pd);
    }



    @Override
    public int addH5PayInfo(PageData pd) throws Exception {
        return (int) dao.save("ApiSupplement.addH5PayInfo",pd);
    }

    @Override
    public List<PageData> findByTrade(PageData pd) throws Exception {
        return (List<PageData>) dao.findForList("ApiSupplement.findByTrade",pd);
    }

    @Override
    public List<PageData> findByMerLayout(PageData pd)throws Exception{
        return (List<PageData>) dao.findForList("ApiSupplement.findByMerLayout",pd);
    }

    @Override
    public int updateTrade(PageData pd)throws Exception{
        return (int) dao.update("ApiSupplement.updateTrade",pd);
    }

}
