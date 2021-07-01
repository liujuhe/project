package com.bjpowernode.crm.workbench.service.impl;

import com.bjpowernode.crm.settings.dao.UserDao;
import com.bjpowernode.crm.settings.domain.User;
import com.bjpowernode.crm.utils.SqlSessionUtil;
import com.bjpowernode.crm.vo.PaginationVo;
import com.bjpowernode.crm.workbench.dao.ContactsDao;
import com.bjpowernode.crm.workbench.domain.Contacts;
import com.bjpowernode.crm.workbench.service.ContactsService;

import java.util.List;
import java.util.Map;


public class ContactsServiceImpl implements ContactsService {

    private ContactsDao  contactsDao = SqlSessionUtil.getSqlSession().getMapper(ContactsDao.class);
    private UserDao userDao = SqlSessionUtil.getSqlSession().getMapper(UserDao.class);
    @Override
    public List<Contacts> selectContact(String fullname) {
        List<Contacts> cList = contactsDao.selectContact(fullname);
        return cList;
    }

    @Override
    public PaginationVo<Contacts> pageList(Map<String, Object> map) {
        int total = contactsDao.pageCount(map);
        List<Contacts> contactsList = contactsDao.pageList(map);
        PaginationVo<Contacts> vo = new PaginationVo<>();
        vo.setTotal(total);
        vo.setDataList(contactsList);
        return vo;
    }

    @Override
    public List<User> getContacts() {
        return userDao.getUserList();
    }

    @Override
    public boolean add(Contacts con) {
        boolean flag = true;
        int count = contactsDao.add(con);
        if (count != 1){
            flag = false;
        }
        return flag;
    }
}
