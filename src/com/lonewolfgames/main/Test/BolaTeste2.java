package com.lonewolfgames.main.Test;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.lonewolfgames.main.Bola;

class BolaTeste2 {

	@Test
    @DisplayName("Testar se o Angulo E menor que permitido")
    public void test() 
    {
        Bola B1 = new Bola();
        int angle = B1.angulo(120);
        assertTrue(angle > 45);
    }

    @Test
    @DisplayName("Testar se o Angulo e maior que permitido")
    public void BolaTeste() {
        Bola B1 = new Bola();
        int angle = B1.angulo(120);
        assertTrue(angle < 120);
    }

    @Test
    @DisplayName("Testar se o Angulo E menor ou maior que permitido x100")
    public void test1() {
        Bola B1 = new Bola();
        boolean passed = false;
        int menor = 0;
        int maior = 0;
        for (int i = 0; i < 101; i++) {
            int angle = B1.angulo(120);
            if (angle <40){
             menor++;
            }else if(angle >120){
             maior++;
            }
        }
        if (menor==0 && maior==0){
            passed=true;
        }
        assertTrue(passed==true);
    }

}
