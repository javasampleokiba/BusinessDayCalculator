package test.javasampleokiba.businessdaycalculator;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Calendar;

import org.junit.jupiter.api.Test;

import javasampleokiba.businessdaycalculator.BusinessDayCalculator;
import javasampleokiba.businessdaycalculator.BusinessDayCalculator.StartingPoint;
import javasampleokiba.businessdaycalculator.resolver.DefaultJapaneseDayOffResolver;
import test.TestBase;

/**
 * JUnit5によるBusinessDayCalculatorクラスのテスト
 */
public class BusinessDayCalculatorTest extends TestBase {

    @Test
    public void testBusinessDayCalculator() {
        assertThrows(NullPointerException.class, () -> new BusinessDayCalculator(null));
    }

    @Test
    public void testCountDays() {
        BusinessDayCalculator bdc = new BusinessDayCalculator(new DefaultJapaneseDayOffResolver());

        // 開始日付 = 終了日付 かつ平日
        assertEquals(0, bdc.countDays(toCalendar(2020, 4, 1), toCalendar(2020, 4, 1)));
        // 開始日付 = 終了日付 かつ土曜
        assertEquals(0, bdc.countDays(toCalendar(2020, 4, 4), toCalendar(2020, 4, 4)));
        // 開始日付 = 終了日付 かつ日曜
        assertEquals(0, bdc.countDays(toCalendar(2020, 4, 5), toCalendar(2020, 4, 5)));
        // 開始終了日付が一日違い かつ平日
        assertEquals(1, bdc.countDays(toCalendar(2020, 4, 1), toCalendar(2020, 4, 2)));
        assertEquals(-1, bdc.countDays(toCalendar(2020, 4, 1), toCalendar(2020, 3, 31)));
        // 開始終了日付が一日違い かつ開始が土曜
        assertEquals(0, bdc.countDays(toCalendar(2020, 4, 4), toCalendar(2020, 4, 5)));
        assertEquals(-1, bdc.countDays(toCalendar(2020, 4, 4), toCalendar(2020, 4, 3)));
        // 開始終了日付が一日違い かつ開始が日曜
        assertEquals(1, bdc.countDays(toCalendar(2020, 4, 5), toCalendar(2020, 4, 6)));
        assertEquals(0, bdc.countDays(toCalendar(2020, 4, 5), toCalendar(2020, 4, 4)));
        // 開始終了日付が一日違い かつ終了が土曜
        assertEquals(0, bdc.countDays(toCalendar(2020, 4, 3), toCalendar(2020, 4, 4)));
        assertEquals(0, bdc.countDays(toCalendar(2020, 4, 5), toCalendar(2020, 4, 4)));
        // 開始終了日付が一日違い かつ終了が日曜
        assertEquals(0, bdc.countDays(toCalendar(2020, 4, 4), toCalendar(2020, 4, 5)));
        assertEquals(0, bdc.countDays(toCalendar(2020, 4, 6), toCalendar(2020, 4, 5)));
        // 平日のみ
        assertEquals(4, bdc.countDays(toCalendar(2020, 4, 6), toCalendar(2020, 4, 10)));
        assertEquals(-2, bdc.countDays(toCalendar(2020, 4, 9), toCalendar(2020, 4, 7)));
        // 週をまたぎ祝日なし かつ開始終了が平日
        assertEquals(10, bdc.countDays(toCalendar(2020, 4, 1), toCalendar(2020, 4, 15)));
        assertEquals(-7, bdc.countDays(toCalendar(2020, 4, 28), toCalendar(2020, 4, 17)));
        // 週をまたぎ祝日なし かつ開始がnot平日
        assertEquals(8, bdc.countDays(toCalendar(2020, 4, 11), toCalendar(2020, 4, 22)));
        assertEquals(-10, bdc.countDays(toCalendar(2020, 4, 26), toCalendar(2020, 4, 13)));
        // 週をまたぎ祝日なし かつ終了がnot平日
        assertEquals(2, bdc.countDays(toCalendar(2020, 4, 15), toCalendar(2020, 4, 19)));
        assertEquals(-5, bdc.countDays(toCalendar(2020, 4, 13), toCalendar(2020, 4, 5)));
        // 祝日のみ
        assertEquals(0, bdc.countDays(toCalendar(2020, 5, 3), toCalendar(2020, 5, 6)));
        assertEquals(0, bdc.countDays(toCalendar(2020, 7, 24), toCalendar(2020, 7, 23)));
        // 平日と祝日のみ かつ開始終了が平日
        assertEquals(2, bdc.countDays(toCalendar(2020, 4, 27), toCalendar(2020, 4, 30)));
        assertEquals(-3, bdc.countDays(toCalendar(2020, 11, 6), toCalendar(2020, 11, 2)));
        // 平日と祝日のみ かつ開始が祝日
        assertEquals(4, bdc.countDays(toCalendar(2020, 8, 10), toCalendar(2020, 8, 14)));
        assertEquals(-2, bdc.countDays(toCalendar(2020, 9, 25), toCalendar(2020, 9, 21)));
        // 平日と祝日のみ かつ終了が祝日
        assertEquals(0, bdc.countDays(toCalendar(2020, 11, 2), toCalendar(2020, 11, 3)));
        assertEquals(-3, bdc.countDays(toCalendar(2020, 11, 27), toCalendar(2020, 11, 23)));
        // 平日と祝日のみ かつ開始終了が祝日
        assertEquals(2, bdc.countDays(toCalendar(2021, 9, 20), toCalendar(2021, 9, 23)));
        assertEquals(-1, bdc.countDays(toCalendar(2022, 5, 6), toCalendar(2022, 5, 2)));
        // 土日と祝日のみ かつ
        assertEquals(0, bdc.countDays(toCalendar(2020, 5, 2), toCalendar(2020, 5, 6)));
        assertEquals(0, bdc.countDays(toCalendar(2020, 11, 23), toCalendar(2020, 11, 21)));
        // 平日、土日、祝日すべて含む かつ一週間内
        assertEquals(4, bdc.countDays(toCalendar(2020, 2, 9), toCalendar(2020, 2, 15)));
        assertEquals(-3, bdc.countDays(toCalendar(2020, 7, 25), toCalendar(2020, 7, 19)));
        // 平日、土日、祝日すべて含む かつ月をまたぐ
        assertEquals(38, bdc.countDays(toCalendar(2020, 4, 1), toCalendar(2020, 5, 31)));
        assertEquals(-60, bdc.countDays(toCalendar(2020, 9, 30), toCalendar(2020, 7, 1)));
        // 平日、土日、祝日すべて含む かつ年をまたぐ
        assertEquals(61, bdc.countDays(toCalendar(2020, 11, 1), toCalendar(2021, 1, 31)));
        assertEquals(-81, bdc.countDays(toCalendar(2020, 2, 29), toCalendar(2019, 11, 1)));
        // 振替休日、国民の休日を含む
        assertEquals(2, bdc.countDays(toCalendar(2020, 5, 1), toCalendar(2020, 5, 8)));
        assertEquals(-1, bdc.countDays(toCalendar(2015, 9, 25), toCalendar(2015, 9, 21)));
        // 国民の祝日制定前のある一年の営業日数
        assertEquals(260, bdc.countDays(toCalendar(1947, 1, 1), toCalendar(1947, 12, 31)));
        // 国民の祝日制定後のある一年の営業日数
        assertEquals(249, bdc.countDays(toCalendar(2000, 1, 1), toCalendar(2000, 12, 31)));

        BusinessDayCalculator bdc2 = new BusinessDayCalculator(new DefaultJapaneseDayOffResolver() {

            @Override
            public boolean isDayOff(Calendar cal) {
                if (super.isDayOff(cal)) {
                    return true;
                }
                int day = cal.get(Calendar.DAY_OF_MONTH);
                return cal.get(Calendar.MONTH) == Calendar.JANUARY &&
                        (day == 2 || day == 3);
            }
        });
        // 三が日は休日とするパターン
        assertEquals(5, bdc2.countDays(toCalendar(2020, 1, 1), toCalendar(2020, 1, 10)));
    }

