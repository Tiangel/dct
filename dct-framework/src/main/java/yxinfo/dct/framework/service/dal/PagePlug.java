package yxinfo.dct.framework.service.dal;

import org.apache.ibatis.executor.parameter.ParameterHandler;
import org.apache.ibatis.executor.resultset.ResultSetHandler;
import org.apache.ibatis.executor.statement.StatementHandler;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.plugin.*;
import org.apache.ibatis.reflection.MetaObject;
import org.apache.ibatis.reflection.SystemMetaObject;
import org.apache.ibatis.scripting.defaults.DefaultParameterHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import yxinfo.dct.framework.service.dal.dao.AbstractModel;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

/**
 * Created by hanley on 2016/6/18.
 */
@Intercepts({
        @Signature(type = StatementHandler.class, method = "prepare", args = {Connection.class, Integer.class})
})
public class PagePlug implements Interceptor {

    Logger logger = LoggerFactory.getLogger(getClass().getName());

    public Object intercept(Invocation invocation) throws Throwable {

        // 拦截StatementHandler的prepare方法再组装sql语句
        if (invocation.getTarget() instanceof StatementHandler) {

            // 1.1~获取StatementHandler对象代理
            StatementHandler statementHandler = (StatementHandler) invocation.getTarget();
            MetaObject metaStatementHandler = SystemMetaObject.forObject(statementHandler);
            // 1.2.1~分离代理对象链
            while (metaStatementHandler.hasGetter("h")) {

                Object object = metaStatementHandler.getValue("h");
                metaStatementHandler = SystemMetaObject.forObject(object);
            }
            // 1.2.2~分离最后一个代理对象的目标类
            while (metaStatementHandler.hasGetter("target")) {

                Object object = metaStatementHandler.getValue("target");
                metaStatementHandler = SystemMetaObject.forObject(object);
            }

            // 1.3~获取BoundSql
            MappedStatement mappedStatement = (MappedStatement) metaStatementHandler.getValue("delegate.mappedStatement");
            BoundSql boundSql = (BoundSql) metaStatementHandler.getValue("delegate.boundSql");
            // 1.4~获取BoundSql绑定的对象
            Object paramObj = boundSql.getParameterObject();
            String sql = boundSql.getSql();

            if ( paramObj != null ) {

                if ( paramObj instanceof  AbstractModel ) {
                    getPage( paramObj, sql, metaStatementHandler, invocation, mappedStatement, boundSql );
                } else if ( paramObj instanceof Map ){

                    Set<Map.Entry> entrysSet = ((Map)paramObj).entrySet();

                    for ( Map.Entry entry : entrysSet ) {

                        Object model = entry.getValue();
                        if ( model instanceof AbstractModel) {
                            getPage( model, sql, metaStatementHandler, invocation, mappedStatement, boundSql );
                            break;

                        }

                    }

                }

            }

        }

        return invocation.proceed();
    }

    private void getPage( Object model, String sql,  MetaObject metaStatementHandler, Invocation invocation, MappedStatement mappedStatement, BoundSql boundSql) throws NoSuchFieldException, IllegalAccessException, InvocationTargetException {

        Field field = model.getClass().getDeclaredField("page");

        if ( field != null ) {
            field.setAccessible(true);
            Page page = (Page) field.get(model);

            if ( page != null ) {
                processPageing(page, sql, metaStatementHandler, invocation, mappedStatement, boundSql );
            }
        }

    }

    private Object processPageing( Page page, String sql, MetaObject metaStatementHandler, Invocation invocation, MappedStatement mappedStatement, BoundSql boundSql ) throws InvocationTargetException, IllegalAccessException {

        String pageSql = getPageSql( sql, page );

        metaStatementHandler.setValue( "delegate.boundSql.sql",  pageSql );

        // 1.6~设置分页总数
        Connection connection = (Connection) invocation.getArgs()[0];
        setPageTotal( sql, connection, mappedStatement, boundSql, page );

        return invocation.proceed();

    }

    /**
     * 组装分页sql语句(MySql)
     *
     * @param sql
     * @return
     */
    private String getPageSql( String sql, Page page ) {
        return new StringBuilder( sql ).append(" LIMIT ").append( page.getPageStart() ).append(" , ").append( page.getNumPerPage() ).toString();
    }

    /**
     * 设置分页总数(MySql)
     *
     * @param sql
     * @param connection
     * @param mappedStatement
     * @param boundSql
     */
    private void setPageTotal( String sql, Connection connection,
                               MappedStatement mappedStatement, BoundSql boundSql, Page page ) {

        logger.debug( "[分页插件] ==>       Getting Sql: {}", sql.replaceAll("\\s+", " ") );

        // 组装总数查询sql语句
        String vSql = "";
        int groupPos = sql.toUpperCase().indexOf("GROUP");

        if ( groupPos > 0 ) {
            vSql = "(" + sql + ") AS TMP";
        } else {
            int fromPos = sql.toUpperCase().indexOf("FROM");
            if ( fromPos > 0 ) {
                vSql = sql.substring( fromPos + 4 );
            }
        }

        String countSql = "SELECT COUNT(1) FROM " + vSql;

        logger.debug( "[分页插件] ==> Setting Total Sql: {}", countSql.replaceAll("\\s+", " ") );

        PreparedStatement countStmt = null;
        ResultSet rs = null;

        try {

            countStmt = connection.prepareStatement(countSql);
//            BoundSql countBS = new BoundSql(mappedStatement.getConfiguration(), countSql,
//                    boundSql.getParameterMappings(), boundSql.getParameterObject());

            ParameterHandler parameterHandler = new DefaultParameterHandler(mappedStatement, boundSql.getParameterObject(), boundSql);
            parameterHandler.setParameters(countStmt);

            rs = countStmt.executeQuery();
            int totalCount = 0;
            if ( rs.next() ) {

                totalCount = rs.getInt(1);
            }

            logger.debug( "[分页插件] <==         Get Total: {}", totalCount );
            page.setTotal(totalCount);

        } catch ( SQLException e ) {
            logger.error("SQLException:{}", e);
        } finally {

            try {

                if ( rs != null ) {
                    rs.close();
                }
                if ( countStmt != null ) {
                    countStmt.close();
                }

            } catch ( SQLException e ) {}
        }
    }

    /**
     * 封装原始对象
     *
     */
    public Object plugin( Object target ) {

        if (target instanceof StatementHandler || target instanceof ResultSetHandler) {

            return Plugin.wrap(target, this);
        } else {
            return target;
        }
    }

    public void setProperties(Properties properties) {}
}
