package com.tipo.witter;

import org.jasypt.encryption.StringEncryptor;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
//@PropertySource("classpath:properties/admin.properties")
public class WitterApplicationTests {
	@Autowired
	private StringEncryptor encryptor;
	@Value("${spring.datasource.url}")
	private String url;
	@Value("${admin.user}")
	private String user;
	@Value("${admin.pass}")
	private String pass;


	@Test
	public void contextLoads() {
		String url=encryptor.encrypt("jdbc:sqlserver://10.16.78.26:4433;sendStringParametersAsUnicode=true");
		String name=encryptor.encrypt("intern_test");
		String pass=encryptor.encrypt("123456");
		System.out.printf(url+"-----------");
		System.out.println(name+"-----------");
		System.out.println(pass+"------------");
	}
	@Test
	public void get(){
		System.out.println(url);
		System.out.println(encryptor.decrypt(pass));
		System.out.println(user);
	}
	@Test
	public void enAdmin(){
		String user=encryptor.encrypt("boss_pi");
		String pass=encryptor.encrypt("tiposec!@#123");
		System.out.println(user+"-------");
		System.out.println(pass+"-------");
	}

}
