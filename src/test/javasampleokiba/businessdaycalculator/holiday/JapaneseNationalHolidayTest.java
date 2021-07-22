package test.javasampleokiba.businessdaycalculator.holiday;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.junit.jupiter.api.Test;

import javasampleokiba.businessdaycalculator.holiday.JapaneseNationalHoliday;
import test.TestBase;

/**
 * JUnit5�ɂ��JapaneseNationalHoliday�N���X�̃e�X�g
 */
public class JapaneseNationalHolidayTest extends TestBase {

    /** ���ׂĂ̏t���̓���ێ� */
    private static final List<Calendar> vernalEquinoxDays_      = new ArrayList<Calendar>();
    static {
        vernalEquinoxDays_.add(toCalendar(1949, 3, 21));
        vernalEquinoxDays_.add(toCalendar(1950, 3, 21));
        vernalEquinoxDays_.add(toCalendar(1951, 3, 21));
        vernalEquinoxDays_.add(toCalendar(1952, 3, 21));
        vernalEquinoxDays_.add(toCalendar(1953, 3, 21));
        vernalEquinoxDays_.add(toCalendar(1954, 3, 21));
        vernalEquinoxDays_.add(toCalendar(1955, 3, 21));
        vernalEquinoxDays_.add(toCalendar(1956, 3, 21));
        vernalEquinoxDays_.add(toCalendar(1957, 3, 21));
        vernalEquinoxDays_.add(toCalendar(1958, 3, 21));
        vernalEquinoxDays_.add(toCalendar(1959, 3, 21));
        vernalEquinoxDays_.add(toCalendar(1960, 3, 20));
        vernalEquinoxDays_.add(toCalendar(1961, 3, 21));
        vernalEquinoxDays_.add(toCalendar(1962, 3, 21));
        vernalEquinoxDays_.add(toCalendar(1963, 3, 21));
        vernalEquinoxDays_.add(toCalendar(1964, 3, 20));
        vernalEquinoxDays_.add(toCalendar(1965, 3, 21));
        vernalEquinoxDays_.add(toCalendar(1966, 3, 21));
        vernalEquinoxDays_.add(toCalendar(1967, 3, 21));
        vernalEquinoxDays_.add(toCalendar(1968, 3, 20));
        vernalEquinoxDays_.add(toCalendar(1969, 3, 21));
        vernalEquinoxDays_.add(toCalendar(1970, 3, 21));
        vernalEquinoxDays_.add(toCalendar(1971, 3, 21));
        vernalEquinoxDays_.add(toCalendar(1972, 3, 20));
        vernalEquinoxDays_.add(toCalendar(1973, 3, 21));
        vernalEquinoxDays_.add(toCalendar(1974, 3, 21));
        vernalEquinoxDays_.add(toCalendar(1975, 3, 21));
        vernalEquinoxDays_.add(toCalendar(1976, 3, 20));
        vernalEquinoxDays_.add(toCalendar(1977, 3, 21));
        vernalEquinoxDays_.add(toCalendar(1978, 3, 21));
        vernalEquinoxDays_.add(toCalendar(1979, 3, 21));
        vernalEquinoxDays_.add(toCalendar(1980, 3, 20));
        vernalEquinoxDays_.add(toCalendar(1981, 3, 21));
        vernalEquinoxDays_.add(toCalendar(1982, 3, 21));
        vernalEquinoxDays_.add(toCalendar(1983, 3, 21));
        vernalEquinoxDays_.add(toCalendar(1984, 3, 20));
        vernalEquinoxDays_.add(toCalendar(1985, 3, 21));
        vernalEquinoxDays_.add(toCalendar(1986, 3, 21));
        vernalEquinoxDays_.add(toCalendar(1987, 3, 21));
        vernalEquinoxDays_.add(toCalendar(1988, 3, 20));
        vernalEquinoxDays_.add(toCalendar(1989, 3, 21));
        vernalEquinoxDays_.add(toCalendar(1990, 3, 21));
        vernalEquinoxDays_.add(toCalendar(1991, 3, 21));
        vernalEquinoxDays_.add(toCalendar(1992, 3, 20));
        vernalEquinoxDays_.add(toCalendar(1993, 3, 20));
        vernalEquinoxDays_.add(toCalendar(1994, 3, 21));
        vernalEquinoxDays_.add(toCalendar(1995, 3, 21));
        vernalEquinoxDays_.add(toCalendar(1996, 3, 20));
        vernalEquinoxDays_.add(toCalendar(1997, 3, 20));
        vernalEquinoxDays_.add(toCalendar(1998, 3, 21));
        vernalEquinoxDays_.add(toCalendar(1999, 3, 21));
        vernalEquinoxDays_.add(toCalendar(2000, 3, 20));
        vernalEquinoxDays_.add(toCalendar(2001, 3, 20));
        vernalEquinoxDays_.add(toCalendar(2002, 3, 21));
        vernalEquinoxDays_.add(toCalendar(2003, 3, 21));
        vernalEquinoxDays_.add(toCalendar(2004, 3, 20));
        vernalEquinoxDays_.add(toCalendar(2005, 3, 20));
        vernalEquinoxDays_.add(toCalendar(2006, 3, 21));
        vernalEquinoxDays_.add(toCalendar(2007, 3, 21));
        vernalEquinoxDays_.add(toCalendar(2008, 3, 20));
        vernalEquinoxDays_.add(toCalendar(2009, 3, 20));
        vernalEquinoxDays_.add(toCalendar(2010, 3, 21));
        vernalEquinoxDays_.add(toCalendar(2011, 3, 21));
        vernalEquinoxDays_.add(toCalendar(2012, 3, 20));
        vernalEquinoxDays_.add(toCalendar(2013, 3, 20));
        vernalEquinoxDays_.add(toCalendar(2014, 3, 21));
        vernalEquinoxDays_.add(toCalendar(2015, 3, 21));
        vernalEquinoxDays_.add(toCalendar(2016, 3, 20));
        vernalEquinoxDays_.add(toCalendar(2017, 3, 20));
        vernalEquinoxDays_.add(toCalendar(2018, 3, 21));
        vernalEquinoxDays_.add(toCalendar(2019, 3, 21));
        vernalEquinoxDays_.add(toCalendar(2020, 3, 20));
        vernalEquinoxDays_.add(toCalendar(2021, 3, 20));
        vernalEquinoxDays_.add(toCalendar(2022, 3, 21));
        vernalEquinoxDays_.add(toCalendar(2023, 3, 21));
        vernalEquinoxDays_.add(toCalendar(2024, 3, 20));
        vernalEquinoxDays_.add(toCalendar(2025, 3, 20));
        vernalEquinoxDays_.add(toCalendar(2026, 3, 20));
        vernalEquinoxDays_.add(toCalendar(2027, 3, 21));
        vernalEquinoxDays_.add(toCalendar(2028, 3, 20));
        vernalEquinoxDays_.add(toCalendar(2029, 3, 20));
        vernalEquinoxDays_.add(toCalendar(2030, 3, 20));
        vernalEquinoxDays_.add(toCalendar(2031, 3, 21));
        vernalEquinoxDays_.add(toCalendar(2032, 3, 20));
        vernalEquinoxDays_.add(toCalendar(2033, 3, 20));
        vernalEquinoxDays_.add(toCalendar(2034, 3, 20));
        vernalEquinoxDays_.add(toCalendar(2035, 3, 21));
        vernalEquinoxDays_.add(toCalendar(2036, 3, 20));
        vernalEquinoxDays_.add(toCalendar(2037, 3, 20));
        vernalEquinoxDays_.add(toCalendar(2038, 3, 20));
        vernalEquinoxDays_.add(toCalendar(2039, 3, 21));
        vernalEquinoxDays_.add(toCalendar(2040, 3, 20));
        vernalEquinoxDays_.add(toCalendar(2041, 3, 20));
        vernalEquinoxDays_.add(toCalendar(2042, 3, 20));
        vernalEquinoxDays_.add(toCalendar(2043, 3, 21));
        vernalEquinoxDays_.add(toCalendar(2044, 3, 20));
        vernalEquinoxDays_.add(toCalendar(2045, 3, 20));
        vernalEquinoxDays_.add(toCalendar(2046, 3, 20));
        vernalEquinoxDays_.add(toCalendar(2047, 3, 21));
        vernalEquinoxDays_.add(toCalendar(2048, 3, 20));
        vernalEquinoxDays_.add(toCalendar(2049, 3, 20));
        vernalEquinoxDays_.add(toCalendar(2050, 3, 20));
        vernalEquinoxDays_.add(toCalendar(2141, 3, 20));
        vernalEquinoxDays_.add(toCalendar(2142, 3, 21));
        vernalEquinoxDays_.add(toCalendar(2143, 3, 21));
        vernalEquinoxDays_.add(toCalendar(2144, 3, 20));
        vernalEquinoxDays_.add(toCalendar(2145, 3, 20));
        vernalEquinoxDays_.add(toCalendar(2146, 3, 21));
        vernalEquinoxDays_.add(toCalendar(2147, 3, 21));
        vernalEquinoxDays_.add(toCalendar(2148, 3, 20));
        vernalEquinoxDays_.add(toCalendar(2149, 3, 20));
        vernalEquinoxDays_.add(toCalendar(2150, 3, 21));
    }

