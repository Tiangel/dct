package yxinfo.dct.framework.service.dal;

import org.apache.ibatis.executor.Executor;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.mapping.SqlCommandType;
import org.apache.ibatis.plugin.*;

import java.lang.reflect.Field;
import java.util.Date;
import java.util.Properties;

/**
 * Created by hanley on 2016/6/22.
 */
@Intercepts({
        @Signature(type = Executor.class, method = "update", args = {MappedStatement.class, Object.class})
})
public class CreateAtPlug implements Interceptor {


    public Object intercept(Invocation invocation) throws Throwable {

        MappedStatement mappedStatement = (MappedStatement) invocation.getArgs()[0];

        if (mappedStatement.getSqlCommandType() == SqlCommandType.INSERT ) {

            Object param = invocation.getArgs()[1];

            if ( param != null ) {

                try {

                    Field createAt = param.getClass().getDeclaredField("createAt");
                    createAt.setAccessible(true);

                    Object val = createAt.get(param);
                    if ( val == null ) {
                        createAt.set(param, new Date());
                    }


                } catch (NoSuchFieldException e) {}

            }

        }

        return invocation.proceed();
    }

    public Object plugin(Object o) {

        if ( o instanceof Executor ) {
            return Plugin.wrap(o, this);
        }
        return o;
    }

    public void setProperties(Properties properties) {}

    public static void main( String[] args ) {
        System.out.println(Integer.MAX_VALUE);
    }
}
