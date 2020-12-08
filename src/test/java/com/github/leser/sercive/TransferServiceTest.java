package com.github.leser.sercive;

import com.github.leser.Validation.PositiveNumberValidation;
import com.github.leser.Validation.UserExistValidation;
import com.github.leser.read.IntegerValidationReader;
import com.github.leser.read.ValidationReader;
import com.github.leser.repository.user.User;
import com.github.leser.repository.user.UserRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;
import static org.mockito.Mockito.times;

@RunWith(MockitoJUnitRunner.class)
public class TransferServiceTest {
    private static final Integer TRANSFER_VALUE = 20;
    private static final String USERNAME_INPUT = "username-input";
    @Mock
    private IntegerValidationReader integerValidationReader;
    @Mock
    private PositiveNumberValidation positiveNumberValidation;
    @Mock
    private ValidationReader validationReader;
    @Mock
    private UserExistValidation userExistValidation;
    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private TransferService underTest;

    @Mock
    public User user1;
    @Mock
    public User user2;


    @Test

    public void transfer_shouldCancelTransfer_whenTramsferValueIsZero() {
        //GIVEN
        given(integerValidationReader.readNumber(positiveNumberValidation)).willReturn(0);
        //WHEN
        underTest.transfer(user1);
        //THEN
        then(user1).should().getBalance();
        then(user1).shouldHaveNoMoreInteractions();
        then(user2).shouldHaveNoInteractions();
        then(validationReader).shouldHaveNoInteractions();
        then(userRepository).shouldHaveNoInteractions();
    }

    @Test
    public void transfer_shouldCancelTransfer_whenUserNameIsBlanc() {
        //GIVEN
        given(integerValidationReader.readNumber(positiveNumberValidation)).willReturn(TRANSFER_VALUE);
        given(validationReader.rearInput(userExistValidation)).willReturn("");
        given(user1.getBalance()).willReturn(TRANSFER_VALUE +1 );
        //WHEN
        underTest.transfer(user1);
        //THEN
        then(user1).should(times(2)).getBalance();
        then(user1).shouldHaveNoMoreInteractions();
        then(user2).shouldHaveNoInteractions();
        then(userRepository).shouldHaveNoInteractions();
    }

    @Test
    public void transfer_executeTransfer() {
        //GIVEN
        given(integerValidationReader.readNumber(positiveNumberValidation)).willReturn(TRANSFER_VALUE);
        given(user1.getBalance()).willReturn(TRANSFER_VALUE + 1 );
        given(validationReader.rearInput(userExistValidation)).willReturn(USERNAME_INPUT);
        given(userRepository.findByUsername(USERNAME_INPUT)).willReturn(user2);
        //WHEN
        underTest.transfer(user1);
        //THEN
        then(user1).should().decreaseBalance(TRANSFER_VALUE);
        then(user2).should().increaseBalance(TRANSFER_VALUE);
        then(userRepository).should().save(user1);
        then(userRepository).should().save(user2);
    }

    @Test
    public void transfer_shouldRetryTransfer_whenTramsferValueIsHigherThanBalance() {
        //GIVEN
        given(user1.getBalance()).willReturn(TRANSFER_VALUE);
        given(integerValidationReader.readNumber(positiveNumberValidation))
                .willReturn(TRANSFER_VALUE + 1)
                .willReturn(TRANSFER_VALUE);
        given(validationReader.rearInput(userExistValidation)).willReturn(USERNAME_INPUT);
        given(userRepository.findByUsername(USERNAME_INPUT)).willReturn(user2);

        //WHEN
        underTest.transfer(user1);
        //THEN
        then(integerValidationReader).should(times(2)).readNumber(positiveNumberValidation);
        then(user1).should().decreaseBalance(TRANSFER_VALUE);
        then(user2).should().increaseBalance(TRANSFER_VALUE);
        then(userRepository).should().save(user1);
        then(userRepository).should().save(user2);
    }

}