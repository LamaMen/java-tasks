package ru.mail.polis.homework.analyzer;


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

    static TextAnalyzer createTooLongAnalyzer(long maxLength) {
        return new TooLongAnalyzer(maxLength);
    }

    static TextAnalyzer createSpamAnalyzer(String[] spam) {
        return null;
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
