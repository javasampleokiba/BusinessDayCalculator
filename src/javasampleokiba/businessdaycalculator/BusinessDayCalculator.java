package javasampleokiba.businessdaycalculator;

import java.util.Calendar;

import javasampleokiba.businessdaycalculator.resolver.DayOffResolver;

/**
 * �c�Ɠ������v�Z����N���X
 */
public class BusinessDayCalculator {

    /**
     * �c�Ɠ������߂��_
     */
    public enum StartingPoint {
        /** ���N */
        THIS_YEAR,
        /** ���N */
        NEXT_YEAR,
        /** ���N */
        PREV_YEAR,
        /** ���� */
        THIS_MONTH,
        /** ���� */
        NEXT_MONTH,
        /** �挎 */
        PREV_MONTH,
        /** ���T */
        THIS_WEEK,
        /** ���T */
        NEXT_WEEK,
        /** ��T */
        PREV_WEEK,
    }
    private DayOffResolver resolver_;

    /**
     * �x������I�u�W�F�N�g���w�肵��{@code BusinessDayCalculator}�𐶐����܂��B
     * 
     * @param resolver  �x������I�u�W�F�N�g
     * @throws NullPointerException  {@code resolver}��{@code null}�̏ꍇ
     */
    public BusinessDayCalculator(DayOffResolver resolver) {
        if (resolver == null) throw new NullPointerException();
        resolver_ = resolver;
    }

    /**
     * �w�肵��2�̓��t�̊Ԃ̉c�Ɠ������J�E���g���܂��B
     * �J�E���g���J�n������t�����͊܂܂�܂���B
     * �J�n���t���I�����t���ߋ��̏ꍇ�͕�����Ԃ��܂��B
     * 
     * @param from  �J�n���t
     * @param to    �I�����t
     * @return �c�Ɠ���
     */
    public int countDays(Calendar from, Calendar to) {
        int count = 0;
        Calendar cal1 = (Calendar) from.clone();
        Calendar cal2 = (Calendar) to.clone();
        int step = from.compareTo(to) <= 0 ? 1 : -1;

        if (isSameDate(cal1, cal2)) return 0;

        do {
            cal1.add(Calendar.DAY_OF_YEAR, step);
            if (!resolver_.isDayOff(cal1)) {
                count++;
            }
        } while (!isSameDate(cal1, cal2));

        return count * step;
    }

    /**
     * �w�肵�����t����w��c�Ɠ��������Z�������t���擾���܂��B
     * �c�Ɠ����ɕ������w�肷�邱�Ƃ��\�ł��B
     * 
     * @param cal     ���t
     * @param offset  ���Z����c�Ɠ���
     * @return �c�Ɠ��������Z�������t
     */
    public Calendar getDate(Calendar cal, int offset) {
        Calendar c = (Calendar) cal.clone();
        int count = 0;
        int step = offset > 0 ? 1 : -1;

        if (offset == 0) return c;

        do {
            c.add(Calendar.DAY_OF_YEAR, step);
            if (!resolver_.isDayOff(c)) {
                count++;
            }
        } while (count != offset * step);

        return c;
    }

    /**
     * �w�肵����_�̑�1�c�Ɠ��̓��t���擾���܂��B
     * 
     * @param cal    ���t
     * @param start  ��_
     * @return ��1�c�Ɠ��̓��t
     */
    public Calendar getFirstDay(Calendar cal, StartingPoint start) {
        return getFirstDay(cal, start, 1);
    }

    /**
     * �w�肵�����t�A��_�̑�n�c�Ɠ��̓��t���擾���܂��B
     * 
     * @param cal      ���t
     * @param start    ��_
     * @param ordinal  ���Ԗڂ̉c�Ɠ���
     * @return ��1�c�Ɠ��̓��t
     * @throws IllegalArgumentException  {@code ordinal}��0�ȉ��̏ꍇ
     */
    public Calendar getFirstDay(Calendar cal, StartingPoint start, int ordinal) {
        if (ordinal <= 0) {
            throw new IllegalArgumentException("ordinal <= 0");
        }
        Calendar c = startingFirstDay(cal, start);
        int count = 0;

        while (true) {
            if (!resolver_.isDayOff(c)) {
                if (++count == ordinal) {
                    break;
                }
            }
            c.add(Calendar.DAY_OF_YEAR, 1);
        }

        return c;
    }

    /**
     * �w�肵����_�̍Ō�̓��t����̑�1�c�Ɠ��̓��t���擾���܂��B
     * 
     * @param cal    ���t
     * @param start  ��_
     * @return ��1�c�Ɠ��̓��t
     */
    public Calendar getLastDay(Calendar cal, StartingPoint start) {
        return getLastDay(cal, start, 1);
    }

