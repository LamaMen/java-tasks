package ru.mail.polis.homework.collections.mail;

public class MailMessage extends SimpleMessage<String> {

    public MailMessage(String sender, String recipient, String content) {
        super(sender, recipient, content);
    }
}
