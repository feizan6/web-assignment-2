package assignment2.viewResolver;

import assignment2.view.CsvView;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.ViewResolver;

import java.util.Locale;

/**
 * Created by Fayzan on 28/04/2017.
 */
public class CsvViewResolver implements ViewResolver{

    @Override
    public View resolveViewName(String s, Locale locale) throws Exception {
        CsvView view = new CsvView();
        return view;
    }
}
