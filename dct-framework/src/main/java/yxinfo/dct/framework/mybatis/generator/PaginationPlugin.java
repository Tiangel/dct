package yxinfo.dct.framework.mybatis.generator;

import org.mybatis.generator.api.CommentGenerator;
import org.mybatis.generator.api.IntrospectedTable;
import org.mybatis.generator.api.PluginAdapter;
import org.mybatis.generator.api.dom.java.*;

import java.util.List;

/**
 * Created by hanley on 2016/6/18.
 */
public class PaginationPlugin extends PluginAdapter {


    @Override
    public boolean modelExampleClassGenerated(TopLevelClass topLevelClass,  IntrospectedTable introspectedTable) { // add field, getter, setter
        addPage(topLevelClass, introspectedTable, "page");
        return super.modelExampleClassGenerated(topLevelClass, introspectedTable);
    }

    private void addPage(TopLevelClass topLevelClass, IntrospectedTable introspectedTable, String name) {

        topLevelClass.addImportedType(new FullyQualifiedJavaType("yxinfo.dct.framework.service.dal.Page"));
        topLevelClass.addImportedType(new FullyQualifiedJavaType("yxinfo.dct.framework.service.dal.dao.AbstractModel"));

        topLevelClass.setSuperClass( "AbstractModel");

        CommentGenerator commentGenerator = context.getCommentGenerator();



        Field field = new Field();
        field.setVisibility(JavaVisibility.PROTECTED);
        field.setType(new FullyQualifiedJavaType("yxinfo.dct.framework.service.dal.Page"));
        field.setName(name);
        commentGenerator.addFieldComment(field, introspectedTable);
        topLevelClass.addField(field);
        char c = name.charAt(0);
        String camel = Character.toUpperCase(c) + name.substring(1);
        Method method = new Method();
        method.setVisibility(JavaVisibility.PUBLIC);
        method.setName("set" + camel);
        method.addParameter(new Parameter(new FullyQualifiedJavaType("yxinfo.dct.framework.service.dal.Page"), name));
        method.addBodyLine("this." + name + "=" + name + ";");
        commentGenerator.addGeneralMethodComment(method, introspectedTable);
        topLevelClass.addMethod(method);
        method = new Method();
        method.setVisibility(JavaVisibility.PUBLIC);
        method.setReturnType(new FullyQualifiedJavaType("yxinfo.dct.framework.service.dal.Page"));
        method.setName("get" + camel);
        method.addBodyLine("return " + name + ";");
        commentGenerator.addGeneralMethodComment(method, introspectedTable);
        topLevelClass.addMethod(method);
    }

    public boolean validate(List<String> list) {
        return true;
    }
}
