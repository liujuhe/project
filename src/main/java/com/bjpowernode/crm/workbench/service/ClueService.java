package com.bjpowernode.crm.workbench.service;

import com.bjpowernode.crm.vo.PaginationVo;
import com.bjpowernode.crm.workbench.domain.Clue;
import com.bjpowernode.crm.workbench.domain.ClueRemark;
import com.bjpowernode.crm.workbench.domain.Tran;

import java.util.List;
import java.util.Map;

public interface ClueService {
    boolean save(Clue c);

    PaginationVo<Clue> pageList(Map<String,Object> map);

    Clue detail(String id);

    List<ClueRemark> getRemarkListByCid(String clueId);

    boolean updateRemark(ClueRemark cr);

    boolean deleteRemark(String id);

    boolean saveRemark(ClueRemark cr);

    boolean unbund(String id);

    boolean bund(String cid, String[] aids);

    boolean convert(String clueId, Tran t, String createBy);
}
