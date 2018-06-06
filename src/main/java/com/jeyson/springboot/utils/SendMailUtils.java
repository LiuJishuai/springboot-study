package com.jeyson.springboot.utils;
import javax.activation.DataHandler;
import javax.mail.*;
import javax.mail.internet.*;
import javax.mail.util.ByteArrayDataSource;
import java.util.Properties;

/**
 * @Author: liujishuai
 * @Time: 2018/2/27 9:34
 * @Description:
 */
public class SendMailUtils {

    private static String host=PropertiesUtil.getValue("jeyson.mail.host");
    private static String port=PropertiesUtil.getValue("jeyson.mail.port");
    private static String username=PropertiesUtil.getValue("jeyson.mail.username");
    private static String password=PropertiesUtil.getValue("jeyson.mail.password");
    /**
     * 发送邮件
     * @param nickName 发件人昵称
     * @param toEmail 收件人邮箱
     * @param replyEmail 回复邮箱
     * @param subject 主题
     * @param content 内容
     * @param attachmentFileName 附近名称
     * @param attachmentFile 附件内容
     * @return
     */
    public static boolean sendEmailSmtp(String nickName, String toEmail, String replyEmail, String subject, String content, String attachmentFileName, byte[] attachmentFile) {
        try {
            final Properties props = new Properties();
            props.put("mail.smtp.auth", "true");
            props.put("mail.smtp.host", host);
            props.put("mail.smtp.port",port);
            props.put("mail.user", username);
            props.put("mail.password", password);
            Authenticator authenticator = new Authenticator() {
                protected PasswordAuthentication getPasswordAuthentication() {
                    String userName = props.getProperty("mail.user");
                    String password = props.getProperty("mail.password");
                    return new PasswordAuthentication(userName, password);
                }
            };
            Session mailSession = Session.getInstance(props, authenticator);
            MimeMessage message = new MimeMessage(mailSession);
            InternetAddress form = new InternetAddress(MimeUtility.encodeText(nickName) + "<" + props.getProperty("mail.user") + ">");
            message.setFrom(form);
            InternetAddress replyTo = new InternetAddress(MimeUtility.encodeText(nickName) + "<" + replyEmail + ">");
            InternetAddress[] replyTos = new InternetAddress[]{replyTo};
            message.setReplyTo(replyTos);
            InternetAddress to = new InternetAddress(toEmail);
            message.setRecipient(MimeMessage.RecipientType.TO, to);
            message.setSubject(subject);
            Multipart mainPart = new MimeMultipart();
            MimeBodyPart messageBodyPart = new MimeBodyPart();
            messageBodyPart.setContent(content, "text/html; charset=utf-8");
            mainPart.addBodyPart(messageBodyPart);
            if (attachmentFile != null && attachmentFile.length > 0) {
                messageBodyPart = new MimeBodyPart();
                ByteArrayDataSource fds = new ByteArrayDataSource(attachmentFile, "application/octet-stream");
                messageBodyPart.setDataHandler(new DataHandler(fds));
                messageBodyPart.setFileName(MimeUtility.encodeText(attachmentFileName, "utf-8", (String)null));
                mainPart.addBodyPart(messageBodyPart);
            }

            message.setContent(mainPart);
            Transport.send(message);
            System.out.println("邮件发送成功，toEmail:" + toEmail + ",subject:"+subject);
            return true;
        } catch (Exception e) {
            System.out.println("邮件发送失败，toEmail:" + toEmail + ",subject:"+subject+",异常信息:"+ e.getMessage());
            return false;
        }
    }

}
