package br.com.facility.gcm;

import java.io.IOException;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/GCMNotification")
public class GCMNotification extends HttpServlet {
	private static final long serialVersionUID = 1L;

	// Put your Google API Server Key here
	private static final String GOOGLE_SERVER_KEY = "AIzaSyDMgqNP5HDbqziPRRAZq6g5rD4XOeQpOZ4";

	// Put your Google Project number here
	final String GOOGLE_USERNAME = "213825734251" + "@gcm.googleapis.com";

	public GCMNotification() {
		super();
	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);

	}

//	protected void doPost(HttpServletRequest request,
//			HttpServletResponse response) throws ServletException, IOException {
//
//		try {
//			String userMessage = request.getParameter("message");
//			Set<String> regIdSet = RegIdManager.readFromFile();
//			String toDeviceRegId = (String) (regIdSet.toArray())[0];
//			SmackCcsClient.sendMessage(GOOGLE_USERNAME, GOOGLE_SERVER_KEY,
//					toDeviceRegId,userMessage);
//			request.setAttribute("pushStatus", "Message Sent.");
//		} catch (IOException ioe) {
//			ioe.printStackTrace();
//			request.setAttribute("pushStatus",
//					"RegId required: " + ioe.toString());
//		} catch (Exception e) {
//			e.printStackTrace();
//			request.setAttribute("pushStatus", e.toString());
//		}
//		request.getRequestDispatcher("index.jsp").forward(request, response);
//	}

}
