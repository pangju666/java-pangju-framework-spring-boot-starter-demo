package io.github.pangju666.test.repository;

import io.github.pangju666.framework.autoconfigure.cache.hash.HashCacheManager;
import io.github.pangju666.framework.autoconfigure.cache.hash.HashCacheProcessor;
import io.github.pangju666.framework.autoconfigure.cache.hash.HashCacheSorter;
import io.github.pangju666.framework.autoconfigure.cache.hash.annoation.HashCacheable;
import io.github.pangju666.framework.data.mybatisplus.repository.BaseRepository;
import io.github.pangju666.test.mapper.TestMapper;
import io.github.pangju666.test.model.entity.TestDO;
import org.apache.commons.collections4.comparators.ComparatorChain;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;

@Repository
public class TestRepository extends BaseRepository<TestMapper, TestDO> implements HashCacheSorter<TestDO>, HashCacheProcessor {
	@HashCacheable(cache = "test_cache", keyField = "id", allEntries = true)
	@Override
	public List<TestDO> list() {
		return super.list();
	}

	@HashCacheable(cache = "test_cache", key = "#p0")
	@Override
	public List<TestDO> listByIds(Collection<? extends Serializable> ids) {
		return super.listByIds(ids);
	}

	@HashCacheable(cache = "test_cache", key = "#p0")
	@Override
	public TestDO getById(Serializable id) {
		return super.getById(id);
	}

	@Override
	public Comparator<TestDO> getComparator(String sortField) {
		return switch (sortField) {
			case "id" -> Comparator.comparing(TestDO::getId);
			case "label" -> Comparator.comparing(TestDO::getLabel);
			default -> (left, right) -> 0;
		};
	}

	@Override
	public void init(HashCacheManager hashCacheManager) {
		hashCacheManager.putAll("test_cache", "id", super.list());
	}

	@Override
	public void destroy(HashCacheManager hashCacheManager) {
		hashCacheManager.clear("test_cache");
	}
}