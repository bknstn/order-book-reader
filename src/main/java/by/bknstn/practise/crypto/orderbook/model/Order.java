package by.bknstn.practise.crypto.orderbook.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Order {

    private String side;

    private BigDecimal price;

    private BigDecimal quantity;
}
