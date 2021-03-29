package com.kashuba.onlinestore.service.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class WebAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class<?>[]{
                DataConfig.class, ServiceConfig.class
        };
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class<?>[]{WebConfig.class};
    }

    @Override
    protected String[] getServletMappings() {
        return new String[]{"/*"};
    }
}
//public class WebAppInitializer implements WebApplicationInitializer {
//
//    @Override
//    public void onStartup(ServletContext servletContext) {
//        AnnotationConfigWebApplicationContext context
//                = new AnnotationConfigWebApplicationContext();
//        context.setConfigLocation("/Volumes/gc/dev/online-store/percistance/src/resources/database.properties");
//
//        servletContext.addListener(new ContextLoaderListener(context));
//
//        ServletRegistration.Dynamic dispatcher = servletContext
//                .addServlet("dispatcher", new DispatcherServlet(context));
//
//        dispatcher.setLoadOnStartup(1);
//        dispatcher.addMapping("/");
//
//    }
//}