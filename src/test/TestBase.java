package test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Calendar;

/**
 * テスト用クラスのベースクラス
 */
public class TestBase {

    public static Calendar toCalendar(int year, int month, int day) {
        Calendar cal = Calendar.getInstance();
        cal.set(year, month - 1, day);
        return cal;
    }

    public static Calendar yesterday(Calendar cal) {
        Calendar c = (Calendar) cal.clone();
        c.add(Calendar.DAY_OF_YEAR, -1);
        return c;
    }

    public static Calendar tomorrow(Calendar cal) {
        Calendar c = (Calendar) cal.clone();
        c.add(Calendar.DAY_OF_YEAR, 1);
        return c;
    }

    public static boolean isSameDate(Calendar cal1, Calendar cal2) {
        return cal1.get(Calendar.YEAR) == cal2.get(Calendar.YEAR) &&
                cal1.get(Calendar.MONTH) == cal2.get(Calendar.MONTH) &&
                cal1.get(Calendar.DAY_OF_MONTH) == cal2.get(Calendar.DAY_OF_MONTH);
    }

    public static void assertDateEquals(Calendar cal1, Calendar cal2) {
        assertEquals(cal1.get(Calendar.YEAR), cal2.get(Calendar.YEAR));
        assertEquals(cal1.get(Calendar.MONTH), cal2.get(Calendar.MONTH));
        assertEquals(cal1.get(Calendar.DAY_OF_MONTH), cal2.get(Calendar.DAY_OF_MONTH));
    }
}
