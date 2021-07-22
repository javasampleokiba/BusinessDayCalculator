package javasampleokiba.businessdaycalculator.resolver;

import java.util.Calendar;

import javasampleokiba.businessdaycalculator.holiday.JapaneseHolidayUtils;

/**
 * w’è‚³‚ê‚½“ú•t‚ª“ú–{‚Ìˆê”Ê“I‚È‹x“ú‚©”»’è‚·‚éƒNƒ‰ƒX.
 * 
 * “y“úA‚¨‚æ‚Ñ‘–¯‚Ìj“úAU‘Ö‹x“úA‘–¯‚Ì‹x“ú‚ğ‹x“ú‚Æ”»’è‚µ‚Ü‚·B
 */
public class DefaultJapaneseDayOffResolver implements DayOffResolver {

    @Override
    public boolean isDayOff(Calendar cal) {
        // “y“ú‚©H
        if (cal.get(Calendar.DAY_OF_WEEK) == Calendar.SATURDAY ||
            cal.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY) {
            return true;
        }

        // ‘–¯‚Ìj“ú‚©H
        if (JapaneseHolidayUtils.isHoliday(cal)) {
            return true;
        }

        return false;
    }
}
