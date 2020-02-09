# securitybysql
基于数据库认证安全
SET FOREIGN_KEY_CHECKS=0;在Mysql中取消外键约束

## 有的权限不起作用
   错误原因：1、数据库查询结果
			 2、 @Override
				//设置 security 权限，路径访问
				protected void configure(HttpSecurity http) throws Exception {
					http.authorizeRequests()
							//	检查下方路径是否有写错
							.antMatchers("/dba/**").hasRole("dba")
							.antMatchers("/admin/**").hasRole("admin")
							.antMatchers("/user/**").hasRole("user")
							.anyRequest().authenticated()
							.and()
							.formLogin()
							.permitAll()
							.and()
							.csrf().disable();
				}	
