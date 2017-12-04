package com.bjccdsrlcr.appoint.web;

import com.bjccdsrlcr.appoint.dto.AppointExecution;
import com.bjccdsrlcr.appoint.dto.Result;
import com.bjccdsrlcr.appoint.entity.Appointment;
import com.bjccdsrlcr.appoint.entity.Book;
import com.bjccdsrlcr.appoint.entity.Student;
import com.bjccdsrlcr.appoint.enums.AppointStateEnum;
import com.bjccdsrlcr.appoint.exception.NoNumberException;
import com.bjccdsrlcr.appoint.exception.RepeatAppoint;
import com.bjccdsrlcr.appoint.service.BookService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Author: bjccdsrlcr
 * Date: 2017/11/30 0030
 * Time: 17:16
 */
@Controller
@RequestMapping("/books")
public class BookController {
	private Logger logger=LoggerFactory.getLogger(this.getClass());
	@Autowired
	private BookService bookService;
	//获取图书列表
	@RequestMapping(value="/list",method = RequestMethod.GET)
	private String List(Model model){
		List<Book> list = bookService.getList();
		model.addAttribute("list", list);
		return "list";
	}
	//跳转添加图书页面
	@RequestMapping(value = "/add", method = RequestMethod.GET)
	private String add(Model model){
		return "add";
	}

	@RequestMapping(value = "/bookData")
	@ResponseBody
    private String bookData(HttpServletRequest request, HttpServletResponse response){
        String bookId = request.getParameter("bookId");
        String bookName = request.getParameter("bookName");
        String bookIntrod = request.getParameter("bookIntrod");
        String bookNumber = request.getParameter("bookNumber");
        System.out.println("bookId:" + bookId + "\t bookName:"+bookName + "\t bookIntrod:" + bookIntrod + "\t bookNumber: "+ bookNumber);
        Integer id = Integer.parseInt(bookId);
        Integer number = Integer.parseInt(bookNumber);
        bookService.addBook(id, bookName, bookIntrod, number);
        return "success";
    }

	//搜索是否有某图书
	@RequestMapping(value="/search",method = RequestMethod.POST, produces = {"application/json; charset=utf-8"})
	private void search(HttpServletRequest req,HttpServletResponse resp)
								throws ServletException, IOException{
		//接收页面的值
		String name=req.getParameter("name");
		System.out.println(name);
		name=name.trim();
		//向页面传值
		req.setAttribute("name", name);
		req.setAttribute("list", bookService.getSomeList(name));
		req.getRequestDispatcher("/WEB-INF/jsp/list.jsp").forward(req, resp);
	}
	//查看某图书的详细情况
	@RequestMapping(value = "/{bookId}/detail", method = RequestMethod.GET)
	private String detail(@PathVariable("bookId") Long bookId, Model model){
		if(bookId==null){
			return "redict:/book/list";
		}
		Book book=bookService.getById(bookId);
		if(book==null){
			return "forward:/book/list";
		}
		model.addAttribute("book",book);
		System.out.println(book);
		return "detail";
	}
	//验证输入的用户名、密码是否正确
	@RequestMapping(value="/verify", method = RequestMethod.POST, produces = {
													"application/json; charset=utf-8" })
	@ResponseBody
	private Map validate(Long studentId,Long password){   //(HttpServletRequest req,HttpServletResponse resp){
		Map resultMap=new HashMap();
		Student student =null;
		System.out.println("验证函数");
		student = bookService.validateStu(studentId,password);

		System.out.println("输入的学号、密码："+studentId+":"+password);
		System.out.println("查询到的："+student.getStudentId()+":"+student.getPassword());

		if(student!=null){
			System.out.println("SUCCESS");
			resultMap.put("result", "SUCCESS");
			return resultMap;
		}else{
			resultMap.put("result", "FAILED");
			return resultMap;
		}

	}
	//执行预约的逻辑
	@RequestMapping(value = "/{bookId}/appoint", method = RequestMethod.POST, produces = {
	"application/json; charset=utf-8" })
	@ResponseBody
	private Result<AppointExecution> execute(@PathVariable("bookId") Long bookId, @RequestParam("studentId") Long studentId){
		Result<AppointExecution> result;
		AppointExecution execution=null;

		try{//手动try catch,在调用appoint方法时可能报错
			execution=bookService.appoint(bookId, studentId);
			result=new Result<AppointExecution>(true,execution);
				return result;

		} catch(NoNumberException e1) {
			execution=new AppointExecution(bookId, AppointStateEnum.NO_NUMBER);
			result=new Result<AppointExecution>(true,execution);
				return result;
		}catch(RepeatAppoint e2){
			execution=new AppointExecution(bookId,AppointStateEnum.REPEAT_APPOINT);
			result=new Result<AppointExecution>(true,execution);
				return result;
		}catch (Exception e){
			execution=new AppointExecution(bookId,AppointStateEnum.INNER_ERROR);
			result=new Result<AppointExecution>(true,execution);
				return result;
		}
	}
	@RequestMapping(value ="/appoint")
	private String appointBooks(@RequestParam("studentId") long studentId,Model model){

		List<Appointment> appointList=new ArrayList<Appointment>();
		appointList=bookService.getAppointByStu(studentId);
		model.addAttribute("appointList", appointList);

		return "appointBookList";
	}

 }
