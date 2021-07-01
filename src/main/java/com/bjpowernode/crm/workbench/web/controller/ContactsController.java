package com.bjpowernode.crm.workbench.web.controller;

import com.bjpowernode.crm.settings.domain.User;
import com.bjpowernode.crm.utils.DateTimeUtil;
import com.bjpowernode.crm.utils.PrintJson;
import com.bjpowernode.crm.utils.ServiceFactory;
import com.bjpowernode.crm.utils.UUIDUtil;
import com.bjpowernode.crm.vo.PaginationVo;
import com.bjpowernode.crm.workbench.dao.ContactsDao;
import com.bjpowernode.crm.workbench.domain.Contacts;
import com.bjpowernode.crm.workbench.service.ContactsService;
import com.bjpowernode.crm.workbench.service.impl.ContactsServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ContactsController extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        System.out.println("进入联系人模块");
        String path = request.getServletPath();
        if ("/workbench/contacts/pageList.do".equals(path)){
            pageList(request,response);
        }else if ("/workbench/contacts/getContacts.do".equals(path)){
            getContacts(request,response);
        }else if ("/workbench/contacts/add.do".equals(path)){
            add(request,response);
        }

    }

    private void add(HttpServletRequest request, HttpServletResponse response) {
        String id = UUIDUtil.getUUID();
        String owner = request.getParameter("owner");
        String source = request.getParameter("source");
        String customerId = request.getParameter("customerId");
        String fullname = request.getParameter("fullname");
        String appellation = request.getParameter("appellation");
        String email = request.getParameter("email");
        String mphone = request.getParameter("mphone");
        String job = request.getParameter("job");
        String birth = request.getParameter("birth");
        String createBy = ((User)request.getSession().getAttribute("user")).getName();
        String createTime = DateTimeUtil.getSysTime();
        String description  = request.getParameter("description");
        String contactSummary = request.getParameter("contactSummary");
        String nextContactTime = request.getParameter("nextContactTime");
        String address = request.getParameter("address");

        Contacts con = new Contacts();
        con.setId(id);
        con.setOwner(owner);
        con.setSource(source);
        con.setCustomerId(customerId);
        con.setFullname(fullname);
        con.setAppellation(appellation);
        con.setEmail(email);
        con.setMphone(mphone);
        con.setJob(job);
        con.setBirth(birth);
        con.setCreateBy(createBy);
        con.setCreateTime(createTime);
        con.setDescription(description);
        con.setContactSummary(contactSummary);
        con.setNextContactTime(nextContactTime);
        con.setAddress(address);

        ContactsService cs = (ContactsService) ServiceFactory.getService(new ContactsServiceImpl());
        boolean flag = cs.add(con);

        PrintJson.printJsonFlag(response,flag);

    }

    private void getContacts(HttpServletRequest request, HttpServletResponse response) {
        ContactsService cs = (ContactsService) ServiceFactory.getService(new ContactsServiceImpl());
        List<User> contactsList = cs.getContacts();
        PrintJson.printJsonObj(response,contactsList);
    }

    private void pageList(HttpServletRequest request, HttpServletResponse response) {
        String pageNos = request.getParameter("pageNo");
        String pageSizes = request.getParameter("pageSize");
        String owner = request.getParameter("owner");
        String fullname = request.getParameter("fullname");
        String customerId = request.getParameter("customerId");
        String source = request.getParameter("source");
        String birth = request.getParameter("birth");
        int pageNo = Integer.valueOf(pageNos);
        int pageSize = Integer.valueOf(pageSizes);
        //计算出略过的记录数
        int skipCount = (pageSize*(pageNo-1));

        Map<String,Object> map = new HashMap<>();
        map.put("owner",owner);
        map.put("fullname",fullname);
        map.put("customerId",customerId);
        map.put("source",source);
        map.put("birth",birth);
        map.put("pageSize",pageSize);
        map.put("skipCount",skipCount);

        ContactsService cs = (ContactsService) ServiceFactory.getService(new ContactsServiceImpl());
        PaginationVo<Contacts> vo = cs.pageList(map);

        PrintJson.printJsonObj(response,vo);
    }
}
