package com.pppcar.spring.boot.druid;

import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;

@Configuration
@PropertySource(value = { "classpath:source.properties" })
public class DruidConfiguration {
	@Autowired
	private Environment env;

	@Bean
	public ServletRegistrationBean DruidStatViewServlet() {

		// org.springframework.boot.context.embedded.ServletRegistrationBean提供类的进行注册.
		ServletRegistrationBean servletRegistrationBean = new ServletRegistrationBean(new StatViewServlet(),
				"/druid/*");
		// 添加初始化参数：initParams
		// 白名单：
		servletRegistrationBean.addInitParameter("allow", "127.0.0.1");
		// IP黑名单 (存在共同时，deny优先于allow) : 如果满足deny的话提示:Sorry, you are not
		// permitted to view this page.
		servletRegistrationBean.addInitParameter("deny", "192.168.1.73");
		// 登录查看信息的账号密码.
		servletRegistrationBean.addInitParameter("loginUsername", "admin2");
		servletRegistrationBean.addInitParameter("loginPassword", "123456");
		// 是否能够重置数据.
		servletRegistrationBean.addInitParameter("resetEnable", "false");
		return servletRegistrationBean;

	}

	@Bean
	public FilterRegistrationBean druidStatFilter() {
		FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean(new WebStatFilter());
		// 添加过滤规则.
		filterRegistrationBean.addUrlPatterns("/*");
		// 添加不需要忽略的格式信息.
		filterRegistrationBean.addInitParameter("exclusions", "*.js,*.gif,*.jpg,*.png,*.css,*.ico,/druid/*");
		return filterRegistrationBean;

	}

	/**
	 * 
	 * 注册dataSouce，这里作为一个例子，只注入了部分参数信息，其它的参数自行扩散思维。
	 * 
	 * @param driver
	 * 
	 * @param url
	 * 
	 * @param username
	 * 
	 * @param password
	 * 
	 * @param maxActive
	 * 
	 * @return
	 * @throws SQLException
	 * 
	 */

	@Bean(initMethod = "init", destroyMethod = "close", name = "druidDataSource")
	public DataSource druidDataSource() throws SQLException {
		DruidDataSource dataSource = new DruidDataSource();
		dataSource.setDriverClassName(env.getProperty("source.driverClassName").trim());
		dataSource.setUrl(env.getProperty("source.url").trim());
		dataSource.setUsername(env.getProperty("source.username").trim());
		dataSource.setPassword(env.getProperty("source.password").trim());
		dataSource.setFilters(env.getProperty("source.filters").trim());
		dataSource.setMaxActive(Integer.parseInt(env.getProperty("source.maxActive").trim()));
		dataSource.setInitialSize(Integer.parseInt(env.getProperty("source.initialSize").trim()));
		dataSource.setMaxWait(Long.parseLong(env.getProperty("source.maxWait").trim()));
		dataSource.setMinIdle(Integer.parseInt(env.getProperty("source.minIdle").trim()));
		dataSource.setTimeBetweenEvictionRunsMillis(
				Long.parseLong(env.getProperty("source.timeBetweenEvictionRunsMillis").trim()));
		dataSource.setMinEvictableIdleTimeMillis(
				Long.parseLong(env.getProperty("source.minEvictableIdleTimeMillis").trim()));
		return dataSource;

	}

}
