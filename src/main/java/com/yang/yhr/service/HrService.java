package com.yang.yhr.service;

import com.yang.yhr.entity.Hr;
import com.yang.yhr.utils.HrUtils;
import org.apache.ibatis.annotations.Param;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * (Hr)表服务接口
 *
 * @author makejava
 * @since 2020-02-24 11:08:03
 */
public interface HrService {

    List<Hr> getAllHrs(String keywords);

    Integer updateHr(Hr hr);

    boolean updateHrRole(Integer hrid, Integer[] rids);

    Integer deleteHrById(Integer id);

    List<Hr> getAllHrsExceptCurrentHr();
}