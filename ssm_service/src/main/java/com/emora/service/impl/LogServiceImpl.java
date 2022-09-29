package com.emora.service.impl;

import com.emora.domain.Log;
import com.emora.mapper.LogMapper;
import com.emora.service.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Description
 * @Author jianpeng
 * @Date 2022/9/11 22:38
 */
@Service
public class LogServiceImpl implements LogService {
    @Autowired
    protected LogMapper logMapper;
    @Override
    public void saveLog(Log log) {
        logMapper.saveLog(log);
    }
}
