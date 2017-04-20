package com.pppcar.spring.boot.config;

import org.springframework.beans.BeansException;
import org.springframework.beans.MutablePropertyValues;
import org.springframework.beans.factory.annotation.AnnotatedBeanDefinition;
import org.springframework.beans.factory.annotation.AnnotatedGenericBeanDefinition;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanDefinitionHolder;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionReaderUtils;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanDefinitionRegistryPostProcessor;
import org.springframework.beans.factory.support.BeanNameGenerator;
import org.springframework.context.annotation.AnnotationBeanNameGenerator;
import org.springframework.context.annotation.Configuration;

import com.pppcar.spring.boot.service.impl.AuthorServiceImpl;
import com.pppcar.spring.boot.service.impl.AuthorServiceImpl2;

/**
 * @author shining 先执行：postProcessBeanDefinitionRegistry()方法，
 *         在执行：postProcessBeanFactory()方法。
 */
@Configuration
public class MyBeanDefinitionRegistryPostProcessor implements BeanDefinitionRegistryPostProcessor {
	private BeanNameGenerator beanNameGenerator = new AnnotationBeanNameGenerator();

	@Override
	public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
		System.out.println("postProcessBeanFactory()");
		BeanDefinition beanDefinition = beanFactory.getBeanDefinition("authorServiceI");
		MutablePropertyValues mutablePropertyValues = beanDefinition.getPropertyValues();
		// 加入属性.
		mutablePropertyValues.addPropertyValue("name","shining");
	}

	@Override
	public void postProcessBeanDefinitionRegistry(BeanDefinitionRegistry registry) throws BeansException {
		System.out.println("MyBeanDefinitionRegistryPostProcessor.postProcessBeanDefinitionRegistry()");
		registerBean(registry, "authorServiceI", AuthorServiceImpl.class);
		registerBean(registry, "authorServiceI2", AuthorServiceImpl2.class);
	}

	private void registerBean(BeanDefinitionRegistry registry, String name, Class<?> beanClass) {
		AnnotatedBeanDefinition annotatedBeanDefinition = new AnnotatedGenericBeanDefinition(beanClass);
		// 可以自动生成name
		String beanName = (name != null ? name
				: this.beanNameGenerator.generateBeanName(annotatedBeanDefinition, registry));
		// bean注册的holer类.
		BeanDefinitionHolder beanDefinitionHolder = new BeanDefinitionHolder(annotatedBeanDefinition, beanName);
		// 使用bean注册工具类进行注册.
		BeanDefinitionReaderUtils.registerBeanDefinition(beanDefinitionHolder, registry);
	}

}
