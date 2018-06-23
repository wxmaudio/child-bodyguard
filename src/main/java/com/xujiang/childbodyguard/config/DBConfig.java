package com.xujiang.childbodyguard.config;

import com.alibaba.druid.pool.DruidDataSource;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @Description 数据源配置
 * @Author madenghui
 * @Created 11/26/16
 */
@Configuration
@MapperScan(basePackages = {"com.xujiang.childbodyguard.dao.mapper"})
@EnableTransactionManagement
@Slf4j
public class DBConfig {

    @Value("${dataSource.master.driverClassName}")
    private String driverClassName;
    @Value("${dataSource.master.url}")
    private String url;
    @Value("${dataSource.master.username}")
    private String userName;
    @Value("${dataSource.master.password}")
    private String password;
    @Value("${dataSource.master.initialSize}")
    private int initialSize;
    @Value("${dataSource.master.minIdle}")
    private int minIdle;
    @Value("${dataSource.master.maxActive}")
    private int maxActive;
    @Value("${dataSource.master.maxWait}")
    private int maxWait;
    @Value("${dataSource.master.timeBetweenEvictionRunsMillis}")
    private int timeBetweenEvictionRunsMillis;
    @Value("${dataSource.master.minEvictableIdleTimeMillis}")
    private int minEvictableIdleTimeMillis;
    @Value("${dataSource.master.validationQuery}")
    private String validationQuery;
    @Value("${dataSource.master.testWhileIdle}")
    private boolean testWhileIdle;
    @Value("${dataSource.master.testOnBorrow}")
    private boolean testOnBorrow;
    @Value("${dataSource.master.testOnReturn}")
    private boolean testOnReturn;
    @Value("${dataSource.master.poolPreparedStatements}")
    private boolean poolPreparedStatements;
    @Value("${dataSource.master.maxPoolPreparedStatementPerConnectionSize}")
    private int maxPoolPreparedStatementPerConnectionSize;
    @Value("${dataSource.master.filters}")
    private String filters;



    @Bean(initMethod = "init", destroyMethod = "close")
    public DruidDataSource masterDataSource(){
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setUrl(url);
        log.info("db url is =========== {}", url);
        dataSource.setUsername(userName);
        dataSource.setPassword(password);
        dataSource.setDriverClassName(driverClassName);

        dataSource.setInitialSize(initialSize);
        dataSource.setMinIdle(minIdle);
        dataSource.setMaxActive(maxActive);
        dataSource.setMaxWait(maxWait);
        dataSource.setTimeBetweenEvictionRunsMillis(timeBetweenEvictionRunsMillis);
        dataSource.setMinEvictableIdleTimeMillis(minEvictableIdleTimeMillis);
        dataSource.setValidationQuery(validationQuery);
        dataSource.setTestWhileIdle(testWhileIdle);
        dataSource.setTestOnBorrow(testOnBorrow);
        dataSource.setTestOnReturn(testOnReturn);
        dataSource.setPoolPreparedStatements(poolPreparedStatements);
        dataSource.setMaxPoolPreparedStatementPerConnectionSize(maxPoolPreparedStatementPerConnectionSize);

        return dataSource;

    }

    @Bean
    public SqlSessionFactory sqlSessionFactory() throws Exception {
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(masterDataSource());
        sqlSessionFactoryBean.setConfigLocation(new ClassPathResource("mybatis-config.xml"));
        PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        Resource[] resources = resolver.getResources("classpath:mapper/*.xml");
        sqlSessionFactoryBean.setMapperLocations(resources);
        sqlSessionFactoryBean.setTypeAliasesPackage("com.xujiang.childbodyguard.domain.po");
        //分页插件 引入pageHelper-springboot-starter即可 不用做其他配置

        return sqlSessionFactoryBean.getObject();
    }

    @Bean
    public PlatformTransactionManager transactionManager() {
        return new DataSourceTransactionManager(masterDataSource());
    }
}

