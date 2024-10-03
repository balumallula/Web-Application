package com.OTP;

import java.io.IOException;
import java.security.SecureRandom;
import java.util.Properties;

import jakarta.mail.AuthenticationFailedException;
import jakarta.mail.Authenticator;
import jakarta.mail.Message;
import jakarta.mail.MessagingException;
import jakarta.mail.PasswordAuthentication;
import jakarta.mail.Session;
import jakarta.mail.Transport;
import jakarta.mail.internet.AddressException;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/SendOtpServlet")
public class SendOtpServlet extends HttpServlet {

    private static final SecureRandom random = new SecureRandom();
    private static final int OTP_LENGTH = 6;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
         String recipientEmail = request.getParameter("email");


        int otp = generateOtp();


        HttpSession session = request.getSession();
        session.setAttribute("otp", otp);



        try {
            sendEmail(recipientEmail, otp);

            RequestDispatcher rd1 = request.getRequestDispatcher("./forgotPass.jsp?msg=OTP sent successfully");
   	        rd1.include(request, response);

        } catch (AddressException ae) {
            ae.printStackTrace();
            response.getWriter().write("Invalid email address.");
        } catch (AuthenticationFailedException afe) {
            afe.printStackTrace();
            response.getWriter().write("Authentication failed: " + afe.getMessage());
        } catch (MessagingException me) {
            me.printStackTrace();
            response.getWriter().write("Failed to send OTP due to email server issues: " + me.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
            response.getWriter().write("An unexpected error occurred.");
        }
    }

    private void sendEmail(String recipientEmail, int otp) throws MessagingException {
        // Email configuration
        Properties props = new Properties();
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");

        Session session = Session.getInstance(props, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("ramasatyanarayana31@gmail.com", "iouo mpgo kflh vjwe"); // Use App Password here
            }
        });

        Message message = new MimeMessage(session);
        message.setFrom(new InternetAddress("ramasatyanarayana31@gmail.com"));
        message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(recipientEmail));
        message.setSubject("Your OTP Code");
        message.setText("Your OTP code is: " + otp);

        Transport.send(message);
    }


    public static int generateOtp() {
        int otp = 100000 + random.nextInt(900000);
         return otp;
    }
}
