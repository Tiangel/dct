package yxinfo.dct.framework.mybatis.generator;

import org.mybatis.generator.api.IntrospectedColumn;
import org.mybatis.generator.api.IntrospectedTable;
import org.mybatis.generator.api.dom.java.Field;
import org.mybatis.generator.internal.DefaultCommentGenerator;

/**
 * Created by hanley on 2016/6/17.
 */
public class DctCommentGenerator extends DefaultCommentGenerator {


    @Override
    public void addFieldComment(Field field, IntrospectedTable introspectedTable, IntrospectedColumn introspectedColumn) {

        // 添加字段注释
        String remark = introspectedColumn.getRemarks();
        if ( remark != null && !"".equals(remark))
        {
            field.addJavaDocLine("//" + remark);
        }


    }

}
