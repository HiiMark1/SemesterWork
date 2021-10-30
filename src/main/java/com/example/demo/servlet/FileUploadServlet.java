package com.example.demo.servlet;

import com.cloudinary.Cloudinary;
import com.cloudinary.Transformation;
import com.cloudinary.utils.ObjectUtils;
import com.example.demo.service.Impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Paths;
import java.util.Date;

@WebServlet(urlPatterns = "/upload")
@MultipartConfig(
        maxFileSize = 5 * 1024 * 1024,
        maxRequestSize = 10 * 1024 * 1024
)
public class FileUploadServlet extends HttpServlet{
      private UserServiceImpl userService = new UserServiceImpl();
      private static final int DIRECTORIES_COUNT = 100;
      private static final String FILE_PATH_PREFIX = "/tmp";
      private final Cloudinary cloudinary = new Cloudinary(ObjectUtils.asMap(
              "cloud_name", "dnsjpwxps",
              "api_key", "832458528611266",
              "api_secret", "IJ6YMkTB6wEG4iqOQgTXUvGCFaQ",
              "secure", true));

      @Override
      protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            req.getRequestDispatcher("upload.ftl").forward(req, resp);
      }

      @Override
      protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            HttpSession httpSession = req.getSession();
            String login = (String) httpSession.getAttribute("login");
            if (login == null) {
                  resp.sendRedirect("/login");
            }

            Part part = req.getPart("file");
            String fileName = Paths.get(part.getSubmittedFileName()).getFileName().toString();
            InputStream content = part.getInputStream();
            int partNumber = Math.abs(fileName.hashCode() % DIRECTORIES_COUNT);
            File file = new File(FILE_PATH_PREFIX + File.separator + partNumber + File.separator + fileName);
            file.getParentFile().mkdirs();
            file.createNewFile();
            FileOutputStream outputStream = new FileOutputStream(file);
            byte[] buffer = new byte[content.available()];
            content.read(buffer);
            outputStream.write(buffer);

            long t = new Date().getTime();
            cloudinary.uploader().upload(file, ObjectUtils.asMap("public_id", String.valueOf(t)));
            userService.changeImage(userService.get(login), cloudinary.url().transformation(new Transformation().width(350)
                    .height(467)).imageTag(String.valueOf(t)));
            resp.sendRedirect("/profile");
      }
}