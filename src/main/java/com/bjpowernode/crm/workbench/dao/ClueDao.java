package com.bjpowernode.crm.workbench.dao;

import com.bjpowernode.crm.workbench.domain.Clue;

import java.util.List;
import java.util.Map;

public interface ClueDao {


    int save(Clue c);

    List<Clue> pageList(Map<String,Object> map);

    int pageCount();

    Clue detail(String id);

    Clue getById(String clueId);

    int delete(String clueId);
}
