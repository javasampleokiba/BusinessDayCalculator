package javasampleokiba.businessdaycalculator.holiday;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.List;

/**
 * ���{�́u�����̏j���v�A�u�U�֋x���v�A�u�����̋x���v�Ɋւ��郆�[�e�B���e�B�N���X.
 * 
 * <p>[���ӎ���]</p>
 * <ul>
 * <li>����̖@�������ɂ�萳��ɓ��삵�Ȃ��Ȃ�\��������܂��B</li>
 * <li>2151�N�ȍ~�́u�t���̓��v�A�u�H���̓��v�͋��߂邱�Ƃ��ł��܂���B</li>
 * <li>�����́u�����̏j���v���d�Ȃ�ꍇ�́A�����ꂩ����̏�񂵂��擾�ł��܂���B
 * �i����ŏ��ɏj�����d������̂�2876�N�Ɨ\������Ă��܂��j</li>
 * </ul>
 */
public class JapaneseHolidayUtils {

    private static final Calendar AMENDMENT_DATE_2ND    = Calendar.getInstance();
    private static final Calendar AMENDMENT_DATE_3RD    = Calendar.getInstance();
    private static final Calendar AMENDMENT_DATE_8TH    = Calendar.getInstance();
    static {
        AMENDMENT_DATE_2ND.set(1973, 3, 12);
        AMENDMENT_DATE_3RD.set(1985, 11, 27);
        AMENDMENT_DATE_8TH.set(2007, 0, 1);
    }
    private static final String SUBSTITUTE_HOLIDAY      = "�U�֋x��";
    private static final String CITIZENS_HOLIDAY        = "�����̋x��";

    private JapaneseHolidayUtils() {
    }

    /**
     * �w�肵�����t��{@code NationalHoliday}�I�u�W�F�N�g���擾���܂��B
     * �w�肵�����t���u�����̏j���v�ł͂Ȃ��ꍇ��{@code null}��Ԃ��܂��B
     * 
     * @param cal  ���t
     * @return �w�肵�����t��{@code NationalHoliday}�I�u�W�F�N�g
     * @throws NullPointerException  {@code cal}��{@code null}�̏ꍇ
     */
    public static JapaneseNationalHoliday getNationalHoliday(Calendar cal) {
        checkNotNull(cal);
        for (JapaneseNationalHoliday holiday : JapaneseNationalHoliday.values()) {
            if (holiday.is(cal)) return holiday;
        }
        return null;
    }

    /**
     * �w�肵�����t�́u�����̏j���v�̖��O���擾���܂��B
     * �u�U�֋x���v�A�u�����̋x���v�̏ꍇ�͂��ꂼ��"�U�֋x��"�A"�����̋x��"��Ԃ��܂��B
     * �u�����̏j���v�A�u�U�֋x���v�A�u�����̋x���v�̂�����ł��Ȃ��ꍇ��{@code null}��Ԃ��܂��B
     * 
     * @param cal  ���t
     * @return �w�肵�����t�́u�����̏j���v�̖��O�A�܂���"�U�֋x��"�A"�����̋x��"
     * @throws NullPointerException  {@code cal}��{@code null}�̏ꍇ
     */
    public static String getHolidayName(Calendar cal) {
        checkNotNull(cal);
        String name = getNationalHolidayName(cal);
        if (name != null) return name;

        // �U�֋x������
        name = getSubstituteHoliday(cal);
        if (name != null) return name;

        // �����̋x������
        name = getCitizensHoliday(cal);
        if (name != null) return name;

        return null;
    }

    /**
     * �w�肵�����t�́u�����̏j���v�̖��O���擾���܂��B
     * �u�����̏j���v�ł͂Ȃ��ꍇ��{@code null}��Ԃ��܂��B
     * 
     * @param cal  ���t
     * @return �w�肵�����t�́u�����̏j���v�̖��O
     * @throws NullPointerException  {@code cal}��{@code null}�̏ꍇ
     */
    public static String getNationalHolidayName(Calendar cal) {
        checkNotNull(cal);
        JapaneseNationalHoliday holiday = getNationalHoliday(cal);
        return holiday != null ? holiday.toString() : null;
    }

    /**
     * �w�肵�����t���u�����̏j���v�A�u�U�֋x���v�A�u�����̋x���v�̂����ꂩ�ł��邩���肵�܂��B
     * 
     * @param cal  ���t
     * @return �w�肵�����t���u�����̏j���v�A�u�U�֋x���v�A�u�����̋x���v�̂����ꂩ�ł���ꍇ�� {@code true}
     * @throws NullPointerException  {@code cal}��{@code null}�̏ꍇ
     */
    public static boolean isHoliday(Calendar cal) {
        checkNotNull(cal);
        return getHolidayName(cal) != null;
    }

    /**
     * �w�肵�����t���u�����̏j���v�ł��邩���肵�܂��B
     * 
     * @param cal  ���t
     * @return �w�肵�����t���u�����̏j���v�ł���ꍇ�� {@code true}
     * @throws NullPointerException  {@code cal}��{@code null}�̏ꍇ
     */
    public static boolean isNationalHoliday(Calendar cal) {
        checkNotNull(cal);
        return getNationalHoliday(cal) != null;
    }

