package io.github.pangju666.test.model.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import io.github.pangju666.framework.data.mybatisplus.model.entity.auto.AutoIdLogicBasicDO;

@TableName("test")
public class TestDO extends AutoIdLogicBasicDO {
	private String label;
}
