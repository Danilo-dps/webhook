package com.danilodps.webhook.adapters.inbound.controller;

import com.danilodps.webhook.adapters.inbound.controller.request.PaymentRequest;
import com.danilodps.webhook.adapters.inbound.controller.request.PaymentUpdateRequest;
import com.danilodps.webhook.adapters.inbound.controller.response.PaymentResponse;
import com.danilodps.webhook.application.usecases.PaymentUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/payment/v1")
public class PaymentController {

    private final PaymentUseCase paymentUseCase;

    @PostMapping()
    public ResponseEntity<PaymentResponse> create(@RequestBody PaymentRequest paymentRequest){
        PaymentResponse paymentResponse = paymentUseCase.create(paymentRequest);
        return ResponseEntity.ok(paymentResponse);
    }

    @GetMapping()
    public ResponseEntity<PaymentResponse> findByPaymentId(@RequestParam String paymentId){
        PaymentResponse paymentResponse = paymentUseCase.findByPaymentId(paymentId);
        return  ResponseEntity.ok(paymentResponse);
    }

    @PostMapping("/webhook")
    public ResponseEntity<PaymentResponse> create(@RequestBody PaymentUpdateRequest paymentUpdateRequest){
        PaymentResponse paymentResponse = paymentUseCase.update(paymentUpdateRequest);
        return ResponseEntity.ok(paymentResponse);
    }

}
