package io.github.pangju666.test.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.github.pangju666.framework.boot.data.mybatisplus.model.entity.LogicBaseEntity;
import io.github.pangju666.framework.data.mybatisplus.type.handler.JsonTypeHandler;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;
import java.util.Map;

@EqualsAndHashCode(callSuper = true)
@Data
@TableName(value = "test", autoResultMap = true)
public class TestDO extends LogicBaseEntity<Long> {
	@TableId(type = IdType.AUTO)
	private Long id;
	private String name;
	@TableField(typeHandler = JsonTypeHandler.class)
	private Map<String, Object> metaData;
	@TableField(typeHandler = JsonTypeHandler.class)
	private List<String> tags;
}
