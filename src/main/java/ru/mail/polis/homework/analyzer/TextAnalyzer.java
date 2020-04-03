package ru.mail.polis.homework.analyzer;


import ru.mail.polis.homework.analyzer.filters.SpamAnalyzer;
import ru.mail.polis.homework.analyzer.filters.TooLongAnalyzer;

/**
 * ������� ���������� �������, ���������� ����� ����������� ������ ��������������� � ���� ��� ������
 * ������� ������.
 * ���� ���� ����������� ������, ������� ������� ������� ��������� ���� (�� ��� ��� ���������� ���������, ��� ��� ���
 * ����� ���, ��� ��� �� ����� ���������� ����������, � ����� ������ ��������, ��� ��������� ����������� �������
 * ����� ���-�� ������������� �����). ���� ����������� ������ ��� ����� ��� �������� ������,
 * ��� �� ��� �������� ������� (������� �� ��������) � ���� "������������" �� ��������.
 *
 * ��� �� ���������� ������� ��� ���������� ������, ������� ����� ��� ����� ��� ������� ������
 * �� ���� �������� � ������ TextFilterManager
 *
 * 2 ����� + (2 ����� �� ������ ������ + 1 ���� �� ���� �� ���� ������) ����� 11
 */
public interface TextAnalyzer {

    FilterType getResult(String text);
    int getIdResult();

    static TextAnalyzer createTooLongAnalyzer(long maxLength) {
        return new TooLongAnalyzer(maxLength);
    }

    static TextAnalyzer createSpamAnalyzer(String[] spam) {
        return new SpamAnalyzer(spam);
    }

    static TextAnalyzer createNegativeTextAnalyzer() {
        return null;
    }

    /**
     * ��������� ���� ������
     */
    static <T> TextAnalyzer createCustomAnalyzer(T something) {
        return null;
    }
}
