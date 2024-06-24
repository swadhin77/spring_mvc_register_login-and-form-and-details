package in.sw.main;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.apache.catalina.connector.Response;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import in.sw.bean.form_details;
import in.sw.connection.dbconnection;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.jsp.tagext.TryCatchFinally;

@Controller
public class controller 
{
	@GetMapping("/register")
	public ModelAndView register_open() 
	{
		ModelAndView mav = new ModelAndView("register");
		return mav;
	}

	@GetMapping("/login")
	public String login_open() 
	{
		return "login";
	}

	@GetMapping("/form")
	public String form_open() 
	{
		return "form";
	}

	@GetMapping("/about")
	public String about_open() 
	{
		return "about";
	}
	
	@PostMapping("/login")
	public String login_method(HttpServletRequest req,HttpServletResponse res,Model model) throws IOException
	{
		PrintWriter pw=res.getWriter();
		res.setContentType("text/html");
		String login_email=req.getParameter("email");
		String login_pass=req.getParameter("pass");
		try{
			Connection con=dbconnection.getconnection();
			String query="select * from login where email=? ";
			PreparedStatement ps=con.prepareStatement(query);
			ps.setString(1, login_email);
			ResultSet rs=ps.executeQuery();
			if(rs.next())
			{
				if(rs.getString(2).equals(login_pass))
				{
					pw.println("email id and password got matched");
					model.addAttribute("model_name", login_email);
					model.addAttribute("model_pass", login_pass);
					return "profile";
				}
				else
				{
					pw.println("Invalid password");
					return "login";
				}
			}
			else
			{
				pw.println("<h2 style : color=red>Invalid email id or password...</h2>");
				return "login";
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
	    }
		return null;
	}

	@PostMapping("/reg")
	public String reg_method(HttpServletRequest req,HttpServletResponse res) throws IOException 
	{
		PrintWriter pw=res.getWriter();
		res.setContentType("text/html");
		String reg_email=req.getParameter("email");
		String reg_pass=req.getParameter("pass");
		try{
			Connection con=dbconnection.getconnection();
			String query="insert into login values(?,?)";
			PreparedStatement ps=con.prepareStatement(query);
			ps.setString(1, reg_email);
			ps.setString(2, reg_pass);
			int a=ps.executeUpdate();
			if(a>0)
			{
				pw.println("<h2 style : color=green>SuccessFully registration completed</h2>");
				return "login";
			}
			else
			{
				pw.println("<h2 style : color=red>Invalid email id or password...</h2>");
				return "register";
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
	    }
		return null;
	}

	@PostMapping("/submitform")
	public String form_method(@ModelAttribute form_details form_details)
	{
		return "form_output";
	}
}