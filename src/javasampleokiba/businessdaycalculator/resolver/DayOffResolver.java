package javasampleokiba.businessdaycalculator.resolver;

import java.util.Calendar;

/**
 * �w�肳�ꂽ���t���x�������肷��C���^�[�t�F�[�X
 */
public interface DayOffResolver {

    /**
     * �w�肳�ꂽ���t���x�������肵�܂��B
     * 
     * @param cal  ���t
     * @return ���t���x���̏ꍇ�� {@code true}
     */
    boolean isDayOff(Calendar cal);
}