    /**
     * �w�肵�����t���u�U�֋x���v�ł��邩���肵�܂��B
     * 
     * @param cal  ���t
     * @return �w�肵�����t���u�U�֋x���v�ł���ꍇ�� {@code true}
     * @throws NullPointerException  {@code cal}��{@code null}�̏ꍇ
     */
    public static boolean isSubstituteHoliday(Calendar cal) {
        checkNotNull(cal);
        return getHolidayName(cal) == SUBSTITUTE_HOLIDAY;
    }

    /**
     * �w�肵�����t���u�����̋x���v�ł��邩���肵�܂��B
     * 
     * @param cal  ���t
     * @return �w�肵�����t���u�����̋x���v�ł���ꍇ�� {@code true}
     * @throws NullPointerException  {@code cal}��{@code null}�̏ꍇ
     */
    public static boolean isCitizensHoliday(Calendar cal) {
        checkNotNull(cal);
        return getHolidayName(cal) == CITIZENS_HOLIDAY;
    }

    /**
     * �w�肵���N�̂��ׂẮu�����̏j���v�A�u�U�֋x���v�A�u�����̋x���v�̓��t���擾���܂��B
     * 
     * @param year  �擾�Ώ۔N
     * @return �u�����̏j���v�A�u�U�֋x���v�A�u�����̋x���v�̓��t�̃��X�g
     */
    public static List<Calendar> getHolidaysOf(int year) {
        List<Calendar> list = new ArrayList<Calendar>();
        for (int i = 1; i <= 12; i++) {
            list.addAll(getHolidaysOf(year, i));
        }
        Collections.sort(list);
        return list;
    }

    /**
     * �w�肵���N�ƌ��̂��ׂẮu�����̏j���v�A�u�U�֋x���v�A�u�����̋x���v�̓��t���擾���܂��B
     * 
     * @param year   �擾�Ώ۔N
     * @param month  �擾�Ώی�
     * @return �u�����̏j���v�A�u�U�֋x���v�A�u�����̋x���v�̓��t�̃��X�g
     */
    public static List<Calendar> getHolidaysOf(int year, int month) {
        // �����̏j���擾
        List<Calendar> list = new ArrayList<Calendar>();
        for (JapaneseNationalHoliday holiday : JapaneseNationalHoliday.values()) {
            Calendar cal = holiday.dateOf(year);
            if (cal != null && month == cal.get(Calendar.MONTH) + 1) {
                list.add(cal);
            }
        }

        // �U�֋x���擾
        List<Calendar> shList = new ArrayList<Calendar>();
        for (Calendar cal : list) {
            Calendar c = tomorrow(cal);
            if (getSubstituteHoliday(c) != null &&
                    !list.contains(c)) {
                shList.add(c);
            }
        }

        // �����̋x���擾
        List<Calendar> chList = new ArrayList<Calendar>();
        for (Calendar cal : list) {
            Calendar c = tomorrow(cal);
            if (getCitizensHoliday(c) != null &&
                    !list.contains(c) &&
                    !shList.contains(c)) {
                chList.add(c);
            }
        }

        list.addAll(shList);
        list.addAll(chList);
        Collections.sort(list);
        return list;
    }

    private static String getSubstituteHoliday(Calendar cal) {
        // �@�������O�́A�U�֋x���ɂ͂Ȃ�Ȃ�
        if (AMENDMENT_DATE_2ND.compareTo(cal) >= 0) return null;

        // ���j�̏ꍇ�́A�U�֋x���ɂ͂Ȃ�Ȃ�
        if (cal.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY) return null;

        Calendar c = yesterday(cal);
        if (AMENDMENT_DATE_8TH.compareTo(cal) > 0) {
            // �j�������j���̏ꍇ�͂��̗����̌��j����U�֋x���Ƃ���
            if (isNationalHoliday(c) &&
                    c.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY) {
                return SUBSTITUTE_HOLIDAY;
            }
        } else {
            // �A������j���̂����A�ǂꂩ1�������j���Əd�Ȃ����ꍇ�́A�Ō�̏j���̗������U�֋x���Ƃ���
            while (true) {
                if (isNationalHoliday(c)) {
                    if (c.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY) {
                        return SUBSTITUTE_HOLIDAY;
                    }
                } else {
                    break;
                }
                c = yesterday(c);
            }
        }
        return null;
    }

    private static String getCitizensHoliday(Calendar cal) {
        // �@�������O�́A�����̋x���ɂ͂Ȃ�Ȃ�
        if (AMENDMENT_DATE_3RD.compareTo(cal) >= 0) return null;

        // ���j�̏ꍇ�́A�����̋x���ɂ͂Ȃ�Ȃ�
        if (cal.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY) return null;

        if (isNationalHoliday(yesterday(cal)) &&
                isNationalHoliday(tomorrow(cal))) {
            return CITIZENS_HOLIDAY;
        }
        return null;
    }

    private static Calendar yesterday(Calendar cal) {
        Calendar c = (Calendar) cal.clone();
        c.add(Calendar.DAY_OF_YEAR, -1);
        return c;
    }

    private static Calendar tomorrow(Calendar cal) {
        Calendar c = (Calendar) cal.clone();
        c.add(Calendar.DAY_OF_YEAR, 1);
        return c;
    }

    private static void checkNotNull(Calendar cal) {
        if (cal == null) throw new NullPointerException("Calendar object is null.");
    }
}
