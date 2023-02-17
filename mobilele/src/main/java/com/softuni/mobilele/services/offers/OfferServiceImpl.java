package com.softuni.mobilele.services.offers;

import com.softuni.mobilele.services.init.DataBaseInitServiceService;
import org.springframework.stereotype.Service;

@Service
public class OfferServiceImpl implements OfferService, DataBaseInitServiceService {
    @Override
    public void dbInit() {
    }

    @Override
    public boolean isDbInit() {
        return false;
    }
}