package javasampleokiba.businessdaycalculator.resolver;

import java.util.Calendar;

import javasampleokiba.businessdaycalculator.holiday.JapaneseHolidayUtils;

/**
 * �w�肳�ꂽ���t�����{�̈�ʓI�ȋx�������肷��N���X.
 * 
 * �y���A����э����̏j���A�U�֋x���A�����̋x�����x���Ɣ��肵�܂��B
 */
public class DefaultJapaneseDayOffResolver implements DayOffResolver {

    @Override
    public boolean isDayOff(Calendar cal) {
        // �y�����H
        if (cal.get(Calendar.DAY_OF_WEEK) == Calendar.SATURDAY ||
            cal.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY) {
            return true;
        }

        // �����̏j�����H
        if (JapaneseHolidayUtils.isHoliday(cal)) {
            return true;
        }

        return false;
    }
}
