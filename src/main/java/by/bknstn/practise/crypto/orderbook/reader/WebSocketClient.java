package by.bknstn.practise.crypto.orderbook.reader;

import by.bknstn.practise.crypto.orderbook.model.MarketData;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import lombok.var;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketHttpHeaders;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.client.standard.StandardWebSocketClient;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import java.net.URI;
@Slf4j
public class WebSocketClient extends TextWebSocketHandler {

    private final ObjectMapper objectMapper;
    private final WebSocketSession clientSession;

    @SneakyThrows
    public WebSocketClient() {
        var webSocketClient = new StandardWebSocketClient();
        this.clientSession = webSocketClient.doHandshake(this, new WebSocketHttpHeaders(),
                URI.create("wss://api.probit.com/api/exchange/v1/ws")
        ).get();
        this.objectMapper = new ObjectMapper();
    }

    @Override
    protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
        MarketData marketData = objectMapper.readValue(message.getPayload(),
                MarketData.class);
        log.info("{}", marketData);
    }

    public WebSocketSession getClientSession() {
        return clientSession;
    }

}
