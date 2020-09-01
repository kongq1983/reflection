package com.kq.mapper;

/**
 *
 */
public interface AccountMapper {

    /**
     * 根据用户ID得到用户名
     * @param id
     * @return
     */
    public String getUsername(String id);

}
