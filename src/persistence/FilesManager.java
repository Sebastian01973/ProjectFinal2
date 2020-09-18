package persistence;

import java.io.IOException;
import java.io.InputStream;
import java.net.ConnectException;
import java.net.HttpURLConnection;
import java.net.InetSocketAddress;
import java.net.MalformedURLException;
import java.net.Proxy;
import java.net.URL;
import java.net.UnknownHostException;

public class FilesManager {
	
	public static InputStream getInputStream(boolean isProxy, String filePath) {
		HttpURLConnection httpURLConnection;
		URL url = null;
		InputStream inputStream = null;
		try {
			url = new URL( filePath );
			if ( !isProxy ) {
				System.out.println("Sin proxy");
				httpURLConnection = (HttpURLConnection) url.openConnection();	
				inputStream = httpURLConnection.getInputStream();
			}else {
				System.out.println("Con proxy");
				Proxy proxy = new Proxy(Proxy.Type.HTTP, new InetSocketAddress("0.0.0.0", 8080));
				httpURLConnection = (HttpURLConnection) url.openConnection(proxy);
				inputStream = httpURLConnection.getInputStream();
			}
		}catch(ConnectException connectException) {
			isProxy = true;
			return getInputStream( isProxy, filePath );
		} catch (UnknownHostException e) {
			isProxy = true;
			return getInputStream( isProxy, filePath );
		} catch (MalformedURLException e1) {
			e1.printStackTrace();
		}catch (IOException e) {
			e.printStackTrace();
		}
		return inputStream;
	}
}
