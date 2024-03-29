package com.shop.service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.shop.dto.ShopDTO;
import com.shop.frame.MyMapper;
import com.shop.frame.MyService;
import com.shop.mapper.ShopMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShopService implements MyService<String, ShopDTO> {
    @Autowired
    ShopMapper shopMapper;

    @Override
    public void register(ShopDTO shopDTO) throws Exception {
        shopMapper.insert(shopDTO);
    }

    @Override
    public void modify(ShopDTO shopDTO) throws Exception {
        shopMapper.update(shopDTO);
    }

    @Override
    public void remove(String id) throws Exception {
        shopMapper.delete(id);
    }

    @Override
    public ShopDTO get(String s) throws Exception {
        return null;
    }

    @Override
    public List<ShopDTO> get() throws Exception {
        return null;
    }
}

