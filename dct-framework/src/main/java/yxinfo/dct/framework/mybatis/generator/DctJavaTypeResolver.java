package yxinfo.dct.framework.mybatis.generator;

import org.mybatis.generator.api.IntrospectedColumn;
import org.mybatis.generator.api.dom.java.FullyQualifiedJavaType;
import org.mybatis.generator.internal.types.JavaTypeResolverDefaultImpl;

import java.math.BigDecimal;
import java.sql.Types;

/**
 * Created by dy on 2016/7/28.
 */
public class DctJavaTypeResolver extends JavaTypeResolverDefaultImpl {

    public FullyQualifiedJavaType calculateJavaType( IntrospectedColumn introspectedColumn ) {

        FullyQualifiedJavaType answer;
        JdbcTypeInformation jdbcTypeInformation = typeMap.get( introspectedColumn.getJdbcType() );

        if ( jdbcTypeInformation == null ) {
            switch ( introspectedColumn.getJdbcType() ) {
                case Types.DECIMAL:
                case Types.NUMERIC:
                    if ( introspectedColumn.getScale() > 0 || introspectedColumn.getLength() > 18 || forceBigDecimals ) {
                        answer = new FullyQualifiedJavaType( BigDecimal.class.getName() );
                    } else if ( introspectedColumn.getLength() > 9 ) {
                        answer = new FullyQualifiedJavaType( Long.class.getName() );
                    } else if ( introspectedColumn.getLength() > 4 ) {
                        answer = new FullyQualifiedJavaType( Integer.class.getName() );
                    } else {
                        answer = new FullyQualifiedJavaType( Short.class.getName() );
                    }
                    break;
                default:
                    answer = null;
                    break;
            }
        } else {
            switch ( introspectedColumn.getJdbcType() ) {
                // ~自定义扩展
                case Types.TINYINT:
                    answer = new FullyQualifiedJavaType( Short.class.getName() );
                    break;
                default:
                    answer = jdbcTypeInformation.getFullyQualifiedJavaType();
                    break;
            }
        }
        return answer;
    }
}
