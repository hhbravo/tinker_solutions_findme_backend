package com.tinker.factory.findme.service.impl;

import com.tinker.factory.findme.service.intf.DateTimeRetriever;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.Date;

/**
 *Created by hans_h'bravo on 24/12/2017
 */
@Service
public class DateTimeRetrieverImpl implements DateTimeRetriever {

    @Override
    public Date currentTime() {
        return new Timestamp(System.currentTimeMillis()); //TODO JCM implement ofr time sync betwen servers
    }
}
