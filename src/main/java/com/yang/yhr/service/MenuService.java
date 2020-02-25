package com.yang.yhr.service;

import com.yang.yhr.entity.Menu;

import java.util.List;

public interface MenuService {

    List<Menu> getMenusByHrId();

    List<Menu> getAllMenusWithRole();

    List<Menu> getAllMenus();

    List<Integer> getMidsByRid(Integer rid);

    boolean updateMenuRole(Integer rid, Integer[] mids);
}
