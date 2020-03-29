package com.company;

import org.junit.jupiter.api.Test;

import java.util.Vector;
import static org.junit.jupiter.api.Assertions.*;

class TaskTest {
    @Test
    void getMinValue1() {
        Task task = new Task(new String[]{"rrr", "safdg"});
        task.CountDifferentChars();
        assertEquals("rrr", task.GetMinValue());
    }

    @Test
    void getMinValue2() {
        Task task = new Task(new String[]{"qwerty", "qwert"});
        task.CountDifferentChars();
        assertEquals("qwert", task.GetMinValue());
    }

    @Test
    void getMinValue3() {
        Task task = new Task(new String[]{"", ""});
        task.CountDifferentChars();
        assertEquals("", task.GetMinValue());
    }

    @Test
    void getMinValue4() {
        Task task = new Task(new String[]{"r", "r"});
        task.CountDifferentChars();
        assertEquals("r", task.GetMinValue());
    }
}