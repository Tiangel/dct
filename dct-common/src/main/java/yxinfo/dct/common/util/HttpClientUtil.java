package yxinfo.dct.common.util;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.mime.MultipartEntity;
import org.apache.http.entity.mime.content.FileBody;
import org.apache.http.entity.mime.content.StringBody;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

import java.io.File;
import java.io.IOException;
import java.util.Map;

/**
 * Created by dy on 2016/7/20.
 */
public class HttpClientUtil {

    /**
     * 文件上传
     * @param url 请求地址
     * @param paths 文件路径
     * @param params POST参数
     * @return
     * @throws IOException
     */
    public static String uploadByFilePath(
            String url, Map<String, String> paths, Map<String, String> params ) throws IOException {
        String retMsg = null;
        HttpClient httpclient = new DefaultHttpClient();
        HttpEntity resEntity = null;
        try {
            HttpPost httppost = new HttpPost( url );
            MultipartEntity reqEntity = new MultipartEntity();
            if ( params != null && params.size() > 0 ) {
                for ( String key : params.keySet() ) {
                    reqEntity.addPart( key, new StringBody( params.get( key ) ) );
                }
            }
            if ( paths != null && paths.size() > 0 ) {
                for ( String key : paths.keySet() ) {
                    File file =  new File( paths.get( key ) );
                    if ( file.exists() ) {
                        reqEntity.addPart( key, new FileBody( file ) );
                    }


                }
            }
            // ~POST请求
            httppost.setEntity( reqEntity );
            HttpResponse response = httpclient.execute( httppost );
            // ~读取响应
            resEntity = response.getEntity();
            retMsg = EntityUtils.toString( resEntity );
            return retMsg;
        } finally {
            try {
                if ( httpclient != null ) httpclient.getConnectionManager().shutdown();
                if ( resEntity != null ) EntityUtils.consume( resEntity );
            } catch ( Exception ignore ) {}
        }
    }

}
