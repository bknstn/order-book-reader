package by.bknstn.practise.crypto.orderbook.model;

import java.util.*;
import java.util.concurrent.PriorityBlockingQueue;

public class OrderBook {

    private Map<Double, List<Order>> bidMap;
    private Map<Double, List<Order>> sellMap;

    private Queue<Double> bidMaxPriceList;
    private Queue<Double> sellMinPriceList;

    public OrderBook() {
        bidMap = new HashMap<Double, List<Order>>();
        sellMap = new HashMap<Double, List<Order>>();

        bidMaxPriceList = new PriorityBlockingQueue<Double>(100, Collections.reverseOrder());
        sellMinPriceList = new PriorityBlockingQueue <Double>();
    }
}
