package com.rozetka;

import com.rozetka.pageobjects.HomePO;
import org.testng.annotations.Test;

public class Rozoktr extends BaseTest {
    @Test
    public void testRe() {
        System.out.println(new HomePO().getTitle());
    }

    @Test
    public void testR1e() {
        System.out.println(new HomePO().getTitle());
    }

    @Test
    public void test2Re() {
        System.out.println(new HomePO().getTitle());
    }
}