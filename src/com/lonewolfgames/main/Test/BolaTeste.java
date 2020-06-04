package com.lonewolfgames.main.Test;

import static org.junit.Assert.*;

import java.util.Random;

import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;

import com.lonewolfgames.api.Score;
import com.lonewolfgames.main.Bola;
import com.lonewolfgames.main.Game;


public class BolaTeste {
    // Primeiro teste é verificar se a bola é criada dentro do angulo certo e não
    // começa nunca em zero
    @BeforeEach
    void setUp() throws Exception {


    }

    @Test
    @DisplayName("Testar se o Angulo E menor que permitido")
    void test() 
    {
        Bola B1 = new Bola();
        int angle = B1.angulo(120);
        assertTrue(angle > 45);
    }

    @Test
    @DisplayName("Testar se o Angulo e maior que permitido")
    void BolaTeste() {
        Bola B1 = new Bola();
        int angle = B1.angulo(120);
        assertTrue(angle < 120);
    }

    @Test
    @DisplayName("Testar se o Angulo E menor ou maior que permitido x100")
    void test1() {
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