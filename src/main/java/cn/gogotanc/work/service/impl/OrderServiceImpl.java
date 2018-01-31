package cn.gogotanc.work.service.impl;

import cn.gogotanc.work.entity.Order;
import cn.gogotanc.work.service.OrderService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author tanc
 */
@Service
public class OrderServiceImpl implements OrderService {

    @Override
    public int add(Order order) {
        return 0;
    }

    @Override
    public List<Order> getAll() {
        return null;
    }
}
