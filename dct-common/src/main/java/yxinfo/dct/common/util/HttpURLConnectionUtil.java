package yxinfo.dct.common.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;

import java.io.*;
import java.net.URL;
import java.net.URLConnection;

/**
 * Https URLConnection Util
 *
 * @author dy
 */
public class HttpURLConnectionUtil {

    /**
     * GET请求
     *
     * @param url
     * @param data
     * @return
     * @throws Exception
     */
    public static String get( String url, String data, String encode ) throws Exception {

        if ( StringUtils.isEmpty( url ) ) return "";
        String getUrlStr = new StringBuffer( url ).append( "?" ).append( data ).toString();
        log.info( "send get, url: {}", getUrlStr );
        URL getUrl = new URL( getUrlStr );

        URLConnection conn = getUrl.openConnection();
        conn.setDoOutput(true);
        conn.connect();

        PrintWriter out = null;
        BufferedReader reader = null;
        try {
            out = new PrintWriter( conn.getOutputStream() );
            out.print( data );
            out.flush();

            reader = new BufferedReader( new InputStreamReader( conn.getInputStream(), encode ) );
            String line = null;
            StringBuffer ret = new StringBuffer();
            while ( ( line = reader.readLine() ) != null ) {
                ret.append( line );
            }
            return ret.toString();
        } finally {
            if ( out != null ) out.close();
            if ( reader != null ) reader.close();
        }
    }

    private static final Logger log = LoggerFactory.getLogger( HttpURLConnectionUtil.class );

}  