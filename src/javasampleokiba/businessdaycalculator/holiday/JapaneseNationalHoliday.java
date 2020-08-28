package javasampleokiba.businessdaycalculator.holiday;

import java.util.Calendar;

/**
 * ���{�́u�����̏j���v��\���񋓌^�N���X�B
 * 
 * [���ӎ���]
 * <ul>
 * <li>����̖@�������ɂ�萳��ɓ��삵�Ȃ��Ȃ�\��������܂��B</li>
 * <li>2151�N�ȍ~�́u�t���̓��v�A�u�H���̓��v�͋��߂邱�Ƃ��ł��܂���B</li>
 * </ul>
 */
public enum JapaneseNationalHoliday {
    /** ���� */
    NewYearsDay                     ("����") {
        @Override
        public Calendar dateOf(int year) {
            if (1949 <= year) {
                return toCalendar(year, 1, 1);
            }
            return null;
        }
    },
    /** ���l�̓� */
    ComingOfAgeDay                  ("���l�̓�") {
        @Override
        public Calendar dateOf(int year) {
            if (1949 <= year && year <= 1999) {
                return toCalendar(year, 1, 15);
            } else if (2000 <= year) {
                return mondayOf(year, 1, 2);
            }
            return null;
        }
    },
    /** �����L�O�̓� */
    NationalFoundationDay           ("�����L�O�̓�") {
        @Override
        public Calendar dateOf(int year) {
            if (1967 <= year) {
                return toCalendar(year, 2, 11);
            }
            return null;
        }
    },
    /** �V�c�a���� */
    EmperorsBirthday                ("�V�c�a����") {
        @Override
        public Calendar dateOf(int year) {
            if (1949 <= year && year <= 1988) {
                return toCalendar(year, 4, 29);
            } else if (1989 <= year && year <= 2018) {
                return toCalendar(year, 12, 23);
            } else if (2020 <= year) {
                return toCalendar(year, 2, 23);
            }
            return null;
        }
    },
    /** �t���̓� */
    VernalEquinoxDay                ("�t���̓�") {
        @Override
        public Calendar dateOf(int year) {
            if (1949 <= year) {
                return toCalendar(year, 3, calcVernalEquinoxDay(year));
            }
            return null;
        }
    },
    /** �݂ǂ�̓� */
    GreeneryDay                     ("�݂ǂ�̓�") {
        @Override
        public Calendar dateOf(int year) {
            if (1989 <= year && year <= 2006) {
                return toCalendar(year, 4, 29);
            } else if (2007 <= year) {
                return toCalendar(year, 5, 4);
            }
            return null;
        }
    },
    /** ���a�̓� */
    ShowaDay                        ("���a�̓�") {
        @Override
        public Calendar dateOf(int year) {
            if (2007 <= year) {
                return toCalendar(year, 4, 29);
            }
            return null;
        }
    },
    /** ���@�L�O�� */
    ConstitutionMemorialDay         ("���@�L�O��") {
        @Override
        public Calendar dateOf(int year) {
            if (1949 <= year) {
                return toCalendar(year, 5, 3);
            }
            return null;
        }
    },
    /** ���ǂ��̓� */
    ChildrensDay                    ("���ǂ��̓�") {
        @Override
        public Calendar dateOf(int year) {
            if (1949 <= year) {
                return toCalendar(year, 5, 5);
            }
            return null;
        }
    },
    /** �C�̓� */
    MarineDay                       ("�C�̓�") {
        @Override
        public Calendar dateOf(int year) {
            if (1996 <= year && year <= 2002) {
                return toCalendar(year, 7, 20);
            } else if (year == 2020) {
                return toCalendar(year, 7, 23);
            } else if (2003 <= year) {
                return mondayOf(year, 7, 3);
            }
            return null;
        }
    },
    /** �R�̓� */
    MountainDay                     ("�R�̓�") {
        @Override
        public Calendar dateOf(int year) {
            if (year == 2020) {
                return toCalendar(year, 8, 10);
            } else if (2016 <= year) {
                return toCalendar(year, 8, 11);
            }
            return null;
        }
    },
    /** �h�V�̓� */
    RespectForTheAgedDay            ("�h�V�̓�") {
        @Override
        public Calendar dateOf(int year) {
            if (1966 <= year && year <= 2002) {
                return toCalendar(year, 9, 15);
            } else if (2003 <= year) {
                return mondayOf(year, 9, 3);
            }
            return null;
        }
    },
    /** �H���̓� */
    AutumnalEquinoxDay              ("�H���̓�") {
        @Override
        public Calendar dateOf(int year) {
            if (1948 <= year) {
                return toCalendar(year, 9, calcAutumnalEquinoxDay(year));
            }
            return null;
        }
    },
    /** �̈�̓� */
    HealthAndSportsDay              ("�̈�̓�") {
        @Override
        public Calendar dateOf(int year) {
            if (1966 <= year && year <= 1999) {
                return toCalendar(year, 10, 10);
            } else if (2000 <= year && year <= 2019) {
                return mondayOf(year, 10, 2);
            }
            return null;
        }
    },
    /** �X�|�[�c�̓� */
    SportsDay                       ("�X�|�[�c�̓�") {
        @Override
        public Calendar dateOf(int year) {
            if (year == 2020) {
                return toCalendar(year, 7, 24);
            } else if (2021 <= year) {
                return mondayOf(year, 10, 2);
            }
            return null;
        }
    },
    /** �����̓� */
    NationalCultureDay              ("�����̓�") {
        @Override
        public Calendar dateOf(int year) {
            if (1948 <= year) {
                return toCalendar(year, 11, 3);
            }
            return null;
        }
    },
    /** �ΘJ���ӂ̓� */
    LaborThanksgivingDay            ("�ΘJ���ӂ̓�") {
        @Override
        public Calendar dateOf(int year) {
            if (1948 <= year) {
                return toCalendar(year, 11, 23);
            }
            return null;
        }
    },
    ;
    private static final double DIFF_DAY_OF_YEAR        = 0.242194;
    private final String name_;