    /** ���ׂĂ̏H���̓���ێ� */
    private static final List<Calendar> autumnalEquinoxDays_        = new ArrayList<Calendar>();
    static {
        autumnalEquinoxDays_.add(toCalendar(1948, 9, 23));
        autumnalEquinoxDays_.add(toCalendar(1949, 9, 23));
        autumnalEquinoxDays_.add(toCalendar(1950, 9, 23));
        autumnalEquinoxDays_.add(toCalendar(1951, 9, 24));
        autumnalEquinoxDays_.add(toCalendar(1952, 9, 23));
        autumnalEquinoxDays_.add(toCalendar(1953, 9, 23));
        autumnalEquinoxDays_.add(toCalendar(1954, 9, 23));
        autumnalEquinoxDays_.add(toCalendar(1955, 9, 24));
        autumnalEquinoxDays_.add(toCalendar(1956, 9, 23));
        autumnalEquinoxDays_.add(toCalendar(1957, 9, 23));
        autumnalEquinoxDays_.add(toCalendar(1958, 9, 23));
        autumnalEquinoxDays_.add(toCalendar(1959, 9, 24));
        autumnalEquinoxDays_.add(toCalendar(1960, 9, 23));
        autumnalEquinoxDays_.add(toCalendar(1961, 9, 23));
        autumnalEquinoxDays_.add(toCalendar(1962, 9, 23));
        autumnalEquinoxDays_.add(toCalendar(1963, 9, 24));
        autumnalEquinoxDays_.add(toCalendar(1964, 9, 23));
        autumnalEquinoxDays_.add(toCalendar(1965, 9, 23));
        autumnalEquinoxDays_.add(toCalendar(1966, 9, 23));
        autumnalEquinoxDays_.add(toCalendar(1967, 9, 24));
        autumnalEquinoxDays_.add(toCalendar(1968, 9, 23));
        autumnalEquinoxDays_.add(toCalendar(1969, 9, 23));
        autumnalEquinoxDays_.add(toCalendar(1970, 9, 23));
        autumnalEquinoxDays_.add(toCalendar(1971, 9, 24));
        autumnalEquinoxDays_.add(toCalendar(1972, 9, 23));
        autumnalEquinoxDays_.add(toCalendar(1973, 9, 23));
        autumnalEquinoxDays_.add(toCalendar(1974, 9, 23));
        autumnalEquinoxDays_.add(toCalendar(1975, 9, 24));
        autumnalEquinoxDays_.add(toCalendar(1976, 9, 23));
        autumnalEquinoxDays_.add(toCalendar(1977, 9, 23));
        autumnalEquinoxDays_.add(toCalendar(1978, 9, 23));
        autumnalEquinoxDays_.add(toCalendar(1979, 9, 24));
        autumnalEquinoxDays_.add(toCalendar(1980, 9, 23));
        autumnalEquinoxDays_.add(toCalendar(1981, 9, 23));
        autumnalEquinoxDays_.add(toCalendar(1982, 9, 23));
        autumnalEquinoxDays_.add(toCalendar(1983, 9, 23));
        autumnalEquinoxDays_.add(toCalendar(1984, 9, 23));
        autumnalEquinoxDays_.add(toCalendar(1985, 9, 23));
        autumnalEquinoxDays_.add(toCalendar(1986, 9, 23));
        autumnalEquinoxDays_.add(toCalendar(1987, 9, 23));
        autumnalEquinoxDays_.add(toCalendar(1988, 9, 23));
        autumnalEquinoxDays_.add(toCalendar(1989, 9, 23));
        autumnalEquinoxDays_.add(toCalendar(1990, 9, 23));
        autumnalEquinoxDays_.add(toCalendar(1991, 9, 23));
        autumnalEquinoxDays_.add(toCalendar(1992, 9, 23));
        autumnalEquinoxDays_.add(toCalendar(1993, 9, 23));
        autumnalEquinoxDays_.add(toCalendar(1994, 9, 23));
        autumnalEquinoxDays_.add(toCalendar(1995, 9, 23));
        autumnalEquinoxDays_.add(toCalendar(1996, 9, 23));
        autumnalEquinoxDays_.add(toCalendar(1997, 9, 23));
        autumnalEquinoxDays_.add(toCalendar(1998, 9, 23));
        autumnalEquinoxDays_.add(toCalendar(1999, 9, 23));
        autumnalEquinoxDays_.add(toCalendar(2000, 9, 23));
        autumnalEquinoxDays_.add(toCalendar(2001, 9, 23));
        autumnalEquinoxDays_.add(toCalendar(2002, 9, 23));
        autumnalEquinoxDays_.add(toCalendar(2003, 9, 23));
        autumnalEquinoxDays_.add(toCalendar(2004, 9, 23));
        autumnalEquinoxDays_.add(toCalendar(2005, 9, 23));
        autumnalEquinoxDays_.add(toCalendar(2006, 9, 23));
        autumnalEquinoxDays_.add(toCalendar(2007, 9, 23));
        autumnalEquinoxDays_.add(toCalendar(2008, 9, 23));
        autumnalEquinoxDays_.add(toCalendar(2009, 9, 23));
        autumnalEquinoxDays_.add(toCalendar(2010, 9, 23));
        autumnalEquinoxDays_.add(toCalendar(2011, 9, 23));
        autumnalEquinoxDays_.add(toCalendar(2012, 9, 22));
        autumnalEquinoxDays_.add(toCalendar(2013, 9, 23));
        autumnalEquinoxDays_.add(toCalendar(2014, 9, 23));
        autumnalEquinoxDays_.add(toCalendar(2015, 9, 23));
        autumnalEquinoxDays_.add(toCalendar(2016, 9, 22));
        autumnalEquinoxDays_.add(toCalendar(2017, 9, 23));
        autumnalEquinoxDays_.add(toCalendar(2018, 9, 23));
        autumnalEquinoxDays_.add(toCalendar(2019, 9, 23));
        autumnalEquinoxDays_.add(toCalendar(2020, 9, 22));
        autumnalEquinoxDays_.add(toCalendar(2021, 9, 23));
        autumnalEquinoxDays_.add(toCalendar(2022, 9, 23));
        autumnalEquinoxDays_.add(toCalendar(2023, 9, 23));
        autumnalEquinoxDays_.add(toCalendar(2024, 9, 22));
        autumnalEquinoxDays_.add(toCalendar(2025, 9, 23));
        autumnalEquinoxDays_.add(toCalendar(2026, 9, 23));
        autumnalEquinoxDays_.add(toCalendar(2027, 9, 23));
        autumnalEquinoxDays_.add(toCalendar(2028, 9, 22));
        autumnalEquinoxDays_.add(toCalendar(2029, 9, 23));
        autumnalEquinoxDays_.add(toCalendar(2030, 9, 23));
        autumnalEquinoxDays_.add(toCalendar(2031, 9, 23));
        autumnalEquinoxDays_.add(toCalendar(2032, 9, 22));
        autumnalEquinoxDays_.add(toCalendar(2033, 9, 23));
        autumnalEquinoxDays_.add(toCalendar(2034, 9, 23));
        autumnalEquinoxDays_.add(toCalendar(2035, 9, 23));
        autumnalEquinoxDays_.add(toCalendar(2036, 9, 22));
        autumnalEquinoxDays_.add(toCalendar(2037, 9, 23));
        autumnalEquinoxDays_.add(toCalendar(2038, 9, 23));
        autumnalEquinoxDays_.add(toCalendar(2039, 9, 23));
        autumnalEquinoxDays_.add(toCalendar(2040, 9, 22));
        autumnalEquinoxDays_.add(toCalendar(2041, 9, 23));
        autumnalEquinoxDays_.add(toCalendar(2042, 9, 23));
        autumnalEquinoxDays_.add(toCalendar(2043, 9, 23));
        autumnalEquinoxDays_.add(toCalendar(2044, 9, 22));
        autumnalEquinoxDays_.add(toCalendar(2045, 9, 22));
        autumnalEquinoxDays_.add(toCalendar(2046, 9, 23));
        autumnalEquinoxDays_.add(toCalendar(2047, 9, 23));
        autumnalEquinoxDays_.add(toCalendar(2048, 9, 22));
        autumnalEquinoxDays_.add(toCalendar(2049, 9, 22));
        autumnalEquinoxDays_.add(toCalendar(2050, 9, 23));
        autumnalEquinoxDays_.add(toCalendar(2141, 9, 23));
        autumnalEquinoxDays_.add(toCalendar(2142, 9, 23));
        autumnalEquinoxDays_.add(toCalendar(2143, 9, 23));
        autumnalEquinoxDays_.add(toCalendar(2144, 9, 22));
        autumnalEquinoxDays_.add(toCalendar(2145, 9, 23));
        autumnalEquinoxDays_.add(toCalendar(2146, 9, 23));
        autumnalEquinoxDays_.add(toCalendar(2147, 9, 23));
        autumnalEquinoxDays_.add(toCalendar(2148, 9, 22));
        autumnalEquinoxDays_.add(toCalendar(2149, 9, 23));
        autumnalEquinoxDays_.add(toCalendar(2150, 9, 23));
    }

