/*
 * =============================================================================
 *
 *   Copyright (c) 2011-2016, The THYMELEAF team (http://www.thymeleaf.org)
 *
 *   Licensed under the Apache License, Version 2.0 (the "License");
 *   you may not use this file except in compliance with the License.
 *   You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 *   Unless required by applicable law or agreed to in writing, software
 *   distributed under the License is distributed on an "AS IS" BASIS,
 *   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *   See the License for the specific language governing permissions and
 *   limitations under the License.
 *
 * =============================================================================
 */
package org.simonscode.thymeleafexample.helper;

import org.simonscode.thymeleafexample.controllers.HomeController;
import org.simonscode.thymeleafexample.controllers.ThymeleafController;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.templatemode.TemplateMode;
import org.thymeleaf.templateresolver.ServletContextTemplateResolver;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

public class ThymeleafApplication {

    private TemplateEngine templateEngine;
    private static final Map<String, ThymeleafController> controllersByURL = new HashMap<>();

    static {
        controllersByURL.put("/", new HomeController());
        // put controllers here

        // Beispielpfade:
        // controllersByURL.put("/product/list", new ProductListController());
        // controllersByURL.put("/product/comments", new ProductCommentsController());
        // controllersByURL.put("/order/list", new OrderListController());
        // controllersByURL.put("/order/details", new OrderDetailsController());
        // controllersByURL.put("/subscribe", new SubscribeController());
        // controllersByURL.put("/userprofile", new UserProfileController());
    }

    public ThymeleafApplication(final ServletContext servletContext) {

        super();

        ServletContextTemplateResolver templateResolver = new ServletContextTemplateResolver(servletContext);

        // HTML is the default mode, but we will set it anyway for better understanding of code
        templateResolver.setTemplateMode(TemplateMode.HTML);
        // This will convert "home" to "/src/main/webapp/home.html"
        templateResolver.setPrefix("/");
        templateResolver.setSuffix(".html");
        // Set template cache TTL to 1 hour. If not set, entries would live in cache until expelled by LRU
        templateResolver.setCacheTTLMs(3600000L);

        // Cache is set to true by default. Set to false if you want templates to
        // be automatically updated when modified.
        templateResolver.setCacheable(true);

        templateEngine = new TemplateEngine();
        templateEngine.setTemplateResolver(templateResolver);
    }

    private static String getRequestPath(final HttpServletRequest request) {

        String requestURI = request.getRequestURI();
        final String contextPath = request.getContextPath();

        final int fragmentIndex = requestURI.indexOf(';');
        if (fragmentIndex != -1) {
            requestURI = requestURI.substring(0, fragmentIndex);
        }

        if (requestURI.startsWith(contextPath)) {
            return requestURI.substring(contextPath.length());
        }
        return requestURI;
    }

    public ThymeleafController resolveControllerForRequest(final HttpServletRequest request) {
        final String path = getRequestPath(request);
        return controllersByURL.get(path);
    }

    public TemplateEngine getTemplateEngine() {
        return templateEngine;
    }


}
