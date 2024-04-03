//package backend.likelion.todos;
//
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.web.method.HandlerMethod;
//import org.springframework.web.servlet.HandlerInterceptor;
//import org.springframework.web.servlet.ModelAndView;
//
//import java.util.UUID;
//
////import static jdk.nio.zipfs.ZipFileAttributeView.AttrID.method;
//@Slf4j
//public class LogInterceptor implements HandlerInterceptor {
//    public static String LOG_ID = "logId";
//
//    @Override
//    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
//        throws Exception{
//        String requestURI = request.getRequestURI();
//        String uuid = UUID.randomUUID().toString();
//
//        request.setAttribute(LOG_ID, uuid);
//
//        if(handler instanceof HandlerMethod){
//            HandlerMethod handlerMethod = (HandlerMethod) method;
//        }
//    }
//
//
//
//    @Override
//    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
//    ModelAndView modelAndView) throws Exception{
//        log.info("postHandler [{}]",modelAndView);
//    }
//
//
//    @Override
//    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
//            throws Exception {
//        String requestURI = request.getRequestURI();
//        String logId = (String)request.getAttribute(LOG_ID);
//
//        log.info("RESPONSE [{}][{}][{}]",logId,requestURI,handler);
//        if (ex!= null){
//            log.error("afterCompletion error!!",ex);
//        }
//    }
//
//
//}
