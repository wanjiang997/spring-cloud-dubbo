package com.wj.provider.mapper.impl;

import com.wj.entity.UserAddress;
import com.wj.provider.mapper.UserMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: wanjiang
 * Date: 2019/11/23
 * Time: 14:35
 */
@Repository
public class UserMapperImpl implements UserMapper {

    private static final Logger logger = LoggerFactory.getLogger(UserMapperImpl.class);

    @Autowired
    @Qualifier("primaryDataSourceJdbcTemplate")
    private JdbcTemplate jdbcTemplate;

    /**
     * 表名
     */
    private static final String TABLE_NAME = "user";

    /**
     * 查询SQL
     */
    private static final String QUERY_SQL = "select t.id, t.user_address, t.user_id, t.consignee, t.phone_num," +
                                             " t.is_default, t.create_time, t.update_time from " + TABLE_NAME + " t WHERE 1=1 and t.id=?";

    @Override
    public List<UserAddress> queryUserList(String id) {
        logger.info("queryUserList id={}", id);
        PreparedStatementSetter param = preparedStatement -> preparedStatement.setString(1, id);
        return jdbcTemplate.query(QUERY_SQL, param, (resultSet, i) -> {
            UserAddress user = new UserAddress();
            user.setId(resultSet.getLong("id"));
            user.setUserAddress(resultSet.getString("user_address"));
            user.setUserId(resultSet.getString("user_id"));
            user.setPhoneNum(resultSet.getString("phone_num"));
            user.setConsignee(resultSet.getString("consignee"));
            user.setIsDefault(resultSet.getInt("is_default"));
            user.setCreateTime(resultSet.getDate("create_time"));
            user.setUpdateTime(resultSet.getDate("update_time"));
            return user;
        });
    }
}
