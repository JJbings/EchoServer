//import com.sun.net.httpserver.Headers;
//import com.sun.net.httpserver.HttpExchange;
//import com.sun.net.httpserver.HttpHandler;
//import com.sun.net.httpserver.HttpPrincipal;
//
//import java.io.IOException;
//import java.io.OutputStream;
//import java.net.URI;
//
//public class MyHandler extends Thread implements HttpHandler {
//    @Override
//    public void handle(HttpExchange exchange) throws IOException {
//        System.out.println(exchange.getResponseHeaders().entrySet()+ "  ssdfdghdsfghjkgfdsahdfghjkfwiuefhuhf");
//        exchange.getResponseHeaders().add("Access-Control-Allow-Origin", "*");
//        exchange.getResponseHeaders().add("Access-Control-Allow-Methods", "GET,POST,PUT,DELETE,OPTIONS");
//        exchange.getResponseHeaders().add("Access-Control-Allow-Headers", "*");
//        exchange.getResponseHeaders().add("Access-Control-Allow-Credentials", "true");
//        exchange.getResponseHeaders().add("Access-Control-Allow-Credentials-Header", "*");
//
//        System.out.println(exchange.getResponseHeaders().entrySet()+ "  ssdfdghdsfghjkgfdsahdfghjkfwiuefhuhf");
//        URI requestURI = exchange.getRequestURI();
//        printRequestInfo(exchange);
//        String response = "ik kan hier zetten wat ik wil ";
//        exchange.sendResponseHeaders(200, response.getBytes().length);
//
//
//        OutputStream os = exchange.getResponseBody();
//
//        os.write(response.getBytes());
//        os.close();
//    }
//
//    private static void printRequestInfo(HttpExchange exchange) {
//
//
//        System.out.println("-- headers --");
//        Headers requestHeaders = exchange.getRequestHeaders();
//        requestHeaders.entrySet().forEach(System.out::println);
//
//        System.out.println("-- principle --");
//        HttpPrincipal principal = exchange.getPrincipal();
//        System.out.println(principal);
//
//        System.out.println("-- HTTP method --");
//        String requestMethod = exchange.getRequestMethod();
//        System.out.println(requestMethod);
//
//        System.out.println("-- query --");
//        URI requestURI = exchange.getRequestURI();
//        String query = requestURI.getQuery();
//        System.out.println(query);
//    }
//}