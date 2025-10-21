package io.github.pangju666.test.repository;

import io.github.pangju666.framework.data.mybatisplus.repository.BaseRepository;
import io.github.pangju666.test.mapper.TestMapper;
import io.github.pangju666.test.model.entity.TestDO;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

@Repository
public class TestRepository extends BaseRepository<TestMapper, TestDO> /*implements HashCacheSorter<TestDO>, HashCacheProcessor*/ {
	//@HashCacheable(cache = "test_cache", keyField = "id", allEntries = true)
	//@Cacheable(cacheManager = "test2RedisCacheManager", value = "test_cache", key = "#result.contains('adsad')")
	@Override
	public List<TestDO> list() {
		return super.list();
	}

	//@HashCacheable(cache = "test_cache", key = "#p0")
	@Override
	public List<TestDO> listByIds(Collection<? extends Serializable> ids) {
		return super.listByIds(ids);
	}

	//@HashCacheable(cache = "test_cache", key = "#p0", sortFields = "id")
	public List<TestDO> listByIdsOrderById(Collection<Long> ids) {
		return listByColumnValues(lambdaQuery().orderByAsc(TestDO::getLabel),
			TestDO::getId, ids);
	}

	//@HashCacheable(cache = "test_cache", key = "#p0", sortFields = "id", reverseOrder = true)
	public List<TestDO> listByIdsOrderByyIdDesc(Collection<Long> ids) {
		return listByColumnValues(lambdaQuery().orderByAsc(TestDO::getLabel),
			TestDO::getId, ids);
	}

	//@HashCacheable(cache = "test_cache", key = "#p0")
	@Override
	public TestDO getById(Serializable id) {
		return super.getById(id);
	}

/*	@Override
	public Comparator<TestDO> getComparator(String sortField) {
		return switch (sortField) {
			case "id" -> Comparator.comparing(TestDO::getId);
			case "label" -> Comparator.comparing(TestDO::getLabel);
			default -> (left, right) -> 0;
		};
	}*/

	/*@Override
	public void init(HashCacheManager hashCacheManager) {
		//hashCacheManager.putAll("test_cache", "id", super.list());
	}

	@Override
	public void destroy(HashCacheManager hashCacheManager) {
		//hashCacheManager.clear("test_cache");
	}*/
}