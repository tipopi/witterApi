package com.tipo.witter.config;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;

/**
 * @author Tipo
 * @version 1.0
 * @date 2019/12/29 14:23
 */
@Configuration
@MapperScan(basePackages = "com.tipo.witter.mapper", sqlSessionTemplateRef = "sqlServerSqlSessionTemplate")
public class SqlServerConfig {
    /**
     * 生成数据源.  @Primary 注解声明为默认数据源
     */
    @Bean(name = "sqlServerDataSource")
    @ConfigurationProperties(prefix = "spring.datasource.secondary")
    public DataSource testDataSource() {
        return DataSourceBuilder.create().build();
    }

    /**
     * 创建 SqlSessionFactory
     */
    @Bean(name = "sqlServerSqlSessionFactory")
    public SqlSessionFactory testSqlSessionFactory(@Qualifier("sqlServerDataSource") DataSource dataSource) throws Exception {
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(dataSource);
          bean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath:mapper/*"));
        return bean.getObject();
    }

    /**
     * 配置事务管理
     */
    @Bean(name = "sqlServerTransactionManager")
    public DataSourceTransactionManager testTransactionManager(@Qualifier("sqlServerDataSource") DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }

    @Bean(name = "sqlServerSqlSessionTemplate")
    public SqlSessionTemplate testSqlSessionTemplate(@Qualifier("sqlServerSqlSessionFactory") SqlSessionFactory sqlSessionFactory) throws Exception {
        return new SqlSessionTemplate(sqlSessionFactory);
    }

}
