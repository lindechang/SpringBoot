package com.lindec.springboot.exception;


import org.springframework.context.MessageSource;

import java.text.MessageFormat;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by lindec on 2016/5/5.
 */
//@Component
public class ErrorResponseFactory {

    private final MessageSource messages;

    private final Map<Integer, MessageFormat> cachedMessageFormats = new ConcurrentHashMap<>();

    //    @Autowired
    public ErrorResponseFactory(MessageSource messages) {
        this.messages = messages;
    }

    public ErrorResponse getErrorResponse(int errorCode, Locale locale, Object... args) {
        MessageFormat messageFormat = this.cachedMessageFormats.get(errorCode);
        if (messageFormat == null) {
            messageFormat = createMessageFormat(ErrorMap.code2Desc(errorCode), locale);
            this.cachedMessageFormats.put(errorCode, messageFormat);
        }
        return new ErrorResponse(errorCode, messageFormat.format(args));
    }

    public String getErrorDesc(int errorCode, Locale locale, Object... args) {
        MessageFormat messageFormat = this.cachedMessageFormats.get(errorCode);
        if (messageFormat == null) {
            messageFormat = createMessageFormat(ErrorMap.code2Desc(errorCode), locale);
            this.cachedMessageFormats.put(errorCode, messageFormat);
        }
        return messageFormat.format(args);
    }

    protected MessageFormat createMessageFormat(String msg, Locale locale) {
        return new MessageFormat((msg != null ? msg : ""), locale);
    }
}
