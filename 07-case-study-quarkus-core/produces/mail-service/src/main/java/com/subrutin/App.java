package com.subrutin;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        try {
			new EmailService("sandbox.smtp.mailtrap.io", 2525, "5a4e7ff71d5bac", "8d6ee301389b31").sendMail();
	        System.out.println("send");

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println(e);
		}
    }
}
