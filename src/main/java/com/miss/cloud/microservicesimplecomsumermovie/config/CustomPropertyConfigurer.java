package com.miss.cloud.microservicesimplecomsumermovie.config;

import java.util.Map.Entry;
import java.util.Properties;
import java.util.Set;

import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;

/**
 * 修改spring读取配置文件属性类（暂时行不通，不知道刘振怎么搞的）
 * 
 * @author Hang W
 * @date 17点25分
 */
public class CustomPropertyConfigurer extends PropertyPlaceholderConfigurer {

	private static final String QUEUE = "queueName";
	
	@Override
	public void setProperties(Properties properties) {
		// TODO Auto-generated method stub
		properties = this.fixProperties(properties);
		
		super.setProperties(properties);
	}

	/**
	 * 修改配置文件属性名
	 * @param properties
	 */
	private Properties fixProperties(Properties properties) {
		Set<Entry<Object,Object>> entrySet = properties.entrySet();
		for (Entry<Object, Object> entry : entrySet) {
			String key = String.valueOf(entry.getKey());
			if (key.contains(QUEUE)) {
				// TODO test. 可以从数据库中读取
				String value = "test." + String.valueOf(entry.getKey());
				entry.setValue(value);
			}
		}
		return properties;
	}
	
}
