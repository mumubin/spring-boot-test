package config.domain;

import lombok.Data;

import java.util.Date;

/**
 * Created by hzhubin15 on 2016/8/19.
 */
@Data
public class NameValue {
	private Long id;

	/**
	 * key
	 */
	private String name;

	/**
	 * 值
	 */
	private String value;

	/**
	 * 用途描述
	 */
	private String descNote;

	private Date dbCreateTime;

	private Date dbUpdateTime;
}