    @Test
    public void testGetDate() {
        BusinessDayCalculator bdc = new BusinessDayCalculator(new DefaultJapaneseDayOffResolver());

        // 営業日数=0 かつ平日
        assertDateEquals(toCalendar(2020, 4, 1), bdc.getDate(toCalendar(2020, 4, 1), 0));
        // 営業日数=0 かつnot平日
        assertDateEquals(toCalendar(2020, 4, 4), bdc.getDate(toCalendar(2020, 4, 4), 0));
        // 営業日数=1 かつ平日のみ
        assertDateEquals(toCalendar(2020, 4, 2), bdc.getDate(toCalendar(2020, 4, 1), 1));
        assertDateEquals(toCalendar(2020, 3, 31), bdc.getDate(toCalendar(2020, 4, 1), -1));
        // 営業日数=1 かつ土日をまたぐ
        assertDateEquals(toCalendar(2020, 4, 6), bdc.getDate(toCalendar(2020, 4, 3), 1));
        assertDateEquals(toCalendar(2020, 4, 6), bdc.getDate(toCalendar(2020, 4, 4), 1));
        assertDateEquals(toCalendar(2020, 4, 6), bdc.getDate(toCalendar(2020, 4, 5), 1));
        assertDateEquals(toCalendar(2020, 4, 3), bdc.getDate(toCalendar(2020, 4, 6), -1));
        assertDateEquals(toCalendar(2020, 4, 3), bdc.getDate(toCalendar(2020, 4, 5), -1));
        assertDateEquals(toCalendar(2020, 4, 3), bdc.getDate(toCalendar(2020, 4, 4), -1));
        // 営業日数=1 かつ祝日をまたぐ
        assertDateEquals(toCalendar(2020, 4, 30), bdc.getDate(toCalendar(2020, 4, 28), 1));
        assertDateEquals(toCalendar(2019, 12, 31), bdc.getDate(toCalendar(2020, 1, 2), -1));
        // 営業日数=2以上 かつ平日のみ
        assertDateEquals(toCalendar(2020, 4, 10), bdc.getDate(toCalendar(2020, 4, 6), 4));
        assertDateEquals(toCalendar(2020, 3, 30), bdc.getDate(toCalendar(2020, 4, 1), -2));
        // 営業日数=2以上 かつ土日をまたぐ
        assertDateEquals(toCalendar(2020, 4, 8), bdc.getDate(toCalendar(2020, 4, 1), 5));
        assertDateEquals(toCalendar(2020, 4, 3), bdc.getDate(toCalendar(2020, 4, 13), -6));
        // 営業日数=2以上 かつ祝日をまたぐ
        assertDateEquals(toCalendar(2020, 2, 14), bdc.getDate(toCalendar(2020, 2, 9), 4));
        assertDateEquals(toCalendar(2020, 4, 27), bdc.getDate(toCalendar(2020, 5, 1), -3));
        // 営業日数=2以上 かつ営業日が連続せずに土日祝日をまたぐ
        assertDateEquals(toCalendar(2020, 2, 26), bdc.getDate(toCalendar(2020, 2, 7), 11));
        assertDateEquals(toCalendar(2020, 7, 22), bdc.getDate(toCalendar(2020, 8, 12), -12));
        assertDateEquals(toCalendar(2020, 5, 12), bdc.getDate(toCalendar(2020, 5, 5), 4));
        assertDateEquals(toCalendar(2020, 9, 9), bdc.getDate(toCalendar(2020, 9, 22), -8));
        // 国民の祝日制定前のある一年の営業日数
        assertDateEquals(toCalendar(1947, 12, 31), bdc.getDate(toCalendar(1947, 1, 1), 260));
        // 国民の祝日制定後のある一年の営業日数
        assertDateEquals(toCalendar(2000, 12, 29), bdc.getDate(toCalendar(2000, 1, 1), 249));

        BusinessDayCalculator bdc2 = new BusinessDayCalculator(new DefaultJapaneseDayOffResolver() {

            @Override
            public boolean isDayOff(Calendar cal) {
                if (super.isDayOff(cal)) {
                    return true;
                }
                int day = cal.get(Calendar.DAY_OF_MONTH);
                return cal.get(Calendar.MONTH) == Calendar.JANUARY &&
                        (day == 2 || day == 3);
            }
        });
        // 三が日は休日とするパターン
        assertDateEquals(toCalendar(2020, 1, 10), bdc2.getDate(toCalendar(2020, 1, 1), 5));
    }