    @Test
    public void testDateOf() {
        final int MAX_YEAR = 3000;

        // [����]
        {
            // �K�p�J�n�O
            assertEquals(null, JapaneseNationalHoliday.NewYearsDay.dateOf(1948));
            // �K�p�J�n��
            for (int year = 1949; year <= MAX_YEAR; year++) {
                assertDateEquals(toCalendar(year, 1, 1), JapaneseNationalHoliday.NewYearsDay.dateOf(year));
            }
        }
        // [���l�̓�]
        {
            // �K�p�J�n�O
            assertEquals(null, JapaneseNationalHoliday.ComingOfAgeDay.dateOf(1948));
            // �K�p�J�n��`�j���Œ�O
            for (int year = 1949; year <= 1999; year++) {
                assertDateEquals(toCalendar(year, 1, 15), JapaneseNationalHoliday.ComingOfAgeDay.dateOf(year));
            }
            // �j���Œ��
            assertDateEquals(toCalendar(2000, 1, 10), JapaneseNationalHoliday.ComingOfAgeDay.dateOf(2000));
            assertDateEquals(toCalendar(2001, 1, 8), JapaneseNationalHoliday.ComingOfAgeDay.dateOf(2001));
            assertDateEquals(toCalendar(2002, 1, 14), JapaneseNationalHoliday.ComingOfAgeDay.dateOf(2002));
            assertDateEquals(toCalendar(2003, 1, 13), JapaneseNationalHoliday.ComingOfAgeDay.dateOf(2003));
            assertDateEquals(toCalendar(2098, 1, 13), JapaneseNationalHoliday.ComingOfAgeDay.dateOf(2098));
            assertDateEquals(toCalendar(2099, 1, 12), JapaneseNationalHoliday.ComingOfAgeDay.dateOf(2099));
            assertDateEquals(toCalendar(2100, 1, 11), JapaneseNationalHoliday.ComingOfAgeDay.dateOf(2100));
        }
        // [�����L�O��]
        {
            // �K�p�J�n�O
            assertEquals(null, JapaneseNationalHoliday.NationalFoundationDay.dateOf(1966));
            // �K�p�J�n��
            for (int year = 1967; year <= MAX_YEAR; year++) {
                assertDateEquals(toCalendar(year, 2, 11), JapaneseNationalHoliday.NationalFoundationDay.dateOf(year));
            }
        }
        // [�V�c�a����]
        {
            // �K�p�J�n�O
            assertEquals(null, JapaneseNationalHoliday.EmperorsBirthday.dateOf(1948));
            // �K�p�J�n��`���t�ύX(1���)�O
            for (int year = 1949; year <= 1988; year++) {
                assertDateEquals(toCalendar(year, 4, 29), JapaneseNationalHoliday.EmperorsBirthday.dateOf(year));
            }
            // ���t�ύX(1���)��`���t�ύX(2���)�O
            for (int year = 1989; year <= 2018; year++) {
                assertDateEquals(toCalendar(year, 12, 23), JapaneseNationalHoliday.EmperorsBirthday.dateOf(year));
            }
            // 2019�N�͕���
            assertEquals(null, JapaneseNationalHoliday.EmperorsBirthday.dateOf(2019));
            // ���t�ύX(2���)��
            for (int year = 2020; year <= MAX_YEAR; year++) {
                assertDateEquals(toCalendar(year, 2, 23), JapaneseNationalHoliday.EmperorsBirthday.dateOf(year));
            }
        }
        // [�t���̓�]
        {
            // �K�p�J�n�O
            assertEquals(null, JapaneseNationalHoliday.VernalEquinoxDay.dateOf(1948));
            // �K�p�J�n��
            for (Calendar c : vernalEquinoxDays_) {
                assertDateEquals(c, JapaneseNationalHoliday.VernalEquinoxDay.dateOf(c.get(Calendar.YEAR)));
            }
            // 2151�N�ȍ~�͌v�Z�ł��Ȃ�
            assertThrows(IllegalArgumentException.class, () -> JapaneseNationalHoliday.VernalEquinoxDay.dateOf(2151));
        }
        // [�݂ǂ�̓�]
        {
            // �K�p�J�n�O
            assertEquals(null, JapaneseNationalHoliday.GreeneryDay.dateOf(1988));
            // �K�p�J�n��`���t�ύX�O
            for (int year = 1989; year <= 2006; year++) {
                assertDateEquals(toCalendar(year, 4, 29), JapaneseNationalHoliday.GreeneryDay.dateOf(year));
            }
            // ���t�ύX��
            for (int year = 2007; year <= MAX_YEAR; year++) {
                assertDateEquals(toCalendar(year, 5, 4), JapaneseNationalHoliday.GreeneryDay.dateOf(year));
            }
        }
        // [���a�̓�]
        {
            // �K�p�J�n�O
            assertEquals(null, JapaneseNationalHoliday.ShowaDay.dateOf(2006));
            // �K�p�J�n��
            for (int year = 2007; year <= MAX_YEAR; year++) {
                assertDateEquals(toCalendar(year, 4, 29), JapaneseNationalHoliday.ShowaDay.dateOf(year));
            }
        }
        // [���@�L�O��]
        {
            // �K�p�J�n�O
            assertEquals(null, JapaneseNationalHoliday.ConstitutionMemorialDay.dateOf(1948));
            // �K�p�J�n��
            for (int year = 1949; year <= MAX_YEAR; year++) {
                assertDateEquals(toCalendar(year, 5, 3), JapaneseNationalHoliday.ConstitutionMemorialDay.dateOf(year));
            }
        }
        // [���ǂ��̓�]
        {
            // �K�p�J�n�O
            assertEquals(null, JapaneseNationalHoliday.ChildrensDay.dateOf(1948));
            // �K�p�J�n��
            for (int year = 1949; year <= MAX_YEAR; year++) {
                assertDateEquals(toCalendar(year, 5, 5), JapaneseNationalHoliday.ChildrensDay.dateOf(year));
            }
        }
        // [�C�̓�]
        {
            // �K�p�J�n�O
            assertEquals(null, JapaneseNationalHoliday.MarineDay.dateOf(1995));
            // �K�p�J�n��`�j���Œ�O
            for (int year = 1996; year <= 2002; year++) {
                assertDateEquals(toCalendar(year, 7, 20), JapaneseNationalHoliday.MarineDay.dateOf(year));
            }
            // �����ܗցE�p�������s�b�N���[�@�Ɋ�Â�2020�N�͓��t���قȂ�
            assertDateEquals(toCalendar(2020, 7, 23), JapaneseNationalHoliday.MarineDay.dateOf(2020));
            // ���� �����ܗցE�p�������s�b�N���[�@�Ɋ�Â�2021�N�͓��t���قȂ�
            assertDateEquals(toCalendar(2021, 7, 22), JapaneseNationalHoliday.MarineDay.dateOf(2021));
            // �j���Œ��
            assertDateEquals(toCalendar(2003, 7, 21), JapaneseNationalHoliday.MarineDay.dateOf(2003));
            assertDateEquals(toCalendar(2004, 7, 19), JapaneseNationalHoliday.MarineDay.dateOf(2004));
            assertDateEquals(toCalendar(2005, 7, 18), JapaneseNationalHoliday.MarineDay.dateOf(2005));
            assertDateEquals(toCalendar(2006, 7, 17), JapaneseNationalHoliday.MarineDay.dateOf(2006));
            assertDateEquals(toCalendar(2019, 7, 15), JapaneseNationalHoliday.MarineDay.dateOf(2019));
            assertDateEquals(toCalendar(2022, 7, 18), JapaneseNationalHoliday.MarineDay.dateOf(2022));
            assertDateEquals(toCalendar(2098, 7, 21), JapaneseNationalHoliday.MarineDay.dateOf(2098));
            assertDateEquals(toCalendar(2099, 7, 20), JapaneseNationalHoliday.MarineDay.dateOf(2099));
            assertDateEquals(toCalendar(2100, 7, 19), JapaneseNationalHoliday.MarineDay.dateOf(2100));
        }
        // [�R�̓�]
        {
            // �K�p�J�n�O
            assertEquals(null, JapaneseNationalHoliday.MountainDay.dateOf(2015));
            // �K�p�J�n��
            for (int year = 2016; year <= MAX_YEAR; year++) {
                if (year == 2020) {
                    // �����ܗցE�p�������s�b�N���[�@�Ɋ�Â�2020�N�͓��t���قȂ�
                    assertDateEquals(toCalendar(year, 8, 10), JapaneseNationalHoliday.MountainDay.dateOf(year));
                } else if (year == 2021) {
                    // ���� �����ܗցE�p�������s�b�N���[�@�Ɋ�Â�2021�N�͓��t���قȂ�
                    assertDateEquals(toCalendar(year, 8, 8), JapaneseNationalHoliday.MountainDay.dateOf(year));
                } else {
                    assertDateEquals(toCalendar(year, 8, 11), JapaneseNationalHoliday.MountainDay.dateOf(year));
                }
            }
        }
        // [�h�V�̓�]
        {
            // �K�p�J�n�O
            assertEquals(null, JapaneseNationalHoliday.RespectForTheAgedDay.dateOf(1965));
            // �K�p�J�n��`�j���Œ�O
            for (int year = 1966; year <= 2002; year++) {
                assertDateEquals(toCalendar(year, 9, 15), JapaneseNationalHoliday.RespectForTheAgedDay.dateOf(year));
            }
            // �j���Œ��
            assertDateEquals(toCalendar(2003, 9, 15), JapaneseNationalHoliday.RespectForTheAgedDay.dateOf(2003));
            assertDateEquals(toCalendar(2004, 9, 20), JapaneseNationalHoliday.RespectForTheAgedDay.dateOf(2004));
            assertDateEquals(toCalendar(2005, 9, 19), JapaneseNationalHoliday.RespectForTheAgedDay.dateOf(2005));
            assertDateEquals(toCalendar(2006, 9, 18), JapaneseNationalHoliday.RespectForTheAgedDay.dateOf(2006));
            assertDateEquals(toCalendar(2098, 9, 15), JapaneseNationalHoliday.RespectForTheAgedDay.dateOf(2098));
            assertDateEquals(toCalendar(2099, 9, 21), JapaneseNationalHoliday.RespectForTheAgedDay.dateOf(2099));
            assertDateEquals(toCalendar(2100, 9, 20), JapaneseNationalHoliday.RespectForTheAgedDay.dateOf(2100));
        }
        // [�H���̓�]
        {
            // �K�p�J�n�O
            assertEquals(null, JapaneseNationalHoliday.AutumnalEquinoxDay.dateOf(1947));
            // �K�p�J�n��
            for (Calendar c : autumnalEquinoxDays_) {
                assertDateEquals(c, JapaneseNationalHoliday.AutumnalEquinoxDay.dateOf(c.get(Calendar.YEAR)));
            }
            // 2151�N�ȍ~�͌v�Z�ł��Ȃ�
            assertThrows(IllegalArgumentException.class, () -> JapaneseNationalHoliday.AutumnalEquinoxDay.dateOf(2151));
        }
        // [�̈�̓�]
        {
            // �K�p�J�n�O
            assertEquals(null, JapaneseNationalHoliday.HealthAndSportsDay.dateOf(1965));
            // �K�p�J�n��`�j���Œ�O
            for (int year = 1966; year <= 1999; year++) {
                assertDateEquals(toCalendar(year, 10, 10), JapaneseNationalHoliday.HealthAndSportsDay.dateOf(year));
            }
            // �j���Œ��
            assertDateEquals(toCalendar(2000, 10, 9), JapaneseNationalHoliday.HealthAndSportsDay.dateOf(2000));
            assertDateEquals(toCalendar(2001, 10, 8), JapaneseNationalHoliday.HealthAndSportsDay.dateOf(2001));
            assertDateEquals(toCalendar(2002, 10, 14), JapaneseNationalHoliday.HealthAndSportsDay.dateOf(2002));
            assertDateEquals(toCalendar(2003, 10, 13), JapaneseNationalHoliday.HealthAndSportsDay.dateOf(2003));
            assertDateEquals(toCalendar(2017, 10, 9), JapaneseNationalHoliday.HealthAndSportsDay.dateOf(2017));
            assertDateEquals(toCalendar(2018, 10, 8), JapaneseNationalHoliday.HealthAndSportsDay.dateOf(2018));
            assertDateEquals(toCalendar(2019, 10, 14), JapaneseNationalHoliday.HealthAndSportsDay.dateOf(2019));
            // ���̕ύX��
            assertEquals(null, JapaneseNationalHoliday.HealthAndSportsDay.dateOf(2020));
        }
        // [�X�|�[�c�̓�]
        {
            // �K�p�J�n�O
            assertEquals(null, JapaneseNationalHoliday.SportsDay.dateOf(2019));
            // �����ܗցE�p�������s�b�N���[�@�Ɋ�Â�2020�N�͓��t���قȂ�
            assertDateEquals(toCalendar(2020, 7, 24), JapaneseNationalHoliday.SportsDay.dateOf(2020));
            // ���� �����ܗցE�p�������s�b�N���[�@�Ɋ�Â�2021�N�͓��t���قȂ�
            assertDateEquals(toCalendar(2021, 7, 23), JapaneseNationalHoliday.SportsDay.dateOf(2021));
            // �K�p�J�n��
            assertDateEquals(toCalendar(2022, 10, 10), JapaneseNationalHoliday.SportsDay.dateOf(2022));
            assertDateEquals(toCalendar(2023, 10, 9), JapaneseNationalHoliday.SportsDay.dateOf(2023));
            assertDateEquals(toCalendar(2098, 10, 13), JapaneseNationalHoliday.SportsDay.dateOf(2098));
            assertDateEquals(toCalendar(2099, 10, 12), JapaneseNationalHoliday.SportsDay.dateOf(2099));
            assertDateEquals(toCalendar(2100, 10, 11), JapaneseNationalHoliday.SportsDay.dateOf(2100));
        }
        // [�����̓�]
        {
            // �K�p�J�n�O
            assertEquals(null, JapaneseNationalHoliday.NationalCultureDay.dateOf(1947));
            // �K�p�J�n��
            for (int year = 1948; year <= MAX_YEAR; year++) {
                assertDateEquals(toCalendar(year, 11, 3), JapaneseNationalHoliday.NationalCultureDay.dateOf(year));
            }
        }
        // [�ΘJ���ӂ̓�]
        {
            // �K�p�J�n�O
            assertEquals(null, JapaneseNationalHoliday.LaborThanksgivingDay.dateOf(1947));
            // �K�p�J�n��
            for (int year = 1948; year <= MAX_YEAR; year++) {
                assertDateEquals(toCalendar(year, 11, 23), JapaneseNationalHoliday.LaborThanksgivingDay.dateOf(year));
            }
        }
    }

