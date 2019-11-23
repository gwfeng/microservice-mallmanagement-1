package com.itheima.mapper;

import com.itheima.po.Order;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface OrderMapper {
    @Insert("insert into tb_order(number,userid,createtime) values (#{number},#{userid},#{createtime})")
	void saveOrder(Order order);
    @Select("select * from tb_order where userid =#{userid}")
    List<Order> selectOrder(Integer userid);
}