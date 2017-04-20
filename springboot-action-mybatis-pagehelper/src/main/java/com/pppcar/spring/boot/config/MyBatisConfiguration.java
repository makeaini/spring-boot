package com.pppcar.spring.boot.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import com.github.pagehelper.PageInterceptor;

@Configuration
@MapperScan("com.pppcar.spring.boot.mapper")
public class MyBatisConfiguration {
	@Bean
	public PageInterceptor pageInterceptor() {
		PageInterceptor interceptor = new PageInterceptor();
		Properties p = new Properties();
		p.setProperty("helperDialect", "mysql");
		p.setProperty("reasonable", "true");
		p.setProperty("supportMethodsArguments", "true");
		p.setProperty("offsetAsPageNum", "true");
		p.setProperty("params", "count=countSql");
		p.setProperty("autoRuntimeDialect", "true");
		p.setProperty("pageSizeZero", "true");
		interceptor.setProperties(p);
		return interceptor;
	}

	@Bean
	public SqlSessionFactory sqlSessionFactoryBean(DataSource dataSource) throws Exception {
		SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
		sqlSessionFactoryBean.setDataSource(dataSource);
		PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
		Interceptor[] plugins = new Interceptor[] { pageInterceptor() };
		sqlSessionFactoryBean.setPlugins(plugins);
		// 指定mybatisxml文件路径
		sqlSessionFactoryBean.setMapperLocations(resolver.getResources("classpath:/mybatis/*.xml"));
		return sqlSessionFactoryBean.getObject();
	}

}