    @Test
    public void testIs() {
        final int MAX_YEAR = 3000;

        // [����]
        {
            // �K�p�J�n�O
            assertFalse(JapaneseNationalHoliday.NewYearsDay.is(toCalendar(1948, 1, 1)));
            // �K�p�J�n��
            for (int year = 1949; year <= MAX_YEAR; year++) {
                assertTrue(JapaneseNationalHoliday.NewYearsDay.is(toCalendar(year, 1, 1)));
                assertFalse(JapaneseNationalHoliday.NewYearsDay.is(toCalendar(year, 1, 2)));
            }
        }
        // [���l�̓�]
        {
            // �K�p�J�n�O
            assertFalse(JapaneseNationalHoliday.ComingOfAgeDay.is(toCalendar(1948, 1, 15)));
            // �K�p�J�n��`�j���Œ�O
            for (int year = 1949; year <= 1999; year++) {
                assertFalse(JapaneseNationalHoliday.ComingOfAgeDay.is(toCalendar(year, 1, 14)));
                assertTrue(JapaneseNationalHoliday.ComingOfAgeDay.is(toCalendar(year, 1, 15)));
                assertFalse(JapaneseNationalHoliday.ComingOfAgeDay.is(toCalendar(year, 1, 16)));
            }
            // �j���Œ��
            assertFalse(JapaneseNationalHoliday.ComingOfAgeDay.is(toCalendar(2000, 1, 9)));
            assertTrue(JapaneseNationalHoliday.ComingOfAgeDay.is(toCalendar(2000, 1, 10)));
            assertFalse(JapaneseNationalHoliday.ComingOfAgeDay.is(toCalendar(2000, 1, 11)));
            assertFalse(JapaneseNationalHoliday.ComingOfAgeDay.is(toCalendar(2001, 1, 7)));
            assertTrue(JapaneseNationalHoliday.ComingOfAgeDay.is(toCalendar(2001, 1, 8)));
            assertFalse(JapaneseNationalHoliday.ComingOfAgeDay.is(toCalendar(2001, 1, 9)));
            assertFalse(JapaneseNationalHoliday.ComingOfAgeDay.is(toCalendar(2002, 1, 13)));
            assertTrue(JapaneseNationalHoliday.ComingOfAgeDay.is(toCalendar(2002, 1, 14)));
            assertFalse(JapaneseNationalHoliday.ComingOfAgeDay.is(toCalendar(2002, 1, 15)));
            assertFalse(JapaneseNationalHoliday.ComingOfAgeDay.is(toCalendar(2003, 1, 12)));
            assertTrue(JapaneseNationalHoliday.ComingOfAgeDay.is(toCalendar(2003, 1, 13)));
            assertFalse(JapaneseNationalHoliday.ComingOfAgeDay.is(toCalendar(2003, 1, 14)));
            assertFalse(JapaneseNationalHoliday.ComingOfAgeDay.is(toCalendar(2098, 1, 12)));
            assertTrue(JapaneseNationalHoliday.ComingOfAgeDay.is(toCalendar(2098, 1, 13)));
            assertFalse(JapaneseNationalHoliday.ComingOfAgeDay.is(toCalendar(2098, 1, 14)));
            assertFalse(JapaneseNationalHoliday.ComingOfAgeDay.is(toCalendar(2099, 1, 11)));
            assertTrue(JapaneseNationalHoliday.ComingOfAgeDay.is(toCalendar(2099, 1, 12)));
            assertFalse(JapaneseNationalHoliday.ComingOfAgeDay.is(toCalendar(2099, 1, 13)));
            assertFalse(JapaneseNationalHoliday.ComingOfAgeDay.is(toCalendar(2100, 1, 10)));
            assertTrue(JapaneseNationalHoliday.ComingOfAgeDay.is(toCalendar(2100, 1, 11)));
            assertFalse(JapaneseNationalHoliday.ComingOfAgeDay.is(toCalendar(2100, 1, 12)));
        }
        // [�����L�O��]
        {
            // �K�p�J�n�O
            assertFalse(JapaneseNationalHoliday.NationalFoundationDay.is(toCalendar(1966, 2, 11)));
            // �K�p�J�n��
            for (int year = 1967; year <= MAX_YEAR; year++) {
                assertFalse(JapaneseNationalHoliday.NationalFoundationDay.is(toCalendar(year, 2, 10)));
                assertTrue(JapaneseNationalHoliday.NationalFoundationDay.is(toCalendar(year, 2, 11)));
                assertFalse(JapaneseNationalHoliday.NationalFoundationDay.is(toCalendar(year, 2, 12)));
            }
        }
        // [�V�c�a����]
        {
            // �K�p�J�n�O
            assertFalse(JapaneseNationalHoliday.EmperorsBirthday.is(toCalendar(1948, 4, 29)));
            // �K�p�J�n��`���t�ύX(1���)�O
            for (int year = 1949; year <= 1988; year++) {
                assertFalse(JapaneseNationalHoliday.EmperorsBirthday.is(toCalendar(year, 4, 28)));
                assertTrue(JapaneseNationalHoliday.EmperorsBirthday.is(toCalendar(year, 4, 29)));
                assertFalse(JapaneseNationalHoliday.EmperorsBirthday.is(toCalendar(year, 4, 30)));
                assertFalse(JapaneseNationalHoliday.EmperorsBirthday.is(toCalendar(year, 12, 23)));
                assertFalse(JapaneseNationalHoliday.EmperorsBirthday.is(toCalendar(year, 2, 23)));
            }
            // ���t�ύX(1���)��`���t�ύX(2���)�O
            for (int year = 1989; year <= 2018; year++) {
                assertFalse(JapaneseNationalHoliday.EmperorsBirthday.is(toCalendar(year, 12, 22)));
                assertTrue(JapaneseNationalHoliday.EmperorsBirthday.is(toCalendar(year, 12, 23)));
                assertFalse(JapaneseNationalHoliday.EmperorsBirthday.is(toCalendar(year, 12, 24)));
                assertFalse(JapaneseNationalHoliday.EmperorsBirthday.is(toCalendar(year, 4, 29)));
                assertFalse(JapaneseNationalHoliday.EmperorsBirthday.is(toCalendar(year, 2, 23)));
            }
            // 2019�N�͕���
            assertFalse(JapaneseNationalHoliday.EmperorsBirthday.is(toCalendar(2019, 4, 29)));
            assertFalse(JapaneseNationalHoliday.EmperorsBirthday.is(toCalendar(2019, 12, 23)));
            assertFalse(JapaneseNationalHoliday.EmperorsBirthday.is(toCalendar(2019, 2, 23)));
            // ���t�ύX(2���)��
            for (int year = 2020; year <= MAX_YEAR; year++) {
                assertFalse(JapaneseNationalHoliday.EmperorsBirthday.is(toCalendar(year, 2, 22)));
                assertTrue(JapaneseNationalHoliday.EmperorsBirthday.is(toCalendar(year, 2, 23)));
                assertFalse(JapaneseNationalHoliday.EmperorsBirthday.is(toCalendar(year, 2, 24)));
                assertFalse(JapaneseNationalHoliday.EmperorsBirthday.is(toCalendar(2019, 4, 29)));
                assertFalse(JapaneseNationalHoliday.EmperorsBirthday.is(toCalendar(2019, 12, 23)));
            }
        }
        // [�t���̓�]
        {
            // �K�p�J�n�O
            assertFalse(JapaneseNationalHoliday.VernalEquinoxDay.is(toCalendar(1948, 3, 20)));
            assertFalse(JapaneseNationalHoliday.VernalEquinoxDay.is(toCalendar(1948, 3, 21)));
            // �K�p�J�n��
            for (Calendar c : vernalEquinoxDays_) {
                assertFalse(JapaneseNationalHoliday.VernalEquinoxDay.is(yesterday(c)));
                assertTrue(JapaneseNationalHoliday.VernalEquinoxDay.is(c));
                assertFalse(JapaneseNationalHoliday.VernalEquinoxDay.is(tomorrow(c)));
            }
            // 2151�N�ȍ~�͌v�Z�ł��Ȃ�
            assertThrows(IllegalArgumentException.class, () -> JapaneseNationalHoliday.VernalEquinoxDay.is(toCalendar(2151, 3, 21)));
        }
        // [�݂ǂ�̓�]
        {
            // �K�p�J�n�O
            assertFalse(JapaneseNationalHoliday.GreeneryDay.is(toCalendar(1988, 4, 29)));
            // �K�p�J�n��`���t�ύX�O
            for (int year = 1989; year <= 2006; year++) {
                assertFalse(JapaneseNationalHoliday.GreeneryDay.is(toCalendar(year, 4, 28)));
                assertTrue(JapaneseNationalHoliday.GreeneryDay.is(toCalendar(year, 4, 29)));
                assertFalse(JapaneseNationalHoliday.GreeneryDay.is(toCalendar(year, 4, 30)));
                assertFalse(JapaneseNationalHoliday.GreeneryDay.is(toCalendar(year, 5, 4)));
            }
            // ���t�ύX��
            for (int year = 2007; year <= MAX_YEAR; year++) {
                assertFalse(JapaneseNationalHoliday.GreeneryDay.is(toCalendar(year, 5, 3)));
                assertTrue(JapaneseNationalHoliday.GreeneryDay.is(toCalendar(year, 5, 4)));
                assertFalse(JapaneseNationalHoliday.GreeneryDay.is(toCalendar(year, 5, 5)));
                assertFalse(JapaneseNationalHoliday.GreeneryDay.is(toCalendar(year, 4, 29)));
            }
        }
        // [���a�̓�]
        {
            // �K�p�J�n�O
            assertFalse(JapaneseNationalHoliday.ShowaDay.is(toCalendar(2006, 4, 29)));
            // �K�p�J�n��
            for (int year = 2007; year <= MAX_YEAR; year++) {
                assertFalse(JapaneseNationalHoliday.ShowaDay.is(toCalendar(year, 4, 28)));
                assertTrue(JapaneseNationalHoliday.ShowaDay.is(toCalendar(year, 4, 29)));
                assertFalse(JapaneseNationalHoliday.ShowaDay.is(toCalendar(year, 4, 30)));
            }
        }
        // [���@�L�O��]
        {
            // �K�p�J�n�O
            assertFalse(JapaneseNationalHoliday.ConstitutionMemorialDay.is(toCalendar(1948, 5, 3)));
            // �K�p�J�n��
            for (int year = 1949; year <= MAX_YEAR; year++) {
                assertFalse(JapaneseNationalHoliday.ConstitutionMemorialDay.is(toCalendar(year, 5, 2)));
                assertTrue(JapaneseNationalHoliday.ConstitutionMemorialDay.is(toCalendar(year, 5, 3)));
                assertFalse(JapaneseNationalHoliday.ConstitutionMemorialDay.is(toCalendar(year, 5, 4)));
            }
        }
        // [���ǂ��̓�]
        {
            // �K�p�J�n�O
            assertFalse(JapaneseNationalHoliday.ChildrensDay.is(toCalendar(1948, 5, 5)));
            // �K�p�J�n��
            for (int year = 1949; year <= MAX_YEAR; year++) {
                assertFalse(JapaneseNationalHoliday.ChildrensDay.is(toCalendar(year, 5, 4)));
                assertTrue(JapaneseNationalHoliday.ChildrensDay.is(toCalendar(year, 5, 5)));
                assertFalse(JapaneseNationalHoliday.ChildrensDay.is(toCalendar(year, 5, 6)));
            }
        }
        // [�C�̓�]
        {
            // �K�p�J�n�O
            assertFalse(JapaneseNationalHoliday.MarineDay.is(toCalendar(1995, 7, 20)));
            // �K�p�J�n��`�j���Œ�O
            for (int year = 1996; year <= 2002; year++) {
                assertFalse(JapaneseNationalHoliday.MarineDay.is(toCalendar(year, 7, 19)));
                assertTrue(JapaneseNationalHoliday.MarineDay.is(toCalendar(year, 7, 20)));
                assertFalse(JapaneseNationalHoliday.MarineDay.is(toCalendar(year, 7, 21)));
            }
            // �����ܗցE�p�������s�b�N���[�@�Ɋ�Â�2020�N�͓��t���قȂ�
            assertFalse(JapaneseNationalHoliday.MarineDay.is(toCalendar(2020, 7, 22)));
            assertTrue(JapaneseNationalHoliday.MarineDay.is(toCalendar(2020, 7, 23)));
            assertFalse(JapaneseNationalHoliday.MarineDay.is(toCalendar(2020, 7, 24)));
            // ���� �����ܗցE�p�������s�b�N���[�@�Ɋ�Â�2021�N�͓��t���قȂ�
            assertFalse(JapaneseNationalHoliday.MarineDay.is(toCalendar(2021, 7, 21)));
            assertTrue(JapaneseNationalHoliday.MarineDay.is(toCalendar(2021, 7, 22)));
            assertFalse(JapaneseNationalHoliday.MarineDay.is(toCalendar(2021, 7, 23)));
            // �j���Œ��
            assertFalse(JapaneseNationalHoliday.MarineDay.is(toCalendar(2003, 7, 20)));
            assertTrue(JapaneseNationalHoliday.MarineDay.is(toCalendar(2003, 7, 21)));
            assertFalse(JapaneseNationalHoliday.MarineDay.is(toCalendar(2003, 7, 22)));
            assertFalse(JapaneseNationalHoliday.MarineDay.is(toCalendar(2004, 7, 18)));
            assertTrue(JapaneseNationalHoliday.MarineDay.is(toCalendar(2004, 7, 19)));
            assertFalse(JapaneseNationalHoliday.MarineDay.is(toCalendar(2004, 7, 20)));
            assertFalse(JapaneseNationalHoliday.MarineDay.is(toCalendar(2005, 7, 17)));
            assertTrue(JapaneseNationalHoliday.MarineDay.is(toCalendar(2005, 7, 18)));
            assertFalse(JapaneseNationalHoliday.MarineDay.is(toCalendar(2005, 7, 19)));
            assertFalse(JapaneseNationalHoliday.MarineDay.is(toCalendar(2006, 7, 16)));
            assertTrue(JapaneseNationalHoliday.MarineDay.is(toCalendar(2006, 7, 17)));
            assertFalse(JapaneseNationalHoliday.MarineDay.is(toCalendar(2006, 7, 18)));
            assertFalse(JapaneseNationalHoliday.MarineDay.is(toCalendar(2019, 7, 14)));
            assertTrue(JapaneseNationalHoliday.MarineDay.is(toCalendar(2019, 7, 15)));
            assertFalse(JapaneseNationalHoliday.MarineDay.is(toCalendar(2019, 7, 16)));
            assertFalse(JapaneseNationalHoliday.MarineDay.is(toCalendar(2022, 7, 17)));
            assertTrue(JapaneseNationalHoliday.MarineDay.is(toCalendar(2022, 7, 18)));
            assertFalse(JapaneseNationalHoliday.MarineDay.is(toCalendar(2022, 7, 19)));
            assertFalse(JapaneseNationalHoliday.MarineDay.is(toCalendar(2098, 7, 20)));
            assertTrue(JapaneseNationalHoliday.MarineDay.is(toCalendar(2098, 7, 21)));
            assertFalse(JapaneseNationalHoliday.MarineDay.is(toCalendar(2098, 7, 22)));
            assertFalse(JapaneseNationalHoliday.MarineDay.is(toCalendar(2099, 7, 19)));
            assertTrue(JapaneseNationalHoliday.MarineDay.is(toCalendar(2099, 7, 20)));
            assertFalse(JapaneseNationalHoliday.MarineDay.is(toCalendar(2099, 7, 21)));
            assertFalse(JapaneseNationalHoliday.MarineDay.is(toCalendar(2100, 7, 18)));
            assertTrue(JapaneseNationalHoliday.MarineDay.is(toCalendar(2100, 7, 19)));
            assertFalse(JapaneseNationalHoliday.MarineDay.is(toCalendar(2100, 7, 20)));
        }
        // [�R�̓�]
        {
            // �K�p�J�n�O
            assertFalse(JapaneseNationalHoliday.MountainDay.is(toCalendar(2015, 8, 11)));
            // �K�p�J�n��
            for (int year = 2016; year <= MAX_YEAR; year++) {
                if (year == 2020) {
                    // �����ܗցE�p�������s�b�N���[�@�Ɋ�Â�2020�N�͓��t���قȂ�
                    assertFalse(JapaneseNationalHoliday.MountainDay.is(toCalendar(year, 8, 9)));
                    assertTrue(JapaneseNationalHoliday.MountainDay.is(toCalendar(year, 8, 10)));
                    assertFalse(JapaneseNationalHoliday.MountainDay.is(toCalendar(year, 8, 11)));
                } else if (year == 2021) {
                    // ���� �����ܗցE�p�������s�b�N���[�@�Ɋ�Â�2021�N�͓��t���قȂ�
                    assertFalse(JapaneseNationalHoliday.MountainDay.is(toCalendar(year, 8, 7)));
                    assertTrue(JapaneseNationalHoliday.MountainDay.is(toCalendar(year, 8, 8)));
                    assertFalse(JapaneseNationalHoliday.MountainDay.is(toCalendar(year, 8, 9)));
                } else {
                    assertFalse(JapaneseNationalHoliday.MountainDay.is(toCalendar(year, 8, 10)));
                    assertTrue(JapaneseNationalHoliday.MountainDay.is(toCalendar(year, 8, 11)));
                    assertFalse(JapaneseNationalHoliday.MountainDay.is(toCalendar(year, 8, 12)));
                }
            }
        }
        // [�h�V�̓�]
        {
            // �K�p�J�n�O
            assertFalse(JapaneseNationalHoliday.RespectForTheAgedDay.is(toCalendar(1965, 9, 15)));
            // �K�p�J�n��`�j���Œ�O
            for (int year = 1966; year <= 2002; year++) {
                assertFalse(JapaneseNationalHoliday.RespectForTheAgedDay.is(toCalendar(year, 9, 14)));
                assertTrue(JapaneseNationalHoliday.RespectForTheAgedDay.is(toCalendar(year, 9, 15)));
                assertFalse(JapaneseNationalHoliday.RespectForTheAgedDay.is(toCalendar(year, 9, 16)));
            }
            // �j���Œ��
            assertFalse(JapaneseNationalHoliday.RespectForTheAgedDay.is(toCalendar(2003, 9, 14)));
            assertTrue(JapaneseNationalHoliday.RespectForTheAgedDay.is(toCalendar(2003, 9, 15)));
            assertFalse(JapaneseNationalHoliday.RespectForTheAgedDay.is(toCalendar(2003, 9, 16)));
            assertFalse(JapaneseNationalHoliday.RespectForTheAgedDay.is(toCalendar(2004, 9, 19)));
            assertTrue(JapaneseNationalHoliday.RespectForTheAgedDay.is(toCalendar(2004, 9, 20)));
            assertFalse(JapaneseNationalHoliday.RespectForTheAgedDay.is(toCalendar(2004, 9, 21)));
            assertFalse(JapaneseNationalHoliday.RespectForTheAgedDay.is(toCalendar(2005, 9, 18)));
            assertTrue(JapaneseNationalHoliday.RespectForTheAgedDay.is(toCalendar(2005, 9, 19)));
            assertFalse(JapaneseNationalHoliday.RespectForTheAgedDay.is(toCalendar(2005, 9, 20)));
            assertFalse(JapaneseNationalHoliday.RespectForTheAgedDay.is(toCalendar(2006, 9, 17)));
            assertTrue(JapaneseNationalHoliday.RespectForTheAgedDay.is(toCalendar(2006, 9, 18)));
            assertFalse(JapaneseNationalHoliday.RespectForTheAgedDay.is(toCalendar(2006, 9, 19)));
            assertFalse(JapaneseNationalHoliday.RespectForTheAgedDay.is(toCalendar(2098, 9, 14)));
            assertTrue(JapaneseNationalHoliday.RespectForTheAgedDay.is(toCalendar(2098, 9, 15)));
            assertFalse(JapaneseNationalHoliday.RespectForTheAgedDay.is(toCalendar(2098, 9, 16)));
            assertFalse(JapaneseNationalHoliday.RespectForTheAgedDay.is(toCalendar(2099, 9, 20)));
            assertTrue(JapaneseNationalHoliday.RespectForTheAgedDay.is(toCalendar(2099, 9, 21)));
            assertFalse(JapaneseNationalHoliday.RespectForTheAgedDay.is(toCalendar(2099, 9, 22)));
            assertFalse(JapaneseNationalHoliday.RespectForTheAgedDay.is(toCalendar(2100, 9, 19)));
            assertTrue(JapaneseNationalHoliday.RespectForTheAgedDay.is(toCalendar(2100, 9, 20)));
            assertFalse(JapaneseNationalHoliday.RespectForTheAgedDay.is(toCalendar(2100, 9, 21)));
        }
        // [�H���̓�]
        {
            // �K�p�J�n�O
            assertFalse(JapaneseNationalHoliday.AutumnalEquinoxDay.is(toCalendar(1947, 9, 22)));
            assertFalse(JapaneseNationalHoliday.AutumnalEquinoxDay.is(toCalendar(1947, 9, 23)));
            assertFalse(JapaneseNationalHoliday.AutumnalEquinoxDay.is(toCalendar(1947, 9, 24)));
            // �K�p�J�n��
            for (Calendar c : autumnalEquinoxDays_) {
                assertFalse(JapaneseNationalHoliday.AutumnalEquinoxDay.is(yesterday(c)));
                assertTrue(JapaneseNationalHoliday.AutumnalEquinoxDay.is(c));
                assertFalse(JapaneseNationalHoliday.AutumnalEquinoxDay.is(tomorrow(c)));
            }
            // 2151�N�ȍ~�͌v�Z�ł��Ȃ�
            assertThrows(IllegalArgumentException.class, () -> JapaneseNationalHoliday.AutumnalEquinoxDay.is(toCalendar(2151, 9, 23)));
        }
        // [�̈�̓�]
        {
            // �K�p�J�n�O
            assertFalse(JapaneseNationalHoliday.HealthAndSportsDay.is(toCalendar(1965, 10, 10)));
            // �K�p�J�n��`�j���Œ�O
            for (int year = 1966; year <= 1999; year++) {
                assertFalse(JapaneseNationalHoliday.HealthAndSportsDay.is(toCalendar(year, 10, 9)));
                assertTrue(JapaneseNationalHoliday.HealthAndSportsDay.is(toCalendar(year, 10, 10)));
                assertFalse(JapaneseNationalHoliday.HealthAndSportsDay.is(toCalendar(year, 10, 11)));
            }
            // �j���Œ��
            assertFalse(JapaneseNationalHoliday.HealthAndSportsDay.is(toCalendar(2000, 10, 8)));
            assertTrue(JapaneseNationalHoliday.HealthAndSportsDay.is(toCalendar(2000, 10, 9)));
            assertFalse(JapaneseNationalHoliday.HealthAndSportsDay.is(toCalendar(2000, 10, 10)));
            assertFalse(JapaneseNationalHoliday.HealthAndSportsDay.is(toCalendar(2001, 10, 7)));
            assertTrue(JapaneseNationalHoliday.HealthAndSportsDay.is(toCalendar(2001, 10, 8)));
            assertFalse(JapaneseNationalHoliday.HealthAndSportsDay.is(toCalendar(2001, 10, 9)));
            assertFalse(JapaneseNationalHoliday.HealthAndSportsDay.is(toCalendar(2002, 10, 13)));
            assertTrue(JapaneseNationalHoliday.HealthAndSportsDay.is(toCalendar(2002, 10, 14)));
            assertFalse(JapaneseNationalHoliday.HealthAndSportsDay.is(toCalendar(2002, 10, 15)));
            assertFalse(JapaneseNationalHoliday.HealthAndSportsDay.is(toCalendar(2003, 10, 12)));
            assertTrue(JapaneseNationalHoliday.HealthAndSportsDay.is(toCalendar(2003, 10, 13)));
            assertFalse(JapaneseNationalHoliday.HealthAndSportsDay.is(toCalendar(2003, 10, 14)));
            assertFalse(JapaneseNationalHoliday.HealthAndSportsDay.is(toCalendar(2017, 10, 8)));
            assertTrue(JapaneseNationalHoliday.HealthAndSportsDay.is(toCalendar(2017, 10, 9)));
            assertFalse(JapaneseNationalHoliday.HealthAndSportsDay.is(toCalendar(2017, 10, 10)));
            assertFalse(JapaneseNationalHoliday.HealthAndSportsDay.is(toCalendar(2018, 10, 7)));
            assertTrue(JapaneseNationalHoliday.HealthAndSportsDay.is(toCalendar(2018, 10, 8)));
            assertFalse(JapaneseNationalHoliday.HealthAndSportsDay.is(toCalendar(2018, 10, 9)));
            assertFalse(JapaneseNationalHoliday.HealthAndSportsDay.is(toCalendar(2019, 10, 13)));
            assertTrue(JapaneseNationalHoliday.HealthAndSportsDay.is(toCalendar(2019, 10, 14)));
            assertFalse(JapaneseNationalHoliday.HealthAndSportsDay.is(toCalendar(2019, 10, 15)));
            // ���̕ύX��
            assertFalse(JapaneseNationalHoliday.HealthAndSportsDay.is(toCalendar(2020, 10, 12)));
        }
        // [�X�|�[�c�̓�]
        {
            // �K�p�J�n�O
            assertFalse(JapaneseNationalHoliday.SportsDay.is(toCalendar(2019, 10, 14)));
            // �����ܗցE�p�������s�b�N���[�@�Ɋ�Â�2020�N�͓��t���قȂ�
            assertFalse(JapaneseNationalHoliday.SportsDay.is(toCalendar(2020, 7, 23)));
            assertTrue(JapaneseNationalHoliday.SportsDay.is(toCalendar(2020, 7, 24)));
            assertFalse(JapaneseNationalHoliday.SportsDay.is(toCalendar(2020, 7, 25)));
            // ���� �����ܗցE�p�������s�b�N���[�@�Ɋ�Â�2021�N�͓��t���قȂ�
            assertFalse(JapaneseNationalHoliday.SportsDay.is(toCalendar(2021, 7, 22)));
            assertTrue(JapaneseNationalHoliday.SportsDay.is(toCalendar(2021, 7, 23)));
            assertFalse(JapaneseNationalHoliday.SportsDay.is(toCalendar(2021, 7, 24)));
            // �K�p�J�n��
            assertFalse(JapaneseNationalHoliday.SportsDay.is(toCalendar(2022, 10, 9)));
            assertTrue(JapaneseNationalHoliday.SportsDay.is(toCalendar(2022, 10, 10)));
            assertFalse(JapaneseNationalHoliday.SportsDay.is(toCalendar(2022, 10, 11)));
            assertFalse(JapaneseNationalHoliday.SportsDay.is(toCalendar(2023, 10, 8)));
            assertTrue(JapaneseNationalHoliday.SportsDay.is(toCalendar(2023, 10, 9)));
            assertFalse(JapaneseNationalHoliday.SportsDay.is(toCalendar(2023, 10, 10)));
            assertFalse(JapaneseNationalHoliday.SportsDay.is(toCalendar(2098, 10, 12)));
            assertTrue(JapaneseNationalHoliday.SportsDay.is(toCalendar(2098, 10, 13)));
            assertFalse(JapaneseNationalHoliday.SportsDay.is(toCalendar(2098, 10, 14)));
            assertFalse(JapaneseNationalHoliday.SportsDay.is(toCalendar(2099, 10, 11)));
            assertTrue(JapaneseNationalHoliday.SportsDay.is(toCalendar(2099, 10, 12)));
            assertFalse(JapaneseNationalHoliday.SportsDay.is(toCalendar(2099, 10, 13)));
            assertFalse(JapaneseNationalHoliday.SportsDay.is(toCalendar(2100, 10, 10)));
            assertTrue(JapaneseNationalHoliday.SportsDay.is(toCalendar(2100, 10, 11)));
            assertFalse(JapaneseNationalHoliday.SportsDay.is(toCalendar(2100, 10, 12)));
        }
        // [�����̓�]
        {
            // �K�p�J�n�O
            assertFalse(JapaneseNationalHoliday.NationalCultureDay.is(toCalendar(1947, 11, 3)));
            // �K�p�J�n��
            for (int year = 1948; year <= MAX_YEAR; year++) {
                assertFalse(JapaneseNationalHoliday.NationalCultureDay.is(toCalendar(year, 11, 2)));
                assertTrue(JapaneseNationalHoliday.NationalCultureDay.is(toCalendar(year, 11, 3)));
                assertFalse(JapaneseNationalHoliday.NationalCultureDay.is(toCalendar(year, 11, 4)));
            }
        }
        // [�ΘJ���ӂ̓�]
        {
            // �K�p�J�n�O
            assertFalse(JapaneseNationalHoliday.LaborThanksgivingDay.is(toCalendar(1947, 11, 23)));
            // �K�p�J�n��
            for (int year = 1948; year <= MAX_YEAR; year++) {
                assertFalse(JapaneseNationalHoliday.LaborThanksgivingDay.is(toCalendar(year, 11, 22)));
                assertTrue(JapaneseNationalHoliday.LaborThanksgivingDay.is(toCalendar(year, 11, 23)));
                assertFalse(JapaneseNationalHoliday.LaborThanksgivingDay.is(toCalendar(year, 11, 24)));
            }
        }
    }

