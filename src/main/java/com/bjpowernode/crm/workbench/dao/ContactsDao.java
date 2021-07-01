package com.bjpowernode.crm.workbench.dao;

import com.bjpowernode.crm.workbench.domain.Contacts;

import java.util.List;
import java.util.Map;

public interface ContactsDao {

    int save(Contacts con);

    List<Contacts> selectContact(String fullname);

    int pageCount(Map<String, Object> map);

    List<Contacts> pageList(Map<String, Object> map);

    List<Contacts> getContacts();

    int add(Contacts con);
}
