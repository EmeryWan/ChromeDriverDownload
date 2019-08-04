package pers.emery.util;

public class Socks5Proxy {

//    private static final InetSocketAddress SOCKS_ADDRESS = new InetSocketAddress("127.0.0.1", 1080);
//    private static final String USER_NAME = "";
//    private static final String PASSWORD = "";
//
//
//    /**
//     * 得到一个已经配置好了连接池的HttpClient
//     **/
//    public static CloseableHttpClient getProxyClient() {
//        //如果有用户名和密码可以设置验证
//        Authenticator.setDefault(new Authenticator() {
//            @Override
//            protected PasswordAuthentication getPasswordAuthentication() {
//                return new PasswordAuthentication(USER_NAME, PASSWORD.toCharArray());
//            }
//        });
//        //注册连接方式
//        Registry<ConnectionSocketFactory> registry = RegistryBuilder.<ConnectionSocketFactory>create().
//                register("http", new MyConnectionSocketFactory()).
//                register("https", new MySslConnectionSocketFactory(SSLContexts.createSystemDefault())).build();
//        //建立连接池
//        PoolingHttpClientConnectionManager poolingHttpClientConnectionManager = new PoolingHttpClientConnectionManager(registry, new FakeDnsResolver());
//        //设置默认请求头
//        Header header = new BasicHeader(HttpHeaders.USER_AGENT, "Mozilla/5.0 (X11; Linux x86_64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/72.0.3626.96 Safari/537.36");
//        List<Header> headers = Lists.newArrayList(header);
//        return HttpClients.custom().
//                setDefaultHeaders(headers).
//                setConnectionManager(poolingHttpClientConnectionManager).build();
//    }
//
//    /**
//     * 得到返回结果的字符串
//     *
//     * @param url     链接
//     * @param headers 请求头
//     **/
//    public static String getContent(String url, Map<String, String> headers) {
//        String content = null;
//        try (CloseableHttpClient closeableHttpClient = getProxyClient()) {
//            HttpGet httpGet = new HttpGet(url);
//            if (headers != null) {
//                for (String key : headers.keySet()
//                ) {
//                    httpGet.setHeader(key, headers.get(key));
//                }
//            }
//            try (CloseableHttpResponse response = closeableHttpClient.execute(httpGet)) {
//                content = new String(EntityUtils.toByteArray(response.getEntity()), StandardCharsets.UTF_8);
//            } catch
//            (IOException e) {
//                e.printStackTrace();
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        return content;
//    }
//
//    /**
//     * dns解析
//     **/
//    static class FakeDnsResolver implements DnsResolver {
//        @Override
//        public InetAddress[] resolve(String host) throws UnknownHostException {
//            // Return some fake DNS record for every request, we won't be using it
//            return new InetAddress[]{InetAddress.getByAddress(new byte[]{1, 1, 1, 1})};
//        }
//    }
//
//    static class MyConnectionSocketFactory extends PlainConnectionSocketFactory {
//        @Override
//        public Socket createSocket(HttpContext context) {
//            Proxy proxy = new Proxy(Proxy.Type.SOCKS, SOCKS_ADDRESS);
//            return new Socket(proxy);
//        }
//
//        @Override
//        public Socket connectSocket(int connectTimeout, Socket socket, HttpHost host, InetSocketAddress remoteAddress,
//                                    InetSocketAddress localAddress, HttpContext context) throws IOException {
//            // Convert address to unresolved
//            InetSocketAddress unresolvedRemote = InetSocketAddress
//                    .createUnresolved(host.getHostName(), remoteAddress.getPort());
//            return super.connectSocket(connectTimeout, socket, host, unresolvedRemote, localAddress, context);
//        }
//    }
//
//    private static class MySslConnectionSocketFactory extends SSLConnectionSocketFactory {
//        MySslConnectionSocketFactory(SSLContext sslContext) {
//            // You may need this verifier if target site's certificate is not secure
//            super(sslContext);
//        }
//
//        @Override
//        public Socket createSocket(HttpContext context) {
//            Proxy proxy = new Proxy(Proxy.Type.SOCKS, SOCKS_ADDRESS);
//            return new Socket(proxy);
//        }
//
//        @Override
//        public Socket connectSocket(int connectTimeout, Socket socket, HttpHost host, InetSocketAddress remoteAddress, InetSocketAddress localAddress, HttpContext context) throws IOException {
//            // Convert address to unresolved
//            InetSocketAddress unresolvedRemote = InetSocketAddress
//                    .createUnresolved(host.getHostName(), remoteAddress.getPort());
//            return super.connectSocket(connectTimeout, socket, host, unresolvedRemote, localAddress, context);
//        }
//    }

}
