package com.github.leser.read;

import com.github.leser.Validation.IntegerValidation;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class IntegerReader {
    private final ValidationReader validationReader;
    private final IntegerValidation integerValidation;
     public int readNumber(){
         String numberString = validationReader.rearInput(integerValidation);

         return Integer.parseInt(numberString);
     }
}
