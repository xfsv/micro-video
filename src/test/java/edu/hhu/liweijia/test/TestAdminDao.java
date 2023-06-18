package edu.hhu.liweijia.test;

import edu.hhu.liweijia.dao.AdminDao;
import edu.hhu.liweijia.entity.Admin;

public class TestAdminDao {

    public static void main(String[] args) {

        AdminDao adminDao = new AdminDao();
        Admin admin = adminDao.queryByAccountAndPassword("admin", "123456");
        System.out.println(admin);
    }
}
