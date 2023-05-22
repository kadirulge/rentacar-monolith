package com.kodlamaio.paymentservice.adapters;

import com.kodlamaio.paymentservice.business.abstracts.PosService;
import org.springframework.stereotype.Service;

@Service
public class FakePosServiceAdapter implements PosService
{
    @Override
    public void pay()
    {
        boolean isPaymentSuccessfull = true; //new Random().nextBoolean();
        if(!isPaymentSuccessfull)
        {
            throw new RuntimeException("Payment invalid...");
        }
    }
}