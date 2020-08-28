package test.javasampleokiba.businessdaycalculator;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Calendar;

import org.junit.jupiter.api.Test;

import javasampleokiba.businessdaycalculator.BusinessDayCalculator;
import javasampleokiba.businessdaycalculator.BusinessDayCalculator.StartingPoint;
import javasampleokiba.businessdaycalculator.resolver.DefaultJapaneseDayOffResolver;
import test.TestBase;

/**
 * JUnit5‚É‚æ‚éBusinessDayCalculatorƒNƒ‰ƒX‚ÌƒeƒXƒg
 */
public class BusinessDayCalculatorTest extends TestBase {

    @Test
    public void testBusinessDayCalculator() {
        assertThrows(NullPointerException.class, () -> new BusinessDayCalculator(null));
    }

    @Test
    public void testCountDays() {
        BusinessDayCalculator bdc = new BusinessDayCalculator(new DefaultJapaneseDayOffResolver());

        // ŠJŽn“ú•t = I—¹“ú•t ‚©‚Â•½“ú
        assertEquals(0, bdc.countDays(toCalendar(2020, 4, 1), toCalendar(2020, 4, 1)));
        // ŠJŽn“ú•t = I—¹“ú•t ‚©‚Â“y—j
        assertEquals(0, bdc.countDays(toCalendar(2020, 4, 4), toCalendar(2020, 4, 4)));
        // ŠJŽn“ú•t = I—¹“ú•t ‚©‚Â“ú—j
        assertEquals(0, bdc.countDays(toCalendar(2020, 4, 5), toCalendar(2020, 4, 5)));
        // ŠJŽnI—¹“ú•t‚ªˆê“úˆá‚¢ ‚©‚Â•½“ú
        assertEquals(1, bdc.countDays(toCalendar(2020, 4, 1), toCalendar(2020, 4, 2)));
        assertEquals(-1, bdc.countDays(toCalendar(2020, 4, 1), toCalendar(2020, 3, 31)));
        // ŠJŽnI—¹“ú•t‚ªˆê“úˆá‚¢ ‚©‚ÂŠJŽn‚ª“y—j
        assertEquals(0, bdc.countDays(toCalendar(2020, 4, 4), toCalendar(2020, 4, 5)));
        assertEquals(-1, bdc.countDays(toCalendar(2020, 4, 4), toCalendar(2020, 4, 3)));
        // ŠJŽnI—¹“ú•t‚ªˆê“úˆá‚¢ ‚©‚ÂŠJŽn‚ª“ú—j
        assertEquals(1, bdc.countDays(toCalendar(2020, 4, 5), toCalendar(2020, 4, 6)));
        assertEquals(0, bdc.countDays(toCalendar(2020, 4, 5), toCalendar(2020, 4, 4)));
        // ŠJŽnI—¹“ú•t‚ªˆê“úˆá‚¢ ‚©‚ÂI—¹‚ª“y—j
        assertEquals(0, bdc.countDays(toCalendar(2020, 4, 3), toCalendar(2020, 4, 4)));
        assertEquals(0, bdc.countDays(toCalendar(2020, 4, 5), toCalendar(2020, 4, 4)));
        // ŠJŽnI—¹“ú•t‚ªˆê“úˆá‚¢ ‚©‚ÂI—¹‚ª“ú—j
        assertEquals(0, bdc.countDays(toCalendar(2020, 4, 4), toCalendar(2020, 4, 5)));
        assertEquals(0, bdc.countDays(toCalendar(2020, 4, 6), toCalendar(2020, 4, 5)));
        // •½“ú‚Ì‚Ý
        assertEquals(4, bdc.countDays(toCalendar(2020, 4, 6), toCalendar(2020, 4, 10)));
        assertEquals(-2, bdc.countDays(toCalendar(2020, 4, 9), toCalendar(2020, 4, 7)));
        // T‚ð‚Ü‚½‚¬j“ú‚È‚µ ‚©‚ÂŠJŽnI—¹‚ª•½“ú
        assertEquals(10, bdc.countDays(toCalendar(2020, 4, 1), toCalendar(2020, 4, 15)));
        assertEquals(-7, bdc.countDays(toCalendar(2020, 4, 28), toCalendar(2020, 4, 17)));
        // T‚ð‚Ü‚½‚¬j“ú‚È‚µ ‚©‚ÂŠJŽn‚ªnot•½“ú
        assertEquals(8, bdc.countDays(toCalendar(2020, 4, 11), toCalendar(2020, 4, 22)));
        assertEquals(-10, bdc.countDays(toCalendar(2020, 4, 26), toCalendar(2020, 4, 13)));
        // T‚ð‚Ü‚½‚¬j“ú‚È‚µ ‚©‚ÂI—¹‚ªnot•½“ú
        assertEquals(2, bdc.countDays(toCalendar(2020, 4, 15), toCalendar(2020, 4, 19)));
        assertEquals(-5, bdc.countDays(toCalendar(2020, 4, 13), toCalendar(2020, 4, 5)));
        // j“ú‚Ì‚Ý
        assertEquals(0, bdc.countDays(toCalendar(2020, 5, 3), toCalendar(2020, 5, 6)));
        assertEquals(0, bdc.countDays(toCalendar(2020, 7, 24), toCalendar(2020, 7, 23)));
        // •½“ú‚Æj“ú‚Ì‚Ý ‚©‚ÂŠJŽnI—¹‚ª•½“ú
        assertEquals(2, bdc.countDays(toCalendar(2020, 4, 27), toCalendar(2020, 4, 30)));
        assertEquals(-3, bdc.countDays(toCalendar(2020, 11, 6), toCalendar(2020, 11, 2)));
        // •½“ú‚Æj“ú‚Ì‚Ý ‚©‚ÂŠJŽn‚ªj“ú
        assertEquals(4, bdc.countDays(toCalendar(2020, 8, 10), toCalendar(2020, 8, 14)));
        assertEquals(-2, bdc.countDays(toCalendar(2020, 9, 25), toCalendar(2020, 9, 21)));
        // •½“ú‚Æj“ú‚Ì‚Ý ‚©‚ÂI—¹‚ªj“ú
        assertEquals(0, bdc.countDays(toCalendar(2020, 11, 2), toCalendar(2020, 11, 3)));
        assertEquals(-3, bdc.countDays(toCalendar(2020, 11, 27), toCalendar(2020, 11, 23)));
        // •½“ú‚Æj“ú‚Ì‚Ý ‚©‚ÂŠJŽnI—¹‚ªj“ú
        assertEquals(2, bdc.countDays(toCalendar(2021, 9, 20), toCalendar(2021, 9, 23)));
        assertEquals(-1, bdc.countDays(toCalendar(2022, 5, 6), toCalendar(2022, 5, 2)));
        // “y“ú‚Æj“ú‚Ì‚Ý ‚©‚Â
        assertEquals(0, bdc.countDays(toCalendar(2020, 5, 2), toCalendar(2020, 5, 6)));
        assertEquals(0, bdc.countDays(toCalendar(2020, 11, 23), toCalendar(2020, 11, 21)));
        // •½“úA“y“úAj“ú‚·‚×‚ÄŠÜ‚Þ ‚©‚ÂˆêTŠÔ“à
        assertEquals(4, bdc.countDays(toCalendar(2020, 2, 9), toCalendar(2020, 2, 15)));
        assertEquals(-3, bdc.countDays(toCalendar(2020, 7, 25), toCalendar(2020, 7, 19)));
        // •½“úA“y“úAj“ú‚·‚×‚ÄŠÜ‚Þ ‚©‚ÂŒŽ‚ð‚Ü‚½‚®
        assertEquals(38, bdc.countDays(toCalendar(2020, 4, 1), toCalendar(2020, 5, 31)));
        assertEquals(-60, bdc.countDays(toCalendar(2020, 9, 30), toCalendar(2020, 7, 1)));
        // •½“úA“y“úAj“ú‚·‚×‚ÄŠÜ‚Þ ‚©‚Â”N‚ð‚Ü‚½‚®
        assertEquals(61, bdc.countDays(toCalendar(2020, 11, 1), toCalendar(2021, 1, 31)));
        assertEquals(-81, bdc.countDays(toCalendar(2020, 2, 29), toCalendar(2019, 11, 1)));
        // U‘Ö‹x“úA‘–¯‚Ì‹x“ú‚ðŠÜ‚Þ
        assertEquals(2, bdc.countDays(toCalendar(2020, 5, 1), toCalendar(2020, 5, 8)));
        assertEquals(-1, bdc.countDays(toCalendar(2015, 9, 25), toCalendar(2015, 9, 21)));
        // ‘–¯‚Ìj“ú§’è‘O‚Ì‚ ‚éˆê”N‚Ì‰c‹Æ“ú”
        assertEquals(260, bdc.countDays(toCalendar(1947, 1, 1), toCalendar(1947, 12, 31)));
        // ‘–¯‚Ìj“ú§’èŒã‚Ì‚ ‚éˆê”N‚Ì‰c‹Æ“ú”
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
        // ŽO‚ª“ú‚Í‹x“ú‚Æ‚·‚éƒpƒ^[ƒ“
        assertEquals(5, bdc2.countDays(toCalendar(2020, 1, 1), toCalendar(2020, 1, 10)));
    }

