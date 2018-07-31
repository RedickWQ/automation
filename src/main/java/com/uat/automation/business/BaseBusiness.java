package com.uat.automation.business;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;


/**
 * @Author Paul.Wang
 * @Date 2018/7/26
 */
public class BaseBusiness {
    public Logger logger = LoggerFactory.getLogger(this.getClass().getName());

    public void assertListIsEmpty(List<?> list) throws Exception{
        if (list.isEmpty()) {
            throw new Exception("list is empty");
        }
    }
}
