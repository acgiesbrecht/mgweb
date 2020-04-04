package org.mg.mgweb.datatypes;

import com.google.common.base.Strings;
import com.haulmont.chile.core.annotations.JavaClass;
import com.haulmont.chile.core.datatypes.Datatype;

import javax.annotation.Nullable;
import java.text.ParseException;
import java.util.Locale;

@JavaClass(Integer.class)
public class CcmDatatype implements Datatype<Integer> {

    private static final String PATTERN = "##00";

    @Override
    public String format(@Nullable Object value) {
        try {
            if (value == null)
                return "";

            String sCta = String.valueOf(value);
            if (sCta.length() == 6 || sCta.length() == 8) {
                sCta = new StringBuilder("0").append(sCta).toString();
            }

            if (sCta.length() == 9) {
                sCta = new StringBuilder(sCta.substring(0, 2)).append("-").append(sCta.substring(2, 6)).append("-").append(sCta.substring(6, 7)).append("/").append(sCta.substring(7, 9)).toString();
            }
            if (sCta.length() == 7) {
                sCta = new StringBuilder(sCta.substring(0, 2)).append("-").append(sCta.substring(2, 6)).append("-").append(sCta.substring(6, 7)).toString();
            }
            return sCta;
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }

    @Override
    public String format(@Nullable Object value, Locale locale) {
        return format(value);
    }

    @Nullable
    @Override
    public Integer parse(@Nullable String value) throws ParseException {
        if (Strings.isNullOrEmpty(value))
            return null;

        return Integer.valueOf(value.replace("-","").replace("/",""));
    }

    @Nullable
    @Override
    public Integer parse(@Nullable String value, Locale locale) throws ParseException {
        return parse(value);
    }

    public static String formatCta(Integer cta){
        return new CcmDatatype().format(cta);
    }

}