    @Test
    public void testGetFirstDay() {
        BusinessDayCalculator bdc = new BusinessDayCalculator(new DefaultJapaneseDayOffResolver());

        // 1947年の第1営業日 (年初が平日のケース)
        assertDateEquals(toCalendar(1947, 1, 1), bdc.getFirstDay(toCalendar(1947, 4, 1), StartingPoint.THIS_YEAR));
        // 2020年の第1営業日 (年初が休みのケース)
        assertDateEquals(toCalendar(2020, 1, 2), bdc.getFirstDay(toCalendar(2020, 6, 2), StartingPoint.THIS_YEAR));
        // 1978年の第3営業日 (1,2日が休みのケース)
        assertDateEquals(toCalendar(1978, 1, 5), bdc.getFirstDay(toCalendar(1978, 9, 3), StartingPoint.THIS_YEAR, 3));
        // 2030年の第10営業日
        assertDateEquals(toCalendar(2030, 1, 16), bdc.getFirstDay(toCalendar(2030, 12, 4), StartingPoint.THIS_YEAR, 10));
        // 1945年の翌年の第1営業日 (年初が平日のケース)
        assertDateEquals(toCalendar(1946, 1, 1), bdc.getFirstDay(toCalendar(1945, 4, 1), StartingPoint.NEXT_YEAR));
        // 1996年の翌年の第1営業日 (年初が休みのケース)
        assertDateEquals(toCalendar(1997, 1, 2), bdc.getFirstDay(toCalendar(1996, 6, 2), StartingPoint.NEXT_YEAR));
        // 2020年の翌年の第4営業日 (1〜3日が休みのケース)
        assertDateEquals(toCalendar(2021, 1, 7), bdc.getFirstDay(toCalendar(2020, 9, 3), StartingPoint.NEXT_YEAR, 4));
        // 2030年の翌年の第8営業日
        assertDateEquals(toCalendar(2031, 1, 14), bdc.getFirstDay(toCalendar(2030, 12, 4), StartingPoint.NEXT_YEAR, 8));
        // 1944年の前年の第1営業日 (年初が平日のケース)
        assertDateEquals(toCalendar(1943, 1, 1), bdc.getFirstDay(toCalendar(1944, 4, 1), StartingPoint.PREV_YEAR));
        // 1981年の前年の第1営業日 (年初が休みのケース)
        assertDateEquals(toCalendar(1980, 1, 2), bdc.getFirstDay(toCalendar(1981, 6, 2), StartingPoint.PREV_YEAR));
        // 1996年の前年の第2営業日 (1,2日が休みのケース)
        assertDateEquals(toCalendar(1995, 1, 4), bdc.getFirstDay(toCalendar(1996, 9, 3), StartingPoint.PREV_YEAR, 2));
        // 2050年の前年の第6営業日
        assertDateEquals(toCalendar(2049, 1, 12), bdc.getFirstDay(toCalendar(2050, 12, 4), StartingPoint.PREV_YEAR, 6));

        // 2020年4月の第1営業日 (月初が平日のケース)
        assertDateEquals(toCalendar(2020, 4, 1), bdc.getFirstDay(toCalendar(2020, 4, 1), StartingPoint.THIS_MONTH));
        // 2020年3月の第1営業日 (月初が休みのケース)
        assertDateEquals(toCalendar(2020, 3, 2), bdc.getFirstDay(toCalendar(2020, 3, 2), StartingPoint.THIS_MONTH));
        // 2020年8月の第5営業日 (1,2日が休みのケース)
        assertDateEquals(toCalendar(2020, 8, 7), bdc.getFirstDay(toCalendar(2020, 8, 15), StartingPoint.THIS_MONTH, 5));
        // 2020年9月の第10営業日
        assertDateEquals(toCalendar(2020, 9, 14), bdc.getFirstDay(toCalendar(2020, 9, 30), StartingPoint.THIS_MONTH, 10));
        // 2015年4月の翌月の第1営業日 (月初が平日のケース)
        assertDateEquals(toCalendar(2015, 5, 1), bdc.getFirstDay(toCalendar(2015, 4, 1), StartingPoint.NEXT_MONTH));
        // 2015年2月の翌月の第1営業日 (月初が休みのケース)
        assertDateEquals(toCalendar(2015, 3, 2), bdc.getFirstDay(toCalendar(2015, 2, 2), StartingPoint.NEXT_MONTH));
        // 2015年7月の翌月の第4営業日 (1,2日が休みのケース)
        assertDateEquals(toCalendar(2015, 8, 6), bdc.getFirstDay(toCalendar(2015, 7, 15), StartingPoint.NEXT_MONTH, 4));
        // 2015年10月の翌月の第8営業日
        assertDateEquals(toCalendar(2015, 11, 12), bdc.getFirstDay(toCalendar(2015, 10, 31), StartingPoint.NEXT_MONTH, 8));
        // 2023年10月の前月の第1営業日 (月初が平日のケース)
        assertDateEquals(toCalendar(2023, 9, 1), bdc.getFirstDay(toCalendar(2023, 10, 1), StartingPoint.PREV_MONTH));
        // 2023年11月の前月の第1営業日 (月初が休みのケース)
        assertDateEquals(toCalendar(2023, 10, 2), bdc.getFirstDay(toCalendar(2023, 11, 2), StartingPoint.PREV_MONTH));
        // 2023年5月の前月の第2営業日 (1,2日が休みのケース)
        assertDateEquals(toCalendar(2023, 4, 4), bdc.getFirstDay(toCalendar(2023, 5, 15), StartingPoint.PREV_MONTH, 2));
        // 2023年6月の前月の第6営業日
        assertDateEquals(toCalendar(2023, 5, 11), bdc.getFirstDay(toCalendar(2023, 6, 30), StartingPoint.PREV_MONTH, 6));

        // 2020年4月1週の第1営業日 (月曜が平日のケース)
        assertDateEquals(toCalendar(2020, 3, 30), bdc.getFirstDay(toCalendar(2020, 4, 4), StartingPoint.THIS_WEEK));
        // 2020年1月3週の第1営業日 (月曜が休みのケース)
        assertDateEquals(toCalendar(2020, 1, 14), bdc.getFirstDay(toCalendar(2020, 1, 12), StartingPoint.THIS_WEEK));
        // 2020年9月4週の第2営業日 (月火曜が休みのケース)
        assertDateEquals(toCalendar(2020, 9, 24), bdc.getFirstDay(toCalendar(2020, 9, 23), StartingPoint.THIS_WEEK, 2));
        // 2020年11月1週の第10営業日
        assertDateEquals(toCalendar(2020, 11, 16), bdc.getFirstDay(toCalendar(2020, 11, 2), StartingPoint.THIS_WEEK, 10));
        // 2020年11月5週の翌週の第1営業日 (月曜が平日のケース)
        assertDateEquals(toCalendar(2020, 12, 7), bdc.getFirstDay(toCalendar(2020, 11, 30), StartingPoint.NEXT_WEEK));
        // 2020年8月2週の翌週の第1営業日 (月曜が休みのケース)
        assertDateEquals(toCalendar(2020, 8, 11), bdc.getFirstDay(toCalendar(2020, 8, 2), StartingPoint.NEXT_WEEK));
        // 2020年5月1週の翌週の第2営業日 (月火水曜が休みのケース)
        assertDateEquals(toCalendar(2020, 5, 8), bdc.getFirstDay(toCalendar(2020, 4, 26), StartingPoint.NEXT_WEEK, 2));
        // 2020年7月3週の翌週の第9営業日
        assertDateEquals(toCalendar(2020, 8, 3), bdc.getFirstDay(toCalendar(2020, 7, 15), StartingPoint.NEXT_WEEK, 9));
        // 2020年2月4週の前週の第1営業日 (月曜が平日のケース)
        assertDateEquals(toCalendar(2020, 2, 10), bdc.getFirstDay(toCalendar(2020, 2, 17), StartingPoint.PREV_WEEK));
        // 2020年3月1週の前週の第1営業日 (月曜が休みのケース)
        assertDateEquals(toCalendar(2020, 2, 25), bdc.getFirstDay(toCalendar(2020, 3, 7), StartingPoint.PREV_WEEK));
        // 2020年10月1週の前週の第3営業日 (月火曜が休みのケース)
        assertDateEquals(toCalendar(2020, 9, 25), bdc.getFirstDay(toCalendar(2020, 10, 1), StartingPoint.PREV_WEEK, 3));
        // 2020年1月1週の前週の第6営業日
        assertDateEquals(toCalendar(2019, 12, 30), bdc.getFirstDay(toCalendar(2020, 1, 1), StartingPoint.PREV_WEEK, 6));

        // 引数不正
        assertThrows(IllegalArgumentException.class, () -> bdc.getFirstDay(toCalendar(2020, 4, 1), StartingPoint.THIS_YEAR, 0));
        assertThrows(IllegalArgumentException.class, () -> bdc.getFirstDay(toCalendar(2020, 4, 1), StartingPoint.NEXT_YEAR, 0));
        assertThrows(IllegalArgumentException.class, () -> bdc.getFirstDay(toCalendar(2020, 4, 1), StartingPoint.PREV_YEAR, 0));
        assertThrows(IllegalArgumentException.class, () -> bdc.getFirstDay(toCalendar(2020, 4, 1), StartingPoint.THIS_MONTH, 0));
        assertThrows(IllegalArgumentException.class, () -> bdc.getFirstDay(toCalendar(2020, 4, 1), StartingPoint.NEXT_MONTH, 0));
        assertThrows(IllegalArgumentException.class, () -> bdc.getFirstDay(toCalendar(2020, 4, 1), StartingPoint.PREV_MONTH, 0));
        assertThrows(IllegalArgumentException.class, () -> bdc.getFirstDay(toCalendar(2020, 4, 1), StartingPoint.THIS_WEEK, 0));
        assertThrows(IllegalArgumentException.class, () -> bdc.getFirstDay(toCalendar(2020, 4, 1), StartingPoint.NEXT_WEEK, 0));
        assertThrows(IllegalArgumentException.class, () -> bdc.getFirstDay(toCalendar(2020, 4, 1), StartingPoint.PREV_WEEK, 0));
    }

