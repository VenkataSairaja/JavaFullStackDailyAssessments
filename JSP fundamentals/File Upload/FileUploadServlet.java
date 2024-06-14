import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;

public class FileUploadServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String savePath = "uploads"; // directory to save uploaded files

        // Create the directory if it doesn't exist
        File fileSaveDir = new File(savePath);
        if (!fileSaveDir.exists()) {
            fileSaveDir.mkdir();
        }

        // Get the uploaded file
        Part filePart = request.getPart("file");
        String fileName = filePart.getSubmittedFileName();

        // Save the uploaded file
        File file = new File(savePath + File.separator + fileName);
        FileOutputStream fos = new FileOutputStream(file);
        InputStream is = filePart.getInputStream();
        byte[] buffer = new byte[1024];
        int bytesRead;
        while ((bytesRead = is.read(buffer)) != -1) {
            fos.write(buffer, 0, bytesRead);
        }
        fos.close();
        is.close();

        // Display confirmation message
        request.setAttribute("message", "File uploaded successfully!");
        RequestDispatcher rd = request.getRequestDispatcher("uploadSuccess.jsp");
        rd.forward(request, response);
    }
}