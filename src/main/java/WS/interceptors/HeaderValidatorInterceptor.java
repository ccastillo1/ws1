package WS.interceptors;

import org.apache.log4j.BasicConfigurator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class HeaderValidatorInterceptor extends HandlerInterceptorAdapter {

    static{
        BasicConfigurator.configure();
    }

    @Autowired
    private IValidator[] validators;

    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {

        for(IValidator validator : validators){
            String header = httpServletRequest.getHeader(validator.headerKey());
            validator.checkHeader(header);
        }
        return super.preHandle(httpServletRequest, httpServletResponse, o);
    }

}