    @Test
    public void testToString() {
        assertEquals("����", JapaneseNationalHoliday.NewYearsDay.toString());
        assertEquals("���l�̓�", JapaneseNationalHoliday.ComingOfAgeDay.toString());
        assertEquals("�����L�O�̓�", JapaneseNationalHoliday.NationalFoundationDay.toString());
        assertEquals("�V�c�a����", JapaneseNationalHoliday.EmperorsBirthday.toString());
        assertEquals("�t���̓�", JapaneseNationalHoliday.VernalEquinoxDay.toString());
        assertEquals("�݂ǂ�̓�", JapaneseNationalHoliday.GreeneryDay.toString());
        assertEquals("���a�̓�", JapaneseNationalHoliday.ShowaDay.toString());
        assertEquals("���@�L�O��", JapaneseNationalHoliday.ConstitutionMemorialDay.toString());
        assertEquals("���ǂ��̓�", JapaneseNationalHoliday.ChildrensDay.toString());
        assertEquals("�C�̓�", JapaneseNationalHoliday.MarineDay.toString());
        assertEquals("�R�̓�", JapaneseNationalHoliday.MountainDay.toString());
        assertEquals("�h�V�̓�", JapaneseNationalHoliday.RespectForTheAgedDay.toString());
        assertEquals("�H���̓�", JapaneseNationalHoliday.AutumnalEquinoxDay.toString());
        assertEquals("�̈�̓�", JapaneseNationalHoliday.HealthAndSportsDay.toString());
        assertEquals("�X�|�[�c�̓�", JapaneseNationalHoliday.SportsDay.toString());
        assertEquals("�����̓�", JapaneseNationalHoliday.NationalCultureDay.toString());
        assertEquals("�ΘJ���ӂ̓�", JapaneseNationalHoliday.LaborThanksgivingDay.toString());
    }
}
