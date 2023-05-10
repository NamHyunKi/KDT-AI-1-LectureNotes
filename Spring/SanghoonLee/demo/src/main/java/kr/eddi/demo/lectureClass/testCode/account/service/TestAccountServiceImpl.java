package kr.eddi.demo.lectureClass.testCode.account.service;

import kr.eddi.demo.lectureClass.testCode.account.controller.form.TestAccountRequestForm;
import kr.eddi.demo.lectureClass.testCode.account.entity.TestAccount;
import kr.eddi.demo.lectureClass.testCode.account.repository.TestAccountRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class TestAccountServiceImpl implements TestAccountService {

    final private TestAccountRepository testAccountRepository;
    @Override
    public TestAccount register(TestAccountRequestForm requestForm) {

        return testAccountRepository.save(requestForm.toTestAccount());
    }
}