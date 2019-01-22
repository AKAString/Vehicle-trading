package com.qr.xxpt.factroy;

import java.sql.Connection;

import java.util.Properties;


import org.apache.ibatis.executor.statement.StatementHandler;
import org.apache.ibatis.mapping.BoundSql;

import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.plugin.Intercepts;
import org.apache.ibatis.plugin.Invocation;
import org.apache.ibatis.plugin.Plugin;
import org.apache.ibatis.plugin.Signature;
import org.apache.ibatis.reflection.MetaObject;
import org.apache.ibatis.reflection.SystemMetaObject;

import com.qr.xxpt.entity.BaseEntity;
//StatementHandler中有一prepare(Connection,transactiontimeout)  executor  R




@Intercepts({@Signature(type = StatementHandler.class, method = "prepare", args = { Connection.class,Integer.class }) })
public class PageInterceptor implements Interceptor {
	// 插件运行的代码，它将代替原有的方法
	
	public Object intercept(Invocation invocation) throws Throwable {
		//获取目标对象
		StatementHandler statementHandler = (StatementHandler) invocation.getTarget();
		
		MetaObject metaStatementHandler = SystemMetaObject.forObject(statementHandler);
		
		BoundSql boundSql = (BoundSql) metaStatementHandler.getValue("delegate.boundSql");
		// 分页参数作为参数对象parameterObject的一个属性
		String sql = boundSql.getSql();
		System.out.println(sql);
		System.out.println("sql=========");
	if (boundSql.getParameterObject()instanceof BaseEntity) {
			
		BaseEntity co = (BaseEntity) (boundSql.getParameterObject());
		if(co!=null)
		if(co.isPage())
		{			
			int startRow=(co.getPageNum()-1)*co.getPerRow();
			int endPow=startRow+co.getPerRow();
			String mysql=sql+" limit "+startRow+","+endPow;	
			System.out.println(mysql);
			metaStatementHandler.setValue("delegate.boundSql.sql", mysql); 
		}
	}
		return invocation.proceed();
	}

	// 拦截类型StatementHandler

	public Object plugin(Object target) {
		if (target instanceof StatementHandler) {
			//创建 代理对象
			return Plugin.wrap(target, this);
		} else {
			return target;
		}
	}


	public void setProperties(Properties properties) {
	}

	/**
	 * 硬编码
	 * @param sql
	 * @return
	 */
	public String returnSql(String sql)
	{
		StringBuffer strB=new StringBuffer(sql);
		strB.insert(6, " rownum rr,");
		return strB.toString();
	}
	

	
}