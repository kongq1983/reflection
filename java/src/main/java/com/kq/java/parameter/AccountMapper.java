package com.kq.java.parameter;

import java.util.Date;

/**
 * @author kq
 * @date 2020-09-23 9:41
 * @since 2020-0630
 */
public interface AccountMapper {

    public void accountAdd(Long id, String username, Date createTime);

}