    private JapaneseNationalHoliday(String name) {
        name_ = name;
    }

    /**
     * �w�肵���N�ɂ����邱�̏j���̓��t���擾���܂��B
     * �j�������݂��Ȃ��ꍇ��{@code null}��Ԃ��B
     * 
     * @param year  �N
     * @return ���t
     * @throws IllegalArgumentException   �u�t���̓��v�u�H���̓��v���v�Z�ł��Ȃ�{@code year}���w�肵���ꍇ
     */
    public abstract Calendar dateOf(int year);

    /**
     * �w�肵�����t�����̏j���̓��t�ƈ�v���邩���肵�܂��B
     * 
     * @param cal  ���肷����t
     * @return ��v����ꍇ�� {@code true}
     */
    public boolean is(Calendar cal) {
        return isSameDate(cal, dateOf(cal.get(Calendar.YEAR)));
    }

    @Override
    public String toString() {
        return name_;
    }

    private static int calcVernalEquinoxDay(int year) {
        int diff1 = year - 1980;
        int diff2 = 0;
        double standard = 0;
        if (year <= 1979) {
            standard = 20.8357;
            diff2 = year - 1983;
        } else if (year <= 2099) {
            standard = 20.8431;
            diff2 = year - 1980;
        } else if (year <= 2150) {
            standard = 21.8510;
            diff2 = year - 1980;
        } else {
            throw new IllegalArgumentException(year + "th year is illegal value.");
        }
        return (int)(standard + DIFF_DAY_OF_YEAR * diff1 - (int)(diff2 / 4));
    }

    private static int calcAutumnalEquinoxDay(int year) {
        int diff1 = year - 1980;
        int diff2 = 0;
        double standard = 0;
        if (year <= 1979) {
            standard = 23.2588;
            diff2 = year - 1983;
        } else if (year <= 2099) {
            standard = 23.2488;
            diff2 = year - 1980;
        } else if (year <= 2150) {
            standard = 24.2488;
            diff2 = year - 1980;
        } else {
            throw new IllegalArgumentException(year + "th year is illegal value.");
        }
        return (int)(standard + DIFF_DAY_OF_YEAR * diff1 - (int)(diff2 / 4));
    }

    private static boolean isSameDate(Calendar cal1, Calendar cal2) {
        if (cal1 == null) {
            throw new NullPointerException("Calendar object is null.");
        }
        if (cal2 == null) {
            return false;
        }
        return cal1.get(Calendar.MONTH) == cal2.get(Calendar.MONTH) &&
                cal1.get(Calendar.DAY_OF_MONTH) == cal2.get(Calendar.DAY_OF_MONTH);
    }

    private static Calendar toCalendar(int year, int month, int day) {
        Calendar cal = Calendar.getInstance();
        cal.set(year, month - 1, day);
        return cal;
    }

    private static Calendar mondayOf(int year, int month, int ordinal) {
        Calendar cal = Calendar.getInstance();
        cal.set(year, month - 1, 1);
        cal.set(Calendar.DAY_OF_WEEK_IN_MONTH, ordinal);
        cal.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
        return cal;
    }
}
