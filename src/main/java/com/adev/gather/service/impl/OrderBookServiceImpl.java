package com.adev.gather.service.impl;

import com.adev.common.base.service.impl.BaseServiceImpl;
import com.adev.gather.domain.PairOrderBook;
import com.adev.gather.domain.PairTicker;
import com.adev.gather.repository.OrderBookRepository;
import com.adev.gather.repository.TickerRepository;
import com.adev.gather.service.OrderBookService;
import com.adev.gather.service.TickerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderBookServiceImpl extends BaseServiceImpl<PairOrderBook, String> implements OrderBookService {

    @Autowired
    private OrderBookRepository orderBookRepository;

    @Override
    public PairOrderBook findByExchangeAndPairName(String exchange, String pairName) {
        String id=exchange+":"+pairName;
        return orderBookRepository.findById(id).orElse(null);
    }
}
