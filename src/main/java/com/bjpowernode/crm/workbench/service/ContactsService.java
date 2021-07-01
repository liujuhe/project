package com.bjpowernode.crm.workbench.service;

import com.bjpowernode.crm.settings.domain.User;
import com.bjpowernode.crm.vo.PaginationVo;
import com.bjpowernode.crm.workbench.domain.Contacts;

import java.util.List;
import java.util.Map;

public interface ContactsService {
    List<Contacts> selectContact(String fullname);

    PaginationVo<Contacts> pageList(Map<String, Object> map);

    List<User> getContacts();

    boolean add(Contacts con);
}
