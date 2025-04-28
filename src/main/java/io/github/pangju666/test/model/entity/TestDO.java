package io.github.pangju666.test.model.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import io.github.pangju666.framework.data.mybatisplus.model.entity.auto.AutoIdLogicBasicDO;
import jakarta.annotation.Nullable;
import lombok.*;

@EqualsAndHashCode(callSuper = true)
@Data
@TableName("test")
public class TestDO extends AutoIdLogicBasicDO {
	private String label;

	public TestDO() {
	}

	public TestDO(String label) {
		this.label = label;
	}
}
