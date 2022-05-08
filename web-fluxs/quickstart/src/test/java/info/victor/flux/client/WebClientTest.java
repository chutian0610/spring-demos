package info.victor.flux.client;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.client.WebClient;

public class WebClientTest {
    private static WebClient client;

    @BeforeAll
    public static void start() {
        client = WebClient.create("http://localhost:8080");
    }

    @Test
    public void testHello() {
        String result = client.get().uri("/v1/hello").accept(MediaType.APPLICATION_JSON).retrieve().bodyToMono(String.class).block();
        System.out.println(result);
    }

}
