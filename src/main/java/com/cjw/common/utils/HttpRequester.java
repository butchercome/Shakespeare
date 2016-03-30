package com.cjw.common.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Map;
import java.util.Vector;

/**
 * HTTP工具类
 * @author sfit0798
 *
 */
public class HttpRequester {
	private String defaultContentEncoding;
 
	public HttpRequester() {
		//this.defaultContentEncoding = Charset.defaultCharset().name();
		this.defaultContentEncoding = "utf-8";
	}
 
	/**
	 * 
	 * @param urlString
	 * @return
	 * @throws IOException
	 */
	public HttpRespons sendGet(String urlString) throws IOException {
		return this.send(urlString, "GET", null, null);
	}
 
	/**
	 * 
	 * @param urlString
	 * @param params
	 * @return
	 * @throws IOException
	 */
	public HttpRespons sendGet(String urlString, Map<String, String> params)
			throws IOException {
		return this.send(urlString, "GET", params, null);
	}
 
	/**
	 * 
	 * @param urlString
	 * @param params
	 * @param propertys
	 * @return
	 * @throws IOException
	 */
	public HttpRespons sendGet(String urlString, Map<String, String> params,
			Map<String, String> propertys) throws IOException {
		return this.send(urlString, "GET", params, propertys);
	}
 
	/**
	 * 
	 * @param urlString
	 * @return
	 * @throws IOException
	 */
	public HttpRespons sendPost(String urlString) throws IOException {
		return this.send(urlString, "POST", null, null);
	}
 
	/**
	 * 
	 * @param urlString
	 * @param params
	 * @return
	 * @throws IOException
	 */
	public HttpRespons sendPost(String urlString, Map<String, String> params)
			throws IOException {
		return this.send(urlString, "POST", params, null);
	}
 
	/**
	 * 
	 * @param urlString
	 * @param params
	 * @param propertys
	 * @return
	 * @throws IOException
	 */
	public HttpRespons sendPost(String urlString, Map<String, String> params,
			Map<String, String> propertys) throws IOException {
		return this.send(urlString, "POST", params, propertys);
	}
 
	/**
	 * 
	 * @param urlString
	 * @param method
	 * @param parameters
	 * @param propertys
	 * @return
	 * @throws IOException
	 */
	private HttpRespons send(String urlString, String method,
			Map<String, String> parameters, Map<String, String> propertys)
			throws IOException {
		HttpURLConnection urlConnection = null;
 
		if (method.equalsIgnoreCase("GET") && parameters != null) {
			StringBuffer param = new StringBuffer();
			int i = 0;
			for (String key : parameters.keySet()) {
				if (i == 0)
					param.append("?");
				else
					param.append("&");
				param.append(key).append("=").append(parameters.get(key));
				i++;
			}
			urlString += param;
		}
		URL url = new URL(urlString);
		urlConnection = (HttpURLConnection) url.openConnection();
 
		urlConnection.setRequestMethod(method);
		urlConnection.setDoOutput(true);
		urlConnection.setDoInput(true);
		urlConnection.setUseCaches(false);
		
		if (propertys != null)
			for (String key : propertys.keySet()) {
				urlConnection.addRequestProperty(key, propertys.get(key));
			}
 
		if (method.equalsIgnoreCase("POST") && parameters != null) {
			StringBuffer param = new StringBuffer();
			for (String key : parameters.keySet()) {
				param.append("&");
				param.append(key).append("=").append(parameters.get(key));
			}
			urlConnection.getOutputStream().write(param.toString().getBytes());
			urlConnection.getOutputStream().flush();
			urlConnection.getOutputStream().close();
		}
 
		return this.makeContent(urlString, urlConnection);
	}
 
	/**
	 * 
	 * @param urlString
	 * @param urlConnection
	 * @return
	 * @throws IOException
	 */
	private HttpRespons makeContent(String urlString,
			HttpURLConnection urlConnection) throws IOException {
		HttpRespons httpResponser = new HttpRespons();
		try {
			InputStream in = urlConnection.getInputStream();
			BufferedReader bufferedReader = new BufferedReader(
					new InputStreamReader(in));
			httpResponser.contentCollection = new Vector<String>();
			StringBuffer temp = new StringBuffer();
			String line = bufferedReader.readLine();
			while (line != null) {
				httpResponser.contentCollection.add(line);
				temp.append(line).append("\r\n");
				line = bufferedReader.readLine();
			}
			bufferedReader.close();
 
			String ecod = urlConnection.getContentEncoding();
			if (ecod == null)
				ecod = this.defaultContentEncoding;
 
			httpResponser.urlString = urlString;
 
			httpResponser.defaultPort = urlConnection.getURL().getDefaultPort();
			httpResponser.file = urlConnection.getURL().getFile();
			httpResponser.host = urlConnection.getURL().getHost();
			httpResponser.path = urlConnection.getURL().getPath();
			httpResponser.port = urlConnection.getURL().getPort();
			httpResponser.protocol = urlConnection.getURL().getProtocol();
			httpResponser.query = urlConnection.getURL().getQuery();
			httpResponser.ref = urlConnection.getURL().getRef();
			httpResponser.userInfo = urlConnection.getURL().getUserInfo();
 
			httpResponser.content = new String(temp.toString().getBytes(), ecod);
			httpResponser.contentEncoding = ecod;
			httpResponser.code = urlConnection.getResponseCode();
			httpResponser.message = urlConnection.getResponseMessage();
			httpResponser.contentType = urlConnection.getContentType();
			httpResponser.method = urlConnection.getRequestMethod();
			httpResponser.connectTimeout = urlConnection.getConnectTimeout();
			httpResponser.readTimeout = urlConnection.getReadTimeout();
 
			return httpResponser;
		} catch (IOException e) {
			throw e;
		} finally {
			if (urlConnection != null)
				urlConnection.disconnect();
		}
	}
 
	/**
	 * 
	 * @return
	 */
	public String getDefaultContentEncoding() {
		return this.defaultContentEncoding;
	}
 
	/**
	 * 
	 * @param defaultContentEncoding
	 */
	public void setDefaultContentEncoding(String defaultContentEncoding) {
		this.defaultContentEncoding = defaultContentEncoding;
	}
}
