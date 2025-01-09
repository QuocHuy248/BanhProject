package AdminController;

import java.awt.Color;
import java.awt.Font;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import nl.captcha.Captcha;
import nl.captcha.backgrounds.GradiatedBackgroundProducer;
import nl.captcha.noise.CurvedLineNoiseProducer;
import nl.captcha.servlet.CaptchaServletUtil;
import nl.captcha.text.producer.DefaultTextProducer;

@WebServlet("/simpleCaptcha.jpg")
public class SimpleCaptchaServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("image/jpeg");

		Captcha captcha = new Captcha.Builder(200, 50).addText(new DefaultTextProducer(6, null))
				.addBackground(new GradiatedBackgroundProducer()).addNoise(new CurvedLineNoiseProducer(Color.BLACK, 3))
				.addBorder().build();

		request.getSession().setAttribute(Captcha.NAME, captcha);

		// Thay vì dùng CaptchaServletUtil, ta ghi trực tiếp
		javax.imageio.ImageIO.write(captcha.getImage(), "jpg", response.getOutputStream());
	}
}