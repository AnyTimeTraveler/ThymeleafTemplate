package org.simonscode.thymeleafexample.servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

@MultipartConfig
public class UploadServlet extends HttpServlet {
    private static final long serialVersionUID = 1839841L;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/plain;charset=UTF-8");
        PrintWriter pw = response.getWriter();
        for (Part p : request.getParts()) {
            pw.println("SubmittedFileName: " + p.getSubmittedFileName());
            pw.println("ContentType: " + p.getContentType());
            pw.println("Size: " + p.getSize());
            pw.println("=== START OF CONTENT ===");
            try {
                BufferedReader br = new BufferedReader(new InputStreamReader(p.getInputStream()));
                br.lines().forEach(pw::println);
                br.close();
                pw.println("===  END OF CONTENT  ===\n\n");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
