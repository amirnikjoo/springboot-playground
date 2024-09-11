package com.amir;

import com.amir.levant.dto.ServiceId;
import com.amir.levant.dto.TransactionDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class MultiThreadedApiTest {
    private static final Random random = new Random();

    private static String url = "http://localhost:8888/v1/payment/do";

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void testSingleThreaded() {
        int numberOfTransactions = 1;
        for (int j = 0; j < numberOfTransactions; j++) {
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);
            HttpEntity<TransactionDto> request = new HttpEntity<>(generateRandomTransactionDto(), headers);
            restTemplate.postForEntity(url, request, String.class);
        }
    }

    @Test
    public void testMultiThreadedRequests() throws InterruptedException {
        int numberOfThreads = 250;
        int numberOfTransactions = 10000;
        ExecutorService executorService = Executors.newFixedThreadPool(numberOfThreads);
        System.out.println("started... ");

        for (int i = 0; i < numberOfThreads; i++) {
            executorService.submit(() -> {
                        for (int j = 0; j < numberOfTransactions; j++) {
                            HttpHeaders headers = new HttpHeaders();
                            headers.setContentType(MediaType.APPLICATION_JSON);
                            HttpEntity<TransactionDto> request = new HttpEntity<>(generateRandomTransactionDto(), headers);
                            restTemplate.postForEntity(url, request, String.class);
                        }
                    }
            );
        }

        executorService.shutdown();
        executorService.awaitTermination(10, TimeUnit.MINUTES);
        System.out.println("finished... ");
    }


    public static TransactionDto generateRandomTransactionDto() {

        TransactionDto transactionDto = new TransactionDto();

//		transactionDto.setId(random.nextLong());
        transactionDto.setRefId(random.nextLong());
        transactionDto.setOrgRefId(random.nextLong());
        transactionDto.setServiceId(ServiceId.SALE);
        transactionDto.setPan(random.nextLong());
        transactionDto.setPan2(random.nextLong());
        transactionDto.setAmount(random.nextLong());
        transactionDto.setLocalDate(new SimpleDateFormat("yyyyMMdd").format(new Date()));
        transactionDto.setLocalTime(new SimpleDateFormat("HH:mm:ss").format(new Date()));
        transactionDto.setIban("IR" + random.nextInt(1000000000));
        transactionDto.setBillId("BILL" + random.nextInt(100000));
        transactionDto.setPaymentId("PAY" + random.nextInt(100000));
        transactionDto.setPayerId("PAYER" + random.nextInt(100000));
        transactionDto.setChannelId(random.nextInt(10));
        transactionDto.setChannelType("ChannelType" + random.nextInt(10));
        transactionDto.setTerminalId(random.nextInt(10000));
        transactionDto.setStan("" + random.nextInt(999999));
        transactionDto.setRrn("" + random.nextInt());
        transactionDto.setAdditionalData("AdditionalData" + random.nextInt(1000));
        transactionDto.setResCode("00");
        transactionDto.setExceptionMessage("No exception");
        transactionDto.setDuration(random.nextInt(100));
//		transactionDto.setInsertDate(new Date());

        return transactionDto;
    }

}