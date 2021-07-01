package com.bjpowernode.crm.workbench.dao;

import com.bjpowernode.crm.workbench.domain.Tran;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface TranDao {

    int save(Tran t);

    Tran detail(String id);

    List<Tran> pageList(@Param("skipCount") int skipCount, @Param("pageSize") int pageSize);

    int changeStage(Tran t);

    int getTotal();

    List<Map<String, Object>> getCharts();
}
