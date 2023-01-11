package by.bknstn.practise.crypto.orderbook.reader;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class WebSocketRequest {

    private String type;

    private String channel;

    private Integer interval;

    @JsonProperty("market_id")
    private String marketId;

    private List<String> filter;
}
