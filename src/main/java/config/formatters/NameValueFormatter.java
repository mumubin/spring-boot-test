package config.formatters;

import config.domain.NameValue;
import org.springframework.format.Formatter;

import java.text.ParseException;
import java.util.Locale;

/**
 * Created by hzhubin15 on 2016/8/19.
 */
public class NameValueFormatter implements Formatter<NameValue> {

	@Override
	public NameValue parse(String text, Locale locale) throws ParseException {
		NameValue nameValue = new NameValue();
		String[] strs = text.split("-");
		nameValue.setName(strs[0]);
		nameValue.setValue(strs[1]);
		return nameValue;
	}

	@Override
	public String print(NameValue object, Locale locale) {
		return object.toString();
	}
}
