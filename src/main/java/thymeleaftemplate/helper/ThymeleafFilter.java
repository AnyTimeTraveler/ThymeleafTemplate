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
package thymeleaftemplate.helper;

import thymeleaftemplate.controllers.ThymeleafController;
import org.thymeleaf.TemplateEngine;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


public class ThymeleafFilter implements Filter {


    private ServletContext servletContext;
    private ThymeleafApplication application;

    public void init(final FilterConfig filterConfig) throws ServletException {
        this.servletContext = filterConfig.getServletContext();
        this.application = new ThymeleafApplication(this.servletContext);
    }


    public void doFilter(final ServletRequest request, final ServletResponse response,
                         final FilterChain chain) throws IOException, ServletException {
        if (!process((HttpServletRequest) request, (HttpServletResponse) response)) {
            chain.doFilter(request, response);
        }
    }


    public void destroy() {
        // nothing to do
    }


    private boolean process(HttpServletRequest request, HttpServletResponse response) throws ServletException {

        try {
            // This prevents triggering engine executions for resource URLs
            if (request.getRequestURI().startsWith("/css") ||
                request.getRequestURI().startsWith("/media") ||
                request.getRequestURI().startsWith("/js") ||
                request.getRequestURI().startsWith("/favicon")) {
                return false;
            }


            /*
             * Query org.simonscode.thymeleafexample.controllers/URL mapping and obtain the org.simonscode.thymeleafexample.controllers
             * that will process the request. If no org.simonscode.thymeleafexample.controllers is available,
             * return false and let other filters/servlets process the request.
             */
            ThymeleafController controller = this.application.resolveControllerForRequest(request);
            if (controller == null) {
                return false;
            }

            /*
             * Obtain the TemplateEngine instance.
             */
            TemplateEngine templateEngine = this.application.getTemplateEngine();

            /*
             * Write the response headers
             */
            response.setContentType("text/html;charset=UTF-8");
            response.setHeader("Pragma", "no-cache");
            response.setHeader("Cache-Control", "no-cache");
            response.setDateHeader("Expires", 0);

            /*
             * Execute the org.simonscode.thymeleafexample.controllers and process view template,
             * writing the results to the response writer.
             */
            controller.process(request, response, this.servletContext, templateEngine);

            return true;

        } catch (Exception e) {
            try {
                response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            } catch (final IOException ignored) {
                // Just ignore this
            }
            throw new ServletException(e);
        }

    }
}
