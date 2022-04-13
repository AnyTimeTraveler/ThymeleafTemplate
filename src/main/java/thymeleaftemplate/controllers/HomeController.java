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
package thymeleaftemplate.controllers;

import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.WebContext;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Calendar;

public class HomeController implements ThymeleafController {

    @Override
    public void process(final HttpServletRequest request, final HttpServletResponse response, final ServletContext servletContext, final TemplateEngine templateEngine) throws IOException {
        // create a context
        WebContext ctx = new WebContext(request, response, servletContext, request.getLocale());

        // set your variables for the template
        ctx.setVariable("today", Calendar.getInstance());
        ctx.setVariable("name", System.getenv("USERNAME"));

        // render the template
        templateEngine.process("home.html", ctx, response.getWriter());
    }
}
