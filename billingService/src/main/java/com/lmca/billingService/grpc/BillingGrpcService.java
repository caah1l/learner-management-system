package com.lmca.billingService.grpc;

import billing.BillingRequest;
import billing.BillingResponse;
import billing.BillingServiceGrpc;
import io.grpc.stub.StreamObserver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BillingGrpcService extends BillingServiceGrpc.BillingServiceImplBase {
    private static final Logger log = LoggerFactory.getLogger(BillingGrpcService.class);

    @Override
    public void createBillingAccount(BillingRequest billingRequest,
                                     StreamObserver<BillingResponse> responseObserver) {
        log.info("Received Create Billing Account Request {}", billingRequest.toString());

       BillingResponse response = BillingResponse.newBuilder()
               .setAccountId("1234")
               .setAccountStatus("Active")
               .build();

       responseObserver.onNext(response);
       responseObserver.onCompleted();


    }
}