    @Test
    public void testGetDate() {
        BusinessDayCalculator bdc = new BusinessDayCalculator(new DefaultJapaneseDayOffResolver());

        // ‰c‹Æ“ú”=0 ‚©‚Â•½“ú
        assertDateEquals(toCalendar(2020, 4, 1), bdc.getDate(toCalendar(2020, 4, 1), 0));
        // ‰c‹Æ“ú”=0 ‚©‚Ânot•½“ú
        assertDateEquals(toCalendar(2020, 4, 4), bdc.getDate(toCalendar(2020, 4, 4), 0));
        // ‰c‹Æ“ú”=1 ‚©‚Â•½“ú‚Ì‚Ý
        assertDateEquals(toCalendar(2020, 4, 2), bdc.getDate(toCalendar(2020, 4, 1), 1));
        assertDateEquals(toCalendar(2020, 3, 31), bdc.getDate(toCalendar(2020, 4, 1), -1));
        // ‰c‹Æ“ú”=1 ‚©‚Â“y“ú‚ð‚Ü‚½‚®
        assertDateEquals(toCalendar(2020, 4, 6), bdc.getDate(toCalendar(2020, 4, 3), 1));
        assertDateEquals(toCalendar(2020, 4, 6), bdc.getDate(toCalendar(2020, 4, 4), 1));
        assertDateEquals(toCalendar(2020, 4, 6), bdc.getDate(toCalendar(2020, 4, 5), 1));
        assertDateEquals(toCalendar(2020, 4, 3), bdc.getDate(toCalendar(2020, 4, 6), -1));
        assertDateEquals(toCalendar(2020, 4, 3), bdc.getDate(toCalendar(2020, 4, 5), -1));
        assertDateEquals(toCalendar(2020, 4, 3), bdc.getDate(toCalendar(2020, 4, 4), -1));
        // ‰c‹Æ“ú”=1 ‚©‚Âj“ú‚ð‚Ü‚½‚®
        assertDateEquals(toCalendar(2020, 4, 30), bdc.getDate(toCalendar(2020, 4, 28), 1));
        assertDateEquals(toCalendar(2019, 12, 31), bdc.getDate(toCalendar(2020, 1, 2), -1));
        // ‰c‹Æ“ú”=2ˆÈã ‚©‚Â•½“ú‚Ì‚Ý
        assertDateEquals(toCalendar(2020, 4, 10), bdc.getDate(toCalendar(2020, 4, 6), 4));
        assertDateEquals(toCalendar(2020, 3, 30), bdc.getDate(toCalendar(2020, 4, 1), -2));
        // ‰c‹Æ“ú”=2ˆÈã ‚©‚Â“y“ú‚ð‚Ü‚½‚®
        assertDateEquals(toCalendar(2020, 4, 8), bdc.getDate(toCalendar(2020, 4, 1), 5));
        assertDateEquals(toCalendar(2020, 4, 3), bdc.getDate(toCalendar(2020, 4, 13), -6));
        // ‰c‹Æ“ú”=2ˆÈã ‚©‚Âj“ú‚ð‚Ü‚½‚®
        assertDateEquals(toCalendar(2020, 2, 14), bdc.getDate(toCalendar(2020, 2, 9), 4));
        assertDateEquals(toCalendar(2020, 4, 27), bdc.getDate(toCalendar(2020, 5, 1), -3));
        // ‰c‹Æ“ú”=2ˆÈã ‚©‚Â‰c‹Æ“ú‚ª˜A‘±‚¹‚¸‚É“y“új“ú‚ð‚Ü‚½‚®
        assertDateEquals(toCalendar(2020, 2, 26), bdc.getDate(toCalendar(2020, 2, 7), 11));
        assertDateEquals(toCalendar(2020, 7, 22), bdc.getDate(toCalendar(2020, 8, 12), -12));
        assertDateEquals(toCalendar(2020, 5, 12), bdc.getDate(toCalendar(2020, 5, 5), 4));
        assertDateEquals(toCalendar(2020, 9, 9), bdc.getDate(toCalendar(2020, 9, 22), -8));
        // ‘–¯‚Ìj“ú§’è‘O‚Ì‚ ‚éˆê”N‚Ì‰c‹Æ“ú”
        assertDateEquals(toCalendar(1947, 12, 31), bdc.getDate(toCalendar(1947, 1, 1), 260));
        // ‘–¯‚Ìj“ú§’èŒã‚Ì‚ ‚éˆê”N‚Ì‰c‹Æ“ú”
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
        // ŽO‚ª“ú‚Í‹x“ú‚Æ‚·‚éƒpƒ^[ƒ“
        assertDateEquals(toCalendar(2020, 1, 10), bdc2.getDate(toCalendar(2020, 1, 1), 5));
    }

