package com.bjpowernode.crm.workbench.dao;

import com.bjpowernode.crm.workbench.domain.ClueRemark;

import java.util.List;

public interface ClueRemarkDao {

    List<ClueRemark> getRemarkListByCid(String clueId);

    int updateRemark(ClueRemark cr);

    int deleteRemark(String id);

    int saveRemark(ClueRemark cr);
}
