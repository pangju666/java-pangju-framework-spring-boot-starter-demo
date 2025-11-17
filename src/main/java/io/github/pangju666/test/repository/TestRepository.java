package io.github.pangju666.test.repository;

import io.github.pangju666.framework.data.mybatisplus.repository.BaseRepository;
import io.github.pangju666.test.entity.TestDO;
import io.github.pangju666.test.mapper.TestMapper;
import org.springframework.stereotype.Repository;

@Repository
public class TestRepository extends BaseRepository<TestMapper, TestDO> {
}
