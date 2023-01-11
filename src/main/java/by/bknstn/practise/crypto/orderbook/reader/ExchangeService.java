package by.bknstn.practise.crypto.orderbook.reader;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;

import java.util.List;

@Component
public class ExchangeService {
    @Scheduled(fixedDelay = 600000l)
    @SneakyThrows
    public void test() {
        WebSocketClient wsSimpleClient = new WebSocketClient();

        WebSocketRequest request = WebSocketRequest
                .builder()
                .interval(500)
                .filter(List.of("ticker", "order_books"))
                .type("subscribe")
                .channel("marketdata")
                .marketId("BTC-USDT")
                .build();
        String requestString = new ObjectMapper()
                .writeValueAsString(request);
        WebSocketSession clientSession = wsSimpleClient.getClientSession();
        clientSession.setTextMessageSizeLimit(5000000);
        clientSession.sendMessage(new TextMessage(requestString));
    }
}
