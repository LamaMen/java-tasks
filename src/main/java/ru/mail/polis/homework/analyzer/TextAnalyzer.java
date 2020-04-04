package ru.mail.polis.homework.analyzer;


import ru.mail.polis.homework.analyzer.filters.CustomAnalyzer;
import ru.mail.polis.homework.analyzer.filters.NegativeTextAnalyzer;
import ru.mail.polis.homework.analyzer.filters.SpamAnalyzer;
import ru.mail.polis.homework.analyzer.filters.TooLongAnalyzer;

/**
 * ������� ���������� �������, ���������� ����� ����������� ������ ��������������� � ���� ��� ������
 * ������� ������.
 * ���� ���� ����������� ������, ������� ������� ������� ��������� ���� (�� ��� ��� ���������� ���������, ��� ��� ���
 * ����� ���, ��� ��� �� ����� ���������� ����������, � ����� ������ ��������, ��� ��������� ����������� �������
 * ����� ���-�� ������������� �����). ���� ����������� ������ ��� ����� ��� �������� ������,
 * ��� �� ��� �������� ������� (������� �� ��������) � ���� "������������" �� ��������.
 * <p>
 * ��� �� ���������� ������� ��� ���������� ������, ������� ����� ��� ����� ��� ������� ������
 * �� ���� �������� � ������ TextFilterManager
 * <p>
 * 2 ����� + (2 ����� �� ������ ������ + 1 ���� �� ���� �� ���� ������) ����� 11
 */
public interface TextAnalyzer {

    static TextAnalyzer createTooLongAnalyzer(long maxLength) {
        return new TooLongAnalyzer(maxLength);
    }

    static TextAnalyzer createSpamAnalyzer(String[] spam) {
        return new SpamAnalyzer(spam);
    }

    static TextAnalyzer createNegativeTextAnalyzer() {
        return new NegativeTextAnalyzer();
    }

    /**
     * ��������� ���� ������
     */
    static TextAnalyzer createCustomAnalyzer(boolean something) {
        return new CustomAnalyzer(something);
    }

    FilterType getResult(String text);

    int getIdResult();
}
