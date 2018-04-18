package yxinfo.dct.service.base.util;

import yxinfo.dct.inteface.dto.base.MemberDTO;

import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;

/**
 * 构建setter
 *
 * @author dy
 */
public class BuildSetter {

    public static void buildSetter( Object obj, String retBeanName, String daoBeanName ) {

        try {

            BeanInfo beanInfo = Introspector.getBeanInfo(obj.getClass());
            @SuppressWarnings("unused")
            PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();

            for ( PropertyDescriptor property : propertyDescriptors ) {

                String key = property.getName();

                if ( !key.equals("class") ) {

                    key = key.substring( 0, 1 ).toUpperCase() + key.substring( 1, key.length() );
                    String str = retBeanName + ".set" + key + "( " + daoBeanName + ".get" + key +"() );";
                    System.out.println( str );
                }
            }

        } catch ( Exception e ) {

            System.out.println( "Error:" + e.getMessage() );
        }
    }

    public static void main( String[] args ) {
        buildSetter( new MemberDTO(), "addMember", "sysMbrInput" );
    }

}
