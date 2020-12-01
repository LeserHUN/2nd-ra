package com.github.leser.jarmu;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.*;

public class DomperTest {
    private static final int KAPACITAS = 100 ;
    private static final int SEBESSEG = 90;
    private Domper underTest;


    @Before
    public void setUp(){
        underTest = new Domper(KAPACITAS, SEBESSEG);
    }

    @After
    public void tearDown(){
        assertThat(underTest.getRakomany()).isEqualTo(0);
    }
    @Test
    public void motorBeindit_shouldSetJarAMotorTrue(){
        //GIVEN


        //WHEN
        underTest.motorBeindit();


        //THEN
        if(!underTest.isJarAMotor()){
            throw new AssertionError("A jarAMotor nem lehet false");
        }
    }
    @Test
    public void motorLeallit_shouldSetJarAMotorFalse(){
        //GIVEN
        underTest.motorBeindit();
        //WHEN
        underTest.motorLeallit();
        //THEN
        assertThat(underTest.isJarAMotor()).isFalse();
    }

    @Test(expected = IllegalStateException.class)
    public void platoKinyit_shouldThrowException_whenSebessegInSotZero(){
        //GIVEN
        underTest.setSebesseg(1);
        //WHEN
        underTest.platoKinyit();
        //THEN
    }
    @Test
    public void elindul_shouldThrowExpection_whenSebesseIsNotZero()throws NemJarAMotorExeption{
        //GIVEN
        underTest.setSebesseg(1);
        //WHEN
        try{
            underTest.elindul(32);
        } catch (IllegalStateException e){
            assertThat(underTest.getSebesseg()).isEqualTo(1);
            return;
        }

        fail("Expected IllegatStateExpection was not thrown");
        //THEN
    }

    @Test
    public void elindul_shouldThrowException_whenNemJarAMotor(){
        //GIVEN

        //WHEN
        Throwable ex= catchThrowable(()->underTest.elindul(32));
        //THEN
        assertThat(ex).isInstanceOf(NemJarAMotorExeption.class);
        assertThat(underTest.getSebesseg()).isEqualTo(0);
    }
}