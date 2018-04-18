package yxinfo.dct.framework.mybatis.generator;

import org.mybatis.generator.api.IntrospectedTable;
import org.mybatis.generator.api.PluginAdapter;
import org.mybatis.generator.api.dom.xml.Attribute;
import org.mybatis.generator.api.dom.xml.XmlElement;

import java.util.List;

/**
 * Created by hanley on 2016/6/21.
 */
public class InsertResultKeyPlugin extends PluginAdapter {


    @Override
    public boolean sqlMapInsertSelectiveElementGenerated(XmlElement element, IntrospectedTable introspectedTable) {
        element.addAttribute(new Attribute("useGeneratedKeys", "true"));
        element.addAttribute( new Attribute("keyProperty", "id"));
        return super.sqlMapInsertSelectiveElementGenerated(element, introspectedTable);
    }

    @Override
    public boolean sqlMapInsertElementGenerated(XmlElement element, IntrospectedTable introspectedTable) {
        element.addAttribute(new Attribute("useGeneratedKeys", "true"));
        element.addAttribute( new Attribute("keyProperty", "id"));
        return super.sqlMapInsertElementGenerated(element, introspectedTable);
    }

    public boolean validate(List<String> list) {
        return true;
    }
}
