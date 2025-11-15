package io.github.pangju666.test.model.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.github.pangju666.framework.boot.data.mybatisplus.model.entity.LogicBaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
@TableName("test")
public class TestDO extends LogicBaseEntity<Long> {
	@TableId(type = IdType.AUTO)
	private Long id;
	private String label;

	public TestDO() {
	}

	public TestDO(String label) {
		this.label = label;
	}
}
