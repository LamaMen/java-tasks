package ru.mail.polis.homework.collections.mail;

public class Salary extends SimpleMessage<Integer> {

    public Salary(String sender, String recipient, Integer content) {
        super(sender, recipient, content);
    }
}