    /**
     * �w�肵�����t�A��_�̍Ō�̓��t����̑�n�c�Ɠ��̓��t���擾���܂��B
     * 
     * @param cal      ���t
     * @param start    ��_
     * @param ordinal  ���Ԗڂ̉c�Ɠ���
     * @return ��1�c�Ɠ��̓��t
     * @throws IllegalArgumentException  {@code ordinal}��0�ȉ��̏ꍇ
     */
    public Calendar getLastDay(Calendar cal, StartingPoint start, int ordinal) {
        if (ordinal <= 0) {
            throw new IllegalArgumentException("ordinal <= 0");
        }
        Calendar c = startingLastDay(cal, start);
        int count = 0;

        while (true) {
            if (!resolver_.isDayOff(c)) {
                if (++count == ordinal) {
                    break;
                }
            }
            c.add(Calendar.DAY_OF_YEAR, -1);
        }

        return c;
    }

    private static boolean isSameDate(Calendar cal1, Calendar cal2) {
        return cal1.get(Calendar.YEAR) == cal2.get(Calendar.YEAR) &&
                cal1.get(Calendar.MONTH) == cal2.get(Calendar.MONTH) &&
                cal1.get(Calendar.DAY_OF_MONTH) == cal2.get(Calendar.DAY_OF_MONTH);
    }

    private static Calendar startingFirstDay(Calendar cal, StartingPoint start) {
        Calendar c = (Calendar) cal.clone();
        switch (start) {
            case THIS_YEAR:
                c.set(c.get(Calendar.YEAR), Calendar.JANUARY, 1);
                break;
            case NEXT_YEAR:
                c.set(c.get(Calendar.YEAR), Calendar.JANUARY, 1);
                c.add(Calendar.YEAR, 1);
                break;
            case PREV_YEAR:
                c.set(c.get(Calendar.YEAR), Calendar.JANUARY, 1);
                c.add(Calendar.YEAR, -1);
                break;
            case THIS_MONTH:
                c.set(Calendar.DAY_OF_MONTH, 1);
                break;
            case NEXT_MONTH:
                c.set(Calendar.DAY_OF_MONTH, 1);
                c.add(Calendar.MONTH, 1);
                break;
            case PREV_MONTH:
                c.set(Calendar.DAY_OF_MONTH, 1);
                c.add(Calendar.MONTH, -1);
                break;
            case THIS_WEEK:
                c.add(Calendar.DAY_OF_YEAR, Calendar.SUNDAY - c.get(Calendar.DAY_OF_WEEK));
                break;
            case NEXT_WEEK:
                c.add(Calendar.DAY_OF_YEAR, Calendar.SUNDAY - c.get(Calendar.DAY_OF_WEEK));
                c.add(Calendar.DAY_OF_YEAR, 7);
                break;
            case PREV_WEEK:
                c.add(Calendar.DAY_OF_YEAR, Calendar.SUNDAY - c.get(Calendar.DAY_OF_WEEK));
                c.add(Calendar.DAY_OF_YEAR, -7);
                break;
            default:
                break;
        }
        return c;
    }

    private static Calendar startingLastDay(Calendar cal, StartingPoint start) {
        Calendar c = (Calendar) cal.clone();
        switch (start) {
            case THIS_YEAR:
                c.set(c.get(Calendar.YEAR), Calendar.DECEMBER, 31);
                break;
            case NEXT_YEAR:
                c.set(c.get(Calendar.YEAR), Calendar.DECEMBER, 31);
                c.add(Calendar.YEAR, 1);
                break;
            case PREV_YEAR:
                c.set(c.get(Calendar.YEAR), Calendar.DECEMBER, 31);
                c.add(Calendar.YEAR, -1);
                break;
            case THIS_MONTH:
                c.set(Calendar.DAY_OF_MONTH, c.getActualMaximum(Calendar.DATE));
                break;
            case NEXT_MONTH:
                c.add(Calendar.MONTH, 1);
                c.set(Calendar.DAY_OF_MONTH, c.getActualMaximum(Calendar.DATE));
                break;
            case PREV_MONTH:
                c.add(Calendar.MONTH, -1);
                c.set(Calendar.DAY_OF_MONTH, c.getActualMaximum(Calendar.DATE));
                break;
            case THIS_WEEK:
                c.add(Calendar.DAY_OF_YEAR, Calendar.SATURDAY - c.get(Calendar.DAY_OF_WEEK));
                break;
            case NEXT_WEEK:
                c.add(Calendar.DAY_OF_YEAR, Calendar.SATURDAY - c.get(Calendar.DAY_OF_WEEK));
                c.add(Calendar.DAY_OF_YEAR, 7);
                break;
            case PREV_WEEK:
                c.add(Calendar.DAY_OF_YEAR, Calendar.SATURDAY - c.get(Calendar.DAY_OF_WEEK));
                c.add(Calendar.DAY_OF_YEAR, -7);
                break;
            default:
                break;
        }
        return c;
    }
}
