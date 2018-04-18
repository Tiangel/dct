package yxinfo.dct.common.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * HttpURLConnection工具
 * Created by dy on 2016/7/21.
 */
public class HttpURLHelper {

    private String urlStr;
    private URL url;
    private HttpURLConnection con;
    private String boundary;
    private String encode = "UTF-8";
    private DataOutputStream ds;

    private static String BOUNDARY_PREFIX = "----";
    private static String TWO_HYPHEN = "--";
    private static String NEW_LINE = "\r\n";

    public HttpURLHelper(String url ) {
        urlStr = url;
    }

    /**
     * 设置URL
     * @param url
     */
    public void setUrl( String url ) {
        urlStr = url;
        url = null;
        con = null;
        release();
    }

    /**
     * 释放资源
     */
    public void release() {
        if ( ds != null ) {
            try { ds.close(); } catch ( Exception e ) {}
        };
    }

    /**
     * 准备GET请求
     * @throws Exception
     */
    public void prepareGet() throws Exception {
        url = new URL( urlStr );
        con = (HttpURLConnection) url.openConnection();
        setConGet();
    }

    /**
     * 准备POST请求
     * @throws Exception
     */
    public void preparePost() throws Exception {
        url = new URL( urlStr );
        con = (HttpURLConnection) url.openConnection();
        setConPost();
        ds = new DataOutputStream( con.getOutputStream() );
    }

    /**
     * 准备文件上传
     * @throws Exception
     */
    public void prepareUpload() throws Exception {
        url = new URL( urlStr );
        con = (HttpURLConnection) url.openConnection();
        boundary = BOUNDARY_PREFIX + System.currentTimeMillis();
        setConPost();
        con.setRequestProperty( "Content-Type", "multipart/form-data; boundary=" + boundary );
        ds = new DataOutputStream( con.getOutputStream() );
    }

    /**
     * 设置POST请求body
     * @param body
     */
    public void setPostBody( String body ) throws Exception {
        if ( ds == null ) {
            log.warn( "Upload not prepared" );
            return;
        }
        ds.writeBytes( body );
    }

    /**
     * 设置文件上传表单text
     * @param key
     * @param value
     */
    public void setUploadText( String key, String value ) throws Exception {
        if ( ds == null ) {
            log.warn( "Upload not prepared" );
            return;
        }
        ds.writeBytes( TWO_HYPHEN + boundary + NEW_LINE );
        ds.writeBytes( new StringBuffer( "Content-Disposition: form-data; name=\"" ).append( key ).append( "\"" )
                .append( NEW_LINE ).toString() );
        ds.writeBytes( NEW_LINE );
        ds.writeBytes( value );
        ds.writeBytes( NEW_LINE );
    }

    /**
     * 设置文件上传文件
     * @param key
     * @param fileName
     * @param file
     */
    public void setUploadFile( String key, String fileName, File file ) throws Exception {
        if ( ds == null ) {
            log.warn( "Upload not prepared" );
            return;
        }
        if ( file == null || !file.exists() ) {
            log.warn( "File not exists" );
            return;
        }
        FileInputStream in = null;
        ByteArrayOutputStream out = null;
        try {
            in = new FileInputStream( file );
            out = new ByteArrayOutputStream();
            byte[] b = new byte[1024];
            int n;
            while ( ( n = in.read( b ) ) != -1 ) {
                out.write( b, 0, n );
            }
        } catch ( Exception e ) {
            log.error( "Read file error, {}", e.getMessage(), e );
            return;
        } finally {
            if ( in != null ) {
                try { in.close(); } catch ( Exception e ){}
            }
            if ( out != null ) {
                try { out.close(); } catch ( Exception e ){}
            }
        }
        if ( out == null ) return;
        ds.writeBytes( TWO_HYPHEN + boundary + NEW_LINE );
        ds.writeBytes( new StringBuffer( "Content-Disposition: form-data; name=\"" ).append( key ).append( "\"" )
                .append( "; filename=\"" ).append( fileName ).append( "\"" )
                .append( NEW_LINE ).toString() );
        ds.writeBytes( "Content-Type: " + "application/octet-stream" + "\r\n" );
        ds.writeBytes( NEW_LINE );
        ds.write( out.toByteArray() );
        ds.writeBytes( NEW_LINE );
    }

    /**
     * 设置GET连接
     * @throws Exception
     */
    private void setConGet() throws Exception {
        if ( con == null ) {
            log.warn( "Connection not init" );
            return;
        }
        con.setDoOutput( true );
        con.setUseCaches( false );
        con.setRequestMethod( "GET" );
        con.setRequestProperty( "Charset", encode );
    }

    /**
     * 设置POST连接
     * @throws Exception
     */
    private void setConPost() throws Exception {
        if ( con == null ) {
            log.warn( "Connection not init" );
            return;
        }
        con.setDoInput( true );
        con.setDoOutput( true );
        con.setUseCaches( false );
        con.setRequestMethod( "POST" );
        con.setRequestProperty( "Connection", "Keep-Alive" );
        con.setRequestProperty( "Charset", encode );
    }

    /**
     * 上传文件
     * @return
     * @throws Exception
     */
    public String upload() throws Exception {
        if ( con == null ) {
            log.warn( "Connection not init" );
            return null;
        }
        if ( ds == null ) {
            log.warn( "Upload not prepared" );
            return null;
        }
        try {
            ds.writeBytes( TWO_HYPHEN + boundary + TWO_HYPHEN );
            return readReturn();
        } finally {
            release();
        }
    }

    /**
     * POST请求
     * @return
     * @throws Exception
     */
    public String post() throws Exception {
        if ( con == null ) {
            log.warn( "Connection not init" );
            return null;
        }
        if ( ds == null ) {
            log.warn( "Upload not prepared" );
            return null;
        }
        try {
            ds.flush();
            return readReturn();
        } finally {
            release();
        }
    }

    /**
     * 读取返回
     * @return
     * @throws Exception
     */
    private String readReturn() throws Exception {
        InputStream is = null;
        BufferedReader in = null;
        StringBuffer result = new StringBuffer();
        try {
            // ~读取返回数据
            is = con.getInputStream();
            in = new BufferedReader( new InputStreamReader( con.getInputStream() ) );
            String line;
            while ( ( line = in.readLine() ) != null ) {
                result.append( line );
            }
            return result.toString();
        } finally {
            if ( is != null ) {
                try { is.close(); } catch ( IOException e ) {}
            }
            if ( in != null ) {
                try { in.close(); } catch ( IOException e ) {}
            }
        }
    }

    private static final Logger log = LoggerFactory.getLogger( HttpURLHelper.class );
}