    @Test
    public void testGetLastDay() {
        BusinessDayCalculator bdc = new BusinessDayCalculator(new DefaultJapaneseDayOffResolver());

        // 2020年の最後の日付からの第1営業日 (年末が平日のケース)
        assertDateEquals(toCalendar(2020, 12, 31), bdc.getLastDay(toCalendar(2020, 1, 1), StartingPoint.THIS_YEAR));
        // 2016年の最後の日付からの第1営業日 (年末が休みのケース)
        assertDateEquals(toCalendar(2016, 12, 30), bdc.getLastDay(toCalendar(2016, 3, 2), StartingPoint.THIS_YEAR));
        // 2017年の最後の日付からの第3営業日 (30,31日が休みのケース)
        assertDateEquals(toCalendar(2017, 12, 27), bdc.getLastDay(toCalendar(2017, 5, 3), StartingPoint.THIS_YEAR, 3));
        // 2030年の最後の日付からの第10営業日
        assertDateEquals(toCalendar(2030, 12, 18), bdc.getLastDay(toCalendar(2030, 8, 4), StartingPoint.THIS_YEAR, 10));
        // 1944年の翌年の最後の日付からの第1営業日 (年末が平日のケース)
        assertDateEquals(toCalendar(1945, 12, 31), bdc.getLastDay(toCalendar(1944, 1, 1), StartingPoint.NEXT_YEAR));
        // 1993年の翌年の最後の日付からの第1営業日 (年末が休みのケース)
        assertDateEquals(toCalendar(1994, 12, 30), bdc.getLastDay(toCalendar(1993, 3, 2), StartingPoint.NEXT_YEAR));
        // 1994年の翌年の最後の日付からの第4営業日 (30,31日が休みのケース)
        assertDateEquals(toCalendar(1995, 12, 26), bdc.getLastDay(toCalendar(1994, 5, 3), StartingPoint.NEXT_YEAR, 4));
        // 2030年の翌年の最後の日付からの第8営業日
        assertDateEquals(toCalendar(2031, 12, 22), bdc.getLastDay(toCalendar(2030, 8, 4), StartingPoint.NEXT_YEAR, 8));
        // 1971年の前年の最後の日付からの第1営業日 (年初が平日のケース)
        assertDateEquals(toCalendar(1970, 12, 31), bdc.getLastDay(toCalendar(1971, 1, 1), StartingPoint.PREV_YEAR));
        // 1978年の前年の最後の日付からの第1営業日 (年初が休みのケース)
        assertDateEquals(toCalendar(1977, 12, 30), bdc.getLastDay(toCalendar(1978, 3, 2), StartingPoint.PREV_YEAR));
        // 1973年の前年の最後の日付からの第2営業日 (30,31日が休みのケース)
        assertDateEquals(toCalendar(1972, 12, 28), bdc.getLastDay(toCalendar(1973, 5, 3), StartingPoint.PREV_YEAR, 2));
        // 2050年の前年の最後の日付からの第6営業日
        assertDateEquals(toCalendar(2049, 12, 24), bdc.getLastDay(toCalendar(2050, 8, 4), StartingPoint.PREV_YEAR, 6));

        // 2000年5月の最後の日付からの第1営業日 (月末が平日のケース)
        assertDateEquals(toCalendar(2000, 5, 31), bdc.getLastDay(toCalendar(2000, 5, 1), StartingPoint.THIS_MONTH));
        // 2000年9月の最後の日付からの第1営業日 (月末が休みのケース)
        assertDateEquals(toCalendar(2000, 9, 29), bdc.getLastDay(toCalendar(2000, 9, 2), StartingPoint.THIS_MONTH));
        // 2000年4月の最後の日付からの第5営業日 (29,30日が休みのケース)
        assertDateEquals(toCalendar(2000, 4, 24), bdc.getLastDay(toCalendar(2000, 4, 15), StartingPoint.THIS_MONTH, 5));
        // 2000年12月の最後の日付からの第10営業日
        assertDateEquals(toCalendar(2000, 12, 18), bdc.getLastDay(toCalendar(2000, 12, 30), StartingPoint.THIS_MONTH, 10));
        // 1990年1月の翌月の最後の日付からの第1営業日 (月末が平日のケース)
        assertDateEquals(toCalendar(1990, 2, 28), bdc.getLastDay(toCalendar(1990, 1, 1), StartingPoint.NEXT_MONTH));
        // 1990年5月の翌月の最後の日付からの第1営業日 (月末が休みのケース)
        assertDateEquals(toCalendar(1990, 6, 29), bdc.getLastDay(toCalendar(1990, 5, 2), StartingPoint.NEXT_MONTH));
        // 1990年3月の翌月の最後の日付からの第4営業日 (28,29,30日が休みのケース)
        assertDateEquals(toCalendar(1990, 4, 24), bdc.getLastDay(toCalendar(1990, 3, 15), StartingPoint.NEXT_MONTH, 4));
        // 1990年10月の翌月の最後の日付からの第8営業日
        assertDateEquals(toCalendar(1990, 11, 20), bdc.getLastDay(toCalendar(1990, 10, 31), StartingPoint.NEXT_MONTH, 8));
        // 2040年2月の前月の最後の日付からの第1営業日 (月末が平日のケース)
        assertDateEquals(toCalendar(2040, 1, 31), bdc.getLastDay(toCalendar(2040, 2, 1), StartingPoint.PREV_MONTH));
        // 2040年4月の前月の最後の日付からの第1営業日 (月末が休みのケース)
        assertDateEquals(toCalendar(2040, 3, 30), bdc.getLastDay(toCalendar(2040, 4, 2), StartingPoint.PREV_MONTH));
        // 2040年10月の前月の最後の日付からの第2営業日 (29,30日が休みのケース)
        assertDateEquals(toCalendar(2040, 9, 27), bdc.getLastDay(toCalendar(2040, 10, 15), StartingPoint.PREV_MONTH, 2));
        // 2040年12月の前月の最後の日付からの第6営業日
        assertDateEquals(toCalendar(2040, 11, 22), bdc.getLastDay(toCalendar(2040, 12, 30), StartingPoint.PREV_MONTH, 6));

        // 2001年1月2週の最後の日付からの第1営業日 (金曜が平日のケース)
        assertDateEquals(toCalendar(2001, 1, 12), bdc.getLastDay(toCalendar(2001, 1, 7), StartingPoint.THIS_WEEK));
        // 2001年7月3週の最後の日付からの第1営業日 (金曜が休みのケース)
        assertDateEquals(toCalendar(2001, 7, 19), bdc.getLastDay(toCalendar(2001, 7, 21), StartingPoint.THIS_WEEK));
        // 2001年5月1週の最後の日付からの第2営業日 (木金曜が休みのケース)
        assertDateEquals(toCalendar(2001, 5, 1), bdc.getLastDay(toCalendar(2001, 5, 2), StartingPoint.THIS_WEEK, 2));
        // 2001年12月5週の最後の日付からの第10営業日
        assertDateEquals(toCalendar(2001, 12, 14), bdc.getLastDay(toCalendar(2001, 12, 26), StartingPoint.THIS_WEEK, 10));
        // 2001年6月3週の翌週の最後の日付からの第1営業日 (金曜が平日のケース)
        assertDateEquals(toCalendar(2001, 6, 22), bdc.getLastDay(toCalendar(2001, 6, 10), StartingPoint.NEXT_WEEK));
        // 2001年11月3週の翌週の最後の日付からの第1営業日 (金曜が休みのケース)
        assertDateEquals(toCalendar(2001, 11, 22), bdc.getLastDay(toCalendar(2001, 11, 17), StartingPoint.NEXT_WEEK));
        // 2001年4月5週の翌週の最後の日付からの第2営業日 (木金曜が休みのケース)
        assertDateEquals(toCalendar(2001, 5, 1), bdc.getLastDay(toCalendar(2001, 4, 23), StartingPoint.NEXT_WEEK, 2));
        // 2001年10月1週の翌週の最後の日付からの第9営業日
        assertDateEquals(toCalendar(2001, 10, 1), bdc.getLastDay(toCalendar(2001, 10, 3), StartingPoint.NEXT_WEEK, 9));
        // 2001年3月5週の前週の最後の日付からの第1営業日 (金曜が平日のケース)
        assertDateEquals(toCalendar(2001, 3, 23), bdc.getLastDay(toCalendar(2001, 3, 31), StartingPoint.PREV_WEEK));
        // 2001年7月4週の前週の最後の日付からの第1営業日 (金曜が休みのケース)
        assertDateEquals(toCalendar(2001, 7, 19), bdc.getLastDay(toCalendar(2001, 7, 25), StartingPoint.PREV_WEEK));
        // 2001年5月2週の前週の最後の日付からの第3営業日 (月火曜が休みのケース)
        assertDateEquals(toCalendar(2001, 4, 27), bdc.getLastDay(toCalendar(2001, 5, 6), StartingPoint.PREV_WEEK, 3));
        // 2001年1月2週の前週の最後の日付からの第6営業日
        assertDateEquals(toCalendar(2000, 12, 28), bdc.getLastDay(toCalendar(2001, 1, 8), StartingPoint.PREV_WEEK, 6));

        // 引数不正
        assertThrows(IllegalArgumentException.class, () -> bdc.getLastDay(toCalendar(2020, 4, 1), StartingPoint.THIS_YEAR, 0));
        assertThrows(IllegalArgumentException.class, () -> bdc.getLastDay(toCalendar(2020, 4, 1), StartingPoint.NEXT_YEAR, 0));
        assertThrows(IllegalArgumentException.class, () -> bdc.getLastDay(toCalendar(2020, 4, 1), StartingPoint.PREV_YEAR, 0));
        assertThrows(IllegalArgumentException.class, () -> bdc.getLastDay(toCalendar(2020, 4, 1), StartingPoint.THIS_MONTH, 0));
        assertThrows(IllegalArgumentException.class, () -> bdc.getLastDay(toCalendar(2020, 4, 1), StartingPoint.NEXT_MONTH, 0));
        assertThrows(IllegalArgumentException.class, () -> bdc.getLastDay(toCalendar(2020, 4, 1), StartingPoint.PREV_MONTH, 0));
        assertThrows(IllegalArgumentException.class, () -> bdc.getLastDay(toCalendar(2020, 4, 1), StartingPoint.THIS_WEEK, 0));
        assertThrows(IllegalArgumentException.class, () -> bdc.getLastDay(toCalendar(2020, 4, 1), StartingPoint.NEXT_WEEK, 0));
        assertThrows(IllegalArgumentException.class, () -> bdc.getLastDay(toCalendar(2020, 4, 1), StartingPoint.PREV_WEEK, 0));
    }
}
