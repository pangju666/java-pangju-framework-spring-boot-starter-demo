package io.github.pangju666.test.repository;

import io.github.pangju666.framework.autoconfigure.cache.hash.annoation.HashCacheable;
import io.github.pangju666.framework.data.mybatisplus.repository.BaseRepository;
import io.github.pangju666.test.mapper.TestMapper;
import io.github.pangju666.test.model.entity.TestDO;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class TestRepository extends BaseRepository<TestMapper, TestDO> {
	@HashCacheable(cache = "test_cache", keyField = "id", allEntries = true)
	@Override
	public List<TestDO> list() {
		return super.list();
	}
}