    @Test
    public void testGetFirstDay() {
        BusinessDayCalculator bdc = new BusinessDayCalculator(new DefaultJapaneseDayOffResolver());

        // 1947”N‚Ì‘æ1‰c‹Æ“ú (”N‰‚ª•½“ú‚ÌƒP[ƒX)
        assertDateEquals(toCalendar(1947, 1, 1), bdc.getFirstDay(toCalendar(1947, 4, 1), StartingPoint.THIS_YEAR));
        // 2020”N‚Ì‘æ1‰c‹Æ“ú (”N‰‚ª‹x‚Ý‚ÌƒP[ƒX)
        assertDateEquals(toCalendar(2020, 1, 2), bdc.getFirstDay(toCalendar(2020, 6, 2), StartingPoint.THIS_YEAR));
        // 1978”N‚Ì‘æ3‰c‹Æ“ú (1,2“ú‚ª‹x‚Ý‚ÌƒP[ƒX)
        assertDateEquals(toCalendar(1978, 1, 5), bdc.getFirstDay(toCalendar(1978, 9, 3), StartingPoint.THIS_YEAR, 3));
        // 2030”N‚Ì‘æ10‰c‹Æ“ú
        assertDateEquals(toCalendar(2030, 1, 16), bdc.getFirstDay(toCalendar(2030, 12, 4), StartingPoint.THIS_YEAR, 10));
        // 1945”N‚Ì—‚”N‚Ì‘æ1‰c‹Æ“ú (”N‰‚ª•½“ú‚ÌƒP[ƒX)
        assertDateEquals(toCalendar(1946, 1, 1), bdc.getFirstDay(toCalendar(1945, 4, 1), StartingPoint.NEXT_YEAR));
        // 1996”N‚Ì—‚”N‚Ì‘æ1‰c‹Æ“ú (”N‰‚ª‹x‚Ý‚ÌƒP[ƒX)
        assertDateEquals(toCalendar(1997, 1, 2), bdc.getFirstDay(toCalendar(1996, 6, 2), StartingPoint.NEXT_YEAR));
        // 2020”N‚Ì—‚”N‚Ì‘æ4‰c‹Æ“ú (1`3“ú‚ª‹x‚Ý‚ÌƒP[ƒX)
        assertDateEquals(toCalendar(2021, 1, 7), bdc.getFirstDay(toCalendar(2020, 9, 3), StartingPoint.NEXT_YEAR, 4));
        // 2030”N‚Ì—‚”N‚Ì‘æ8‰c‹Æ“ú
        assertDateEquals(toCalendar(2031, 1, 14), bdc.getFirstDay(toCalendar(2030, 12, 4), StartingPoint.NEXT_YEAR, 8));
        // 1944”N‚Ì‘O”N‚Ì‘æ1‰c‹Æ“ú (”N‰‚ª•½“ú‚ÌƒP[ƒX)
        assertDateEquals(toCalendar(1943, 1, 1), bdc.getFirstDay(toCalendar(1944, 4, 1), StartingPoint.PREV_YEAR));
        // 1981”N‚Ì‘O”N‚Ì‘æ1‰c‹Æ“ú (”N‰‚ª‹x‚Ý‚ÌƒP[ƒX)
        assertDateEquals(toCalendar(1980, 1, 2), bdc.getFirstDay(toCalendar(1981, 6, 2), StartingPoint.PREV_YEAR));
        // 1996”N‚Ì‘O”N‚Ì‘æ2‰c‹Æ“ú (1,2“ú‚ª‹x‚Ý‚ÌƒP[ƒX)
        assertDateEquals(toCalendar(1995, 1, 4), bdc.getFirstDay(toCalendar(1996, 9, 3), StartingPoint.PREV_YEAR, 2));
        // 2050”N‚Ì‘O”N‚Ì‘æ6‰c‹Æ“ú
        assertDateEquals(toCalendar(2049, 1, 12), bdc.getFirstDay(toCalendar(2050, 12, 4), StartingPoint.PREV_YEAR, 6));

        // 2020”N4ŒŽ‚Ì‘æ1‰c‹Æ“ú (ŒŽ‰‚ª•½“ú‚ÌƒP[ƒX)
        assertDateEquals(toCalendar(2020, 4, 1), bdc.getFirstDay(toCalendar(2020, 4, 1), StartingPoint.THIS_MONTH));
        // 2020”N3ŒŽ‚Ì‘æ1‰c‹Æ“ú (ŒŽ‰‚ª‹x‚Ý‚ÌƒP[ƒX)
        assertDateEquals(toCalendar(2020, 3, 2), bdc.getFirstDay(toCalendar(2020, 3, 2), StartingPoint.THIS_MONTH));
        // 2020”N8ŒŽ‚Ì‘æ5‰c‹Æ“ú (1,2“ú‚ª‹x‚Ý‚ÌƒP[ƒX)
        assertDateEquals(toCalendar(2020, 8, 7), bdc.getFirstDay(toCalendar(2020, 8, 15), StartingPoint.THIS_MONTH, 5));
        // 2020”N9ŒŽ‚Ì‘æ10‰c‹Æ“ú
        assertDateEquals(toCalendar(2020, 9, 14), bdc.getFirstDay(toCalendar(2020, 9, 30), StartingPoint.THIS_MONTH, 10));
        // 2015”N4ŒŽ‚Ì—‚ŒŽ‚Ì‘æ1‰c‹Æ“ú (ŒŽ‰‚ª•½“ú‚ÌƒP[ƒX)
        assertDateEquals(toCalendar(2015, 5, 1), bdc.getFirstDay(toCalendar(2015, 4, 1), StartingPoint.NEXT_MONTH));
        // 2015”N2ŒŽ‚Ì—‚ŒŽ‚Ì‘æ1‰c‹Æ“ú (ŒŽ‰‚ª‹x‚Ý‚ÌƒP[ƒX)
        assertDateEquals(toCalendar(2015, 3, 2), bdc.getFirstDay(toCalendar(2015, 2, 2), StartingPoint.NEXT_MONTH));
        // 2015”N7ŒŽ‚Ì—‚ŒŽ‚Ì‘æ4‰c‹Æ“ú (1,2“ú‚ª‹x‚Ý‚ÌƒP[ƒX)
        assertDateEquals(toCalendar(2015, 8, 6), bdc.getFirstDay(toCalendar(2015, 7, 15), StartingPoint.NEXT_MONTH, 4));
        // 2015”N10ŒŽ‚Ì—‚ŒŽ‚Ì‘æ8‰c‹Æ“ú
        assertDateEquals(toCalendar(2015, 11, 12), bdc.getFirstDay(toCalendar(2015, 10, 31), StartingPoint.NEXT_MONTH, 8));
        // 2023”N10ŒŽ‚Ì‘OŒŽ‚Ì‘æ1‰c‹Æ“ú (ŒŽ‰‚ª•½“ú‚ÌƒP[ƒX)
        assertDateEquals(toCalendar(2023, 9, 1), bdc.getFirstDay(toCalendar(2023, 10, 1), StartingPoint.PREV_MONTH));
        // 2023”N11ŒŽ‚Ì‘OŒŽ‚Ì‘æ1‰c‹Æ“ú (ŒŽ‰‚ª‹x‚Ý‚ÌƒP[ƒX)
        assertDateEquals(toCalendar(2023, 10, 2), bdc.getFirstDay(toCalendar(2023, 11, 2), StartingPoint.PREV_MONTH));
        // 2023”N5ŒŽ‚Ì‘OŒŽ‚Ì‘æ2‰c‹Æ“ú (1,2“ú‚ª‹x‚Ý‚ÌƒP[ƒX)
        assertDateEquals(toCalendar(2023, 4, 4), bdc.getFirstDay(toCalendar(2023, 5, 15), StartingPoint.PREV_MONTH, 2));
        // 2023”N6ŒŽ‚Ì‘OŒŽ‚Ì‘æ6‰c‹Æ“ú
        assertDateEquals(toCalendar(2023, 5, 11), bdc.getFirstDay(toCalendar(2023, 6, 30), StartingPoint.PREV_MONTH, 6));

        // 2020”N4ŒŽ1T‚Ì‘æ1‰c‹Æ“ú (ŒŽ—j‚ª•½“ú‚ÌƒP[ƒX)
        assertDateEquals(toCalendar(2020, 3, 30), bdc.getFirstDay(toCalendar(2020, 4, 4), StartingPoint.THIS_WEEK));
        // 2020”N1ŒŽ3T‚Ì‘æ1‰c‹Æ“ú (ŒŽ—j‚ª‹x‚Ý‚ÌƒP[ƒX)
        assertDateEquals(toCalendar(2020, 1, 14), bdc.getFirstDay(toCalendar(2020, 1, 12), StartingPoint.THIS_WEEK));
        // 2020”N9ŒŽ4T‚Ì‘æ2‰c‹Æ“ú (ŒŽ‰Î—j‚ª‹x‚Ý‚ÌƒP[ƒX)
        assertDateEquals(toCalendar(2020, 9, 24), bdc.getFirstDay(toCalendar(2020, 9, 23), StartingPoint.THIS_WEEK, 2));
        // 2020”N11ŒŽ1T‚Ì‘æ10‰c‹Æ“ú
        assertDateEquals(toCalendar(2020, 11, 16), bdc.getFirstDay(toCalendar(2020, 11, 2), StartingPoint.THIS_WEEK, 10));
        // 2020”N11ŒŽ5T‚Ì—‚T‚Ì‘æ1‰c‹Æ“ú (ŒŽ—j‚ª•½“ú‚ÌƒP[ƒX)
        assertDateEquals(toCalendar(2020, 12, 7), bdc.getFirstDay(toCalendar(2020, 11, 30), StartingPoint.NEXT_WEEK));
        // 2020”N8ŒŽ2T‚Ì—‚T‚Ì‘æ1‰c‹Æ“ú (ŒŽ—j‚ª‹x‚Ý‚ÌƒP[ƒX)
        assertDateEquals(toCalendar(2020, 8, 11), bdc.getFirstDay(toCalendar(2020, 8, 2), StartingPoint.NEXT_WEEK));
        // 2020”N5ŒŽ1T‚Ì—‚T‚Ì‘æ2‰c‹Æ“ú (ŒŽ‰Î…—j‚ª‹x‚Ý‚ÌƒP[ƒX)
        assertDateEquals(toCalendar(2020, 5, 8), bdc.getFirstDay(toCalendar(2020, 4, 26), StartingPoint.NEXT_WEEK, 2));
        // 2020”N7ŒŽ3T‚Ì—‚T‚Ì‘æ9‰c‹Æ“ú
        assertDateEquals(toCalendar(2020, 8, 3), bdc.getFirstDay(toCalendar(2020, 7, 15), StartingPoint.NEXT_WEEK, 9));
        // 2020”N2ŒŽ4T‚Ì‘OT‚Ì‘æ1‰c‹Æ“ú (ŒŽ—j‚ª•½“ú‚ÌƒP[ƒX)
        assertDateEquals(toCalendar(2020, 2, 10), bdc.getFirstDay(toCalendar(2020, 2, 17), StartingPoint.PREV_WEEK));
        // 2020”N3ŒŽ1T‚Ì‘OT‚Ì‘æ1‰c‹Æ“ú (ŒŽ—j‚ª‹x‚Ý‚ÌƒP[ƒX)
        assertDateEquals(toCalendar(2020, 2, 25), bdc.getFirstDay(toCalendar(2020, 3, 7), StartingPoint.PREV_WEEK));
        // 2020”N10ŒŽ1T‚Ì‘OT‚Ì‘æ3‰c‹Æ“ú (ŒŽ‰Î—j‚ª‹x‚Ý‚ÌƒP[ƒX)
        assertDateEquals(toCalendar(2020, 9, 25), bdc.getFirstDay(toCalendar(2020, 10, 1), StartingPoint.PREV_WEEK, 3));
        // 2020”N1ŒŽ1T‚Ì‘OT‚Ì‘æ6‰c‹Æ“ú
        assertDateEquals(toCalendar(2019, 12, 30), bdc.getFirstDay(toCalendar(2020, 1, 1), StartingPoint.PREV_WEEK, 6));

        // ˆø”•s³
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

        // 2020”N‚ÌÅŒã‚Ì“ú•t‚©‚ç‚Ì‘æ1‰c‹Æ“ú (”N––‚ª•½“ú‚ÌƒP[ƒX)
        assertDateEquals(toCalendar(2020, 12, 31), bdc.getLastDay(toCalendar(2020, 1, 1), StartingPoint.THIS_YEAR));
        // 2016”N‚ÌÅŒã‚Ì“ú•t‚©‚ç‚Ì‘æ1‰c‹Æ“ú (”N––‚ª‹x‚Ý‚ÌƒP[ƒX)
        assertDateEquals(toCalendar(2016, 12, 30), bdc.getLastDay(toCalendar(2016, 3, 2), StartingPoint.THIS_YEAR));
        // 2017”N‚ÌÅŒã‚Ì“ú•t‚©‚ç‚Ì‘æ3‰c‹Æ“ú (30,31“ú‚ª‹x‚Ý‚ÌƒP[ƒX)
        assertDateEquals(toCalendar(2017, 12, 27), bdc.getLastDay(toCalendar(2017, 5, 3), StartingPoint.THIS_YEAR, 3));
        // 2030”N‚ÌÅŒã‚Ì“ú•t‚©‚ç‚Ì‘æ10‰c‹Æ“ú
        assertDateEquals(toCalendar(2030, 12, 18), bdc.getLastDay(toCalendar(2030, 8, 4), StartingPoint.THIS_YEAR, 10));
        // 1944”N‚Ì—‚”N‚ÌÅŒã‚Ì“ú•t‚©‚ç‚Ì‘æ1‰c‹Æ“ú (”N––‚ª•½“ú‚ÌƒP[ƒX)
        assertDateEquals(toCalendar(1945, 12, 31), bdc.getLastDay(toCalendar(1944, 1, 1), StartingPoint.NEXT_YEAR));
        // 1993”N‚Ì—‚”N‚ÌÅŒã‚Ì“ú•t‚©‚ç‚Ì‘æ1‰c‹Æ“ú (”N––‚ª‹x‚Ý‚ÌƒP[ƒX)
        assertDateEquals(toCalendar(1994, 12, 30), bdc.getLastDay(toCalendar(1993, 3, 2), StartingPoint.NEXT_YEAR));
        // 1994”N‚Ì—‚”N‚ÌÅŒã‚Ì“ú•t‚©‚ç‚Ì‘æ4‰c‹Æ“ú (30,31“ú‚ª‹x‚Ý‚ÌƒP[ƒX)
        assertDateEquals(toCalendar(1995, 12, 26), bdc.getLastDay(toCalendar(1994, 5, 3), StartingPoint.NEXT_YEAR, 4));
        // 2030”N‚Ì—‚”N‚ÌÅŒã‚Ì“ú•t‚©‚ç‚Ì‘æ8‰c‹Æ“ú
        assertDateEquals(toCalendar(2031, 12, 22), bdc.getLastDay(toCalendar(2030, 8, 4), StartingPoint.NEXT_YEAR, 8));
        // 1971”N‚Ì‘O”N‚ÌÅŒã‚Ì“ú•t‚©‚ç‚Ì‘æ1‰c‹Æ“ú (”N‰‚ª•½“ú‚ÌƒP[ƒX)
        assertDateEquals(toCalendar(1970, 12, 31), bdc.getLastDay(toCalendar(1971, 1, 1), StartingPoint.PREV_YEAR));
        // 1978”N‚Ì‘O”N‚ÌÅŒã‚Ì“ú•t‚©‚ç‚Ì‘æ1‰c‹Æ“ú (”N‰‚ª‹x‚Ý‚ÌƒP[ƒX)
        assertDateEquals(toCalendar(1977, 12, 30), bdc.getLastDay(toCalendar(1978, 3, 2), StartingPoint.PREV_YEAR));
        // 1973”N‚Ì‘O”N‚ÌÅŒã‚Ì“ú•t‚©‚ç‚Ì‘æ2‰c‹Æ“ú (30,31“ú‚ª‹x‚Ý‚ÌƒP[ƒX)
        assertDateEquals(toCalendar(1972, 12, 28), bdc.getLastDay(toCalendar(1973, 5, 3), StartingPoint.PREV_YEAR, 2));
        // 2050”N‚Ì‘O”N‚ÌÅŒã‚Ì“ú•t‚©‚ç‚Ì‘æ6‰c‹Æ“ú
        assertDateEquals(toCalendar(2049, 12, 24), bdc.getLastDay(toCalendar(2050, 8, 4), StartingPoint.PREV_YEAR, 6));

        // 2000”N5ŒŽ‚ÌÅŒã‚Ì“ú•t‚©‚ç‚Ì‘æ1‰c‹Æ“ú (ŒŽ––‚ª•½“ú‚ÌƒP[ƒX)
        assertDateEquals(toCalendar(2000, 5, 31), bdc.getLastDay(toCalendar(2000, 5, 1), StartingPoint.THIS_MONTH));
        // 2000”N9ŒŽ‚ÌÅŒã‚Ì“ú•t‚©‚ç‚Ì‘æ1‰c‹Æ“ú (ŒŽ––‚ª‹x‚Ý‚ÌƒP[ƒX)
        assertDateEquals(toCalendar(2000, 9, 29), bdc.getLastDay(toCalendar(2000, 9, 2), StartingPoint.THIS_MONTH));
        // 2000”N4ŒŽ‚ÌÅŒã‚Ì“ú•t‚©‚ç‚Ì‘æ5‰c‹Æ“ú (29,30“ú‚ª‹x‚Ý‚ÌƒP[ƒX)
        assertDateEquals(toCalendar(2000, 4, 24), bdc.getLastDay(toCalendar(2000, 4, 15), StartingPoint.THIS_MONTH, 5));
        // 2000”N12ŒŽ‚ÌÅŒã‚Ì“ú•t‚©‚ç‚Ì‘æ10‰c‹Æ“ú
        assertDateEquals(toCalendar(2000, 12, 18), bdc.getLastDay(toCalendar(2000, 12, 30), StartingPoint.THIS_MONTH, 10));
        // 1990”N1ŒŽ‚Ì—‚ŒŽ‚ÌÅŒã‚Ì“ú•t‚©‚ç‚Ì‘æ1‰c‹Æ“ú (ŒŽ––‚ª•½“ú‚ÌƒP[ƒX)
        assertDateEquals(toCalendar(1990, 2, 28), bdc.getLastDay(toCalendar(1990, 1, 1), StartingPoint.NEXT_MONTH));
        // 1990”N5ŒŽ‚Ì—‚ŒŽ‚ÌÅŒã‚Ì“ú•t‚©‚ç‚Ì‘æ1‰c‹Æ“ú (ŒŽ––‚ª‹x‚Ý‚ÌƒP[ƒX)
        assertDateEquals(toCalendar(1990, 6, 29), bdc.getLastDay(toCalendar(1990, 5, 2), StartingPoint.NEXT_MONTH));
        // 1990”N3ŒŽ‚Ì—‚ŒŽ‚ÌÅŒã‚Ì“ú•t‚©‚ç‚Ì‘æ4‰c‹Æ“ú (28,29,30“ú‚ª‹x‚Ý‚ÌƒP[ƒX)
        assertDateEquals(toCalendar(1990, 4, 24), bdc.getLastDay(toCalendar(1990, 3, 15), StartingPoint.NEXT_MONTH, 4));
        // 1990”N10ŒŽ‚Ì—‚ŒŽ‚ÌÅŒã‚Ì“ú•t‚©‚ç‚Ì‘æ8‰c‹Æ“ú
        assertDateEquals(toCalendar(1990, 11, 20), bdc.getLastDay(toCalendar(1990, 10, 31), StartingPoint.NEXT_MONTH, 8));
        // 2040”N2ŒŽ‚Ì‘OŒŽ‚ÌÅŒã‚Ì“ú•t‚©‚ç‚Ì‘æ1‰c‹Æ“ú (ŒŽ––‚ª•½“ú‚ÌƒP[ƒX)
        assertDateEquals(toCalendar(2040, 1, 31), bdc.getLastDay(toCalendar(2040, 2, 1), StartingPoint.PREV_MONTH));
        // 2040”N4ŒŽ‚Ì‘OŒŽ‚ÌÅŒã‚Ì“ú•t‚©‚ç‚Ì‘æ1‰c‹Æ“ú (ŒŽ––‚ª‹x‚Ý‚ÌƒP[ƒX)
        assertDateEquals(toCalendar(2040, 3, 30), bdc.getLastDay(toCalendar(2040, 4, 2), StartingPoint.PREV_MONTH));
        // 2040”N10ŒŽ‚Ì‘OŒŽ‚ÌÅŒã‚Ì“ú•t‚©‚ç‚Ì‘æ2‰c‹Æ“ú (29,30“ú‚ª‹x‚Ý‚ÌƒP[ƒX)
        assertDateEquals(toCalendar(2040, 9, 27), bdc.getLastDay(toCalendar(2040, 10, 15), StartingPoint.PREV_MONTH, 2));
        // 2040”N12ŒŽ‚Ì‘OŒŽ‚ÌÅŒã‚Ì“ú•t‚©‚ç‚Ì‘æ6‰c‹Æ“ú
        assertDateEquals(toCalendar(2040, 11, 22), bdc.getLastDay(toCalendar(2040, 12, 30), StartingPoint.PREV_MONTH, 6));

        // 2001”N1ŒŽ2T‚ÌÅŒã‚Ì“ú•t‚©‚ç‚Ì‘æ1‰c‹Æ“ú (‹à—j‚ª•½“ú‚ÌƒP[ƒX)
        assertDateEquals(toCalendar(2001, 1, 12), bdc.getLastDay(toCalendar(2001, 1, 7), StartingPoint.THIS_WEEK));
        // 2001”N7ŒŽ3T‚ÌÅŒã‚Ì“ú•t‚©‚ç‚Ì‘æ1‰c‹Æ“ú (‹à—j‚ª‹x‚Ý‚ÌƒP[ƒX)
        assertDateEquals(toCalendar(2001, 7, 19), bdc.getLastDay(toCalendar(2001, 7, 21), StartingPoint.THIS_WEEK));
        // 2001”N5ŒŽ1T‚ÌÅŒã‚Ì“ú•t‚©‚ç‚Ì‘æ2‰c‹Æ“ú (–Ø‹à—j‚ª‹x‚Ý‚ÌƒP[ƒX)
        assertDateEquals(toCalendar(2001, 5, 1), bdc.getLastDay(toCalendar(2001, 5, 2), StartingPoint.THIS_WEEK, 2));
        // 2001”N12ŒŽ5T‚ÌÅŒã‚Ì“ú•t‚©‚ç‚Ì‘æ10‰c‹Æ“ú
        assertDateEquals(toCalendar(2001, 12, 14), bdc.getLastDay(toCalendar(2001, 12, 26), StartingPoint.THIS_WEEK, 10));
        // 2001”N6ŒŽ3T‚Ì—‚T‚ÌÅŒã‚Ì“ú•t‚©‚ç‚Ì‘æ1‰c‹Æ“ú (‹à—j‚ª•½“ú‚ÌƒP[ƒX)
        assertDateEquals(toCalendar(2001, 6, 22), bdc.getLastDay(toCalendar(2001, 6, 10), StartingPoint.NEXT_WEEK));
        // 2001”N11ŒŽ3T‚Ì—‚T‚ÌÅŒã‚Ì“ú•t‚©‚ç‚Ì‘æ1‰c‹Æ“ú (‹à—j‚ª‹x‚Ý‚ÌƒP[ƒX)
        assertDateEquals(toCalendar(2001, 11, 22), bdc.getLastDay(toCalendar(2001, 11, 17), StartingPoint.NEXT_WEEK));
        // 2001”N4ŒŽ5T‚Ì—‚T‚ÌÅŒã‚Ì“ú•t‚©‚ç‚Ì‘æ2‰c‹Æ“ú (–Ø‹à—j‚ª‹x‚Ý‚ÌƒP[ƒX)
        assertDateEquals(toCalendar(2001, 5, 1), bdc.getLastDay(toCalendar(2001, 4, 23), StartingPoint.NEXT_WEEK, 2));
        // 2001”N10ŒŽ1T‚Ì—‚T‚ÌÅŒã‚Ì“ú•t‚©‚ç‚Ì‘æ9‰c‹Æ“ú
        assertDateEquals(toCalendar(2001, 10, 1), bdc.getLastDay(toCalendar(2001, 10, 3), StartingPoint.NEXT_WEEK, 9));
        // 2001”N3ŒŽ5T‚Ì‘OT‚ÌÅŒã‚Ì“ú•t‚©‚ç‚Ì‘æ1‰c‹Æ“ú (‹à—j‚ª•½“ú‚ÌƒP[ƒX)
        assertDateEquals(toCalendar(2001, 3, 23), bdc.getLastDay(toCalendar(2001, 3, 31), StartingPoint.PREV_WEEK));
        // 2001”N7ŒŽ4T‚Ì‘OT‚ÌÅŒã‚Ì“ú•t‚©‚ç‚Ì‘æ1‰c‹Æ“ú (‹à—j‚ª‹x‚Ý‚ÌƒP[ƒX)
        assertDateEquals(toCalendar(2001, 7, 19), bdc.getLastDay(toCalendar(2001, 7, 25), StartingPoint.PREV_WEEK));
        // 2001”N5ŒŽ2T‚Ì‘OT‚ÌÅŒã‚Ì“ú•t‚©‚ç‚Ì‘æ3‰c‹Æ“ú (ŒŽ‰Î—j‚ª‹x‚Ý‚ÌƒP[ƒX)
        assertDateEquals(toCalendar(2001, 4, 27), bdc.getLastDay(toCalendar(2001, 5, 6), StartingPoint.PREV_WEEK, 3));
        // 2001”N1ŒŽ2T‚Ì‘OT‚ÌÅŒã‚Ì“ú•t‚©‚ç‚Ì‘æ6‰c‹Æ“ú
        assertDateEquals(toCalendar(2000, 12, 28), bdc.getLastDay(toCalendar(2001, 1, 8), StartingPoint.PREV_WEEK, 6));

        // ˆø”•s³
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
