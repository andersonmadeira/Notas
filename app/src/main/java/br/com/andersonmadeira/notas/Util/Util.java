package br.com.andersonmadeira.notas.Util;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * Created by anderson on 06/11/17.
 */

public class Util {
    private static DateFormat dateFormat = DateFormat.getDateInstance(DateFormat.FULL, new Locale("pt","BR"));

    public static String formatDateFull(Date date) {
        String dateInStr = dateFormat.format(date);
        return Character.toString(dateInStr.charAt(0)).toUpperCase()+dateInStr.substring(1);
    }
}
