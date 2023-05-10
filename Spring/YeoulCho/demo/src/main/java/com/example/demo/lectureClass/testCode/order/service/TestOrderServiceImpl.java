package com.example.demo.lectureClass.testCode.order.service;



import com.example.demo.lectureClass.testCode.account.entity.TestAccount;
import com.example.demo.lectureClass.testCode.account.repository.TestAccountRepository;
import com.example.demo.lectureClass.testCode.order.controller.form.TestOrderRequestForm;
import com.example.demo.lectureClass.testCode.order.entity.TestOrder;
import com.example.demo.lectureClass.testCode.order.repository.TestOrderRepository;
import com.example.demo.lectureClass.testCode.product.entity.TestProduct;
import com.example.demo.lectureClass.testCode.product.repository.TestProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class TestOrderServiceImpl implements TestOrderService{
    final private TestAccountRepository accountRepository;
    final private TestOrderRepository orderRepository;
    final private TestProductRepository productRepository;

    private Long alwaysReturnFirst(String userToken){
        return 1L;
    }
    @Override
    public TestOrder order(TestOrderRequestForm requestForm){
        final Long accountId = alwaysReturnFirst(requestForm.getUserToken());
        final Optional<TestAccount> maybeAccount = accountRepository.findById(accountId);

        if(maybeAccount.isEmpty()){
            log.debug("주문을 진행할 수 없습니다.");
            return null;
        }
        final TestAccount account =maybeAccount.get();
        final Optional<TestProduct> maybeProduct = productRepository.findById(requestForm.getProductId());
        if(maybeProduct.isEmpty()){
            log.debug("주문을 진행할 수 없습니다.");
            return null;
        }
        final TestProduct product =maybeProduct.get();
        return orderRepository.save(new TestOrder(account,product));
    }
}
