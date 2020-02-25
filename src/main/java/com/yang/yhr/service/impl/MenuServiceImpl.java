package com.yang.yhr.service.impl;

import com.yang.yhr.dao.MenuDao;
import com.yang.yhr.dao.MenuRoleDao;
import com.yang.yhr.entity.Hr;
import com.yang.yhr.entity.Menu;
import com.yang.yhr.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class MenuServiceImpl implements MenuService {
    @Autowired
    MenuDao menuDao;
    @Autowired
    MenuRoleDao menuRoleDao;
    public List<Menu> getMenusByHrId() {
        return menuDao.getMenusByHrId(((Hr) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getId());
    }

    public List<Menu> getAllMenusWithRole() {
        return menuDao.getAllMenusWithRole();
    }

    public List<Menu> getAllMenus() {
        return menuDao.getAllMenus();
    }

    public List<Integer> getMidsByRid(Integer rid) {
        return menuDao.getMidsByRid(rid);
    }

    @Transactional
    public boolean updateMenuRole(Integer rid, Integer[] mids) {
        menuRoleDao.deleteByRid(rid);
        if (mids == null || mids.length == 0) {
            return true;
        }
        Integer result = menuRoleDao.insertRecord(rid, mids);
        return result==mids.length;
    }
}
