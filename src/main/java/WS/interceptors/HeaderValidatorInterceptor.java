package WS.interceptors;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@Component
public class HeaderValidatorInterceptor extends HandlerInterceptorAdapter {
    //requiredarks to instan
    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {

        String header = httpServletRequest.getHeader("platform");

        if (header == null || header.isEmpty() || (header.toLowerCase() != "ios" && header.toLowerCase() != "android")) {

            throw new RuntimeException("Header not found");
        }

        return true;
    }

}
