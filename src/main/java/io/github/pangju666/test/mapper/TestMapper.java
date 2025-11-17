package io.github.pangju666.test.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import io.github.pangju666.test.entity.TestDO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface TestMapper extends BaseMapper<TestDO> {
}
