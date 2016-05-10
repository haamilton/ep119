package br.com.hsj.ep119.api.handler;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.exolab.castor.mapping.GeneralizedFieldHandler;

public class BirthdayHandler extends GeneralizedFieldHandler {
 
    private static final Log logger = LogFactory.getLog(BirthdayHandler.class);
 
    private static final String FORMAT = "dd/MM";
 
    private SimpleDateFormat formatter = new SimpleDateFormat(FORMAT);
 
    public Object convertUponGet(Object value) {
        if (value == null) {
            return null;    // default value if null date
        }
        Date date = (Date) value;
        return formatter.format(date);
    }
 
    public Object convertUponSet(Object value) {
        Date date = null;
        try {
            date = formatter.parse((String) value);
        }
        catch (ParseException px) {
            logger.error("Parse Exception (bad date format) : " + (String) value);
            return null;  // default value for empty/incorrect date
        }
        return date;
    }
 
    public Class<?> getFieldType() {
        return Date.class;
    }
 
    public Object newInstance(Object parent) throws IllegalStateException {
        return null;
    }
}