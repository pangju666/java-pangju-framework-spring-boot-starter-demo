package io.github.pangju666.test.repository;

import io.github.pangju666.framework.data.mybatisplus.repository.BaseRepository;
import io.github.pangju666.test.mapper.TestMapper;
import io.github.pangju666.test.model.entity.TestDO;
import org.springframework.stereotype.Repository;

@Repository
public class TestRepository extends BaseRepository<TestMapper, TestDO> {
}
