package config.mapper;

import config.domain.NameValue;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * Created by hzhubin15 on 2016/8/19.
 */
@Mapper
@Repository("nameValueMapper")
public interface NameValueMapper {

	@Select("Select * from tb_name_value where name = #{name}")
	NameValue findByName(@Param("name") String name);

	@Select("Select * from tb_name_value where id = #{id}")
	NameValue findById(@Param("id") String id);
}
