package com.yang.yhr.service.impl;

import com.yang.yhr.dao.HrRoleDao;
import com.yang.yhr.entity.Hr;
import com.yang.yhr.dao.HrDao;
import com.yang.yhr.service.HrService;
import com.yang.yhr.utils.HrUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * (Hr)表服务实现类
 *
 * @author makejava
 * @since 2020-02-24 11:08:04
 */
@Service
public class HrServiceImpl implements HrService, UserDetailsService {
    @Autowired
    HrDao hrDao;
    @Autowired
    HrRoleDao hrRoleMapper;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Hr hr = hrDao.loadUserByUsername(username);
        if (hr == null) {
            throw new UsernameNotFoundException("用户名不存在!");
        }
        hr.setRoles(hrDao.getHrRolesById(hr.getId()));
        return hr;
    }

    public List<Hr> getAllHrs(String keywords) {
        return hrDao.getAllHrs(HrUtils.getCurrentHr().getId(),keywords);
    }

    public Integer updateHr(Hr hr) {
        return hrDao.updateByPrimaryKeySelective(hr);
    }

    @Transactional
    public boolean updateHrRole(Integer hrid, Integer[] rids) {
        hrRoleMapper.deleteByHrid(hrid);
        return hrRoleMapper.addRole(hrid, rids) == rids.length;
    }

    public Integer deleteHrById(Integer id) {
        return hrDao.deleteByPrimaryKey(id);
    }

    public List<Hr> getAllHrsExceptCurrentHr() {
        return hrDao.getAllHrsExceptCurrentHr(HrUtils.getCurrentHr().getId());
    }
}