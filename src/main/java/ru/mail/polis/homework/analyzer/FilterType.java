package ru.mail.polis.homework.analyzer;

/**
 * ���� �������� (2 �����)
 */
public enum FilterType {
    SPAM(0),
    TOO_LONG(1),
    NEGATIVE_TEXT(2),
    CUSTOM(3),
    GOOD(4);

    public int id;

    FilterType(int id) {
        this.id = id;
    }
}
