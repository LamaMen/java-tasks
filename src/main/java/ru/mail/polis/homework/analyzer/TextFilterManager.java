package ru.mail.polis.homework.analyzer;


import java.util.Arrays;

/**
 * ������� �������� ������� ���������� ������������.
 * ���� ����������� ��� ���� ������������ ��������
 * 1) ������ ��� ������� ������� ������� (����� �������� ��� ��������) (TOO_LONG)
 * 2) ������ ��� ����� (���������� ������ ������ ����, ������� �� ������ ���� � ������) (SPAM)
 * 3) ������ ��� ������� � ������� ��������. (� ������ �� ������ ���� ����� �������:
 * "=(", ":(", ":|" (NEGATIVE_TEXT)
 * + ������� ����� ���� ������ (CUSTOM)
 * <p>
 * ����� TextFilterManager ������ ��������� ��� �������, ������� ���������� ��� � ������������,
 * � ��� ������� ������ ����� ����� analyze ������ �������� ������ "��������" ������,
 * ���� �� ���� �� ������, �� ���������� ��� GOOD.
 * �������������� �������: ����� ���� ����� �������� ������ ���������
 * (SPAM, TOO_LONG, NEGATIVE_TEXT, CUSTOM - � ����� �������) � ���������� ��� � ������������ �����������.
 * ������������� ������� ����� � ������� �������
 * Arrays.sort(filter, (filter1, filter2) -> {
 * if (filter1 < filter2) {
 * return -1;
 * } else if (filter1 == filter2) {
 * return 0;
 * }
 * return 1;
 * }
 * ��� ������ ��������� ����� �������� ������ ���� ���������� �����-�� �������������� ���������� �������
 * <p>
 * 2 ����� ( + 2 ����� �� ��� ���������)
 * ����� 15 ������ + 2 ��������������
 */
public class TextFilterManager {

    private TextAnalyzer[] filters;

    /**
     * ��� ������ � ������ ��������� �������, ����� ������������ ���� for-each
     * ������� ��������, ��� ��� �� ������ �� �����, ����� ��������� ��� ������� ��������, ����� ������ ��,
     * ��� � ��� ���������� ��������� TextAnalyzer
     */
    public TextFilterManager(TextAnalyzer[] filters) {
        this.filters = filters;
        Arrays.sort(filters, (filter1, filter2) -> {
            Integer id1 = filter1.getIdResult();
            Integer id2 = filter2.getIdResult();
            return id1.compareTo(id2);
        });
    }

    /**
     * ���� ���������� ����� ������ �� ���������, �� ��� ��������, ��� �� ���� ������ �� ��������
     */
    public FilterType analyze(String text) {
        if (text == null) {
            return FilterType.GOOD;
        }
        FilterType result;
        for (TextAnalyzer filter : filters) {
            result = filter.getResult(text);
            if (result != FilterType.GOOD) {
                return result;
            }
        }

        return FilterType.GOOD;
    }
}
