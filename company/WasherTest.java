package com.company;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class WasherTest {
    Washer x = new Washer("Samsung", "792SM", "7KG", 1600, "B", 600);
    @org.junit.jupiter.api.Test
    void consturctorTest(){
        assertNotNull(x);
    }
    @org.junit.jupiter.api.Test
    void read() {
        String s = "WASHER Samsung, 792SM, 7KG, 1600, B, 600 euros";
        assertEquals(x, Washer.read(s));
    }

    @org.junit.jupiter.api.Test
    void getRotations() {
        assertEquals(1600, x.getRotations());
    }

    @org.junit.jupiter.api.Test
    void getCapKg() {
        assertEquals("7KG", x.getCapKg());
    }

    @org.junit.jupiter.api.Test
    void setCapKg() {
        x.setCapKg("10KG");
        assertEquals("10KG", x.getCapKg());
    }

    @org.junit.jupiter.api.Test
    void testEquals() {
        Washer y = new Washer("Samsung", "792SM", "7KG", 1600, "B", 600);
        assertEquals(x,y);
    }
    @org.junit.jupiter.api.Test
    void testEqualsSameObject() {
        assertEquals(x,x);
    }
    @org.junit.jupiter.api.Test
    void testEqualsDifferentObj() {
        Washer y = new Washer("asd", "792SM", "7KG", 100, "B", 600);
        assertNotEquals(x,y);
    }

    @org.junit.jupiter.api.Test
    void testToString() {
        assertEquals("WASHER Samsung, 792SM, 7KG, 1600, B, 600 euros", x.toString());
    }
}
